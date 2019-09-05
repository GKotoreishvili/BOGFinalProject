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
public class CategoryManager implements CategoryAPI {

    @PersistenceContext
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void addCategory(Category category) {
        em.persist(category);
    }

    @Override
    public void editCategory(Category category, String name) {

        em.createQuery("update Category set name = :name where id = :id")
                .setParameter("name", name)
                .setParameter("id", category.getId())
                .executeUpdate();
    }

    @Override
    public void deleteCategory(Category category) {

    }

    public boolean findCategory(Category category) {
        List<Category> id = em.createQuery("select c from Category c", Category.class)
                            .getResultList();
        if (id.isEmpty()) return false;
        return true;
    }

    public Category getCategory(int id) {
        return em.createQuery("select c from Category c where c.id = :id", Category.class)
                .setParameter("id", id)
                .getResultList().get(0);
    }

    @Override
    public List<Category> getCategories() {
        return em.createQuery("select c from Category c", Category.class)
                .getResultList();
    }
}
