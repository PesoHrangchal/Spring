package com.springBoot.ptm.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.ptm.Entity.Student;
import com.springBoot.ptm.Service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String show() {
		return "Welcome to Peso Tutorial Management!";
	}
	
	@GetMapping("/students")
	public List<Student> getCallStudents(){
		return this.studentService.getAllStudents();
	}
	
	@GetMapping("/student/{id}")
	public Optional<Student> getAStudent(@PathVariable Long id){
		return this.studentService.getAStudent(id);
	}
	
	@PostMapping("/student")
	public Student createANewStudent(@RequestBody Student student) {
		return this.studentService.createStudent(student);
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		return this.studentService.update(student);
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return this.studentService.delete(id);
	}
}
