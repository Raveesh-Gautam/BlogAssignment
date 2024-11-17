package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entity.Blog;
import com.assignment.repository.BlogRepository;
@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getBlogsByUserId(Long userId) {
        return blogRepository.findAllByUserId(userId);
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Long blogId, Blog updatedBlog) {
        Blog existingBlog = blogRepository.findById(blogId).orElseThrow(() -> new RuntimeException("Blog not found"));
        existingBlog.setBlogName(updatedBlog.getBlogName());
        existingBlog.setBody(updatedBlog.getBody());
        return blogRepository.save(existingBlog);
    }

    public void deleteBlog(Long blogId) {
        blogRepository.deleteById(blogId);
    }

}
