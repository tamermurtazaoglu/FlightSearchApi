package com.tamerm.FlightSearchApi.business.concretes;

import com.tamerm.FlightSearchApi.business.abstracts.UserService;
import com.tamerm.FlightSearchApi.dataAccess.abstracts.UserDao;
import com.tamerm.FlightSearchApi.entities.concretes.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private final UserDao userDao;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserManager(UserDao userDao, BCryptPasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }
}