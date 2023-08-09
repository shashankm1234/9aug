package com.example.RestApiProject.services;

import com.example.RestApiProject.data.Entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();

    public Course getCourse(int courseId);

    public Course addCourse(Course course);

    public Course updateCourse(Course course);

    public void deleteCourse(int parseInt);

}
// cant give body since its an interface
// implement this in a new class