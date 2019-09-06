package ge.bog.eventmanager.core;

import ge.bog.eventmanager.model.Category;
import ge.bog.eventmanager.model.Event;
import ge.bog.eventmanager.model.User;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Singleton
@TransactionManagement(TransactionManagementType.CONTAINER)
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class EventManager implements EventAPI{

    @PersistenceContext
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Lock(LockType.READ)
    public void addEvent(Event event) {
        em.persist(event);
    }

    @Override
    @Lock(LockType.WRITE)
    public void deleteEvent(Event event) {
        em.createQuery("delete from Event where id =:id")
                .setParameter("id", event.getId())
                .executeUpdate();
    }

    @Override
    @Lock(LockType.WRITE)
    public void updateName(Event event, String name) {
        em.createQuery("update Event set name =:name where id =:id")
                .setParameter("name", name)
                .setParameter("id", event.getId())
                .executeUpdate();
    }

    @Override
    @Lock(LockType.WRITE)
    public void updateDescription(Event event, String description) {
        em.createQuery("update Event set description =:description where id =:id")
                .setParameter("description", description)
                .setParameter("id", event.getId())
                .executeUpdate();
    }

    @Override
    @Lock(LockType.WRITE)
    public void updateStartDate(Event event, Date startDate) {
        em.createQuery("update Event set startDate =:startdate where id =:id")
                .setParameter("startdate", startDate)
                .setParameter("id", event.getId())
                .executeUpdate();
    }

    @Override
    @Lock(LockType.WRITE)
    public void updateLocation(Event event, String location) {
        em.createQuery("update Event set location =:location where id =:id")
                .setParameter("location", location)
                .setParameter("id", event.getId())
                .executeUpdate();
    }

    @Override
    @Lock(LockType.WRITE)
    public void updateImageUrl(Event event, String imageUrl) {
        em.createQuery("update Event set imageUrl =:imageUrl where id =:id")
                .setParameter("imageUrl", imageUrl)
                .setParameter("id", event.getId())
                .executeUpdate();
    }

    @Override
    @Lock(LockType.WRITE)
    public void updateCategory(Event event, Category category) {
        em.createQuery("update Event set category =:category where id =:id")
                .setParameter("category", category)
                .setParameter("id", event.getId())
                .executeUpdate();
    }

    @Override
    @Lock(LockType.READ)
    public Event getEvent(int id) {
        return (Event) em.createQuery("select e from Event e where e.id =:id")
                         .setParameter("id", id)
                         .getSingleResult();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Lock(LockType.READ)
    public List<Event> getEvents() {
        return em.createQuery("select e from Event e", Event.class)
                 .getResultList();
    }

    @Override
    @Lock(LockType.READ)
    public List<Event> getUserEvents(User user) {
        return em.createQuery("select e from Event e where e.creator =:user", Event.class)
                 .setParameter("user", user)
                 .getResultList();
    }
}
