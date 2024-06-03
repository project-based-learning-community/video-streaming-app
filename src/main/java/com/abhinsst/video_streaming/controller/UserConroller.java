package com.abhinsst.video_streaming.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhinsst.video_streaming.service.UserService;
import com.abhinsst.video_streaming.user.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserConroller {

  private final UserService service;

  @PostMapping
  public void register(User user) {
    service.register(user);
  }

  @PostMapping
  public User login(User user) {
    return service.login(user);
  }

  @PostMapping
  public void logout(String email) {
    service.logout(email);
  }

  @GetMapping
  public List<User> findAll() {
    return service.findAll();
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handle(Exception ex) {
    ex.printStackTrace();
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(ex.getMessage());
  }

}
