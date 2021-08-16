package org.itbl;

import org.itbl.entity.User;
import org.itbl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		User user = userRepo.findByName(username);
		
		if(user == null) {
			
			throw new UsernameNotFoundException("User Not Found");
		}
		
		
		System.out.println("user :" + user);
		return new CustomUserDetails(user);
	}

}
