package com.unla.grpc.repositories;

import com.unla.grpc.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsernameAndPasswordAndRole(String username, String password, String role);

    Optional<User> findByUsernameOrEmailOrDni(String username, String email, int dni);

}
