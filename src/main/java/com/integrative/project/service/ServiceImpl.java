package com.integrative.project.service;


import com.integrative.project.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ServiceImpl implements ServiceI {

    HashMap<Integer, User> userData = new HashMap<>();

    @Override
    public HashMap<Integer, User> all() {
        return userData;
    }

    @Override
    public User createUser(User user) {
        Integer key = user.getIdUser();
        return userData.put(key, user);
    }

    @Override
    public User readById(Integer id) {
        return userData.get(id);
    }

    @Override
    public User updateUser(Integer id, User user) {

        return userData.put(id, user);
    }

    @Override
    public boolean deleteUser(Integer id) {

        if(userData != null){
            userData.remove(id);
            return true;
        }else{
            return false;
        }
    }
}
