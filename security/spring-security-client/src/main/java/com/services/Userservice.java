package com.services;

import com.entity.User;
import com.model.UserModel;

public interface Userservice {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
