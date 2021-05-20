package com.aplication.enjoypictures.controller;

import com.aplication.enjoypictures.dto.UserDataDto;
import com.aplication.enjoypictures.dto.UserDto;
import com.aplication.enjoypictures.entity.User;
import com.aplication.enjoypictures.repository.UserRepository;
import com.aplication.enjoypictures.security.UserDetailsServiceImpl;
import com.aplication.enjoypictures.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/login")
    public String Login_Register()
    {
        final UserDto userDto = UserDetailsServiceImpl.getLoggedInUserDetails();
        if (userDto != null) {
            return "redirect:/index";
        }
        return "login";
    }

    @GetMapping(value="/admin")
    public String admin()
    {
        return "admin";
    }
    @GetMapping(value="/foods")
    public String foods()
    {
        return "foods";
    }
    @GetMapping(value="/portrait")
    public String portrait()
    {
        return "portrait";
    }
    @GetMapping(value="/tech")
    public String tech()
    {
        return "tech";
    }
    @GetMapping(value="/sport")
    public String sport()
    {
        return "sport";
    }
    @GetMapping(value="/animals")
    public String urban()
    {
        return "Animals";
    }
    @GetMapping(value="/randompics1")
    public String randompic1()
    {
        return "randompics1";
    }

    @GetMapping(value="/randompics2")
    public String randompic2()
    {
        return "randompics2";
    }

    @GetMapping(value="/randompics3")
    public String randompic3()
    {
        return "randompics3";
    }

    @GetMapping(value="/randompics4")
    public String randompic4()
    {
        return "randompics4";
    }

    @GetMapping(value="/")
    public String index()
    {
        final UserDto userDto = UserDetailsServiceImpl.getLoggedInUserDetails();
        if (userDto != null) {
            return "redirect:/index";
        }
        return "redirect:/login";
    }
    @GetMapping(value="/index")
    public String Index(Model model)
    {
        final UserDto userDto = UserDetailsServiceImpl.getLoggedInUserDetails();
        final UserDataDto userDataDto = new UserDataDto(userDto.getUsername());

        model.addAttribute("userData", userDataDto);
        return "index";
    }
    @PostMapping(value = "/register")
    public String registration(@RequestParam(value = "username", required = true) final String username,
                               @RequestParam(value = "password", required = true) final String password,
                               Model model) {
        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("exists","Username already exists!");
            return "/login";
        }
        final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        final String pass = passwordEncoder.encode(password);
        User user = new User(username, pass, "ROLE_USER", new Date(), true);
        userRepository.save(user);
        model.addAttribute("registered","Registered successfuly, please log in");

        return "/login";
    }
    @GetMapping(value="/delete")
    public String Delete()
    {
        final UserDto userDto = UserDetailsServiceImpl.getLoggedInUserDetails();
        if (userDto != null)
        {
            final Optional<User> optionalUser = userRepository.findByUsername(userDto.getUsername());
            final User user = optionalUser.get();
            user.setActive(false);
            userRepository.save(user);
        }
        return "redirect:/logout";
    }
}
