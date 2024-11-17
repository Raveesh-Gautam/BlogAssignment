package com.assignment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entity.Blog;
import com.assignment.service.BlogService;
import com.assignment.service.ReportService;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private ReportService reportService;

    @GetMapping("/{userId}")
    public List<Blog> getUserBlogs(@PathVariable Long userId) {
        return blogService.getBlogsByUserId(userId);
    }

    @PostMapping
    public String createBlog(@RequestBody Blog blog) {
         blogService.createBlog(blog);
         return "blog created";
         
    }

    @PutMapping("/{blogId}")
    public Blog updateBlog(@PathVariable Long blogId, @RequestBody Blog updatedBlog) {
        return blogService.updateBlog(blogId, updatedBlog);
    }

    @DeleteMapping("/{blogId}")
    public String deleteBlog(@PathVariable Long blogId) {
        blogService.deleteBlog(blogId);
        return "Blog deleted successfully!";
    }

    @GetMapping("/report/{userId}")
    public Map<String, Integer> getBlogReport(@PathVariable Long userId) {
        List<Blog> blogs = blogService.getBlogsByUserId(userId);
        List<String> blogBodies = blogs.stream().map(Blog::getBody).toList();
        return reportService.getTopWords(blogBodies);
    }
}
