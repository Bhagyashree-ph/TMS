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
    <link href="../css/style.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--<link rel="stylesheet" href="formStyles.css"/>-->
    <link rel="stylesheet" href="rtostyles.css"/>
    <title>View Role</title>
    
</head>
<body>
    <jsp:include page="/WEB-INF/header.html"/>

    <h:panelGroup  style="pointer-events:all">
        <h1 id="heading">View Role</h1>
           <div id="pageContainer" style="width: 50%">
    <h:form>
        <div class="search-container">
                <label for="userid" class="search-label">Role Name:</label>
                <h:inputText id="userid" value="#{admin.vrole.rolename}" styleClass="search-container-input" />
                
            <h:commandButton value="Submit" styleClass="search-container-btn" action="#{admin.viewRole}"></h:commandButton>
            </div>
            <centter>
                            <h:dataTable value="#{admin.rollist}" style="width: 100%; " var="row"
                                         id="dt1">
                                <%-- 
                                    oracle-jdev-comment:Faces.RI.DT.Class.Key:tms.persistence.Roles
                                --%>
                                <h:column id="c2">
                                    <f:facet name="header">
                                        <h:outputText value="Rolename"
                                                      id="ot3"/>
                                    </f:facet>
                                    
                                        <h:commandLink action="#{admin.editnavrole}" >
                     <f:setPropertyActionListener target="#{admin.mrole.rolename}"
       value="#{row.rolename}"/>
                    <i class="fa fa-pencil-square-o"></i>
                                        </h:commandLink>
                                    <h:outputText value="#{row.rolename}"
                                                  id="ot1"/>
                                </h:column>
                                <h:column id="c1">
                                    <f:facet name="header">
                                        <h:outputText value="Role Description"
                                                      id="ot2"/>
                                    </f:facet>
                                    <h:outputText value="#{row.roleDescription}"
                                                  id="ot4"/>
                                </h:column>
                            </h:dataTable>
                            </centter>
                        </h:form>
         <h:form binding="#{admin.pop}" rendered="false" style="pointer-events:all" styleClass="popup">
            <center>
        <br>
        <p class="icon">X</p>
            <br>
            <h:outputLabel value="#{admin.popmsg}" styleClass="error"></h:outputLabel>
           <br><br>
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