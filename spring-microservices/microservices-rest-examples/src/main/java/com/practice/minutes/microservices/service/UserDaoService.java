package com.practice.minutes.microservices.service;

import com.practice.minutes.microservices.domain.User;
import com.practice.minutes.microservices.domain.UserRepository;
import com.practice.minutes.microservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

//    static {
//        users.add(new User(1, "Teja", new Date()));
//        users.add(new User(2, "Ramya", new Date()));
//        users.add(new User(3, "Havish", new Date()));
//    }

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not found with id" + id));
//        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(() -> new UserNotFoundException("User Not found with id" + id));
    }

    public User saveUser(User user) {
//        if (null == user.getId()) {
//            user.setId(users.size() + 1);
//            users.add(user);
//        }
//        return user;
        return userRepository.save(user);
    }

    public void deleteUser(Integer id){
//        User user1 = users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(() -> new UserNotFoundException("User Not found with id" + id));
//        users.remove(user1);
//        return user1;
        User userById = getUserById(id);

        userRepository.delete(userById);

    }
}
