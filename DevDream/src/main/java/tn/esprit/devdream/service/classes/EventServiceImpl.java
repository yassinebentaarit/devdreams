package tn.esprit.devdream.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.devdream.entities.Event;
import tn.esprit.devdream.repositories.EventRepository;
import tn.esprit.devdream.service.interfaces.IEventService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EventServiceImpl implements IEventService {

    @Autowired
    EventRepository eventRep;
    @Override
    public Event addEvent(Event e) {
        if (e.getEventStart() != null && e.getEventEnd() != null && e.getEventEnd().after(e.getEventStart())) {
        eventRep.save(e);
        return e;}
        else { // If the validation fails, you can throw an exception or handle it in any other appropriate way
            throw new IllegalArgumentException("Fill the form correctly");
        }
    }
    @Override
    public Event showEvent(int e) {
        return eventRep.findById(e).orElse(null);
    }

    @Override
    public List<Event> allEvents() {
        Iterable<Event> eventsIterable = eventRep.findAll();
        List<Event> eventsList = new ArrayList<>();
        for (Event event : eventsIterable) {
            eventsList.add(event);
        }
        return eventsList;
    }
    @Override
    public Event updateEvent(Event e) {
        // Validate that eventEnd is after eventStart
        if ((e.getEventEnd() == null || e.getEventStart() == null || e.getEventEnd().after(e.getEventStart())) &&
                (e.getEventStart() == null || e.getEventEnd() == null || e.getEventStart().before(e.getEventEnd())))
        {
            // Retrieve the existing event from the database
            Event existingEvent = eventRep.findById(Math.toIntExact(e.getId_event())).orElse(null);

            if (existingEvent != null) {
                // Update the fields of the existing event
                existingEvent.setEventName(e.getEventName());
                existingEvent.setDescription(e.getDescription());
                existingEvent.setEventStart(e.getEventStart());
                existingEvent.setEventEnd(e.getEventEnd());
                existingEvent.setBudget(e.getBudget());
                existingEvent.setFeedback(e.getFeedback());
                existingEvent.setPoster(e.getPoster());

                // Save the updated event to the database
                return eventRep.save(existingEvent);
            } else {
                // If the event does not exist, you can throw an exception or handle it in any other appropriate way
                throw new IllegalArgumentException("Event not found");
            }
        } else {
            // If the validation fails, you can throw an exception or handle it in any other appropriate way
            throw new IllegalArgumentException("eventEnd must be after eventStart");
        }
    }
    @Override
    public Event deleteEvent(int eventId) {
        // Check if the event exists
        try{
            Optional<Event> optionalEvent = eventRep.findById(eventId);



            // If the event exists, retrieve it
            Event eventToDelete = optionalEvent.get();

            // Delete the event by its ID
            eventRep.deleteById(eventId);

            // Return the deleted event
            return eventToDelete;
        } catch(Exception e) {
            // If the event does not exist, throw an exception or handle it in any other appropriate way
            throw new IllegalArgumentException("Event not found");
        }
    }
}
