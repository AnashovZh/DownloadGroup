package progect.serviceImpl;

import progect.model.Database;
import progect.model.MyException;
import progect.model.User;
import progect.service.UserService;

public class UserServiceImpl implements UserService {
    private Database database;

    public UserServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void turnOn(User user) {
        database.getUsers().add(user);
        System.out.println(user);
    }

    @Override
    public void uppDatePassword(String gmailUser, String newPassword) {
        try {
            for (User u : database.getUsers()) {
                if (!u.getEmail().equalsIgnoreCase(gmailUser)) {
                    throw new MyException("Myndai gmail jok");
                }
            }
            for (User u : database.getUsers()) {
                if (u.getEmail().equalsIgnoreCase(gmailUser)) {
                    u.setPassword(newPassword);
                    System.out.println(newPassword);
                }
            }
        }catch (MyException m){
            System.out.println(m.getMessage());
        }
    }
}
