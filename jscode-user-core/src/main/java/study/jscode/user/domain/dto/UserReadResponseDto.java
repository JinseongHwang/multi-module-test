package study.jscode.user.domain.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.jscode.user.domain.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public final class UserReadResponseDto {

    private Long userId;

    private String name;

    private Double gpa;

    @Builder
    public UserReadResponseDto(Long userId, String name, Double gpa) {
        this.userId = userId;
        this.name = name;
        this.gpa = gpa;
    }

    public static UserReadResponseDto toDto(User entity) {
        return UserReadResponseDto.builder()
            .userId(entity.getUserId())
            .name(entity.getName())
            .gpa(entity.getGpa())
            .build();
    }
}
