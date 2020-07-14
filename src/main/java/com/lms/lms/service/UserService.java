package com.lms.lms.service;

import com.lms.lms.model.User;
import com.lms.lms.model.dto.CreateUserRequestDto;
import com.lms.lms.model.dto.CreateUserResponseDto;
import com.lms.lms.repository.UserRepository;
import com.lms.lms.utils.UserRequestConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRequestConverter userRequestConverter = new UserRequestConverter();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CreateUserResponseDto createStudent(CreateUserRequestDto createUserRequest) {
        User user = userRequestConverter.typeToEntity(createUserRequest);

        userRepository.save(user);

        return new CreateUserResponseDto(user.getEmail(), user.getPassword());
    }
}
