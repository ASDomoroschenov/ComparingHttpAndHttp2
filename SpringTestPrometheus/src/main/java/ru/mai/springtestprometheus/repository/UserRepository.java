package ru.mai.springtestprometheus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mai.springtestprometheus.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
