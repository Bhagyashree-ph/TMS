<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
  <af:document id="d1">
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="../css/style.css"/>
        <link rel="stylesheet" href="formStyles.css"/>
        
    </head>
    <body>
        <jsp:include page="/copheader.html"/>
    <center>
    <h:form id="f1" styleClass="col-8 form">
        <h1>Profile Page</h1>
        <div>
            <img src="profile.png" />
        </div>
        <div>
            <label for="userid" ><b>UserID:</b></label>
            <h:outputLabel id="userid" styleClass="col-4" value="#{log.currusr.userId}" />
        </div>
        <div>
            <label for="username" ><b>Username:</b></label>
            <h:outputLabel id="username" styleClass="col-4" value="#{log.currusr.userName}" />
        </div>
        <div >
            <label for="email" ><b>Email:</b></label>
            <h:outputLabel id="email" styleClass="col-4" value="#{log.currusr.email}"/>
        </div>
        <div>
            <label for="password"><b>Password:</b></label>
            <h:outputLabel id="password" styleClass="col-4" value="#{log.currusr.password}"/>
        </div>
    </h:form> 
    </center>  
    </body>
  </af:document>
</f:view>