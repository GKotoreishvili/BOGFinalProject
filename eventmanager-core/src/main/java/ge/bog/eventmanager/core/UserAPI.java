package ge.bog.eventmanager.core;

import ge.bog.eventmanager.model.User;

public interface UserAPI {
    void addUser(User user);
    void editUser(User user);
    void deleteUser(User user);
    void searchUser(User user);
}
