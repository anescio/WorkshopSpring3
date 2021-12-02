package com.skni.workshopspring3.repo;

import com.skni.workshopspring3.repo.entity.CourseTypeEnum;
import com.skni.workshopspring3.repo.entity.GenderEnum;
import com.skni.workshopspring3.repo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query(value = "SELECT * FROM Student s JOIN Course c ON s.course_id = c.id WHERE s.gender = ?1 AND c.courseType = ?2", nativeQuery = true)
    List<Student> findAllByGenderAndCourseType(GenderEnum gender, CourseTypeEnum courseType);

    List<Student> findAll();

    List<Student> findAllBySurname(String surname);
}
