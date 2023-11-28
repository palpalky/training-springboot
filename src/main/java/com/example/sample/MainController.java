package com.example.sample;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController // This is a REST Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    //@RequestMapping(value = "/demo", method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    /*
    @RequestMapping(value = "/demo/all", method = RequestMethod.GET)
    public User responseDemo (){
        User returnUser = new User();
        returnUser.setName("hoge");
        returnUser.setEmail("piyo@piyo");

        return returnUser;
    }
    */

    @RequestMapping(value = "/demo/add", method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User addNewUser(@RequestBody User user) {
        userRepository.save(user);
        return user; 
    }


    @RequestMapping(value = "/demo/all", method = RequestMethod.GET)
    @ResponseBody 
    public Iterable<User> responseAllUsers() {
        return userRepository.findAll();
    }

}