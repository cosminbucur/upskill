package com.sda.spring.data.jpa.validation.dto;

import com.sda.spring.data.jpa.validation.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserWriteDto dto) {
        User entity = new User();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setConsented(dto.isConsented());
        entity.setAboutMe(dto.getAboutMe());
        entity.setAge(dto.getAge());
        return entity;
    }

    public User toEntity(User userToUpdate, UserWriteDto updateInfo) {
        userToUpdate.setName(updateInfo.getName());
        userToUpdate.setEmail(updateInfo.getEmail());
        userToUpdate.setConsented(updateInfo.isConsented());
        userToUpdate.setAboutMe(updateInfo.getAboutMe());
        userToUpdate.setAge(updateInfo.getAge());
        return userToUpdate;
    }

    public UserReadDto toDto(User entity) {
        UserReadDto dto = new UserReadDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setConsented(entity.isConsented());
        dto.setAboutMe(entity.getAboutMe());
        dto.setAge(entity.getAge());
        return dto;
    }
}
