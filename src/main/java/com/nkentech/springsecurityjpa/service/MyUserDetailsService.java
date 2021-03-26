package com.nkentech.springsecurityjpa.service;

import com.nkentech.springsecurityjpa.models.MyUserDetails;
import com.nkentech.springsecurityjpa.models.User;
import com.nkentech.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    public void addUser(User user){
        userRepository.save(user);
    }

   // @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + userName));

        return user.map(MyUserDetails::new).get();
    }


}
