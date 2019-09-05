package ge.bog.eventmanager.core;

import ge.bog.eventmanager.model.Event;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EventManager implements EventAPI{

    @PersistenceContext
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void addEvent(Event event) {
        em.persist(event);
    }

    @Override
    public void editEvent(Event event) {

    }

    @Override
    public void deleteEvent(Event event) {

    }
}
