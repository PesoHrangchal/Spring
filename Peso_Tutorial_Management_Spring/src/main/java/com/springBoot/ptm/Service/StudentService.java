package com.springBoot.ptm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.springBoot.ptm.Entity.Student;
@Component
public interface StudentService {
	public Student createStudent(Student student);
	public List<Student>getAllStudents();
	public Optional<Student> getAStudent(Long id);
	public String delete(Long id);
	public Student update(Student student);
}
