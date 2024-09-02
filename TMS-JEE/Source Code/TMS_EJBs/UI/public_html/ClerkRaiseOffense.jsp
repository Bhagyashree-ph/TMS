<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
  <html>
    <head>
      <title>RaiseOffense</title>
      <link rel="stylesheet" href="../css/style.css">
      <link rel="stylesheet" href="rtostyles.css"/>   
      <style type="text/css">
            .popup {
            all: unset;
            position: absolute;
            height: 270px;
            width: 300px;
            top: 50%;
            left: 50%;
            background-color: #F2F3F5;
            translate: -50%-50%;
            box-shadow: 0 0 10pxrgba(0, 0, 0, 0.3);
            border-radius: 20px;
            display: inline-block;
            padding: 0px;
        }
        
        .popup-button {
            background: #007bff;
            width: 50.0px;
            height: 30px;
            margin: 0px;
            padding: 0px;
            font-size: 15px;
            margin-bottom: 30px;
            border: none;
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
        
        .error {
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
    <jsp:include page="/ClerkHeader.html"/>
    <h:panelGroup style="mouse-pointers:all">
     <h1 id="heading">Raise Offense</h1>
     <dir id="pageContainer">
        <h:form>
            <!--<div class="form-group">
                <label for="offenseDetailsId" class="custLabel">Offense Details ID:</label>
                <h:inputText id="offenseDetailsId" value="#{cop.offdobj.offenseDetailId}" required="true" styleClass="custInText"/>
            </div>-->

            
            <div class="form-group">
                <label for="place" class="custLabel">Place:</label>
                <h:inputText id="place" value="#{cop.offdobj.place}" required="true" styleClass="custInText"/>
            </div>

            <div class="form-group">
                <label for="registrationId" class="custLabel">Registration ID:</label>
                <h:inputText id="registrationId" value="#{cop.registrationId}" required="true" styleClass="custInText"/>
            </div>

             <div class="form-group">
                <label for="offenseId" class="custLabel">Offense ID:</label>
                <h:inputText id="offenseId" value="#{cop.offenseId}" required="true"  styleClass="custInText"/>
            </div>

            <div class="form-group">
                <label for="recordedBy" class="custLabel">Recorded By:</label>
                <h:inputText id="recordedBy" value="#{cop.userId}" required="true" styleClass="custInText"/>
            </div>

            <div class="form-group">
                <label for="penaltyStatus" class="custLabel">Penalty Status:</label>
                <h:selectOneMenu id="penaltyStatus" value="#{cop.offdobj.penaltyStatus}" required="true">
                    <f:selectItem itemValue="unpaid" itemLabel="UnPaid"/>
                    <f:selectItem itemValue="paid" itemLabel="Paid"/>
                    
                </h:selectOneMenu>
            </div>
            <br/>
            <div class="d-flex justify-content-center">
            <h:commandButton value="Raise" action="#{cop.raise}" styleClass="custBtn"/>
        </h:form>
    </dir>
      
           <h:form binding="#{cop.pop}" rendered="false" style="pointer-events:all"
                styleClass="popup">
          <center>
            <br></br>
            
            <br></br>
            <h:outputLabel value="#{cop.popmsg}"></h:outputLabel>
            <br></br>
            <br></br>
            <h:commandButton value="OK" action="#{cop.closePop}"
                             styleClass="popup-button"/>
          </center>
        </h:form>
        </h:panelGroup>
    </body>
  </html>
</f:view>
