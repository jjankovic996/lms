package com.lms.lms.service;

import com.lms.lms.model.Course;
import com.lms.lms.model.User;
import com.lms.lms.model.dto.AddCourseDto;
import com.lms.lms.repository.CourseRepository;
import com.lms.lms.repository.UserRepository;
import com.lms.lms.utils.AddCourseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final AddCourseConverter addCourseConverter;
    private final UserRepository userRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository,
                         AddCourseConverter addCourseConverter,
                         UserRepository  userRepository) {
        this.courseRepository = courseRepository;
        this.addCourseConverter = addCourseConverter;
        this.userRepository = userRepository;
    }

    public AddCourseDto addCourseDto(AddCourseDto addCourseDto) {
        Course course = addCourseConverter.entityToType(addCourseDto);

        User professor = userRepository.findById(addCourseDto.getProfessorId()).get();

        course.setProfessor(professor);

        course = courseRepository.save(course);

        return addCourseConverter.typeToEntity(course);
    }
}
