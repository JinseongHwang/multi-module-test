package study.jscode.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.jscode.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
