package com.example.demo.Service;

import com.example.demo.Model.AuthenticationToken;
import com.example.demo.Model.User;
import com.example.demo.Repository.AuthenticationTokenRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationTokenRepository tokenRepository;

    public User signUp(User user) {

        return userRepository.save(user);
    }

    public String signIn(User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {

            String token = generateToken(existingUser);

            AuthenticationToken authToken = new AuthenticationToken();
            authToken.setToken(token);
            authToken.setTokenCreationDate(LocalDate.now());
            authToken.setUser(existingUser);
            tokenRepository.save(authToken);

            return token;
        }


        return null;
    }

    public User updateUserDetails(User user) {

        User existingUser = userRepository.findById(user.getId()).orElse(null);

        if (existingUser != null) {

            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setAge(user.getAge());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            return userRepository.save(existingUser);
        }

        return null;
    }

    private String generateToken(User user) {

        return UUID.randomUUID().toString();
    }
}
