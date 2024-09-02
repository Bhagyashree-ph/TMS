package ui.beans;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlForm;

import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlPanelGroup;

import javax.naming.InitialContext;

import javax.naming.NamingException;


import oracle.adf.view.rich.component.rich.RichDocument;

import tms.business.AdminEJB;

import tms.persistence.Roles;
import tms.persistence.Users;


public class AdminBean {
    
    private Users usr=new Users();    
    private Users vusr=new Users();    
    private Users musr=new Users();
    private String roleName="";
    private Roles role = new Roles();
    private Roles vrole = new Roles();
    private Roles mrole = new Roles();
    private List<String> roleslist= new ArrayList<String>();
    private List<Roles> rollist = new ArrayList<Roles>();
    private List<Users> usrlist = new ArrayList<Users>();
    private String selectedrole="";
    private String popmsg = "";
    private HtmlPanelGroup content;
    private HtmlForm pop;
    public AdminBean() {
        viewAllUser();
        viewAllRole();
    }
    
    public AdminEJB getSession() throws NamingException {
        InitialContext context = new InitialContext();
        AdminEJB adminEJB = (AdminEJB)context.lookup("TMS_EJBs-Model-AdminEJB#tms.business.AdminEJB");
        return adminEJB;
    }
    
    public void add() {
        try {
            
            usr.setRoles(getSession().findRoleById(selectedrole));
            usr=getSession().persistUsers(usr);
            System.out.println(usr);
            if(usr==null) {
                popmsg="User not Added";
            }
            else {
                popmsg="User "+usr.getUserId()+" Added";
                usr = new Users();
            }
        } catch (Exception e) {
            popmsg="User Not Added";
            e.printStackTrace();
        }
        showPop();
    }
    
    public void update() {
        try {
            musr=getSession().mergeUsers(musr);
            popmsg = "User Updated";
            musr = new Users();
        }
        catch(Exception e) {
            e.printStackTrace();
            popmsg = "User Not Updated";
        }
        showPop();
    }
    
   
    public void delete() {
        try {
            getSession().removeUsers(musr);
            popmsg="User Deleted";
            musr = new Users();
        }
        catch(NamingException e) {
            popmsg = "User Not Deleted";
            e.printStackTrace();
        }
        showPop();
    }
    
    public void search() {
        try {
            musr=getSession().findUserById(musr.getUserId());
            if(musr == null) {
                throw new SQLException();
            }
        }
        catch(Exception e) {
            e.printStackTrace();  
            musr=new Users();
            popmsg = "User Not Found";
            showPop();
        }
    }
    
    public String editnav() {
        try {
            System.out.println("Search Called");
            musr=getSession().findUserById(musr.getUserId());
            System.out.println(usr.getPassword());
            return "edit";
        }
        catch(NamingException e) {
            e.printStackTrace();
        }
        return "#";
    }
    
    public String editnavrole() {
        try {
            System.out.println("Search Called");
            mrole=getSession().findRoleById(mrole.getRolename());
            return "edit";
        }
        catch(NamingException e) {
            e.printStackTrace();
        }
        return "#";
    }
    

    public void setUsr(Users usr) {
        this.usr = usr;
    }

    public Users getUsr() {
        return usr;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }


    

    public List<String> getRoleslist() {

        try {
            roleslist = new ArrayList<String>();
            List<Roles> rl = getSession().getRolesFindAll();
            for(Roles r:rl) {
                roleslist.add(r.getRolename());
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(roleslist);
        return roleslist;
    }

    public void setSelectedrole(String selectedrole) {
        this.selectedrole = selectedrole;
    }

    public String getSelectedrole() {
        return selectedrole;
    }

    public List<Users> getUsrlist() {
        return usrlist;
    }
    
    public void viewAllUser() {
        try {
            usrlist = getSession().getUsersFindAll();
        }
        catch(Exception e) {
            System.out.println("Exception in  all users");
        }
    }
    
    public void viewUser() {
        usrlist = new ArrayList<Users>();
        try {
            if(getSession().findUserById(vusr.getUserId())==null) {
                viewAllUser();
                popmsg = "User Not Found";
                showPop();
            }
            else
            usrlist.add(getSession().findUserById(vusr.getUserId()));
        }
        catch(Exception e) {
            System.out.println("Exception in view single users");
        }
    }
    
    public void viewAllRole() {
        try {
            rollist = getSession().getRolesFindAll();
        }
        catch(Exception e) {
            System.out.println("Exception in view all users");
        }
    }
    
    public void viewRole() {
        rollist = new ArrayList<Roles>();
        try {
            if(getSession().findRoleById(vrole.getRolename())==null) {
                viewAllRole();
                popmsg = "Role not found";
                showPop();
            }
            else
            rollist.add(getSession().findRoleById(vrole.getRolename()));
        }
        catch(Exception e) {
            System.out.println("Exception in view single role");
            popmsg = "Role not found";
        }
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Roles getRole() {
        return role;
    }
    
    public void addRole() {
        try {
            role=getSession().persistRoles(role);
            if(role==null) {
                popmsg = "Role not Added";
            }
            else {
                popmsg = "Role Added Successfully";
            }
            
        }
        catch(Exception e) {
            popmsg = "Role not Added Role Might already exist";
            System.out.println("Exception in role");
        }
        showPop();
    }
    
    public void updateRole() {
        try {
            mrole=getSession().mergeRoles(mrole);
            if(mrole!=null)
            popmsg="Role Updated";
            else
                popmsg="Role Not Updated";
            mrole = new Roles();
        }
        catch(Exception e) {
            popmsg="Role not updated";
            System.out.println("Exception in update role");
        }
        showPop();
    }
    
    public void deleteRole() {
        try {
            getSession().removeRoles(mrole);
            popmsg="Role Deleted";
            mrole = new Roles();
        }
        catch(Exception e) {
            popmsg="Role not deleted";
            System.out.println("Exception in update role");
        }
        showPop();
    }
    
    public void searchRole() {
        try {
            mrole = getSession().findRoleById(mrole.getRolename());
            if(mrole == null) {
                mrole = new Roles();
                throw new SQLException();
            }
        }
        catch(Exception e) {
            System.out.println("Exception in search role");
            popmsg = "Role Not Found";
            showPop();
            e.printStackTrace();
        }
    }

    public void setRollist(List<Roles> rollist) {
        this.rollist = rollist;
    }

    public List<Roles> getRollist() {
        return rollist;
    }

    public void setVusr(Users vusr) {
        this.vusr = vusr;
    }

    public Users getVusr() {
        return vusr;
    }

    public void setMusr(Users musr) {
        this.musr = musr;
    }

    public Users getMusr() {
        return musr;
    }

    public void setVrole(Roles vrole) {
        this.vrole = vrole;
    }

    public Roles getVrole() {
        return vrole;
    }

    public void setMrole(Roles mrole) {
        this.mrole = mrole;
    }

    public Roles getMrole() {
        return mrole;
    }

    public void setPopmsg(String popmsg) {
        this.popmsg = popmsg;
    }

    public String getPopmsg() {
        return popmsg;
    }

    public void setPop(HtmlForm pop) {
        this.pop = pop;
    }

    public HtmlForm getPop() {
        return pop;
    }

    public void showPop() {
        pop.setRendered(true);
        content=(HtmlPanelGroup)pop.getParent();
        content.setStyle("pointer-events:none");
    }
    
    public void closePop() {
        pop.setRendered(false);
        content.setStyle("pointer-events:all");
    }

    
    
}

