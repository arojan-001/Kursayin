package com.saga.kursayin.persistence.repository;

import com.saga.kursayin.persistence.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity,Long> {
}
