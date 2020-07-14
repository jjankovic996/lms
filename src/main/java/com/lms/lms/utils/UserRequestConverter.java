package com.lms.lms.utils;

import com.lms.lms.enums.Title;
import com.lms.lms.model.User;
import com.lms.lms.model.dto.CreateUserRequestDto;

public class UserRequestConverter implements Converter<User, CreateUserRequestDto> {

    @Override
    public CreateUserRequestDto entityToType(User entity) {
        CreateUserRequestDto type = new CreateUserRequestDto();
        type.setTitle(entity.getTitle().name());
        type.setFirstName(entity.getFirstName());
        type.setLastName(entity.getLastName());
        type.setEmail(entity.getEmail());
        type.setPassword(entity.getPassword());
        type.setAge(entity.getAge());

        return type;
    }

    @Override
    public User typeToEntity(CreateUserRequestDto type) {
        User entity = new User();
        entity.setTitle(Title.valueOf(type.getTitle()));
        entity.setFirstName(type.getFirstName());
        entity.setLastName(type.getLastName());
        entity.setEmail(type.getEmail());
        entity.setPassword(type.getPassword());
        entity.setAge(type.getAge());

        return entity;
    }
}
