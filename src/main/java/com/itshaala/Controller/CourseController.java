package com.itshaala.Controller;

import com.itshaala.Model.Course;
import com.itshaala.Service.CourseService;

import java.util.List;

public class CourseController {

    CourseService courseService = new CourseService();

    public void addCourse(Course course){
        courseService.addCourse(course);
    }
    public void updateCourse(Course course){
        courseService.updateCourse(course);
    }
    public void deleteCourse(int courseId){
        courseService.deleteCourse(courseId);
    }
        public List<Course> findAll(){
            return courseService.findAll();
        }

}
