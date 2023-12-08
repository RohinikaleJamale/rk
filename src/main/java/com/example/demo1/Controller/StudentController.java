package com.example.demo1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo1.Model.Student;
import com.example.demo1.Service.StudentServiceI;

@RestController
public class StudentController {
	@Autowired
	private StudentServiceI studentServiceI;
	@PostMapping(value="saveStudent",produces="application/json",consumes ="application/json" )
 public ResponseEntity<String> saveStudent(Student stu){
		boolean student = studentServiceI.saveStudent(stu);
		if(student) {
	 return new ResponseEntity<String>("students save successfully",HttpStatus.CREATED);
 }else {
	 return new ResponseEntity<String>("students save not successfully",HttpStatus.BAD_REQUEST);
 }
 }
@PostMapping(value="saveAllStudent",produces="application/json",consumes ="application/json" )
public ResponseEntity<String> saveAllstudent(List<Student> stu){
		boolean saveAllStudent = studentServiceI.saveAllStudent(stu);
		if(saveAllStudent) {
			 return new ResponseEntity<String>("All students save successfully",HttpStatus.CREATED);
		 }else {
			 return new ResponseEntity<String>("students save not successfully",HttpStatus.BAD_REQUEST);
		 }
}
@GetMapping(value="getAllStudent",produces="application/json")
 public ResponseEntity<List<Student>>   getAllStudent(){
	 List<Student> allStudents = studentServiceI.getAllStudents();
	 return new ResponseEntity<List<Student>>(allStudents,HttpStatus.OK);
 }
@PutMapping(value="updateStudent",produces="application/json",consumes ="application/json" )
public ResponseEntity<String> updatestudent(Student stu) {
	boolean updatestudent = studentServiceI.updatestudent(stu);
	if(updatestudent) {
		 return new ResponseEntity<String>("students save successfully",HttpStatus.CREATED);
	 }else {
		 return new ResponseEntity<String>("students save not successfully",HttpStatus.BAD_REQUEST);
	 }
	}
@GetMapping(value="getStudentQuerypara",produces="application/json")
public ResponseEntity<Student> getStudentByIdQueryParam(@RequestParam int sid) {
	Student studentBy = studentServiceI.getStudentByIdQueryParam(sid);
	return new ResponseEntity<Student>(studentBy,HttpStatus.OK);
}

@GetMapping(value="getStudentPathpara",produces="application/json")
public ResponseEntity<Student> getStudentByIdpathParam(@RequestParam int sid) {
	Student studentBy1 = studentServiceI.getStudentByIdPathParam(sid);
	return new ResponseEntity<Student>(studentBy1,HttpStatus.OK);
}

@DeleteMapping("/deleteStudentByIdQueryParam")
public ResponseEntity<String> deleteStudentByIdQueryParam(@RequestParam int sid) {
boolean queryParam = studentServiceI.deleteStudentByIdQueryParam(sid);
if(queryParam) {
        return new ResponseEntity<String>("Student Deleted successfully",HttpStatus.CREATED);
}else {
	return new ResponseEntity<String>("Student  Not Deleted successfully",HttpStatus.BAD_REQUEST);
}
}
@DeleteMapping("/deleteStudentByIdPathParam")
public ResponseEntity<String> deleteStudentByIdPathParam(@RequestParam int sid) {
boolean queryParam = studentServiceI.deleteStudentByIdPathParam(sid);
if(queryParam) {
        return new ResponseEntity<String>("Student Deleted successfully",HttpStatus.CREATED);
}else {
	return new ResponseEntity<String>("Student  Not Deleted successfully",HttpStatus.BAD_REQUEST);
}
}

}

