package com.eventmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanagementsystem.entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long>{

}
