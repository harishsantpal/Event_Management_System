package com.eventmanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagementsystem.entity.Organizer;
import com.eventmanagementsystem.repository.OrganizerRepository;

@Service
public class OrganizerService {
	
	@Autowired
	private OrganizerRepository organizerRepository;
	
	public Organizer createOrganizer(Organizer organizer) {
		return organizerRepository.save(organizer);
	}
	
	public Optional<Organizer> getOrganizerById(Long id){
		return organizerRepository.findById(id);
	}
	
	public List<Organizer> getAllOrganizers(){
		return organizerRepository.findAll();
	}
	
	public Organizer updateOrganizer(Long id, Organizer orgainzerDetails) {
		Organizer organizer=organizerRepository.findById(id).orElseThrow(()->new RuntimeException("Organizer Not Found!"));
		organizer.setName(orgainzerDetails.getName());
		organizer.setContactInfo(orgainzerDetails.getContactInfo());
		return organizerRepository.save(organizer);
	}
	
	public void deleteOrganizer(Long id) {
		organizerRepository.deleteById(id);
	}

}
