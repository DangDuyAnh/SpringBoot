package com.example.dataconnect.services;

import com.example.dataconnect.user.CustomUserDetails;
import com.example.dataconnect.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService implements UserDetailsService {
    @Value("${application.username}")
    private String username;
    @Value("${application.storedPassword}")
    private String storedPassword;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username != username) {
            throw new UsernameNotFoundException(username);
        }
        User user = new User(username,storedPassword);
        return new CustomUserDetails(user);
    }
}
