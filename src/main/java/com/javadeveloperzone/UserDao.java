package com.javadeveloperzone.component.user;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {

  @Select("select * from users where id=#{id}")
  User findById(User user);

  @Select("select * from users")
  List<User> findAll();

  @Insert("insert into users (id , name) values (#{id},#{name})")
  void insert(User user);

  @Update("update users set name = #{name} where id=#{id}")
  boolean update(User user);

  @Delete("delete from users where id=#{id}")
  boolean delete(User user);

}
