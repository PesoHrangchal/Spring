package com.springBoot.ptm.Repository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.ptm.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
//	@Query("from Student where  id like :s%")
//	Student  getOne(@Param("s") Long id);
}
