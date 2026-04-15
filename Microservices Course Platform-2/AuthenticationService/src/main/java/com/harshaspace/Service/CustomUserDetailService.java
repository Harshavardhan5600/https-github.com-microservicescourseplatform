package com.harshaspace.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.harshaspace.Repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository Userrepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.harshaspace.Entity.User user = Userrepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("username not found"));
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), false, false, false, false, null);
	}

}
