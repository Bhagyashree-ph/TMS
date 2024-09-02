<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
  <af:document id="d1">
    <html>
<head>
    <title>Modify Role</title>
    <link rel="stylesheet" href="../css/style.css"/>
        <link rel="stylesheet" href="rtostyles.css"/>
    <!--<link rel="stylesheet" href="formStyles.css"/>-->
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

    <h:panelGroup  style="pointer-events:all">
  <h1 id="heading">Modify Role</h1>
           <div id="pageContainer">
                <h:form>
            <div class="search-container">
                <label for="rolename" class="search-label">Role Name:</label>
                <h:inputText id="rolename" value="#{admin.mrole.rolename}" styleClass="search-container-input" />
                <h:commandButton styleClass="search-container-btn"  value="Search" action="#{admin.searchRole}"></h:commandButton>
                
            </div>
            <div  style="margin-left: 95px;">
                <label for="roledesc" class="search-label">Role Description:</label>
                <h:inputTextarea id="roledesc" styleClass="search-container-input" value="#{admin.mrole.roleDescription}"/>
                
            </div>
            <div class="edit-delete-container">
            <h:commandButton value="Update" styleClass="editBtn" action="#{admin.updateRole}"></h:commandButton>
            <h:commandButton value="Delete" styleClass="delBtn" action="#{admin.deleteRole}"></h:commandButton>
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
        </div>
        </h:panelGroup>
    </center>
</body>
</html>

  </af:document>
</f:view>