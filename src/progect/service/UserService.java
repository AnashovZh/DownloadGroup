package progect.service;

import progect.model.User;

public interface UserService {
    void turnOn(User user);
    void uppDatePassword(String gmailUser,String newPassword);
}
