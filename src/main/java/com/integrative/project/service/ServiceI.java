package com.integrative.project.service;



import com.integrative.project.model.User;

import java.util.HashMap;

public interface ServiceI {
    HashMap<Integer, User> all();
    User createUser(User user);
    User readById(Integer id);
    User updateUser(Integer id, User user);
    boolean deleteUser(Integer id);
}
