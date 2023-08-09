package com.example.RestApiProject.controller;

//import org.springframework.stereotype.Controller;
import com.example.RestApiProject.data.Entity.Course;
import com.example.RestApiProject.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller returns view, @RestController returns JSON format
@RestController
public class MyController {
    @Autowired
    private CourseService courseService;
//     home fn() gets fired when request comes for /home
    @GetMapping("/home")
    public String home(){
        return "Welcome to Courses application";
    }

    // to get the courses list
    @GetMapping("/courses")
    public List<Course> getCourses(){
        // now to return the courses we goto service layer
        return this.courseService.getCourses();
    }

    // to get a single course instead of all courses
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Integer.parseInt(courseId));
    }

    // to add a course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    // updating course using PUT
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    // DELETING A COURSE
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try{
            this.courseService.deleteCourse(Integer.parseInt(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
// CourseService interface method getCourses() gets called
// using @Autowired spring hamare lie object ko create krdega
// CourseService interface ki implementation class CourseServiceImpl ka object create krdega and use lake
// courseService variable me inject krdega
// @Autowired gives us object and injects it i.e. LOOSE COUPLING
// when object comes using @Autowired we simply call its method getCourses()

// @PathVariable String courseId puts value of {courseId} into this variable String courseId
// then getCourse() method of CourseService gets called, it takes Id in Integer
// PUT -> we need Course object , this comes from @RequestBody

// @PostMapping(path = "/courses",consumes = "application/json") tells data comes in json format, not necessary to write

// DELETE: take courseId to delete the course, calls deleteCourse() method