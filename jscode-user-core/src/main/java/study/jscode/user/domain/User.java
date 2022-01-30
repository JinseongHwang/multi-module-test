package study.jscode.user.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private double gpa;

    @Builder
    public User(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateGpa(double gpa) {
        this.gpa = gpa;
    }

    public User() {
    }
}
