package com.javadeveloperzone;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService){
    this.userService = userService;
  }

  private static final Logger log =
  LoggerFactory.getLogger(UserController.class);

  @GetMapping("/user/{id}")
  public User getUser(@PathVariable Integer id ){
    log.info("getUser");
    User user = new User();
    user.setId(id);
    return userService.findById(user);
  }

  @GetMapping("/users")
  public List<User> getUserList(){
    log.info("getUserList");
    return userService.getUserList();
  }

  @PostMapping("/insert_user/{id}")
  public User insertUser(@PathVariable Integer id ,
                         @RequestParam String name){
    log.info("insertUser");
    User user = new User();
    user.setId(id);
    user.setName(name);
    userService.insert(user);
  }

  @PutMapping("/update_user/{id}")
  public User updateUser(@PathVariable Integer id ,
                         @RequestParam String name){
    log.info("updateUser");
    User user = new User();
    user.setId(id);
    user.setName(name);
    return userService.update(user);
  }

  @DeleteMapping("/delete_user/{id}")
  public User deleteUser(@PathVariable Integer id){
    log.info("deleteUser");
    User user = new User();
    user.setId(id);
    return userService.delete(user);
  }

}
