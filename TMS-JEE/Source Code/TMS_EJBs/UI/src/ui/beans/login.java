package ui.beans;

import javax.faces.component.html.HtmlForm;

import javax.faces.component.html.HtmlInputText;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import tms.business.AdminEJB;

import tms.business.LoginEJB;

import tms.persistence.Users;

public class login {
    private Users currusr = new Users();
    private Users loginuser = new Users();
    private HtmlForm pop;
    private HtmlForm content;
    public login() {
        super();
    }
    
    public LoginEJB getSession() throws NamingException {
        InitialContext context = new InitialContext();
        LoginEJB logEJB = (LoginEJB)context.lookup("TMS_EJBs-Model-LoginEJB#tms.business.LoginEJB");
        return logEJB;
    }
    
    public String log() {
        try{
            currusr=getSession().login(loginuser.getUserId(), loginuser.getPassword());
            if(currusr!=null)
            {
                loginuser = new Users();
                return currusr.getRoles().getRolename().toLowerCase();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        if(currusr == null)
            currusr = new Users();
        pop.setRendered(true);
        content.setStyle("pointer-events:none");
        return null;
    }
    
    public void closePop() {
        pop.setRendered(false);
        content.setStyle("pointer-events:all");
        loginuser = new Users();
    }
    
    public void setCurrusr(Users currusr) {
        this.currusr = currusr;
    }

    public Users getCurrusr() {
        return currusr;
    }

    public void setLoginuser(Users loginuser) {
        this.loginuser = loginuser;
    }

    public Users getLoginuser() {
        return loginuser;
    }

    public void setPop(HtmlForm pop) {
        this.pop = pop;
    }

    public HtmlForm getPop() {
        return pop;
    }

    public void setContent(HtmlForm content) {
        this.content = content;
    }

    public HtmlForm getContent() {
        return content;
    }
}
