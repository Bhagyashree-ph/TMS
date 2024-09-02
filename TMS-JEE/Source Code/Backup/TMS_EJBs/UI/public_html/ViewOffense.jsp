<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
  <html>
    <head>
      <title>View Offenses</title>
      <link rel="stylesheet" href="rtostyles.css"/>
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
    <body>
      <jsp:include page="/copheader.html"/>
       
      <h:panelGroup style="event-pointers:all">
        
        <h1 id="heading">View Offenses</h1>
        
        <div id="pageContainer" style="width: 80%;">
        
          <h:form>
          <div class="search-container">
            <h:outputLabel for="registrationId" value="Registration Id:" styleClass="search-label"/>
            <h:inputText id="registrationId" value="#{cop.registrationId}" styleClass="search-container-input"/>
            <h:commandButton styleClass="search-container-btn" value="View"
                             action="#{cop.searchVehOffense}"/>
        </div>
         <h:dataTable value="#{cop.offlist}" var="row" id="dataTable1">
              <%-- oracle-jdev-comment:Faces.RI.DT.Class.Key:tms.persistence.OffenseDetails--%>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Offense Detail Id" id="outputText1"/>
                </f:facet>
                <h:outputText value="#{row.offenseDetailId}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Offence Type id" id="outputText2"/>
                </f:facet>
                <h:outputText value="#{row.offenseTypes.offenseId}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Offense Date Time" id="outputText3"/>
                </f:facet>
                <h:outputText value="#{row.offenseDateTime}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Place" id="outputText4"/>
                </f:facet>
                <h:outputText value="#{row.place}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Penalty Status" id="outputText5"/>
                </f:facet>
                <h:outputText value="#{row.penaltyStatus}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Registration Id" id="outputText6"/>
                </f:facet>
                <h:outputText value="#{row.registrations.registrationId}"/>
              </h:column>
              <%--<h:column>
                <f:facet name="header">
                  <h:outputText value="Image" id="outputText7"/>
                </f:facet>
                <h:outputText value="#{row.image}"/>
              </h:column>--%>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Recorded By" id="outputText8"/>
                </f:facet>
                <h:outputText value="#{row.users.userId}"/>
              </h:column>
            </h:dataTable>
        </h:form>
        <h:form binding="#{cop.pop}" rendered="false" style="pointer-events:all"
                styleClass="popup">
          <center>
            <br>
            <p class="icon"> X </p>
            </br>
            <h:outputLabel value="#{cop.popmsg}"></h:outputLabel>
            <br></br><br>
            <h:commandButton value="OK" action="#{cop.closePop}"
                             styleClass="popup-button"/>
          </center>
        </h:form>
      </div></h:panelGroup>
    </body>
  </html>
</f:view>
<%-- oracle-jdev-comment:auto-binding-backing-bean-name:backing_ClearOffense--%>