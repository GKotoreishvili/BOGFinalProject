package ge.bog.eventmanager.core;

import ge.bog.eventmanager.model.Event;

public interface EventAPI {
    public  void addEvent(Event event);
    public  void editEvent(Event event);
    public  void deleteEvent(Event event);
}
