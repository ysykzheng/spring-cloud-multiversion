package com.sharetextonline.springcloudmultiversion;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.client.IClientConfigAware;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractServerListFilter;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;

public class VersionedFilter <T extends Server> extends
                                                AbstractServerListFilter<T> implements IClientConfigAware {

  private static final String VERSION_KEY = "versions";

  private final RibbonClientApi ribbonClientApi;

  public VersionedFilter(RibbonClientApi ribbonClientApi) {
    this.ribbonClientApi = ribbonClientApi;
  }

  @Override
  public void initWithNiwsConfig(IClientConfig clientConfig) {
  }

  private List<String> getInstanceVersions(InstanceInfo instanceInfo) {
    List<String> result = new ArrayList<>();
    String rawVersions = instanceInfo.getMetadata().get(VERSION_KEY);
    if (StringUtils.isNotBlank(rawVersions)) {
      result.addAll(Arrays.asList(rawVersions.split(",")));
    }
    return result;
  }

  @Override
  public List<T> getFilteredListOfServers(List<T> servers) {
    return (List<T>) servers.stream()
                            .map(server -> (DiscoveryEnabledServer)server)
                            .peek(discoveryEnabledServer -> System.out.println(discoveryEnabledServer.getId()))
                            .filter(server -> {
             InstanceInfo instanceInfo = server.getInstanceInfo();
             List<String> versions = this.getInstanceVersions(instanceInfo);
                              System.out.println(versions);
             return versions.isEmpty() || versions.contains(this.ribbonClientApi.version);
           })
                            .collect(Collectors.toList());

  }
}
