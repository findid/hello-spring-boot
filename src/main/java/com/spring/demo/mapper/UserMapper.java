package com.spring.demo.mapper;

import com.spring.demo.model.User;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public interface UserMapper {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);

}
