package tms.business;

import javax.ejb.Local;

import tms.persistence.Users;

@Local
public interface LoginEJBLocal {
    Users login(String userId, String password);
    
    String navigate(Users user);
}
