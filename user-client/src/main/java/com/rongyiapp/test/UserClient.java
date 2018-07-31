package com.rongyiapp.test;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "test-user-server", path = "/")
public interface UserClient {

  @GetMapping(path = "test")
  String test();
}
