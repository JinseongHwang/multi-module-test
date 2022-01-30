package study.jscode.user.domain.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.jscode.user.domain.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public final class UserCreateRequestDto {

    private String name;

    private Double gpa;

    @Builder
    public UserCreateRequestDto(String name, Double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public User toEntity() {
        return User.builder()
            .name(this.name)
            .gpa(this.gpa)
            .build();
    }
}
