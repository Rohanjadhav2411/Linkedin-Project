package com.backgroundimg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backgroundimg.model.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

}