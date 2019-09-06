package ge.bog.eventmanager.core;

import ge.bog.eventmanager.model.Category;
import ge.bog.eventmanager.model.Event;
import ge.bog.eventmanager.model.User;

import java.util.Date;
import java.util.List;

public interface EventAPI {
    void addEvent(Event event);
    void deleteEvent(Event event);

    void updateName(Event event, String name);
    void updateDescription(Event event, String description);
    void updateStartDate(Event event, Date startDate);
    void updateLocation(Event event, String location);
    void updateImageUrl(Event event, String imageUrl);
    void updateCategory(Event event, Category category);

    Event getEvent(int id);
    List<Event> getEvents();
    List<Event> getUserEvents(User user);
}
