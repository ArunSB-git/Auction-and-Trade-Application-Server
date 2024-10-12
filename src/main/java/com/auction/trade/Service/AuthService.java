package com.auction.trade.Service;

import com.auction.trade.DTO.AuthRepository;
import com.auction.trade.LoginResponse;
import com.auction.trade.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {



    @Autowired
    AuthRepository authRepository;


    public List<Users> getAllByUserRole(String role) {
        return authRepository.findByRole(role);
    }

    public List<Users> getAllUsers() {
        return authRepository.findAll();
    }

//    public List<Users> getAllByNationality(String nationality) {
//        return authRepository.findByNationality(nationality);
//    }

    public Optional<LoginResponse> login(String username, String password) {
        Optional<Users> user = authRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            Users foundUser = user.get();
            return Optional.of(new LoginResponse(foundUser.getUserid(), foundUser.getRole()));
        }
        return Optional.empty();
    }

}
