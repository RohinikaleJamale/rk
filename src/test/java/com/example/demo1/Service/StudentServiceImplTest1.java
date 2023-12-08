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

}
