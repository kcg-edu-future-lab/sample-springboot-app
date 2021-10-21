package edu.kcg.futurelab.sample.springboot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kcg.futurelab.sample.springboot.model.UserEntry;
import edu.kcg.futurelab.sample.springboot.service.repository.UserRepository;
import edu.kcg.futurelab.sample.springboot.service.repository.entity.User;

@Service
public class UserService
implements UserDetailsService {
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findByUsername(username);
		if (u == null) {
			throw new UsernameNotFoundException("Invalid user ID or password.");
		}
		return new AuthUser(u);
	}

	@Transactional
	public void addUser(String username, String displayName, String password) {
		User u = new User(username, passwordEncoder.encode(password),
			displayName, User.Role.USER);
		userRepository.save(u);
	}

	@Transactional
	public List<UserEntry> searchUser(String keyword) {
		if(keyword != null){
			return map(userRepository.findAllByDisplayNameContains(keyword), UserEntry.class);
		} else{
			return map(userRepository.findAll(), UserEntry.class);
		}
	}

	protected <T, U> U map(T v, Class<U> targetClass) {
		return modelMapper.map(v, targetClass);
	}
	
	protected <T, U> List<U> map(Iterable<T> iterable, Class<U> targetClass){
		var ret = new ArrayList<U>();
		for(T v : iterable) {
			ret.add(modelMapper.map(v, targetClass));
		}
		return ret;
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper modelMapper;
}
