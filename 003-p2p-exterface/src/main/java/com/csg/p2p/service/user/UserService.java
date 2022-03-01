package com.csg.p2p.service.user;

import com.csg.p2p.model.user.User;

public interface UserService {
    Integer queryAllUserCount();

    User queryPhone(String phone);

    User insertUser(String phone, String loginPassword) throws Exception;

    void addMessageToRedis(String phone, String messageCode);

    String getMessageCodeByPhone(String phone);

    int removeUserById(User user);
}
