package com.example.demo.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Post createPost(@RequestParam("file") MultipartFile file,
                           @RequestParam("content") String content,
                           @RequestParam("authorId") Long authorId) throws IOException {
        Post post = new Post();
        post.setContent(content);
        post.setFileData(file.getBytes());
        post.setAuthor(userRepository.getById(authorId));
        post.setCreatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
