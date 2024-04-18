package cs489.apsd.adsdentalsurgeries.service;

import cs489.apsd.adsdentalsurgeries.model.User;

import java.util.List;

public interface UserService {
    User addNewUser(User user);
    User updateUser(Integer userId, User editedUser);
    void deleteUser(Integer userId);

    List<User> getAllUsers();
    User getUserByUserName(String username);
    User registerUser(User user);

}
