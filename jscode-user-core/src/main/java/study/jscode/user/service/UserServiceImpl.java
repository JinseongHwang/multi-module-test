package study.jscode.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.jscode.user.domain.User;
import study.jscode.user.domain.dto.UserCreateRequestDto;
import study.jscode.user.domain.dto.UserReadResponseDto;
import study.jscode.user.domain.dto.UserUpdateRequestDto;
import study.jscode.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserReadResponseDto create(UserCreateRequestDto dto) {
        final User user = dto.toEntity();
        final User savedUser = userRepository.save(user);
        return UserReadResponseDto.toDto(savedUser);
    }

    @Transactional(readOnly = true)
    @Override
    public UserReadResponseDto read(Long id) {
        final User foundUser = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 User ID 입니다."));
        return UserReadResponseDto.toDto(foundUser);
    }

    @Transactional
    @Override
    public UserReadResponseDto update(Long id, UserUpdateRequestDto dto) {
        final User foundUser = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 User ID 입니다."));
        foundUser.updateName(dto.getName());
        foundUser.updateGpa(dto.getGpa());
        return UserReadResponseDto.toDto(foundUser);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        final User foundUser = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 User ID 입니다."));
        userRepository.delete(foundUser);
    }
}
