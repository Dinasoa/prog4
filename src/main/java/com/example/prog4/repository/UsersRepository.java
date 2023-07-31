package com.example.prog4.repository;

import com.example.prog4.controller.viewModel.User;
import com.example.prog4.model.Users;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUsernameAndPassword(String username, String password);
    Users findByUsername(String username);
}
