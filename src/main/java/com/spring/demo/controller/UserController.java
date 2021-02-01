package com.spring.demo.controller;

import java.util.List;
import java.util.Map;

import com.spring.demo.mapper.UserMapper;
import com.spring.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class UserController {

    @Autowired(required=true)
    private UserMapper userMapper;

    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users=userMapper.getAll();
        return users;
    }

    @RequestMapping(value="/getUser",method = RequestMethod.GET)
    public User getUser( Long id) {
        User user=userMapper.getOne(id);
        return user;
    }

     @ResponseBody
     @RequestMapping(value="/add",method = RequestMethod.POST)
    public void save(@RequestBody User user) {
        //System.out.println("ii");
        userMapper.insert(user);
    }

    @RequestMapping(value="update")
    public void update(User user) {
        userMapper.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }


}
