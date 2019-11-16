package edu.csumb.Webstore.service;

import java.util.HashMap;
import java.util.Optional;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.repositories.ProductRepository;
import edu.csumb.Webstore.repositories.UserRepository;

@Service
public class CartService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    public User atc(String username, String product, int quantity) {
        User temp = userRepository.findById(username).get();

        if (quantity == 0) {
            return null;
        }

        if (userRepository.findById(username) == null) {
            return null;
        } else {
            if (temp.getCart().containsKey(product)) {
                int newQuant = temp.getCart().get(product) + quantity;
                temp.getCart().put(product, newQuant);
            } else {
                temp.getCart().put(product, quantity);
            }
        }

        //User result = userRepository.findById(username).get();

        //userRepository.insert(temp);
        userRepository.deleteById(username);
        userRepository.insert(temp);
        User result = userRepository.findById(username).get();
        return result;
    }

    public User upCart(String username, String product, int quantity) {
        User temp = userRepository.findById(username).get();

        if (userRepository.findById(username) == null) {
            return null;
        } else {
            if (temp.getCart().containsKey(product)) {
                if (quantity == 0) {
                    temp.getCart().remove(product);
                } else {
                    temp.getCart().put(product, quantity);
                }
            } else {
                return null;
            }
        }

        userRepository.deleteById(username);
        userRepository.insert(temp);

        User result = userRepository.findById(username).get();
        return result;
    }

    public User checkout(String username) {
        User temp = userRepository.findById(username).get();

        if (userRepository.findById(username) == null) {
            return null;
        } else {
            for (Entry<String, Integer> entry : temp.getCart().entrySet())
            {
                String tKey = entry.getKey();
                int adjustQ = temp.getCart().get(tKey);
                
                Product pNew = productRepository.findById(tKey).get();
                int newStock = pNew.getStock() - adjustQ;
                pNew.setStock(newStock);
                productRepository.deleteById(tKey);
                productRepository.insert(pNew);

                temp.getCart().remove(tKey);
            }
        }

        userRepository.deleteById(username);
        userRepository.insert(temp);
        return temp;
    }

}