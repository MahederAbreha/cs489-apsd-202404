package cs489.apsd.adsdentalsurgeries.service.impl;

import cs489.apsd.adsdentalsurgeries.model.User;
import cs489.apsd.adsdentalsurgeries.repository.UserRepository;
import cs489.apsd.adsdentalsurgeries.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer userId, User editedUser) {
        User userToUpdate = userRepository.findById(userId).orElse(null);
        assert userToUpdate != null;
        userToUpdate.setFullName(editedUser.getFullName());
        userToUpdate.setPhoneNumber(editedUser.getPhoneNumber());
        userToUpdate.setEmail(editedUser.getEmail());
        return userRepository.save(userToUpdate);
    }


    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepository.findByUserName(username).orElse(null);
    }

    @Override
    public User registerUser(User user) {
        User userToRegister = new User();
        userToRegister.setFullName(user.getFullName());
        userToRegister.setPhoneNumber(user.getPhoneNumber());
        userToRegister.setEmail(user.getEmail());
        userToRegister.setUserName(user.getUsername());
        userToRegister.setPassword(user.getPassword());
        userToRegister.setRoles(user.getRoles());
        return userRepository.save(userToRegister);
    }

}
