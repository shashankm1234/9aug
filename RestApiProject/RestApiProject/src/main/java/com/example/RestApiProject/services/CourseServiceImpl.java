package com.example.RestApiProject.services;
import com.example.RestApiProject.data.Entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{
    // here we're creating a list to temporarily store data
    List<Course> list;
    public CourseServiceImpl(){
        // here we're creating data but we can also use our DATABASE to give the data
        list = new ArrayList<>();
        list.add(new Course(145,"Java Core Course","this course contains basics of java"));
        list.add(new Course(4343,"Spring Boot Course","creating rest api using spring boot"));
    }
    @Override
    public List<Course> getCourses(){
        return list;
    }

    @Override
    public Course getCourse(int courseId) {
        Course c=null;
        for(Course course:list){
            if(course.getId()==courseId){
                c = course;
                break;               // when we get that courseId we were founding, we put it in c and break foreach loop
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        list.forEach(e->{
            if(e.getId()==course.getId()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        return course;
    }

    @Override
    public void deleteCourse(int parseInt) {
        list = this.list.stream().filter(e->e.getId()!=parseInt).collect(Collectors.toList());
    }
}
// when getCourses() is called this list gets returned
// @Service means this class is working as Service Layer i.e. Spring framework identifies this class as a Service class
// when we request for /courses , we get data in JSON format
// we get an array of courses with id,title,description

// in updateCourse(): traversing list using foreach, e is lambda function, e will have a course
// agar naya course which we're updating uski id or hamare current course in foreach uski id same h then
// we'll add its title & description
// jo course hum pass krenge uski id list me sbhi courses ki id se match hogi, we'll update that course and return same

// in deletion: list se ek stream nikalke filter if our id isnt equal to its id