package ge.bog.eventmanager.core;

import ge.bog.eventmanager.model.Category;
import ge.bog.eventmanager.model.Event;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
@TransactionManagement(TransactionManagementType.CONTAINER)
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class CategoryManager implements CategoryAPI {

    @PersistenceContext
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Lock(LockType.READ)
    public void addCategory(Category category) {
        em.persist(category);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Lock(LockType.WRITE)
    public void deleteCategory(Category category) {
        em.createQuery("delete from Category where id =:id")
                .setParameter("id", category.getId())
                .executeUpdate();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Lock(LockType.WRITE)
    public void updateCategory(Category category, String name) {
        em.createQuery("update Category set name =:name where id =:id")
                .setParameter("name", name)
                .setParameter("id", category.getId())
                .executeUpdate();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Lock(LockType.READ)
    public boolean findCategory(String name) {
        List<Category> id = em.createQuery("select c from Category c where c.name =:name", Category.class)
                              .setParameter("name", name)
                              .getResultList();
        if (id.isEmpty()) return false;
        return true;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Lock(LockType.READ)
    public Category getCategory(int id) {
        return em.createQuery("select c from Category c where c.id = :id", Category.class)
                .setParameter("id", id)
                .getResultList().get(0);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Lock(LockType.READ)
    public List<Category> getCategories() {
        System.out.println(em.createQuery("select count(*) from Category c").getFirstResult());
        return em.createQuery("select c from Category c", Category.class)
                .getResultList();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Lock(LockType.READ)
    public boolean checkIfInUse(Category category) {
        List<Event> list = em.createQuery("select e from Event e where e.category =:category", Event.class)
                                .setParameter("category", category)
                                .getResultList();
        if (list.isEmpty()) return false;
        return true;
    }
}
