package edu.csumb.Webstore.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.service.UserService;
import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/users/add")
    @ApiOperation(value = "Add a new user to the database.")
    public User createUser(@RequestBody User users)
    {
        userService.save(users);
        return users;
    }

    @RequestMapping(method = RequestMethod.POST, value = "users/auth")
    @ApiOperation(value = "Verify that a user exists before logging in.")
    public String authUser(/*@RequestBody*/ String password, /*@RequestBody*/ String username)
    {
        User users = new User();

        users.setId(username);
        users.setUsername(username);
        users.setPassword(password);
        HashMap<String, Integer> cart = new HashMap<String, Integer>();
        users.setCart(cart);

        users.setId(users.getUsername());
        String result;
        if(userService.authenticate(users) == true)//(userService.authenticate(username, password) == true)
        {
            //return "User Login Successful";
            result = "User Login Successful.";
        }
        else
        {
            result = "User Login Failed. Incorrect username and/or password.";
        }
        return result;
    }
}