package com.tim3.ois.service;


//import com.tim3.ois.model.Role;
import com.tim3.ois.model.User;
import com.tim3.ois.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service("userService")
public class UserService {


    private UserRepository userRepository;
//    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
//    @Autowired
//    public UserService(UserRepository userRepository,
//                       RoleRepository roleRepository){
//        this.userRepository=userRepository;
//        this.roleRepository=roleRepository;
//    }
//
    public User findUserById(long id){return userRepository.findById(id);}
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }

}
