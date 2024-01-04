package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	 @Autowired
	    private CommentRepository commentRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PostRepository postRepository;

	    @PostMapping
	    public Comment createComment(@RequestBody CommentRequest commentRequest) {
	        Comment comment = new Comment();
	        comment.setAuthor(userRepository.getById(commentRequest.getAuthorId()));
	        comment.setPost(postRepository.getById(commentRequest.getPostId()));
	        comment.setCommentText(commentRequest.getCommentText());
	        comment.setLikeCount(commentRequest.getLikeCount());
	        comment.setCreatedAt(LocalDateTime.now());
	        return commentRepository.save(comment);
	    }

	    @GetMapping("/post/{postId}")
	    public List<Comment> getCommentsByPost(@PathVariable Long postId) {
	        return commentRepository.findByPostId(postId);
	    }

}
