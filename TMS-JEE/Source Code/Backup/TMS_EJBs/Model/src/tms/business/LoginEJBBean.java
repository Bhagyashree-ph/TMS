package tms.business;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tms.persistence.Roles;
import tms.persistence.Users;

@Stateless(name = "LoginEJB", mappedName = "TMS_EJBs-Model-LoginEJB")
public class LoginEJBBean implements LoginEJB, LoginEJBLocal {
    @PersistenceContext(unitName="Model")
    private EntityManager em;

    public LoginEJBBean() {
    }
    
    public Users login(String userId, String password) {
        Users user= em.find(Users.class,userId);
        if(user.getPassword().equals(password))
            return user;
        else{
            System.out.println("Wrong Password");

            return null;
        }
    }
    
    public String navigate(Users user){
        return user.getRoles().getRolename();
    }
}
