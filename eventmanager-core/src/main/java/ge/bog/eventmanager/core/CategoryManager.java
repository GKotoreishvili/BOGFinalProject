package ge.bog.eventmanager.core;

import ge.bog.eventmanager.model.Category;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CategoryManager implements CategoryAPI {

    @PersistenceContext
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void addCategory(Category category) {
        System.out.println("Givi");
        em.persist(category);
        em.flush();
        System.out.println("Bacho");
    }

    @Override
    public void editCategory(Category category) {

    }

    @Override
    public void deleteCategory(Category category) {

    }
}
