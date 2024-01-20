package com.igor.Spring_Crud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public @ResponseBody List<Course>list(){
        return courseRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id){
       return courseRepository.findById(id)
       .map(recordFound -> ResponseEntity.ok().body(recordFound))
       .orElse(ResponseEntity.notFound().build());
    }

    //Metodo só vai ser chamado quando realizar um http post
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course){
        //Retorne o status do salvamento da informação
        return courseRepository.save(course);

        //outro metodo abaixo.

        //Retorne o status do salvamento da informação
        //return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
    }

    //Vai atualizar as informações do registro do objeto
    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course){
        return courseRepository.findById(id)
        .map(recordFound -> {
            recordFound.setName(course.getName());
            recordFound.setCategoria(course.getCategoria());
            Course updated = courseRepository.save(recordFound);
            return ResponseEntity.ok().body(updated);
        } )
        .orElse(ResponseEntity.notFound().build());
    }
}
