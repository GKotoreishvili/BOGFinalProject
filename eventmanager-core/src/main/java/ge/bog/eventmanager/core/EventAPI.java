package ge.bog.eventmanager.core;

import ge.bog.eventmanager.model.Event;

import java.util.List;

public interface EventAPI {
    void addEvent(Event event);
    void editEvent(Event event);
    void deleteEvent(Event event);
    List<Event> getEvents();
}
