package study.jscode.user.service;

import study.jscode.user.domain.dto.UserCreateRequestDto;
import study.jscode.user.domain.dto.UserReadResponseDto;
import study.jscode.user.domain.dto.UserUpdateRequestDto;

public interface UserService {

    UserReadResponseDto create(UserCreateRequestDto dto);

    UserReadResponseDto read(Long id);

    UserReadResponseDto update(Long id, UserUpdateRequestDto dto);

    void delete(Long id);
}
