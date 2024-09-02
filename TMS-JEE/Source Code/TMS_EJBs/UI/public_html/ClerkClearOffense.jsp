<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
  <html>
    <head>
      <title>Table with Checkboxes</title>
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
      <jsp:include page="/ClerkHeader.html"/>
       
      <h:panelGroup style="event-pointers:all">
        
        <h1 id="heading">Clear Offense</h1>
        
        <div id="pageContainer" style="width: 80%;">
        
          <h:form>
          <div class="search-container">
            <h:outputLabel for="registrationId" value="Registration Id:" styleClass="search-label"/>
            <h:inputText id="registrationId" value="#{cop.registrationId}" styleClass="search-container-input"/>
            <h:commandButton styleClass="search-container-btn" value="View"
                             action="#{cop.searchUnpaidVehOffense}"/>
          <h:commandButton styleClass="search-container-btn" value="Clear" style="margin-left:80px; background-color: #4CAF50;"
                           action="#{cop.clearOff}"/>
        </div>
          <h:dataTable styleClass="my-table" value="#{cop.offdlist}" var="row"
                       id="dataTable1">
            <%-- oracle-jdev-comment:Faces.RI.DT.Class.Key:training.iqgateway.ui.Clearlist--%>
            <h:column>
              <f:facet name="header">
                <h:outputText value="Check" id="outputText1"/>
              </f:facet>
              <h:selectBooleanCheckbox id="selectBooleanCheckbox1"
                                       value="#{row.check}"/>
            </h:column>
            <h:column>
              <f:facet name="header">
                <h:outputText value="Offense Details Id" id="outputText2"/>
              </f:facet>
              <h:outputText value="#{row.off.offenseDetailId}"/>
            </h:column>
            <h:column>
              <f:facet name="header">
                <h:outputText value="Offense Date Time" id="outputText3"/>
              </f:facet>
              <h:outputText value="#{row.off.offenseDateTime}"/>
            </h:column>
            <h:column>
              <f:facet name="header">
                <h:outputText value="Place" id="outputText4"/>
              </f:facet>
              <h:outputText value="#{row.off.place}"/>
            </h:column>
            <%-- <h:column> <f:facet name="header"> <h:outputText value="Image"
                 id="outputText5"/> </f:facet> <h:outputText
                 value="#{row.off.image}"/> </h:column>--%>
            <h:column>
              <f:facet name="header">
                <h:outputText value="RegistrationID" id="outputText6"/>
              </f:facet>
              <h:outputText value="#{row.off.registrations.registrationId}"/>
            </h:column>
            <h:column>
              <f:facet name="header">
                <h:outputText value="Offense Id" id="outputText7"/>
              </f:facet>
              <h:outputText value="#{row.off.offenseTypes.offenseId}"/>
            </h:column>
            <h:column>
              <f:facet name="header">
                <h:outputText value="Recorded By" id="outputText8"/>
              </f:facet>
              <h:outputText value="#{row.off.users.userId}"/>
            </h:column>
            <h:column>
              <f:facet name="header">
                <h:outputText value="Penalty status" id="outputText9"/>
              </f:facet>
              <h:outputText value="#{row.off.penaltyStatus}"/>
            </h:column>
          </h:dataTable>
        </h:form>
        <h:form binding="#{cop.pop}" rendered="false" style="pointer-events:all"
                styleClass="popup">
          <center>
            <br></br>
            <br></br>
            <h:outputLabel value="#{cop.popmsg}"></h:outputLabel>
            <br></br>
            <br></br>
            <h:commandButton value="OK" action="#{cop.closePop}"
                             styleClass="popup-button"/>
          </center>
        </h:form>
      </div></h:panelGroup>
    </body>
  </html>
</f:view>
<%-- oracle-jdev-comment:auto-binding-backing-bean-name:backing_ClearOffense--%>