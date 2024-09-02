<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
    <af:document id="av" title="Transfer">
        <html>
            <head>
                <meta http-equiv="Content-Type"
                      content="text/html; charset=windows-1252"/>
                <title>Transfer</title>
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
                <jsp:include page="/rtoheader.html"/>
                 <h:panelGroup style="pointer-events:all">
                <br></br>
                 
                <h1 id="heading">Transfer Vehicle</h1>
                <div id="pageContainer">
                    <h:form>
                        <div class="search-container">
                            <h:outputLabel for="registrationId"
                                           styleClass="search-label">Registration
                                                                  ID:</h:outputLabel>
                             
                            <h:inputText id="registrationId"
                                         styleClass="search-container-input"
                                         value="#{rto.registrations.registrationId}"/>
                             
                            <h:commandButton value="Search"
                                             styleClass="search-container-btn"
                                             action="#{rto.findVehAndOwnDetails}"/>
                        </div>
                    </h:form>
                     
                    <h:form>
                        <div class="row">
                            <div class="col-6"
                                 style=" box-shadow: .5px 0 0 #000;">
                                <table>
                                    <tr>
                                        <th colspan="2" style="text-align:center;">Owner details</th>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="ownerId"
                                                           styleClass="custLabel">Owner
                                                                                  ID:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="ownerId" 
                                                          styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.owners.ownerId}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel styleClass="custLabel">ID
                                                                                  Type:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="idType"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.owners.idType}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="firstName"
                                                           styleClass="custLabel">First
                                                                                  Name:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="firstName"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.owners.firstName}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="lastName"
                                                           styleClass="custLabel">Last
                                                                                  Name:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="lastName"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.owners.lastName}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="dateOfBirth"
                                                           styleClass="custLabel">Date
                                                                                  of
                                                                                  Birth:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="dateOfBirth"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.owners.dateofbirth.date}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="gender"
                                                           styleClass="custLabel">Gender:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="gender"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.owners.gender}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="phoneNumber"
                                                           styleClass="custLabel">Phone
                                                                                  Number:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="phoneNumber"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.owners.phoneNumber}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="address"
                                                           styleClass="custLabel">Address:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="address"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.owners.address}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="pincode"
                                                           styleClass="custLabel">Pincode:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="pincode"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.owners.pincode}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="occupation"
                                                           styleClass="custLabel">Occupation:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="occupation"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.owners.occupation}"/>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div class="col-6" style="box-shadow: -.5px 0 0 #000;">
                                <table>
                                    <tr>
                                        <th colspan="2" style="text-align:center; ">Vehicle details</th>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="vehicleId"
                                                           styleClass="custLabel">Vehicle
                                                                                  ID:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="vehicleId"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.vehicles.vehicleId}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="engineNumber"
                                                           styleClass="custLabel">Engine
                                                                                  Number:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="engineNumber"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.vehicles.engineNumber}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="chassisNumber"
                                                           styleClass="custLabel">Chassis
                                                                                  Number:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="chassisNumber"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.vehicles.chassisNumber}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="vehicleType"
                                                           styleClass="custLabel">Vehicle
                                                                                  Type:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="vehicleType"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.vehicles.vehicleType}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="vehColor"
                                                           styleClass="custLabel">Vehicle
                                                                                  Color:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="vehColor"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.vehicles.vehColor}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="fuelUsed"
                                                           styleClass="custLabel">Fuel
                                                                                  Used:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="fuelUsed"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.vehicles.fuelUsed}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="manufactureDate"
                                                           styleClass="custLabel">Manufacture
                                                                                  Date:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="manufactureDate"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.vehicles.manufactureDate}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="manufacturerName"
                                                           styleClass="custLabel">Manufacturer
                                                                                  Name:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="manufacturerName"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.vehicles.manufacturerName}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="model"
                                                           styleClass="custLabel">Model:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText id="model"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.vehicles.model}"/>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td>
                                            <h:outputLabel for="variant"
                                                           styleClass="custLabel">Variant:</h:outputLabel>
                                        </td>
                                        <td>
                                            <h:inputText  id="variant"
                                                         styleClass="custInText"
                                                         style="width:100%;"
                                                         value="#{rto.vehicles.variant}"/>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <br>
                        <h4 style="text-align:center; color: red; text-shadow: 3px 1px #C8C8C8;"><b>Pending offenses</b></h4>
                        <div>
                            <h:dataTable rendered="#{!rto.isOffenseCleared}" value="#{rto.unpaidOfd}" var="offdet">
                                <%-- oracle-jdev-comment:Faces.RI.DT.Class.Key:tms.persistence.OffenseDetails--%>
                                <h:column id="c3">
                                    <f:facet name="header">
                                        <h:outputText value="Offense Detail Id"
                                                      id="ot3"/>
                                    </f:facet>
                                    <h:outputText value="#{offdet.offenseDetailId}"
                                                  id="ot10"/>
                                </h:column>
                                <%--<h:column id="c2">
                                    <f:facet name="header">
                                        <h:outputText value="Image" id="ot1"/>
                                    </f:facet>
                                    <h:outputText value="#{offdet.image}"
                                                  id="ot16"/>
                                </h:column>--%>
                                <h:column id="c8">
                                    <f:facet name="header">
                                        <h:outputText value="Offense Date Time"
                                                      id="ot2"/>
                                    </f:facet>
                                    <h:outputText value="#{offdet.offenseDateTime}"
                                                  id="ot13"/>
                                </h:column>
                                <h:column id="c1">
                                    <f:facet name="header">
                                        <h:outputText value="Penalty Status"
                                                      id="ot4"/>
                                    </f:facet>
                                    <h:outputText value="#{offdet.penaltyStatus}"
                                                  id="ot12"/>
                                </h:column>
                                <h:column id="c4">
                                    <f:facet name="header">
                                        <h:outputText value="Place" id="ot5"/>
                                    </f:facet>
                                    <h:outputText value="#{offdet.place}"
                                                  id="ot14"/>
                                </h:column>
                                <h:column id="c7">
                                    <f:facet name="header">
                                        <h:outputText value="Offense Types"
                                                      id="ot6"/>
                                    </f:facet>
                                    <h:outputText value="#{offdet.offenseTypes.offenseId}"
                                                  id="ot11"/>
                                </h:column>
                                <h:column id="c5">
                                    <f:facet name="header">
                                        <h:outputText value="Registrations"
                                                      id="ot7"/>
                                    </f:facet>
                                    <h:outputText value="#{offdet.registrations.registrationId}"
                                                  id="ot15"/>
                                </h:column>
                                <h:column id="c6">
                                    <f:facet name="header">
                                        <h:outputText value="Users" id="ot8"/>
                                    </f:facet>
                                    <h:outputText value="#{offdet.users.userId}"
                                                  id="ot9"/>
                                </h:column>
                            </h:dataTable>
                            <h:outputLabel rendered = "#{rto.isOffenseCleared}" value="No Unpaid Offenses"/>
                        </div>
                        <div class="edit-delete-container">
                            <h:commandButton value="Clear"
                                             styleClass="editBtn"
                                             action="#{rto.clearOffenses}"
                                             rendered="#{!rto.isOffenseCleared}"/>
                             
                            <h:commandButton value="Next"
                                             styleClass="delBtn"
                                             style="background-color: blue;"
                                             action="#{rto.nextPage}"/>
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
<%-- oracle-jdev-comment:auto-binding-backing-bean-name:backing_Transfer--%>    