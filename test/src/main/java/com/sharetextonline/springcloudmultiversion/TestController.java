package com.sharetextonline.springcloudmultiversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @Autowired
  private UserClient userClient;

  @GetMapping("test")
  public String test() {
    return userClient.test();
  }
}
