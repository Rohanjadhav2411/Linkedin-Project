package com.clone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.model.Options;

@Repository
public interface OptionsRepository extends JpaRepository<Options, Long> {

}
