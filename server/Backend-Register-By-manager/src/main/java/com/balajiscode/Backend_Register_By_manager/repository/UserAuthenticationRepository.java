package com.balajiscode.Backend_Register_By_manager.repository;

import com.balajiscode.Backend_Register_By_manager.entity.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication, Long> {
}
