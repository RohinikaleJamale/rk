package com.example.demo1.Service;

import java.util.List;

import com.example.demo1.Model.Student;

public interface StudentServiceI {
      public boolean saveStudent(Student stu);
      public boolean saveAllStudent(List<Student> stu);
      public List<Student> getAllStudents();
      public boolean updatestudent(Student stu);
      public boolean deleteAll();
      public Student getStudentByIdQueryParam(int sid);
      public Student getStudentByIdPathParam(int sid);
      public boolean deleteStudentByIdQueryParam(int sid);
      public boolean deleteStudentByIdPathParam(int sid);



}
