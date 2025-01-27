package main.service;

import main.model.User;
import main.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void removeUser(String memberID) {
        userRepository.findById(memberID).ifPresent(user -> {
            userRepository.deleteById(memberID);
            System.out.println("User Removed Successfully");
        });
    }

    public void addUser(User user) {
        userRepository.save(user);
        System.out.println("User Added Successfully: " + user);
    }
}
