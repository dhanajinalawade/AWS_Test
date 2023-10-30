package com.aws.service.test.service;

import com.aws.service.test.domain.Users;

public interface UserService {

	
	long addUser(Users user);
	
	Users getUser(long id);
	
}
