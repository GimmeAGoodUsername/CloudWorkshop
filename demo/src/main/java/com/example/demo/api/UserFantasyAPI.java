package com.example.demo.api;

import com.example.demo.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserFantasyAPI {
  private String uri = "http://localhost:9001/test/genUser";

  private RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public UserModel call_generateUser(String name) {
    ResponseEntity<UserModel> userModel = callFantasyAPI(name);

    assert userModel.getStatusCode().equals(HttpStatus.OK) : "Error in HTTP response";
    return userModel.getBody();
  }

  ResponseEntity<UserModel> callFantasyAPI(String name) {
    return restTemplate().postForEntity(uri + "", name, UserModel.class);
  }
}
