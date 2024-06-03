package com.abhinsst.video_streaming.service;

import java.util.ArrayList;
import java.util.List;

import com.abhinsst.video_streaming.user.User;

public interface UserService {

  public void register(User user);

  public User login(User user);

  public void logout(String email);

  public List<User> findAll();

}
