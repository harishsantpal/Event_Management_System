package com.eventmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanagementsystem.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

}
