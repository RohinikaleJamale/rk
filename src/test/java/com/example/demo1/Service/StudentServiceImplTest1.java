package com.example.demo1.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;
import org.junit.jupiter.api.Test;

import com.example.demo1.Model.Student;
import com.example.demo1.Repository.StudentRepository;

class StudentServiceImplTest1 {

	@Test
	public void getAllStudentTest() throws Exception {
		StudentRepository daoProxy = EasyMock.createMock(StudentRepository.class);// mock for dependent object
		List<Student> list = new ArrayList<Student>();
		Student s = new Student(); // crate our own list.
		s.setStuId(101);
		s.setStuName("Rohini");
		s.setStuAddr("Pune");
		s.setStuEmail("rohini@gmail.com");
		s.setStuPass("123e");
		Student s2 = new Student();
		s2.setStuId(102);
		s2.setStuName("amit");
		s2.setStuAddr("Kolapur");
		s2.setStuEmail("Amit@gmail.com");
		s2.setStuPass("1245r");
		list.add(s);
		list.add(s2);

		EasyMock.expect(daoProxy.findAll()).andReturn(list);
		EasyMock.replay(daoProxy);
		StudentServiceImpl impl = new StudentServiceImpl();
		impl.setStudentRepository(daoProxy);
		List<Student> actualResult = impl.getAllStudents();
		Integer expectedList = 2;
		assertEquals(expectedList, actualResult.size());
	}
	@Test
	public void getStudentByIdQueryParamtest() throws Exception {
		
		 StudentRepository daoproxy1 = EasyMock.createMock(StudentRepository.class);
		 
		 StudentServiceImpl impl=new StudentServiceImpl();
		 impl.setStudentRepository(daoproxy1);
		 Student s1 = new Student(); // crate our own list.
			s1.setStuId(101);
			s1.setStuName("Rohini");
			s1.setStuAddr("Pune");
			s1.setStuEmail("rohini@gmail.com");
			s1.setStuPass("123e");
			Integer id=101;
			
	         EasyMock.expect(daoproxy1.findById(id)).andReturn(s1);
	         
	         EasyMock.replay(daoproxy1);
	
	 Student originalrecord = impl.getStudentByIdPathParam(101);
	 String StuName="kale";
	 assertEquals( StuName, originalrecord.getStuName());
	 assertEquals( "pune", originalrecord.getStuAddr());
	 assertEquals( "13225", originalrecord.getStuPass());
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
    }
