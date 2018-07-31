package com.sharetextonline.springcloudmultiversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonFilterConfiguration {

  @Autowired
  private RibbonClientApi ribbonClientApi;

  @Bean
  public VersionedFilter serverListFilter() {
    VersionedFilter filter = new VersionedFilter(ribbonClientApi);
    return filter;
  }

}
