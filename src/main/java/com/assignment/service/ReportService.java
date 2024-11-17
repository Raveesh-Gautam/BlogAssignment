package com.assignment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ReportService {
	 public Map<String, Integer> getTopWords(List<String> blogBodies) {
	        Map<String, Integer> wordCount = new HashMap<>();
	        blogBodies.forEach(body -> {
	            String[] words = body.toLowerCase().split("\\W+");
	            for (String word : words) {
	                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
	            }
	        });
	        return wordCount.entrySet()
	                        .stream()
	                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
	                        .limit(5)
	                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	    }
}
