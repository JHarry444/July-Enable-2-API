package com.qa.biscuits.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.biscuits.domain.Biscuit;

@Repository
public interface BiscuitRepo extends JpaRepository<Biscuit, Integer> {

}
