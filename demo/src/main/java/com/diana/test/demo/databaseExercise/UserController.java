package com.diana.test.demo.databaseExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
//    private UserService userService;

    @GetMapping("/test")
    public String goIndex() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayLogin( Model model)
    { model.addAttribute("user", new User()); return "user"; }

    @GetMapping("/create")
    public String index (Model model){
        model.addAttribute("message", "Hello there");
        model.addAttribute("user", new User());
        // try Model with new User() or ModelAndView with return model
        return "index";
    }

    @PostMapping("/create")
    public String register (@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
        Argon2PasswordEncoder passwordEncoder= new Argon2PasswordEncoder();

        model.addAttribute("user", new User());
        User n = new User();
        n.setName(name);
        n.setPassword(password);
        n.getPassword();
        n.setPassword(passwordEncoder.encode(password));
        userRepository.saveAndFlush(n);
//        userService.save();
        model.addAttribute(password);
        model.addAttribute(name);
        return "user";
    }

//    @GetMapping(path="/all")
//    public @ResponseBody Iterable<User> getAllUsers() {
//        // This returns a JSON or XML with the users
//        return userRepository.findAll();
//    }

    @GetMapping("/name")
    public String testGet(Model model) {
        model.addAttribute("message", "HELLO");
        return "name";
    }



}


