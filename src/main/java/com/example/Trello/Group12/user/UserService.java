package com.example.Trello.Group12.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public boolean registerUser(User user) {
        if (userRepo.findByEmail(user.getEmail()).size() == 0) {
            userRepo.save(user);
            return true;
        } else {
            return false;
        }
    }

    public int login(String email, String password) {
        List<User> user = userRepo.findByEmail(email);
        if (user.size() != 0) {
            if (user.get(0).getPassword().equals(password)) {
                return user.get(0).getID();
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public boolean forgotPassword(String email, String answer, String newPass) {
        User user = userRepo.findByEmail(email).get(0);
        if (user.getAnswer().equals(answer)) {
            user.setPassword(newPass);
            userRepo.save(user);
            return true;
        } else {
            return false;
        }
    }

    /*
    public void deleteUser(User user) {
        userRepo.delete(user);
    }

     */

    public User getWorkspaces(int ID) {
        Optional<User> user = userRepo.findById(ID);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }


}
