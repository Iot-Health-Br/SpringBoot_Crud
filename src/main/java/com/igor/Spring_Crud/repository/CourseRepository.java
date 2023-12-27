package com.igor.Spring_Crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.Spring_Crud.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
