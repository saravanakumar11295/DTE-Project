package com.niit.dao;

import java.util.List;

import com.niit.model.UserDetail;

public interface UserDAO 
{
  public boolean registerUser(UserDetail user);
  public boolean updateUserDetail(UserDetail user);
  public UserDetail getuser(String username);
  public boolean deleteUserDetail(UserDetail user);
  public List<UserDetail> getuser();
}
