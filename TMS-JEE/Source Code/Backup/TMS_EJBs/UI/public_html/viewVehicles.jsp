<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
<af:document id="av"  title="View Vehicles">
  <html>
    <head>
      <meta http-equiv="Content-Type"
            content="text/html; charset=UTF-9"/>
      <title>viewVehicles</title>
      <link rel="stylesheet" type="text/css" href="rtostyles.css" />
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
    <jsp:include page="/rtoheader.html"/><br/>
      <h1 id="heading">View Vehicles</h1><br/>
      <h:panelGroup style="pointer-events:all">
    <div id="pageContainer" style="width: 90%">
        <h:form>
        <div class="search-container">
            <h:outputLabel styleClass="search-label" for="vehicle_id_search">Vehicle ID:</h:outputLabel>
            <h:inputText id="vehicle_id_search" styleClass="search-container-input"
                         value="#{rto.vehicles.vehicleId}"/>
            <h:commandButton value="Search" styleClass="search-container-btn"
                             action="#{rto.viewByVehicleId}"/>
        </div>
        </h:form>
        <h:dataTable value="#{rto.allVehicles}" var="allVeh">
          <%-- 
            oracle-jdev-comment:Faces.RI.DT.Class.Key:tms.persistence.Vehicles
          --%>
          <h:column>
            <f:facet name="header">
              <h:outputText value="Chassis Number"/>
            </f:facet>
            <h:outputText value="#{allVeh.chassisNumber}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="Engine Number"/>
            </f:facet>
            <h:outputText value="#{allVeh.engineNumber}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="Fuel Used"/>
            </f:facet>
            <h:outputText value="#{allVeh.fuelUsed}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="Manufacturer Name"/>
            </f:facet>
            <h:outputText value="#{allVeh.manufacturerName}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="Manufacture Date"/>
            </f:facet>
            <h:outputText value="#{allVeh.manufactureDate}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="Model"/>
            </f:facet>
            <h:outputText value="#{allVeh.model}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="Variant"/>
            </f:facet>
            <h:outputText value="#{allVeh.variant}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="Vehicle Id"/>
            </f:facet>
            <h:outputText value="#{allVeh.vehicleId}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="Vehicle Type"/>
            </f:facet>
            <h:outputText value="#{allVeh.vehicleType}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="Vehicle Color"/>
            </f:facet>
            <h:outputText value="#{allVeh.vehColor}"/>
          </h:column>
        </h:dataTable>
      </div> 
    <h:form binding="#{rto.pop}" rendered="false" style="pointer-events:all" styleClass="popup">
        <center>
        <br>
        <p class="icon">Х</p>
         <br>
        <h:outputLabel value="#{rto.popmsg}" styleClass="error"></h:outputLabel>
         <br><br>
        <h:commandButton value="OK" action="#{rto.closePop}" 
         styleClass="popup-button"/>
        </center>
    </h:form>
      
      </h:panelGroup>
    </body>
  </html>
  </af:document>
</f:view>