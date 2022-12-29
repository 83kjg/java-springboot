package com.javadeveloperzone.component.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserDao userDao;

  @Autowired
  public UserService(UserDao userDao){
    this.userDao = userDao;
  }

  public User findById(User user){
    return this.userDao.findById(user);
  }

  public List<User> getUserList(){
    return this.userDao.findAll();
  }

  public User insert(User user){
    this.userDao.insert(user);
    //return user;
    return redirect:/users;
  }

  public User update(User user){
    if(this.userDao.update(user)){
      return user;
    }else{
      return null;
    }
  }

  public User delete (User user){
    User delUser = findById(user);
    if(this.userDao.delete(user)){
      return delUser;
    }else{
      return null;
    }

  }
}
