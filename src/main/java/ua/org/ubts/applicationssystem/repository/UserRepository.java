package ua.org.ubts.applicationssystem.repository;

import ua.org.ubts.applicationssystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByLogin(String login);

}
