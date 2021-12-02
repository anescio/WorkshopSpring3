package com.skni.workshopspring3.service;

import com.skni.workshopspring3.repo.CourseRepository;
import com.skni.workshopspring3.repo.StudentRepository;
import com.skni.workshopspring3.repo.entity.Course;
import com.skni.workshopspring3.repo.entity.CourseTypeEnum;
import com.skni.workshopspring3.repo.entity.GenderEnum;
import com.skni.workshopspring3.repo.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    
    private final StudentRepository studentRepository;

    public Student addStudent(String name, String surname, LocalDate birthdate, GenderEnum gender, Course course) {
        Student student = Student.builder()
                .name(name)
                .surname(surname)
                .birthdate(birthdate)
                .gender(gender)
                .course(course)
                .build();
        return studentRepository.save(student);
    }

    public List<Student> findAllByLastName(String lastName) {
        return studentRepository.findAllBySurname(lastName);
        //return studentRepository.findAll().stream().filter(s -> s.getSurname().equals(lastName)).collect(Collectors.toList());
    }

//    public List<Student> getStudentByGenderAndByCourseType(GenderEnum gender, CourseTypeEnum courseType) {
//        return studentRepository.findAllByGenderAndCourseType(gender,courseType);
//    }

    public List<Student> getStudentByGenderAndByCourseType(GenderEnum gender, CourseTypeEnum courseType) {
        return studentRepository.findAll().stream()
                .filter(s -> s.getCourse().getCourseType().equals(courseType) && s.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public boolean deleteStudentById(Long id){
        Optional<Student> s = studentRepository.findById(id);

        if(s.isPresent()){
            studentRepository.delete(s.get());
            return true;
        } else
            return false;
    }
}
