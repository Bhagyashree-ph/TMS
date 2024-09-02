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
    <link rel="stylesheet" href="../css/style.css"/>
    <!--<link rel="stylesheet" href="formStyles.css"/>-->
    <link rel="stylesheet" href="rtostyles.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>View User</title>
    <style type="text/css">
            .popup {
            all: unset;
            position: absolute;
            height: 270px;
            width: 300px;
            top: 50%;
            left: 50%;
            background-color: #F2F3F5;
            translate: -50%-50%;
            box-shadow: 0 0 10pxrgba(0, 0, 0, 0.3);
            border-radius: 20px;
            display: inline-block;
            padding: 0px;
        }
        
        .popup-button {
            background: #007bff;
            width: 50.0px;
            height: 30px;
            margin: 0px;
            padding: 0px;
            font-size: 15px;
            margin-bottom: 30px;
            border: none;
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
        
        .error {
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
<body >
    <jsp:include page="/WEB-INF/header.html"/>
    <h:panelGroup style="pointer-events:all">
        <h1 id="heading">View User</h1>
           <div id="pageContainer" style="width: 80%">
    <h:form>
        <div class="search-container">
                <label for="userid" class="search-label">UserId:</label>
                <h:inputText id="userid" value="#{admin.vusr.userId}" styleClass="search-container-input" />   
            <h:commandButton value="Submit" styleClass="search-container-btn" action="#{admin.viewUser}"></h:commandButton>
        </div><br>
            <h:dataTable value="#{admin.usrlist}" style="width: 100%;" var="row"
                         id="dt1">
                <h:column id="c3">
                    <f:facet name="header">
                        <h:outputText value="User Id" id="ot4"/>
                        
                    </f:facet>
                    <h:commandLink action="#{admin.editnav}" >
                     <f:setPropertyActionListener target="#{admin.musr.userId}"
       value="#{row.userId}"/>
                    <i class="fa fa-pencil-square-o"></i>
                    </h:commandLink>
                    <h:outputText value="#{row.userId}"
                                  id="ot1"/>
                </h:column>
                <h:column id="c4">
                    <f:facet name="header">
                        <h:outputText value="User Name"
                                      id="ot7"/>
                    </f:facet>
                    <h:outputText value="#{row.userName}"
                                  id="ot6"/>
                </h:column>
                <h:column id="c1">
                    <f:facet name="header">
                        <h:outputText value="Role Name" id="ot8"/>
                    </f:facet>
                    <h:outputText value="#{row.roles.rolename}"
                                  id="ot5"/>
                </h:column>
                <h:column id="c5">
                    <f:facet name="header">
                        <h:outputText value="Email" id="ot3"/>
                    </f:facet>
                    <h:outputText value="#{row.email}"
                                  id="ot9"/>
                </h:column>
                <h:column id="c2">
                    <f:facet name="header">
                        <h:outputText value="Password"
                                      id="ot2"/>
                    </f:facet>
                    <h:outputText value="#{row.password}"
                                  id="ot10"/>
                </h:column>
            </h:dataTable>
        </h:form>
        
            <h:form binding="#{admin.pop}" rendered="false" style="pointer-events:all" styleClass="popup">
         <center>
        <br>
        <p class="icon">X</p>
        <br>
        <h:outputLabel value="#{admin.popmsg}"></h:outputLabel>
        <br><br><br>
        <h:commandButton value="OK" action="#{admin.closePop}" styleClass="popup-button"/>
        </center>
    </h:form>
    </div>
    </h:panelGroup>

    <script src="./script.js" type="text/javascript">
    </script>
</body>
</html>
  </af:document>
</f:view>