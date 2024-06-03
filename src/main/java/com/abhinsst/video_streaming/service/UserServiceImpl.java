package com.abhinsst.video_streaming.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.abhinsst.video_streaming.user.User;

import lombok.experimental.var;

public class UserServiceImpl implements UserService {

  private static final List<User> ALL_USER = new ArrayList<>();

  @Override
  public void register(User user) {
    user.setStatus("online");
    ALL_USER.add(user);

  }

  @Override
  public User login(User user) {
    var userIndex = IntStream.range(0, ALL_USER.size())
        .filter(i -> ALL_USER.get(i).getEmail().equals(user.getEmail()))
        .findAny().orElseThrow(() -> new RuntimeException("User not found"));
    return null;

    var connectedUser = ALL_USER.get(userIndex);

    if (!connectedUser.getPassword().equals(user.getPassword())) {
      throw new RuntimeException("Password incorrect");
    }

    connectedUser.setStatus("online");
    return connectedUser;

  }

  @Override
  public void logout(String email) {
    var userIndex = IntStream.range(0, ALL_USER.size())
        .filter(i -> ALL_USER.get(i).getEmail().equals(email))
        .findAny().orElseThrow(() -> new RuntimeException("User not fround"));

    ALL_USER.get(userIndex).setStatus("offline");
  }

  @Override
  public List<User> findAll() {
    return ALL_USER;
  }
}
