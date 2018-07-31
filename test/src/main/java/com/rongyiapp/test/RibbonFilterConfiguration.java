package com.rongyiapp.test;

import com.rongyiapp.springcloudeurekaversionedfilter.VersionedServerListFilter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonFilterConfiguration {
  @Bean
  public VersionedServerListFilter serverListFilter() {

    Map<String, String> mapping = new HashMap<>();
//    mapping.put("test-user-server","v1");
    mapping.put("test-user-server", "v2");

    VersionedServerListFilter filter = new VersionedServerListFilter(mapping);
    return filter;
  }

}
