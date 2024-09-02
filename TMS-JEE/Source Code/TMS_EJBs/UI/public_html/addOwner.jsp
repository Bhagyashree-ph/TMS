<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>

<f:view>
  <af:document id="d1" title="Add Owner" >
  <html>
  <head>
    <link href="rtostyles.css" rel ="stylesheet"/>
    <title>Add Owner</title>
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
    <jsp:include page="rtoheader.html"/>
    <h:panelGroup style="mouse-pointers:all">
                <h1 id="heading" style="text-align: center;">Add New Owner</h1>
        <div id="pageContainer">
            <h:form id="addOwner">
           <div id="progress">
                <h:commandButton styleClass="curr" value="1" action="own"></h:commandButton>
                <h:commandButton styleClass="next" value="2" action="#{rto.veh}"></h:commandButton>
                <h:commandButton styleClass="next" value="3" action="#{rto.reg}"></h:commandButton>
            </div>
            <br>

             <br>
                <div class="form-group">
                        <p>
                            <h:outputLabel for="ownerId" id="ol1" styleClass="custLabel">
                                Owner ID:
                            </h:outputLabel>
                             
                            <h:inputText id="ownerId"
                                         value="#{rto.owners.ownerId}"
                                         styleClass="custInText"/>
                        </p>
                </div>
                    <div class="form-group">
                    <p>
                        <h:outputLabel id="idType" styleClass="custLabel">ID Type</h:outputLabel>
                       <h:selectOneRadio value="#{rto.owners.idType}" >
            <f:selectItem itemValue="Pan card" itemLabel="Pan Card" />
            <f:selectItem itemValue="Aadhar card" itemLabel="Aadhar card" />
        </h:selectOneRadio> 
        </p>
                    </div>
                
                <div class="form-group">
                    <h:outputLabel styleClass="custLabel">First Name:</h:outputLabel>
                    <h:inputText id="firstName" styleClass="custInText"
                                 value="#{rto.owners.firstName}"/>
                </div>
                <div class="form-group">
                    <h:outputLabel styleClass="custLabel">Last Name:</h:outputLabel>
                    <h:inputText id="lastName" styleClass="custInText"
                                 value="#{rto.owners.lastName}"/>
                </div>
                <div class="form-group">
                        <p>
                        <h:outputLabel styleClass="custLabel">Date of Birth:</h:outputLabel>
                            <af:inputDate  styleClass="custInText"
                                          id="id1"
                                          value="#{rto.owners.dateofbirth}"/>
                        </p>
                        </div>
                        <div class="form-group">
                        <p>
                        <h:outputLabel id="gender" styleClass="custLabel">Gender</h:outputLabel>
                        <h:selectOneRadio label="Gender" value="#{rto.owners.gender}" >
            <f:selectItem itemValue="Male" itemLabel="Male" />
            <f:selectItem itemValue="Female" itemLabel="Female" />
                        </h:selectOneRadio>   
                        </p>
                    </div>
                <div class="form-group">
                    <h:outputLabel styleClass="custLabel">Phone Number:</h:outputLabel>
                    <h:inputText id="phoneNumber" styleClass="custInText"
                                 value="#{rto.owners.phoneNumber}"/>
                </div>
                <div class="form-group">
                    <h:outputLabel styleClass="custLabel">Address:</h:outputLabel>
                    <h:inputText id="address" styleClass="custInText"
                                 value="#{rto.owners.address}"/>
                </div>
                <div class="form-group">
                    <h:outputLabel styleClass="custLabel">Pincode:</h:outputLabel>
                    <h:inputText id="pincode" styleClass="custInText"
                                 value="#{rto.owners.pincode}"/>
                </div>
                <div class="form-group">
                    <h:outputLabel styleClass="custLabel">Occupation:</h:outputLabel>
                    <h:inputText id="occupation" styleClass="custInText"
                                 value="#{rto.owners.occupation}"/>
                </div>
                <div class="d-flex justify-content-center" style="text-align:center;">
                    <h:commandButton value="Add Owner" styleClass="custBtn"
                                     action="#{rto.addNewOwner}"></h:commandButton>
                </div>
            </h:form>             
                
                    <h:form binding="#{rto.pop}" rendered="false" style="pointer-events:all" styleClass="popup">
         <center>
        <br><br><br>
        <h:outputLabel value="#{rto.popmsg}"></h:outputLabel>
        <br><br><br><br><br>
        <h:commandButton value="OK" action="#{rto.closePop}" styleClass="popup-button"/>
        </center>
    </h:form>
        </div>
        </h:panelGroup>
        </body>
        </html>
  </af:document>
</f:view>
<%-- oracle-jdev-comment:auto-binding-backing-bean-name:backing_addOwner--%>