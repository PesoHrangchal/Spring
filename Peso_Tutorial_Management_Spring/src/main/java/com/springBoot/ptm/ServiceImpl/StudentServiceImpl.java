package com.springBoot.ptm.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.ptm.Entity.Student;
import com.springBoot.ptm.Repository.StudentRepository;
import com.springBoot.ptm.Service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repo;
	
	@Override
	public Student createStudent(Student s) {
		// TODO Auto-generated method stub
		return repo.save(s);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Student> getAStudent(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Student update(Long id) {
		// TODO Auto-generated method stub
		Student s=repo.getById(id);
		return repo.save(s);
	}

	@Override
	public String delete(Long id) {
		// TODO Auto-generated method stub
		Student s=repo.getById(id);
		repo.delete(s);
		return "The student with id "+id+" is deleted successfully"; 
	}

}
