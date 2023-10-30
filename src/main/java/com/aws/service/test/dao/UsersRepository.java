package com.aws.service.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aws.service.test.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
