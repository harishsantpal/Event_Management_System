package com.eventmanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagementsystem.entity.Venue;
import com.eventmanagementsystem.repository.VenueRepository;

@Service
public class VenueService {

	@Autowired
	private VenueRepository venueRepository;
	
	public Venue createVenue(Venue venue) {
		return venueRepository.save(venue);
	}
	
	public Optional<Venue> getVenueById(Long id){
		return venueRepository.findById(id);
	}
	
	public List<Venue> getAllVenues(){
		return venueRepository.findAll();
	}
	
	public Venue updateVenue(Long id, Venue venueDetails) {
		Venue venue=venueRepository.findById(id).orElseThrow(()->new RuntimeException("Venue Not Found!"));
		venue.setName(venueDetails.getName());
		venue.setLocation(venueDetails.getLocation());
		venue.setCapacity(venueDetails.getCapacity());
		return venueRepository.save(venue);
	}
	
	public void deleteVenue(Long id) {
		venueRepository.deleteById(id);
	}
}
