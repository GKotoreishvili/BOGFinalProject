package ge.bog.eventmanager.core;

import ge.bog.eventmanager.model.User;
import ge.bog.eventmanager.model.staticclasses.HashPassword;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserManager implements UserAPI {

    @PersistenceContext
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void addUser(User user) {
        System.out.println("GIVIIIIIII");
        em.persist(user);
        System.out.println("BACHOOOOOOO");
    }

    @Override
    public void deleteUser(User user) {
        em.createQuery("delete from User where id = :id")
                .setParameter("id", user.getId())
                .executeUpdate();
    }

    @Override
    public User getUser(int id) {
        return em.createQuery("select u from User u where u.id = :id", User.class)
                 .setParameter("id", id)
                 .getSingleResult();
    }

    @Override
    public boolean checkUserName(String userName) {
        List<User> list = em.createQuery("select u from User u where u.userName = :username", User.class)
                            .setParameter("username", userName)
                            .getResultList();
        if (list == null || list.isEmpty()) return false;
        return true;
    }

    @Override
    public boolean checkLogin(String userName, String password) {
        List<User> list = em.createQuery("select u from User u where u.userName = :" +
                            " username and u.password = :password", User.class)
                            .setParameter("username", userName)
                            .setParameter("password", HashPassword.hashPassword(password))
                            .getResultList();
        if (list == null || list.isEmpty()) return false;
        return true;
    }

    @Override
    public boolean checkPhoneNumber(String phoneNumber) {
        List<User> list = em.createQuery("select u from User u where u.phoneNumber = :phonenumber", User.class)
                .setParameter("phonenumber", phoneNumber)
                .getResultList();
        if (list == null || list.isEmpty()) return false;
        return true;
    }
}
