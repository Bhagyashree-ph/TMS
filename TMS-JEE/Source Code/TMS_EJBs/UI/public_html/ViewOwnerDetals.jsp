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
            <title>View Owner</title>
            <link rel="stylesheet" type="text/css" href="rtostyles.css"/>
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
             
            <br></br>
             
            <h:panelGroup style="pointer-events:all">
                <h1 id="heading">View Owner Details</h1>
                <div id="pageContainer">
                    <h:form id="ownerForm">
                        <div class="search-container">
                            <h:outputLabel for="registrationId"
                                           value="Registration Id:"
                                           styleClass="search-label"/>
                             
                            <h:inputText id="registrationId"
                                         value="#{cop.registrationId}"
                                         styleClass="search-container-input"/>
                             
                            <h:commandButton value="View"
                                             styleClass="search-container-btn"
                                             action="#{cop.ownerDetails}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="ownerId" styleClass="custLabel">Owner
                                                                                ID:</h:outputLabel>
                             
                            <h:inputText id="ownerId" styleClass="custInText"
                                         value="#{cop.ownereo.ownerId}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel styleClass="custLabel">ID Type:</h:outputLabel>
                             
                            <h:inputText id="idType" styleClass="custInText"
                                         value="#{cop.ownereo.idType}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="firstName"
                                           styleClass="custLabel">First Name:</h:outputLabel>
                             
                            <h:inputText id="firstName" styleClass="custInText"
                                         value="#{cop.ownereo.firstName}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="lastName"
                                           styleClass="custLabel">Last Name:</h:outputLabel>
                             
                            <h:inputText id="lastName" styleClass="custInText"
                                         value="#{cop.ownereo.lastName}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="dateOfBirth"
                                           styleClass="custLabel">Date of Birth:</h:outputLabel>
                             
                            <h:outputText id="dateOfBirth"
                                          styleClass="custInText"
                                          value="#{cop.ownereo.dateofbirth}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="gender" styleClass="custLabel">Gender:</h:outputLabel>
                             
                            <h:inputText id="gender" styleClass="custInText"
                                         value="#{cop.ownereo.gender}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="phoneNumber"
                                           styleClass="custLabel">Phone Number:</h:outputLabel>
                             
                            <h:inputText id="phoneNumber"
                                         styleClass="custInText"
                                         value="#{cop.ownereo.phoneNumber}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="address" styleClass="custLabel">Address:</h:outputLabel>
                             
                            <h:inputText id="address" styleClass="custInText"
                                         value="#{cop.ownereo.address}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="pincode" styleClass="custLabel">Pincode:</h:outputLabel>
                             
                            <h:inputText id="pincode" styleClass="custInText"
                                         value="#{cop.ownereo.pincode}"/>
                        </div>
                        <div class="form-group">
                            <h:outputLabel for="occupation"
                                           styleClass="custLabel">Occupation:</h:outputLabel>
                             
                            <h:inputText id="occupation" styleClass="custInText"
                                         value="#{cop.ownereo.occupation}"/>
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