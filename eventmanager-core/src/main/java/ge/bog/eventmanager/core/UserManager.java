package ge.bog.eventmanager.core;

import ge.bog.eventmanager.model.User;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserManager implements UserAPI {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {

    }

    @Override
    public void editUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void searchUser(User user) {

    }
}
