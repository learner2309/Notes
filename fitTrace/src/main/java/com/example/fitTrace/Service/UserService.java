package com.example.fitTrace.Service;

import java.util.List;

import com.example.fitTrace.entity.User;
import com.example.fitTrace.exception.UserNotFoundException;


public interface UserService {
	public User login(String username, String password);
    public User register(User user) ;
    public List<User> getusers();
    public User getUserById(Long id) throws UserNotFoundException;
    public User updateUser(User user);
}
