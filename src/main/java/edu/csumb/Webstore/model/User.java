package edu.csumb.Webstore.model;

import java.util.HashMap;

import org.springframework.data.annotation.Id;

public class User
{
    @Id
    public String id;

    public String username;
    public String password;
    public HashMap<String, Integer> cart;

    public User()
    {}//empty constructor

    public User(String id, String username, String password, HashMap<String, Integer> cart)
    {
        this.id = username;
        this.username = username;
        this.password = password;
        this.cart = cart;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HashMap<String, Integer> getCart() {
		return cart;
	}

	public void setCart(HashMap<String, Integer> cart) {
		this.cart = cart;
	}


}