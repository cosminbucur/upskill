package com.sda.spring.data.jpa.validation.config;

import com.sda.spring.data.jpa.validation.dto.UserReadDto;
import com.sda.spring.data.jpa.validation.dto.UserWriteDto;
import com.sda.spring.data.jpa.validation.model.User;
import com.sda.spring.data.jpa.validation.repository.UserRepository;
import com.sda.spring.data.jpa.validation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidationConfig {

    @Autowired
    private UserRepository repository;

    @Autowired
    private IUserService userService;

    @Bean
    public CommandLineRunner validationData() {
        return args -> {
            testValidations();
            testService();
        };
    }

    // TODO: add validation before save
    private void testValidations() {
        User goodUser = createGoodUser();
        User badUser = createBadUser();
        repository.save(goodUser);
        repository.save(badUser);
    }

    private User createGoodUser() {
        User user = new User();
        user.setName("paul");
        user.setEmail("paul@gmail.com");
        user.setConsented(true);
        user.setAge(20);
        user.setAboutMe("learn to code every day");
        return user;
    }

    private User createBadUser() {
        User user = new User();
        user.setName("");
        user.setEmail("paulgmail.com");
        user.setConsented(false);
        user.setAge(5);
        user.setAboutMe("...");
        return user;
    }

    private void testService() {
        UserWriteDto dto = new UserWriteDto();
        dto.setName("paul");
        dto.setEmail("paul@gmail.com");
        dto.setConsented(true);
        dto.setAge(20);
        dto.setAboutMe("learn to code every day");

        UserReadDto savedUserDto = userService.save(dto);

        List<UserReadDto> allUsersDto = userService.findAll();

        UserReadDto foundUserDto = userService.findById(savedUserDto.getId()).get();

        UserWriteDto updateData = new UserWriteDto();
        updateData.setName("paul1");
        updateData.setEmail("paul@gmail.com1");
        updateData.setConsented(false);
        updateData.setAge(21);
        updateData.setAboutMe("learn to code every day1");

        UserReadDto updatedUserDto = userService.update(foundUserDto.getId(), updateData);

        userService.delete(updatedUserDto.getId());
    }
}
