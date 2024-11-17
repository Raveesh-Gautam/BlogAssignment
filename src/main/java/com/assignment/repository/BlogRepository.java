package com.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assignment.entity.Blog;

public interface BlogRepository  extends JpaRepository<Blog,Long>{
	@Query(value="Select * from blogs where user_id=:userId",nativeQuery=true)
	List<Blog> findAllByUserId(@Param("userId") Long userId);

}
