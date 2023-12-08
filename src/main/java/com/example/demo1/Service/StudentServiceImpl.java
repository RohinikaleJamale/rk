package com.example.demo1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.Model.Student;
import com.example.demo1.Repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentServiceI{
	@Autowired
private StudentRepository studentRepository;
	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public boolean saveStudent(Student stu) {
		Student student = studentRepository.save(stu);
		if(student !=null) {
	    return true;
		}else {
			return false;
	}
	}

	@Override
	public boolean saveAllStudent(List<Student> stu) {
		List<Student> saveAll = studentRepository.saveAll(stu);
		if(saveAll.isEmpty()) {
			return false;
		}else {
			
		return true;
		}
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> findAll = studentRepository.findAll();
		return findAll;
	}

	@Override
	public boolean updatestudent(Student stu) {
		Student save = studentRepository.save(stu);
		if(save !=null) {
		    return true;
			}else {
				return false;
		}
	}

	@Override
	public boolean deleteAll() {
		List<Student> findAll = studentRepository.findAll();
		if(findAll.isEmpty()) {
			return false;
			}else {
		return true;
	}
}

	@Override
	public Student getStudentByIdQueryParam(int sid) {
		Student findById = studentRepository.findById(sid).get();
		return findById;
	}
	
	@Override
	public Student getStudentByIdPathParam(int sid) {
		Student findbyid1 = studentRepository.findById(sid).get();
		return findbyid1;
	}

	@Override
	public boolean deleteStudentByIdQueryParam(int sid) {
		        boolean existsById = studentRepository.existsById(sid);
		        if(existsById) {
		        	studentRepository.deleteById(sid);
		        }else {
		        }
		        return existsById;
		        }
		@Override
	public boolean deleteStudentByIdPathParam(int sid) {
		boolean existsById1 = studentRepository.existsById(sid);
		if(existsById1) {
			studentRepository.deleteById(sid);
		}else {
		}
			return existsById1;
		}
		
	}
