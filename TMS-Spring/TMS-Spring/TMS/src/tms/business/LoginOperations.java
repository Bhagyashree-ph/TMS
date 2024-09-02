package tms.business;

import org.springframework.http.ResponseEntity;

import tms.persistence.entities.UsersEO;

public interface LoginOperations {
	
	public void resetPasswaord(UsersEO user);

	public ResponseEntity<UsersEO> loginUser(String userId);
}
