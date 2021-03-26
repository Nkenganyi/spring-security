package com.nkentech.springsecurityjpa.resource;

import com.nkentech.springsecurityjpa.models.User;
import com.nkentech.springsecurityjpa.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeResource {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome</h1>");
    }

    @PostMapping("/addUser")
    public void add(@RequestBody User user){
        userDetailsService.addUser(user);
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome Admin</h1>");
    }


}
