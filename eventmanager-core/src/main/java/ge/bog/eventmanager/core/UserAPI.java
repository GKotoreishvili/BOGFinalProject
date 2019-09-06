package ge.bog.eventmanager.core;

import ge.bog.eventmanager.model.User;

public interface UserAPI {
    void addUser(User user);
    void deleteUser(User user);
    User getUser(int id);
    boolean checkUserName(String userName);
    boolean checkLogin(String userName, String password);
    boolean checkPhoneNumber(String phoneNumber);
}
