package com.aws.service.test.service.impl;

import org.springframework.stereotype.Service;

import com.aws.service.test.dao.UsersRepository;
import com.aws.service.test.domain.Users;
import com.aws.service.test.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UsersRepository usersRepository;
	
	@Override
	public long addUser(Users user) {
		
		Users result = usersRepository.save(user);
		return result.getId();
	}

	@Override
	public Users getUser(long id) {
		return usersRepository.getById(id);
	}

}
