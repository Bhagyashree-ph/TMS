<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
        <af:document id="d1">
                <html>
                        <head>
                                <link href="rtostyles.css" rel="stylesheet"/>
                                <title>Registration</title>
                        </head>
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
                        <body>
                                <jsp:include page="/rtoheader.html"/><br></br>
                                 
                                <h1 id="heading">Register your vehicle</h1>
                                <div id="pageContainer">
                                        <h:panelGroup style="pointer-events:all">
                                                <af:form id="f1">
                                                        <br></br>
                                                        <div id="progress">
                                                                <af:commandButton styleClass="prev"
                                                                                  text="1"
                                                                                  action="own"></af:commandButton>
                                                                 
                                                                <af:commandButton styleClass="prev"
                                                                                  text="2"
                                                                                  action="veh"></af:commandButton>
                                                                 
                                                                <af:commandButton styleClass="curr"
                                                                                  text="3"
                                                                                  action="addreg"></af:commandButton>
                                                        </div>
                                                        <br></br>
                                                        <div class="form-group">
                                                                <h:outputLabel for="registrationId"
                                                                               styleClass="custLabel">Registration
                                                                                                      ID</h:outputLabel>
                                                                 
                                                                <h:inputText id="registrationId"
                                                                             styleClass="custInText"
                                                                             value="#{rto.registrations.registrationId}"/>
                                                        </div>
                                                        <div class="form-group">
                                                                <h:outputLabel for="vehicleId"
                                                                               styleClass="custLabel">Vehicle
                                                                                                      ID</h:outputLabel>
                                                                 
                                                                <h:inputText id="vehicleId"
                                                                             styleClass="custInText"
                                                                             value="#{rto.vehicles.vehicleId}"/>
                                                        </div>
                                                        <div class="form-group">
                                                                <h:outputLabel styleClass="custLabel">Owner
                                                                                                      ID</h:outputLabel>
                                                                 
                                                                <h:inputText id="ownId"
                                                                             value="#{rto.owners.ownerId}"
                                                                             styleClass="custInText"/>
                                                        </div>
                                                        <div class="form-group">
                                                                <p>
                                                                        <h:outputLabel styleClass="custLabel">Registeration
                                                                                                              Date</h:outputLabel>
                                                                         
                                                                        <af:inputDate id="id1"
                                                                                      value="#{rto.registrations.registrationDate}"/>
                                                                </p>
                                                        </div>
                                                        <div class="d-flex justify-content-center"
                                                             style="text-align:center;">
                                                                <af:commandButton text="Register"
                                                                                  id="rreg"
                                                                                  action="#{rto.addNewRegistration}" inlineStyle="background: #4CAF50; width: 100px; font-size: 15px;
                                    color: white;
                                    padding: 10px 20px;
                                    border: none;
                                    border-radius: 5px;
                                    cursor: pointer;"/>
                                                        </div>
                                                </af:form>
                                        
                                <h:form binding="#{rto.pop}" rendered="false"
                                        style="pointer-events:all"
                                        styleClass="popup">
                                        <center>
                                                <br></br>
                                                <br></br>
                                                <h:outputLabel value="#{rto.popmsg}"></h:outputLabel>
                                                <br></br>
                                                <br></br>
                                                <h:commandButton value="OK"
                                                                 action="#{rto.closePop}"
                                                                 styleClass="popup-button"/>
                                        </center>
                                </h:form>
                                 </h:panelGroup>
                                </div>
                        </body>
                </html>
        </af:document>
</f:view>
<%-- oracle-jdev-comment:auto-binding-backing-bean-name:backing_addRegistration--%>