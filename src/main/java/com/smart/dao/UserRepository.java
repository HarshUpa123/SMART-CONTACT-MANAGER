package com.smart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
