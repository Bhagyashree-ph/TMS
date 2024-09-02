<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
    <af:document id="av" title="Add Vehicle">
        <html>
            <head>
                <link href="rtostyles.css" rel="stylesheet"/>
                <title>Add vehicle</title>
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
                <jsp:include page="rtoheader.html"/><br></br>
                 
                <h1 id="heading">Add Vehicle</h1>
                <div id="pageContainer">
                    <af:form id="f1">
                        <br></br>
                        <div id="progress">
                            <af:commandButton styleClass="prev " text="1"
                                              action="own"></af:commandButton>
                             
                            <af:commandButton styleClass="curr" text="2"
                                              action="addveh"></af:commandButton>
                             
                            <af:commandButton styleClass="next" text="3"
                                              action="#{rto.reg}"></af:commandButton>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="vehicleId"
                                           styleClass="custLabel" id="ol1">Vehicle
                                                                           ID:</h:outputLabel>
                             
                            <h:inputText id="vehicleId" styleClass="custInText"
                                         value="#{rto.vehicles.vehicleId}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="engineNumber"
                                           styleClass="custLabel" id="ol2">Engine
                                                                           Number:</h:outputLabel>
                             
                            <h:inputText id="engineNumber"
                                         styleClass="custInText"
                                         value="#{rto.vehicles.engineNumber}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="chassisNumber"
                                           styleClass="custLabel" id="ol3">Chassis
                                                                           Number:</h:outputLabel>
                             
                            <h:inputText id="chassisNumber"
                                         styleClass="custInText"
                                         value="#{rto.vehicles.chassisNumber}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="vehicleType"
                                           styleClass="custLabel" id="ol4">Vehicle
                                                                           Type:</h:outputLabel>
                             
                            <h:inputText id="vehicleType"
                                         styleClass="custInText"
                                         value="#{rto.vehicles.vehicleType}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="vehColor" styleClass="custLabel"
                                           id="ol5">Vehicle Color:</h:outputLabel>
                             
                            <h:inputText id="vehColor" styleClass="custInText"
                                         value="#{rto.vehicles.vehColor}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="fuelUsed" styleClass="custLabel"
                                           id="ol6">Fuel Used:</h:outputLabel>
                             
                            <h:inputText id="fuelUsed" styleClass="custInText"
                                         value="#{rto.vehicles.fuelUsed}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel styleClass="custLabel" id="ol7">Manufacture
                                                                           Date:</h:outputLabel>
                             
                            <af:inputDate id="id1" styleClass="custInText"
                                          value="#{rto.vehicles.manufactureDate}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel styleClass="custLabel" id="ol8">Manufacturer
                                                                           Name:</h:outputLabel>
                             
                            <h:inputText id="manufacturerName"
                                         styleClass="custInText"
                                         value="#{rto.vehicles.manufacturerName}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel styleClass="custLabel" id="ol9">Model:</h:outputLabel>
                             
                            <h:inputText id="model" styleClass="custInText"
                                         value="#{rto.vehicles.model}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel styleClass="custLabel" id="ol10">Variant:</h:outputLabel>
                             
                            <h:inputText id="variant" styleClass="custInText"
                                         value="#{rto.vehicles.variant}"/>
                        </div>
                        <div class="d-flex justify-content-center"
                             style="text-align:center;">
                            <af:commandButton text="Add Vehicle"
                                              styleClass="custBtn" id="cb1"
                                              action="#{rto.createVehicle}" 
                                              inlineStyle="background: #4CAF50; font-size: 15px;
                                                        color: white;
                                                        padding: 10px 20px;
                                                        border: none;
                                                        border-radius: 5px;
                                                        cursor: pointer;"/>
                        </div>
                    </af:form>
                </div>
                               
                    <h:form binding="#{rto.pop}" rendered="false" style="pointer-events:all" styleClass="popup">
         <center>
        <br><br><br>
        <h:outputLabel value="#{rto.popmsg}"></h:outputLabel>
        <br><br><br><br><br>
        <h:commandButton value="OK" action="#{rto.closePop}" styleClass="popup-button"/>
        </center>
    </h:form>
            </body>
        </html>
    </af:document>
</f:view>
<%-- oracle-jdev-comment:auto-binding-backing-bean-name:backing_addVehicle--%>