package com.sda.spring.data.jpa.validation.service;

import com.sda.spring.data.jpa.validation.dto.UserReadDto;
import com.sda.spring.data.jpa.validation.dto.UserWriteDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface IUserService {

    // UserRequest, UserCreate
    UserReadDto save(@Valid UserWriteDto dto);

    List<UserReadDto> findAll();

    Optional<UserReadDto> findById(Long id);

    UserReadDto update(Long id, UserWriteDto dto);

    void delete(Long id);
}
