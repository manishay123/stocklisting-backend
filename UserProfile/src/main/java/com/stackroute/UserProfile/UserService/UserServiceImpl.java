package com.stackroute.UserProfile.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.UserProfile.UserEntity.User;
import com.stackroute.UserProfile.UserException.UserAlreadyExistException;
import com.stackroute.UserProfile.UserException.UserNotFoundException;
import com.stackroute.UserProfile.UserRepository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserRepository userRepository;

	@Override
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		 return userRepository.findById(userId)
	                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		if (userRepository.findByUserName(user.getUserName()).isPresent()) {
            throw new UserAlreadyExistException("Username already exists: " + user.getUserName());
        }
		return userRepository.save(user);
	}

	@Override
	 public User updateUser(long userId, User user) {

	        // Check if the user with the given userId exists
	        Optional<User> optionalUser = userRepository.findById(userId);
	        if (optionalUser.isPresent()) {
	            User existingUser = optionalUser.get();

	            // Update the fields with the new values
	            existingUser.setUserName(user.getUserName());
	            existingUser.setFirstName(user.getFirstName());
	            existingUser.setLastName(user.getLastName());
	            existingUser.setPhone(user.getPhone());
	            existingUser.setPassword(user.getPassword());
	            existingUser.setEmailId(user.getEmailId());
	            existingUser.setCountry(user.getCountry());

	            // Save the updated user
	            return userRepository.save(existingUser);
	        } else {
	            throw new UserNotFoundException("User not found with id: " + userId);
	        }
	}
}
	