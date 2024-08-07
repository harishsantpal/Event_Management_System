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

import com.eventmanagementsystem.entity.Venue;
import com.eventmanagementsystem.services.VenueService;

@RestController
@RequestMapping("/api/venues")
public class VenueController {

	@Autowired
	private VenueService venueService;
	
	@PostMapping
	public Venue createVenue(@RequestBody Venue venue) {
		return venueService.createVenue(venue);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Venue> getVenueById(@PathVariable Long id){
		Venue venue=venueService.getVenueById(id).orElseThrow(()-> new RuntimeException("Venue Not Found!"));
		return ResponseEntity.ok(venue);
	}
	
	@GetMapping
	public List<Venue> getAllVenues(){
		return venueService.getAllVenues();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Venue> updateVenue(@PathVariable Long id, @RequestBody Venue venueDetails){
		Venue updateVenue=venueService.updateVenue(id, venueDetails);
		return ResponseEntity.ok(updateVenue);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVenue(@PathVariable Long id){
		venueService.deleteVenue(id);
		return ResponseEntity.noContent().build();
	}
	
}
