<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
        <html>
                <head>
                        <meta http-equiv="Content-Type"
                              content="text/html; charset=windows-1252"/>
                        <title>View Vehicle</title>
                        <link rel="stylesheet" type="text/css"
                              href="rtostyles.css"/>
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
                        <jsp:include page="/copheader.html"/>
                         
                        <br>
                         
                        <h:panelGroup style="pointer-events:all">
                                <h1 id="heading">View Vehicle Details</h1>
                                <br>
                                <div id="pageContainer">
                                        <h:form id="form1">
                                                <div class="search-container">
                                                        <h:outputLabel for="registrationId"
                                                                       value="Registration Id:" styleClass="search-label"/>
                                                         
                                                        <h:inputText id="registrationId" styleClass="search-container-input"
                                                                     value="#{cop.registrationId}"/>
                                                         
                                                        <h:commandButton value="View"
                                                                         styleClass="search-container-btn"
                                                                         action="#{cop.vehDetails}"/>
                                                </div>
                                                </h:form>
                                               <h:form>
                                                        <div class="form-group">
                                                                <h:outputLabel for="vehicleId"
                                                                               styleClass="custLabel">Vehicle
                                                                                                      ID:</h:outputLabel>
                                                                 
                                                                <h:inputText id="vehicleId"
                                                                             styleClass="custInText"
                                                                             value="#{cop.veheo.vehicleId}"/>
                                                        </div>
                                                        <div class="h:form-group">
                                                                <h:outputLabel for="engineNumber"
                                                                               styleClass="custLabel">Engine
                                                                                                      Number:</h:outputLabel>
                                                                 
                                                                <h:inputText id="engineNumber"
                                                                             styleClass="custInText"
                                                                             value="#{cop.veheo.engineNumber}"/>
                                                        </div>
                                                        <div class="h:form-group">
                                                                <h:outputLabel for="chassisNumber"
                                                                               styleClass="custLabel">Chassis
                                                                                                      Number:</h:outputLabel>
                                                                 
                                                                <h:inputText id="chassisNumber"
                                                                             styleClass="custInText"
                                                                             value="#{cop.veheo.chassisNumber}"/>
                                                        </div>
                                                        <div class="h:form-group">
                                                                <h:outputLabel for="vehicleType"
                                                                               styleClass="custLabel">Vehicle
                                                                                                      Type:</h:outputLabel>
                                                                 
                                                                <h:inputText id="vehicleType"
                                                                             styleClass="custInText"
                                                                             value="#{cop.veheo.vehicleType}"/>
                                                        </div>
                                                        <div class="h:form-group">
                                                                <h:outputLabel for="vehColor"
                                                                               styleClass="custLabel">Vehicle
                                                                                                      Color:</h:outputLabel>
                                                                 
                                                                <h:inputText id="vehColor"
                                                                             styleClass="custInText"
                                                                             value="#{cop.veheo.vehColor}"/>
                                                        </div>
                                                        <div class="h:form-group">
                                                                <h:outputLabel for="fuelUsed"
                                                                               styleClass="custLabel">Fuel
                                                                                                      Used:</h:outputLabel>
                                                                 
                                                                <h:inputText id="fuelUsed"
                                                                             styleClass="custInText"
                                                                             value="#{cop.veheo.fuelUsed}"/>
                                                        </div>
                                                        <div class="h:form-group">
                                                                <h:outputLabel for="manufacturerName"
                                                                               styleClass="custLabel">Manufacturer
                                                                                                      Name:</h:outputLabel>
                                                                 
                                                                <h:inputText id="manufacturerName"
                                                                             styleClass="custInText"
                                                                             value="#{cop.veheo.manufacturerName}"/>
                                                        </div>
                                                        <div class="h:form-group">
                                                                <h:outputLabel for="manufacturerDate"
                                                                               styleClass="custLabel">Manufacture
                                                                                                      Date:</h:outputLabel>
                                                                 
                                                                <h:inputText id="manufacturerDate"
                                                                             styleClass="custInText"
                                                                             value="#{cop.veheo.manufactureDate}"/>
                                                        </div>
                                                        <div class="h:form-group">
                                                                <h:outputLabel for="model"
                                                                               styleClass="custLabel">Model:</h:outputLabel>
                                                                 
                                                                <h:inputText id="model"
                                                                             styleClass="custInText"
                                                                             value="#{cop.veheo.model}"/>
                                                        </div>
                                                        <div class="h:form-group">
                                                                <h:outputLabel for="variant"
                                                                               styleClass="custLabel">Variant:</h:outputLabel>
                                                                 
                                                                <h:inputText id="variant"
                                                                             styleClass="custInText"
                                                                             value="#{cop.veheo.variant}"/>
                                                        </div>
                                               
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
                                </div>
                        </h:panelGroup>
                         
                </body>
        </html>
</f:view>
<%-- oracle-jdev-comment:auto-binding-backing-bean-name:backing_ViewVehicleDetails--%>