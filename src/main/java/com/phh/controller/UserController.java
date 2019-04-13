package com.phh.controller;

import com.phh.entity.User;
import com.phh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p> TODO
 *
 * @author phh
 * @version V1.0
 * @project: spring
 * @package com.phh.controller
 * @date 2019/4/5
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/add")
    public Object add(@RequestBody User user) {
        user.setCreateDate(new Date());
        userService.insert(user);
        return "success";
    }

    @PostMapping("/update")
    public Object update(@RequestBody User user) {
        userService.update(user);
        return "success";
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

}
