package cn.wilmar.boot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wilmar.boot.model.User;
import cn.wilmar.boot.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/users")
    public List<User> listUsers(@RequestParam(defaultValue = "") String name) {
        return userRepo.findByNameLike("%"+name+"%");
    }

    @GetMapping("/users/new")
    public User createUser(@RequestParam String name) {
        return userRepo.save(new User(name));
    }
}