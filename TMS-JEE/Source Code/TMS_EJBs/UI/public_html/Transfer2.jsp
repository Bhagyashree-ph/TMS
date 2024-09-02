<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@ page contentType="text/html;charset=windows-1252"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>

<f:view>

<af:document>
    <html>

        <head>

            <meta http-equiv="Content-Type"

                  content="text/html; charset=windows-1252"/>

            <title>Transfer</title>

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
         <jsp:include page="/rtoheader.html"/>
          <h:panelGroup style ="pointer-events:all">       
                <br></br>
                 
                <h1 id="heading">Transfer Vehicle</h1>
        <div id="pageContainer">

            <h:form>

                 <h2 style="text-align: center;">New owner details</h2><br>

            <div class="search-container">

                <h:outputLabel for="ownerId" styleClass="search-label" >Owner ID:</h:outputLabel>

                <h:inputText id="ownerId" 

                             styleClass="search-container-input"

                             value="#{rto.owners.ownerId}"/>

                <h:commandButton value="Search" 

                                 styleClass="search-container-btn"

                                 action="#{rto.fetchByOwnerID}"/>

            </div>

                </h:form>

            <h:form id="f1">

                <div class="form-group">

                    <h:outputLabel styleClass="custLabel">ID Type:</h:outputLabel>

                    <h:inputText id="idType" styleClass="custInText"

                                 value="#{rto.owners.idType}"/>

                </div>

                <div class="form-group">

                    <h:outputLabel for="firstName" styleClass="custLabel">First

                                                                          Name:</h:outputLabel>

                    <h:inputText id="firstName" styleClass="custInText"

                                 value="#{rto.owners.firstName}"/>

                </div>

                <div class="form-group">

                    <h:outputLabel for="lastName" styleClass="custLabel">Last

                                                                         Name:</h:outputLabel>

                    <h:inputText id="lastName" styleClass="custInText"

                                 value="#{rto.owners.lastName}"/>

                </div>

                <div class="form-group">

                    <h:outputLabel for="dateOfBirth" styleClass="custLabel">Date

                                                                            of

                                                                            Birth:</h:outputLabel>

                    <h:inputText id="dateOfBirth" styleClass="custInText"

                                 value="#{rto.owners.dateofbirth}"/>

                </div>

                <div class="form-group">

                    <h:outputLabel for="gender" styleClass="custLabel">Gender:</h:outputLabel>

                    <h:inputText id="gender" styleClass="custInText"

                                 value="#{rto.owners.gender}"/>

                </div>

                <div class="form-group">

                    <h:outputLabel for="phoneNumber" styleClass="custLabel">Phone

                                                                            Number:</h:outputLabel>

                    <h:inputText id="phoneNumber" styleClass="custInText"

                                 value="#{rto.owners.phoneNumber}"/>

                </div>

                <div class="form-group">

                    <h:outputLabel for="address" styleClass="custLabel">Address:</h:outputLabel>

                    <h:inputText id="address" styleClass="custInText"

                                 value="#{rto.owners.address}"/>

                </div>

                <div class="form-group">

                    <h:outputLabel for="pincode" styleClass="custLabel">Pincode:</h:outputLabel>

                    <h:inputText id="pincode" styleClass="custInText"

                                 value="#{rto.owners.pincode}"/>

                </div>

                <div class="form-group">

                    <h:outputLabel for="occupation" styleClass="custLabel">Occupation:</h:outputLabel>

                    <h:inputText id="occupation" styleClass="custInText"

                                 value="#{rto.owners.occupation}"/>

                </div>

                <div class="form-group" style="text-align: center;">

                    <h:commandButton value="Transfer" styleClass="custBtn"

                                     action="#{rto.updateRegistration}"/>

                     <%--<h:commandButton value="Add Owner"

                                 styleClass="editBtn" />--%>

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

<%-- oracle-jdev-comment:auto-binding-backing-bean-name:backing_Transfer2--%>