package com.backgroundimg.service;


import org.springframework.stereotype.Service;

import com.backgroundimg.model.Image;

import java.util.List;

@Service
public interface ImageService {
    public Image create(Image image);
    public List<Image> viewAll();
    public Image viewById(long id);
}