package tms.business.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tms.business.LoginOperations;
import tms.persistence.dao.DAO;
import tms.persistence.entities.UsersEO;

@Controller
@RequestMapping(value="/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginOperationsImpl implements LoginOperations {

	DAO<UsersEO, String> userDAORef = (DAO<UsersEO, String>) Context.getContextBean("userDAOBean");
	
	public LoginOperationsImpl() {
		super();
	}

	public LoginOperationsImpl(DAO<UsersEO, String> userDAORef) {
		super();
		this.userDAORef = userDAORef;
	}

	public DAO<UsersEO, String> getUserDAORef() {
		return userDAORef;
	}

	public void setUserDAORef(DAO<UsersEO, String> userDAORef) {
		this.userDAORef = userDAORef;
	}

	@Override
	@GetMapping
	public ResponseEntity<UsersEO> loginUser(@RequestParam String userId) {
		System.out.println(userId);
		UsersEO fetchedUser = userDAORef.findByID(userId);
		System.out.println(fetchedUser);
		if(fetchedUser != null){
			return ResponseEntity.ok(fetchedUser);
		}
		return null;
	}

	@Override
	public void resetPasswaord(UsersEO user) {
		// TODO Auto-generated method stub
		userDAORef.update(user);
	}

}
