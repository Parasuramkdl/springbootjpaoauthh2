package com.prokarma.springboot.jpa.h2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prokarma.springboot.jpa.h2.dao.UserDao;
import com.prokarma.springboot.jpa.h2.entity.User;
import com.prokarma.springboot.jpa.h2.entity.UserProfile;
import com.prokarma.springboot.jpa.h2.repository.UserProfileRepository;
import com.prokarma.springboot.jpa.h2.repository.UserRepository;
import com.prokarma.springboot.jpa.h2.resource.UserResource;

/**
 * @author JavaSolutionsGuide
 *
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserProfileRepository userProfileRepository;

	public void setuserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserResource> retrieveUsers() {
		List<User> Users = userRepository.findAll();

		List<UserProfile> userProfiles = userProfileRepository.findAll();
		List<UserResource> userResources = new ArrayList<>();

		Users.forEach(user -> {

			UserResource UserResource = new UserResource();
			BeanUtils.copyProperties(user, UserResource);
			userResources.add(UserResource);

		});

		return userResources;
	}

	public UserResource getUser(Long UserId) {
		Optional<User> optEmp = userRepository.findById(UserId);
		User User = optEmp.get();

		UserResource UserResource = new UserResource();

		BeanUtils.copyProperties(User, UserResource);

		return UserResource;
	}

	public UserResource saveUser(UserResource userResource) {

		User User = buildSaveUser(userResource);

		User emp = userRepository.save(User);

		BeanUtils.copyProperties(emp, userResource);

		return userResource;
	}

	public void deleteUser(Long UserId) {
		userRepository.deleteById(UserId);
	}

	public UserResource updateUser(UserResource UserResource) {

		User user = null;

		user = buildUpdateUser(UserResource);

		User updatedEmp = userRepository.saveAndFlush(user);

		BeanUtils.copyProperties(updatedEmp, UserResource);

		return UserResource;
	}

	private User buildUpdateUser(UserResource userResource) {

		User user = new User();
		user.setId(userResource.getId());
		user.setFirstName(userResource.getFirstName());
		user.setLastName(userResource.getLastName());
		user.setEmail(userResource.getEmail());
		user.setPassword(userResource.getPassword());
		// user.setUserProfile(userProfile);

		return user;
	}

	private User buildSaveUser(UserResource userResource) {

		User user = new User();

		UserProfile userProfile = new UserProfile();

		BeanUtils.copyProperties(userResource, user);

		BeanUtils.copyProperties(userResource, userProfile);

		userProfile.setUser(user);

		user.setUserProfile(userProfile);

		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		User user = userDao.findByUserName(userName);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {

		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

}
