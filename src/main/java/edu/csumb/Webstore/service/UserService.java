package edu.csumb.Webstore.service;

import java.util.Optional;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void save(User users) {
        userRepository.insert(users);
    }

    public boolean authenticate(User users)// (String username, String password)
    {
        boolean result;
        // userRepository.findById(username);
        // return false;

        String username = users.getUsername();
        String password = users.getPassword();

        if(userRepository.findById(username).get().getPassword().equals(password) )
        {
            return true;
        }
        else
        {
            return false;
        }

        /*if (userRepository.existsById(users.getId()) == true) // (userRepository.findById(users.getId()) == null)//
                                                              // (userRepository.findById(username) != null)
        {
            String testPass = users.getPassword();

            User temp = userRepository.findById(username).get();

            System.out.println(temp);

            if(testPass == temp.getPassword())
            {
                result = true;
            }
            else
            {
                result = false;
            }

            // userRepository.find({users: {$elemMatch: { password: testPass}}});

            //User temp = userRepository.findById(username).get();
            //Optional<User> dbo = userRepository.findById(username);

            //String pass = dbo.get("password");

            // String temp = userRepository.findById(username).get().getPassword();
            // String temp =
            // userRepository.findById(users.getId()).orElseGet(null).getPassword();
            /*
             * Optional<User> temp = userRepository.findById(users.getId());
             * 
             * if(temp.get().getPassword() == users.getPassword()) { result = true; } else {
             * result = false; }
             */
            // BasicDBObject whereQuery = new BasicDBObject();
            // whereQuery.put("username", users.getUsername())

            //result = true;
        /*}
        else
        {
            result = false;
        }
        return result;*/

    }//end of authenticate
}