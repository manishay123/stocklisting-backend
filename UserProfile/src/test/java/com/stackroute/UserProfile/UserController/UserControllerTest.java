package com.stackroute.UserProfile.UserController;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.stackroute.UserProfile.UserRepository.UserRepository;
import com.stackroute.UserProfile.UserService.UserService;

public class UserControllerTest {

	@InjectMocks
    private UserController userController;
 
    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;

}
