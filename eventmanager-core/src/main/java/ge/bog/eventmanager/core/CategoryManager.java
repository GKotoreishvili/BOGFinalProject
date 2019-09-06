package ge.bog.eventmanager.core;

import ge.bog.eventmanager.model.Category;

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
    @Lock(LockType.WRITE)
    public void deleteCategory(Category category) {
        em.createQuery("delete from Category where id =:id")
                .setParameter("id", category.getId())
                .executeUpdate();
    }

    @Override
    @Lock(LockType.READ)
    public boolean findCategory(Category category) {
        List<Category> id = em.createQuery("select c from Category c", Category.class)
                            .getResultList();
        if (id.isEmpty()) return false;
        return true;
    }

    @Override
    @Lock(LockType.READ)
    public Category getCategory(int id) {
        return em.createQuery("select c from Category c where c.id = :id", Category.class)
                .setParameter("id", id)
                .getResultList().get(0);
    }

    @Override
    @Lock(LockType.READ)
    public List<Category> getCategories() {
        return em.createQuery("select c from Category c", Category.class)
                .getResultList();
    }
}
