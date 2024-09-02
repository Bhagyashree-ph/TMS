<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
  <af:document id="d1">
        <html>
    <head>
        <title>Edit User</title>
        <link rel="stylesheet" href="../css/style.css"/>
        <!--<link rel="stylesheet" href="formStyles.css"/>-->
            <link rel="stylesheet" href="rtostyles.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
         <style type="text/css">
         .popup{
            all:unset;
            position:absolute;
            height:270px;
            width: 300px;
            top:50%;
            left:50%;
            background-color: #F2F3F5;
            translate: -50% -50%;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
             border-radius: 20px;
             display: inline-block;
             padding: 0px ;
            }
            
            .popup-button{
                background: #007bff;
                width: 50.0px;
                height: 30px;
                margin: 0px;
                padding: 0px;
                font-size: 15px;
                margin-bottom: 30px;
                border: none ;
                border-radius: 10px;
            }
            
            .icon {
              color: Red;
                  font-size: 30px;
                  font-weight: bold;
                  margin-right: 10px;
                  color: #FF0000;
                  border: 3px solid Red;
                  padding: 15px;
                  border-radius: 50%;
                  width: 60px;
            }
            
            .error{
                color: #DB3646;
                font-size: medium;
                font-weight: 200 bold;
            }
            
            .success {
                  color: Green;
                  font-size: 30px;
                  font-weight: bold;
                  margin-right: 10px;
                  color: #FF0000;
                  border: 3px solid green;
                  padding: 15px;
                  border-radius: 50%;
                  width: 60px;
            }
        </style>
    </head>
    <body>
    <jsp:include page="/WEB-INF/header.html"/>
        <h:panelGroup style="pointer-events:all">
        
            <h1 id="heading">Modify User</h1>
           <div id="pageContainer">
                <h:form>
            <div class="search-container">
                    <label for="userid" class="search-label">UserID:</label>
                    <h:inputText id="userid" styleClass="search-container-input" value="#{admin.musr.userId}" />
                    <h:commandButton value="Select" styleClass="search-container-btn" action="#{admin.search}"/>
                </div>
                <div class="form-label">
                    <label for="username" class="custLabel">Username:</label>
                    <h:inputText id="username" styleClass="custInText" value="#{admin.musr.userName}" />
                </div><br>
                <div class="form-label">
                    <label for="rolename" class="custLabel">Role:</label>
                    <h:selectOneMenu value="#{admin.selectedrole}" styleClass="drop custInText">
                        <c:forEach items="#{admin.roleslist}" var="role" >
                            <f:selectItem itemLabel="#{role}" itemValue="#{role}" />
                        </c:forEach>
                    </h:selectOneMenu>
                </div><br>
                <div class="form-label">
                    <label for="email" class="custLabel">Email:</label>
                    <h:inputText id="email" value="#{admin.musr.email}"  styleClass="custInText"/>
                </div><br>
                <div class="form-label">
                    <label for="password" class="custLabel">Password:</label>
                    <h:inputSecret id="passwordl"  styleClass="custInText" value="#{admin.musr.password}" redisplay="true"/>
                </div>
                <div class="edit-del-container">
                <h:commandButton value="Update" styleClass="editBtn" action="#{admin.update}"></h:commandButton>
                <h:commandButton value="Delete" styleClass="delBtn" action="#{admin.delete}"></h:commandButton>
                </div>
            </h:form>
            
                <h:form binding="#{admin.pop}" rendered="false" style="pointer-events:all" styleClass="popup">
            <center>
        <br><br><br>
            <h:outputLabel value="#{admin.popmsg}"></h:outputLabel>
           <br><br><br><br><br>
            <h:commandButton value="OK" action="#{admin.closePop}"  styleClass="popup-button"/>
        </center>
        </h:form>
        </center>
        </h:panelGroup>
    </body>
</html>
  </af:document>
</f:view>