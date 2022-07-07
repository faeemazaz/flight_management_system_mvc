package com.flightbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbook.entity.Passanger;

@Repository
public interface PassangerRepo extends JpaRepository<Passanger, Long> {

}
