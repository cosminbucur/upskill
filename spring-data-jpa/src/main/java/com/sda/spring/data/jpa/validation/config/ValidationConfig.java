package com.sda.spring.data.jpa.validation.config;

import com.sda.spring.data.jpa.validation.dto.UserReadDto;
import com.sda.spring.data.jpa.validation.dto.UserWriteDto;
import com.sda.spring.data.jpa.validation.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Component
public class ValidationConfig {

    private static final Logger log = LoggerFactory.getLogger(ValidationConfig.class);

    @Autowired
    private IUserService userService;

    @Bean
    public CommandLineRunner validationData() {
        return args -> {
            testProgrammaticValidations();
            testService();
        };
    }

    private void testProgrammaticValidations() {
        UserWriteDto goodUser = createUser();
        isValid(goodUser);

        UserWriteDto badUser = createBadUser();
        isValid(badUser);
    }

    // check if dto is valid
    private boolean isValid(UserWriteDto dto) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<UserWriteDto>> constraintViolations = validator.validate(dto);

        if (!constraintViolations.isEmpty()) {
            log.info("validating user: {}", dto);
            constraintViolations
                    .forEach(violation -> log.error("violation: {}", violation.getMessage()));
            return false;
        }
        return true;
    }

    private void testService() {
        // extract method
        UserWriteDto dto = createBadUser();

        UserReadDto savedUserDto = userService.save(dto);

        List<UserReadDto> allUsersDto = userService.findAll();

        UserReadDto foundUserDto = userService.findById(savedUserDto.getId()).get();

        UserWriteDto updateData = new UserWriteDto();
        updateData.setName("paul1");
        updateData.setEmail("paul@gmail.com1");
        updateData.setConsented(true);
        updateData.setAge(21);
        updateData.setAboutMe("learn to code every day1");

        UserReadDto updatedUserDto = userService.update(foundUserDto.getId(), updateData);

        userService.delete(updatedUserDto.getId());
    }

    private UserWriteDto createBadUser() {
        UserWriteDto dto = new UserWriteDto();
        dto.setName("");
        dto.setEmail("paulgmail.com");
        dto.setConsented(false);
        dto.setAge(5);
        dto.setAboutMe("...");
        return dto;
    }

    private UserWriteDto createUser() {
        UserWriteDto dto = new UserWriteDto();
        dto.setName("paul");
        dto.setEmail("paul@gmail.com");
        dto.setConsented(true);
        dto.setAge(20);
        dto.setAboutMe("learn to code every day");
        return dto;
    }
}
