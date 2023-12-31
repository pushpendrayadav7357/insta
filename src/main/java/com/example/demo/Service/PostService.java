package com.example.demo.Service;

import com.example.demo.Model.Post;
import com.example.demo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post savePost(Post post) {

        return postRepository.save(post);
    }

    public Post getPostById(Long postId) {

        return postRepository.findById(postId).orElse(null);
    }
}
