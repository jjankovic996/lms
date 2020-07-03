package com.lms.lms.service;

import com.lms.lms.model.User;
import com.lms.lms.model.dto.CreateStudentRequest;
import com.lms.lms.model.dto.CreateStudentResponse;
import com.lms.lms.repository.StudentRepository;
import com.lms.lms.utils.StudentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter = new StudentConverter();

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        User student = studentConverter.typeToEntity(createStudentRequest);

        studentRepository.save(student);

        return new CreateStudentResponse(student.getEmail(), student.getPassword());
    }
}
