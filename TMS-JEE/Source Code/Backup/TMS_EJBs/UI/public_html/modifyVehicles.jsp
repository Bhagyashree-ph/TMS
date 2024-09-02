<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
<af:document id="av"  title="Modify Vehicles">
  <html>
    <head>
      <meta http-equiv="Content-Type"
            content="text/html; charset=windows-1252"/>
      <title>modifyVehicles</title>
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
    <jsp:include page="/rtoheader.html"/> <br>
    <h:panelGroup style="pointer-events:all">
      <h1 id="heading">Modify Vehicle</h1>
    <div id="pageContainer">
    <h:form>
        <div class="search-container">
            <h:outputLabel for="vehicleId" styleClass="search-label">Vehicle ID:</h:outputLabel>
            <h:inputText id="vehicleId" styleClass="search-container-input"
                         value="#{rto.vehicles.vehicleId}"/>
            <h:commandButton value="Search" styleClass="search-container-btn"
                             action="#{rto.fetchByVehicleID}"/>
        </div>
        </h:form>
        <h:form>
            <div class="h:form-group">
                <h:outputLabel for="engineNumber" styleClass="custLabel">Engine Number:</h:outputLabel>
                <h:inputText id="engineNumber" styleClass="custInText"
                             value="#{rto.vehicles.engineNumber}"/>
            </div>
            <div class="h:form-group">
                <h:outputLabel for="chassisNumber" styleClass="custLabel">Chassis Number:</h:outputLabel>
                <h:inputText id="chassisNumber" styleClass="custInText"
                             value="#{rto.vehicles.chassisNumber}"/>
            </div>
            <div class="h:form-group">
                <h:outputLabel for="vehicleType" styleClass="custLabel">Vehicle Type:</h:outputLabel>
                <h:inputText id="vehicleType" styleClass="custInText"
                             value="#{rto.vehicles.vehicleType}"/>
            </div>
            <div class="h:form-group">
                <h:outputLabel for="vehColor" styleClass="custLabel">Vehicle Color:</h:outputLabel>
                <h:inputText id="vehColor" styleClass="custInText"
                             value="#{rto.vehicles.vehColor}"/>
            </div>
            <div class="h:form-group">
                <h:outputLabel for="fuelUsed" styleClass="custLabel">Fuel Used:</h:outputLabel>
                <h:inputText id="fuelUsed" styleClass="custInText"
                             value="#{rto.vehicles.fuelUsed}"/>
            </div>
            <div class="h:form-group">
                <h:outputLabel for="manufactureDate" styleClass="custLabel">Manufacture Date:</h:outputLabel>
                
                    <af:inputDate 
                                                  id="manufactureDate"
                                  value="#{rto.vehicles.manufactureDate}"/>
            </div>
            <div class="h:form-group">
                <h:outputLabel for="manufacturerName" styleClass="custLabel">Manufacturer Name:</h:outputLabel>
                <h:inputText id="manufacturerName" styleClass="custInText"
                             value="#{rto.vehicles.manufacturerName}"/>
            </div>
            <div class="h:form-group">
                <h:outputLabel for="model" styleClass="custLabel">Model:</h:outputLabel>
                <h:inputText id="model" styleClass="custInText"
                             value="#{rto.vehicles.model}"/>
            </div>
            <div class="h:form-group">
                <h:outputLabel for="variant" styleClass="custLabel">Variant:</h:outputLabel>
                <h:inputText id="variant" styleClass="custInText"
                             value="#{rto.vehicles.variant}"/>
            </div>

            <div class="edit-delete-container">
                <h:commandButton type="submit" value="Edit" styleClass="editBtn"
                                 action="#{rto.updateVehicle}"/>
                <h:commandButton type="submit" value="Delete" styleClass="delBtn" action="#{rto.deleteVehicle}"/>
            </div>
        </h:form>
    </div>
     
    <h:form binding="#{rto.pop}" rendered="false" style="pointer-events:all" styleClass="popup">
         <center>
        <br><br><br>
        <h:outputLabel value="#{rto.popmsg}"></h:outputLabel>
        <br><br><br><br><br>
        <h:commandButton value="OK" action="#{rto.closePop}" styleClass="popup-button"/>
        </center>
    </h:form>
    </h:panelGroup>
    </body>
  </html>
  </af:document>
</f:view>