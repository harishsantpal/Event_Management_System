package com.eventmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagementsystem.entity.Event;
import com.eventmanagementsystem.entity.Organizer;
import com.eventmanagementsystem.entity.Venue;
import com.eventmanagementsystem.services.EventService;
import com.eventmanagementsystem.services.OrganizerService;
import com.eventmanagementsystem.services.VenueService;

@RestController
@RequestMapping("api/events")
public class EventController {

	@Autowired
	private EventService eventService;
	
	 @Autowired
	    private OrganizerService organizerService;

	    @Autowired
	    private VenueService venueService;
	
	@PostMapping
	public Event createEvent(@RequestBody Event event) {
		return eventService.createEvent(event);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable Long id){
		Event event=eventService.getEventById(id).orElseThrow(()->new RuntimeException("Event Not Found!"));
		return ResponseEntity.ok(event);
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails){
//		Event updateEvent=eventService.updateEvent(id, eventDetails);
//		return ResponseEntity.ok(updateEvent);
//	}
	
	
	 @PutMapping("/{id}")
	    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
	        Organizer organizer = organizerService.getOrganizerById(eventDetails.getOrganizer().getId())
	                .orElseThrow(() -> new RuntimeException("Organizer Not Found!"));
	        eventDetails.setOrganizer(organizer);

	        Venue venue = venueService.getVenueById(eventDetails.getVenue().getId())
	                .orElseThrow(() -> new RuntimeException("Venue Not Found!"));
	        eventDetails.setVenue(venue);

	        Event updatedEvent = eventService.updateEvent(id, eventDetails);
	        return ResponseEntity.ok(updatedEvent);
	    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable Long id){
		eventService.deleteEvent(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/venue/{venueId}")
	public List<Event> getEventByVenue(@PathVariable Long venueId){
		return eventService.getEventsByVenue(venueId);
	}
	
	@GetMapping("/organizer/{organizerId}")
	public List<Event> getEventByOrganizer(@PathVariable Long organizerId){
		return eventService.getEventByOrganizerr(organizerId);
	}
	
	
}
