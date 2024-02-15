package tn.esprit.devdream.service.interfaces;

import tn.esprit.devdream.entities.Event;

import java.util.List;

public interface IEventService {
    public Event addEvent(Event e);
    public Event showEvent(int e) ;
    public List<Event> allEvents();
    public Event updateEvent(Event e);
    public Event deleteEvent(int e);
}
