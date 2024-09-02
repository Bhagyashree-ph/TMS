package tms.business;

import javax.ejb.Remote;

import tms.persistence.Users;

@Remote
public interface LoginEJB {
    Users login(String userId, String password);
    
    String navigate(Users user);
}
