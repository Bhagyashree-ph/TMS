<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
  <af:document id="d1" >
    <html>
        <head>
            <title>Add Offense Type</title>
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
            <h:panelGroup style="pointer-events:all">
            <h1 id="heading">Add New Offense</h1>
            <div id="pageContainer">
                <h:form>
                    <div class="form-group">
                        <h:outputLabel for="offenseName" styleClass="custLabel">Offense Name:</h:outputLabel>
                        <h:inputText value="#{rto.offTypes.offenseName}" id="offenseName" styleClass="custInText" />
                    </div>
                    <div class="form-group">
                        <h:outputLabel for="vehicleType" styleClass="custLabel">Vehicle Type:</h:outputLabel>
                        <h:inputText value="#{rto.offTypes.vehicleType}"  id="vehicleType" styleClass="custInText"/>
                    </div>
                    <div class="form-group">
                        <h:outputLabel for="penalty" styleClass="custLabel">Penalty:</h:outputLabel>
                        <h:inputText value="#{rto.offTypes.penalty}" id="penalty" styleClass="custInText"/>
                    </div>
                    <div class="d-flex justify-content-center">
                        <h:commandButton value="Add Offense" styleClass="custBtn"
                                         action="#{rto.addOffenseTypes}"/>
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
