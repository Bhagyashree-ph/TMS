<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
<af:document id="d1" >
<html>
<head>
    <link href="../css/style.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="rtostyles.css"/>
    <title>Add Role</title>
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
             
            <h:panelGroup style="pointer-events:all" id="pg1">
                <h1 id="heading">
                    Add User
                </h1>
                <div id="pageContainer">
                    <af:form id="f2">
                        <div class="form-group">
                            <br/>
                             
                            <label for="username" class="custLabel">
                                Username:
                            </label>
                             
                            <h:inputText id="username" styleClass="custInText"
                                         value="#{admin.usr.userName}"
                                         required="true"/>
                        </div>
                        <div class="form-group">
                            <label for="rolename" class="custLabel">
                                Role:
                            </label>
                             
                            <h:selectOneMenu value="#{admin.selectedrole}"
                                             styleClass="drop custInText"
                                             id="som1">
                                <c:forEach items="#{admin.roleslist}"
                                           var="role">
                                    <f:selectItem itemLabel="#{role}"
                                                  itemValue="#{role}" id="si1"/>
                                </c:forEach>
                            </h:selectOneMenu>
                        </div>
                        <div class="form-group">
                            <label for="email" class="custLabel">
                                Email:
                            </label>
                             
                            <h:inputText id="email" value="#{admin.usr.email}"
                                         styleClass="custInText">
                        </h:inputText>
                        </div>
                        <div class="form-group">
                            <label for="password" class="custLabel">
                                Password:
                            </label>
                             
                            <h:inputSecret id="password"
                                           value="#{admin.usr.password}"
                                           styleClass="custInText">
                           </h:inputSecret>
                        </div>
                        <div class="d-flex justify-content-center">
                            <h:commandButton value="Submit" styleClass="custBtn"
                                             action="#{admin.add}" id="cb1"/>
                        </div>
                    </af:form>
                     
                    <h:form binding="#{admin.pop}" rendered="false"
                            style="pointer-events:all" styleClass="popup"
                            id="f1">
                        <center>
                            <br/>
                            <br/>
                            <br/>
                            <h:outputLabel value="#{admin.popmsg}" id="ol1"/>
                            <br/>
                            <br/>
                            <br/>
                            <h:commandButton value="OK"
                                             action="#{admin.closePop}"
                                             styleClass="popup-button"
                                             id="cb2"/>
                        </center>
                    </h:form>
                </div>
            </h:panelGroup>
            </body>
            </html>
        </af:document>

</f:view>
<%-- 
    oracle-jdev-comment:preferred-managed-bean-name:admin
--%>