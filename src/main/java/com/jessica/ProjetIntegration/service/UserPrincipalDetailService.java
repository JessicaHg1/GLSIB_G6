package com.jessica.ProjetIntegration.service;

import com.jessica.ProjetIntegration.model.User;
import com.jessica.ProjetIntegration.model.UserPrincipal;
import com.jessica.ProjetIntegration.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPrincipalDetailService implements UserDetailsService {

    private UserRepository userRepository;

    public UserPrincipalDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        UserPrincipal userPrincipal = new UserPrincipal(user);

        return userPrincipal;
    }


    public List<User> getList() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
