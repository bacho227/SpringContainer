package ge.emis.teachers.service;

import ge.emis.teachers.model.security.User;
import ge.emis.teachers.repository.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Bacho on 3/19/15.
 */
@Service
public class SecurityService {
	@Autowired
	private UserRepository secUserRepository;

	public User getUserByUsername(String username) {
		return secUserRepository.getUserByUsername(username);
	}


}