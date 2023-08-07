package com.studentapp;

import java.util.List;

import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.studentapp.entity.Student;
import com.studentapp.repo.StudentRepo;

@SpringBootApplication
public class StudentappApplication implements CommandLineRunner {

	@Autowired
	private StudentRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		init();
		
		//someMethodAutoGenQuaries();
//		Student getStudentByEmail(String email);
//		
//		Student student=repo.getStudentByEmail("ravi@gmail.com");
//		System.out.println(student);
//		@Query("select s.firstName from Student s where s.email=?1")
//		String getStudentNameByEmail(String email);
//		
		
//		String studentName=repo.getStudentNameByEmail("ravi@gmail.com");
//		System.out.println(studentName);
		
		
//		//SQL
//		@Query(value = "select * from student_table s where s.email=?1", nativeQuery = true)
//		Student getStudentByEmailNativeQuery(String email);

//		Student student=repo.getStudentByEmailNativeQuery("ravi@gmail.com");
//		System.out.println(student);
		
//		@Query(value = "select * from student_table s where s.email=:email", nativeQuery = true)
//		Student getStudentByEmailNativeQueryUsingParam(@Param("email")  String email);
		
//		Student student=repo.getStudentByEmailNativeQueryUsingParam("ravi@gmail.com");
//		System.out.println(student);
	}

	private void someMethodAutoGenQuaries() {
		System.out.println("---");
//		List<Student> findByFirstName(String firstName);
		
//		List<Student> findbyLastname= repo.findByLastName("gupta");
//		findbyLastname.forEach(s-> System.out.println(s));
		
//		List<Student> findByFirstNameContaining(String firstName);
//		List<Student> findbyFirstname= repo.findByFirstNameContaining("raj");
//		findbyFirstname.forEach(s-> System.out.println(s));
		
//		List<Student> findByLastName(String firstName);
		
//		List<Student> findByFistName= repo.findByFirstName("rajeev");
//		findByFistName.forEach(s-> System.out.println(s));
		
//		List<Student> findByLastNameNotNull();
//		List<Student> findByLastNameNotNull=repo.findByLastNameNotNull();
//		findByLastNameNotNull.forEach(st-> System.out.println(st));
		
//		List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	}

	private void init() {
		repo.save(new Student("rajeev", "gupta", "r@gmail.com"));
		repo.save(new Student("ravi", "kumar", "ravi@gmail.com"));
		repo.save(new Student("anit", "gupta", "anil@gmail.com"));
		repo.save(new Student("suman", "kumari", "sk@gmail.com"));
		
		repo.save(new Student("gunika", "gupta", "gun@gmail.com"));
		repo.save(new Student("ekta",null, "ekta@gmail.com"));
	}

}
