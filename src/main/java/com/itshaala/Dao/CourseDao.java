package com.itshaala.Dao;

import com.itshaala.Model.Course;
import com.itshaala.Util.ConnectionUtil;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    @SneakyThrows
    public void addCourse(Course course) {
        Connection connection  = ConnectionUtil.getConnection();
            String sqlQuery = "insert into course(name, discription, price) VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1,course.getName());
        preparedStatement.setString(2,course.getDiscription());
        preparedStatement.setInt(3,course.getPrice());
        preparedStatement.executeUpdate();
        System.out.println("Course Added");
        connection.close();
    }
@SneakyThrows
    public void updateCourse(Course course) {
        Connection connection = ConnectionUtil.getConnection();
        String sqlQuery = "update course set name =?, discription=?, price=? where id = ?";
        PreparedStatement preparedStatement =connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, course.getName());
        preparedStatement.setString(2, course.getDiscription());
        preparedStatement.setInt(3, course.getPrice());
        preparedStatement.setInt(4, course.getId());
        preparedStatement.executeUpdate();
    System.out.println("Course Updated");
    connection.close();
    }
@SneakyThrows
    public void deleteCourse(int courseId) {
        Connection connection = ConnectionUtil.getConnection();
        String sqlQuery = "delete from course where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, courseId);
        preparedStatement.executeUpdate();
    System.out.println("Course Deleted");
    connection.close();
    }

@SneakyThrows
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Connection connection = ConnectionUtil.getConnection();
    Statement statement = connection.createStatement();
    String sqlQuery = "select * from course";
    ResultSet resultSet = statement.executeQuery(sqlQuery);
    while(resultSet.next()){
        Course course = Course.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .discription(resultSet.getString("discription"))
                .id(resultSet.getInt("price"))
                .build();
        courseList.add(course);
    }
    connection.close();
    return courseList;
    }
}
