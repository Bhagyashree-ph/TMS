package tms.business;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;

import tms.persistence.Roles;
import tms.persistence.Users;

@Stateful(name = "AdminEJB", mappedName = "TMS_EJBs-Model-AdminEJB")
public class AdminEJBBean implements AdminEJB, AdminEJBLocal {
    @PersistenceContext(unitName="Model")
    private EntityManager em;

    public AdminEJBBean() {
    }

    public Users persistUsers(Users users) {
        em.persist(users);
        String usrId = findId(users.getEmail());
        users.setUserId(usrId);
        return users;
    }
    
    public String findId(String email){
        Query qry = em.createNamedQuery("Users.findId");
        qry.setParameter("email", email);
        return (String)qry.getResultList().get(0);
    }

    public Users mergeUsers(Users users) {
        return em.merge(users);
    }

    public void removeUsers(Users users) {
        users = em.find(Users.class, users.getUserId());
        em.remove(users);
    }
    
    public Users findUserById(String userId) {
        return em.find(Users.class, userId);
    }

    /** <code>select o from Users o</code> */
    public List<Users> getUsersFindAll() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }

    public Roles persistRoles(Roles roles) {
        em.persist(roles);
        return roles;
    }

    public Roles mergeRoles(Roles roles) {
        return em.merge(roles);
    }

    public void removeRoles(Roles roles) {
        roles = em.find(Roles.class, roles.getRolename());
        em.remove(roles);
    }

    public Roles findRoleById(String roleName) {
        return em.find(Roles.class, roleName);
    }
    
    /** <code>select o from Roles o</code> */
    public List<Roles> getRolesFindAll() {
        return em.createNamedQuery("Roles.findAll").getResultList();
    }
}
