package study.jscode.user.domain.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserUpdateRequestDto {

    private String name;

    private Double gpa;

    @Builder
    public UserUpdateRequestDto(String name, Double gpa) {
        this.name = name;
        this.gpa = gpa;
    }
}
