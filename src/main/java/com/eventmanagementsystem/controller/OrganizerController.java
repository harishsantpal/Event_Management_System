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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagementsystem.entity.Organizer;
import com.eventmanagementsystem.services.OrganizerService;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {
	
	@Autowired
	private OrganizerService organizerService;
	
	@PostMapping
	public Organizer createOrganizer(@RequestBody Organizer organizer) {
		return organizerService.createOrganizer(organizer);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Organizer> getOrganizerById(@PathVariable Long id){
		Organizer organizer=organizerService.getOrganizerById(id).orElseThrow(()->new RuntimeException("Organizer Not Found!"));
		return ResponseEntity.ok(organizer);
	}
	
	@GetMapping
	public List<Organizer> getAllOrganizers(){
		return organizerService.getAllOrganizers();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Organizer> updateOrganizer(@PathVariable Long id, @RequestBody Organizer organizerDetails){
		Organizer updatedOrganizer=organizerService.updateOrganizer(id, organizerDetails);
		return ResponseEntity.ok(updatedOrganizer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id){
		organizerService.deleteOrganizer(id);
		return ResponseEntity.noContent().build();
	}

}
