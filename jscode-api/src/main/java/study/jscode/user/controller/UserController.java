package study.jscode.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.jscode.user.domain.dto.UserCreateRequestDto;
import study.jscode.user.domain.dto.UserReadResponseDto;
import study.jscode.user.domain.dto.UserUpdateRequestDto;
import study.jscode.user.service.UserService;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserReadResponseDto> create(@RequestBody UserCreateRequestDto dto) {
        return ResponseEntity.ok(userService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserReadResponseDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserReadResponseDto> update(
        @PathVariable("id") Long id,
        @RequestBody UserUpdateRequestDto dto
    ) {
        return ResponseEntity.ok(userService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
