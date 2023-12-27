package com.igor.Spring_Crud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.Spring_Crud.model.Course;
import com.igor.Spring_Crud.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    // Private final e para garantir a não alteração desta instancia
    private final CourseRepository courseRepository;

    @GetMapping
    public List<Course>list(){
        return courseRepository.findAll();
    }

}
