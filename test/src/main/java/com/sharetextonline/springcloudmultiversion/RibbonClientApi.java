package com.sharetextonline.springcloudmultiversion;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("app")
public class RibbonClientApi {

  public  String serviceId;
  public  String version;

  public String getServiceId() {
    return serviceId;
  }

  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

//  public RibbonClientApi(String serviceId, String version) {
//    this.serviceId = serviceId;
//    this.version = version;
//  }

}
