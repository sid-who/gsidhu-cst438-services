package edu.csumb.Webstore.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.service.CartService;
import edu.csumb.Webstore.service.UserService;
import io.swagger.annotations.ApiOperation;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping(method = RequestMethod.POST, value = "users/cart/")
    @ApiOperation(value = "Add items to a user's cart.")
    public User addToCart(String username, String productId, int quantity)
    {
        return cartService.atc(username, productId, quantity);
    }

    @RequestMapping(method = RequestMethod.POST, value = "users/updateCart")
    @ApiOperation(value = "Update quanity of item in a user's cart. (0) Will remove the item.")
    public User updateCart(String username, String productId, int quantity)
    {
        return cartService.upCart(username, productId, quantity);
    }

    @RequestMapping(method = RequestMethod.POST, value = "users/checkout")
    @ApiOperation(value = "Update quanity of item in a user's cart. (0) Will remove the item.")
    public User checkout(String username)
    {
        return cartService.checkout(username);
    }
}