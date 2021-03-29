package com.sda.spring.data.jpa.validation.service;

import com.sda.spring.data.jpa.validation.dto.UserMapper;
import com.sda.spring.data.jpa.validation.dto.UserReadDto;
import com.sda.spring.data.jpa.validation.dto.UserWriteDto;
import com.sda.spring.data.jpa.validation.model.User;
import com.sda.spring.data.jpa.validation.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Validated  // evaluate constraint annotations on method params
// validate on service or controller, persistence layer might be too late
@Service
public class UserService implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserReadDto save(@Valid UserWriteDto dto) {
        log.info("saving: {}", dto);
        User user = userMapper.toEntity(dto);

        User savedUser = userRepository.save(user);

        return userMapper.toDto(savedUser);
    }

    @Override
    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream()
                .map(user -> userMapper.toDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id)
                .map(user -> userMapper.toDto(user));
    }

    //    @Override
    public UserReadDto update2(Long id, UserWriteDto dto) {
        // find user
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user with id " + id + " not found "));

        // change data
        foundUser.setName(dto.getName());
        foundUser.setEmail(dto.getEmail());
        foundUser.setConsented(dto.isConsented());
        foundUser.setAboutMe(dto.getAboutMe());

        // save
        User updatedUser = userRepository.save(foundUser);

        // convert result to dto
        return userMapper.toDto(updatedUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public UserReadDto update(Long id, UserWriteDto updateData) {
        // find user
        return userRepository.findById(id)                              // find user
                .map(user -> userMapper.toEntity(user, updateData))     // update data
                .map(updatedUser -> userRepository.save(updatedUser))   // save
                .map(savedUser -> userMapper.toDto(savedUser))          // convert to dto
                .orElseThrow(() -> new RuntimeException("user with id " + id + " not found "));
    }

}
