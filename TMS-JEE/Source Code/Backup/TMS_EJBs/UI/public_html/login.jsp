<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>

<f:view>

  <af:document id="d1">

  <head>

    <link rel="stylesheet" href="../css/style.css"/>

    <link rel="stylesheet" href="rtostyles.css"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
                background-color: #007bff;
                width: 50.0px;
                height: 30px;
                margin: 0px;
                padding: 0px;
                font-size: 15px;
                margin-bottom: 30px;
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
            .title {
                font-family: 'Times New Roman', 'Arial Black', times, Serif;
                font-style: italic;
                display: flex;
                align-items: center;
                justify-content: center;
                font-weight: bold;
                font-size: 40px;
                color: crimson;
                margin-bottom: 30px;
            }
            #bgimg {
                background: url("login.jpg") ;
                background-repeat: no-repeat;
                background-size: cover;
                background-position: fill;
            }
</style>

    </head>

    <body id="bgimg">
        <h1 id="heading">Traffic Management System</h1>
        
    <br></br>
    
    <div id="pageContainer" style="width: 500px; height: 400px; opacity: 0.9;">

 <h:outputText styleClass="title"  value="Login" rendered="true">  </h:outputText>
    
    <h:form id="f1" binding="#{log.content}">

        <div class="form-group">

                    <h:outputLabel for="userid" styleClass="custLabel">UserID:</h:outputLabel>

                    <h:inputText id="userid" required="true" styleClass="custInText" value="#{log.loginuser.userId}" />

        </div>

        <div class="form-group" >

            <h:outputLabel for="password" styleClass="custLabel">Password:</h:outputLabel>

            <h:inputSecret id="passwordl" styleClass="custInText" required="true" value="#{log.loginuser.password}" redisplay="true"/>

        </div>
            <br></br>
                    <p class="d-flex justify-content-center">

                        <h:commandButton value="Login"

                                         styleClass="custBtn"

                                         action="#{log.log}" id="cb1"/>

                    </p>

                    <p>

                        &nbsp;

                    </p>

    </h:form>


 <h:form styleClass="popup" binding="#{log.pop}"
                        rendered="false">
                        
                        <br>
                    <p class="icon">Х</p>
                    <!--<div class="success" style="color: Green;">✔</div>-->
                    <br>
                    <p class="error">Invalid Credentials.!</p>
                    <p style="font-weight: 200; font-size: 15px;">Please enter valid user id or password</p>
                    <br>
                    <h:commandButton value="OK" action="#{log.closePop}"
                                     styleClass="popup-button"/>
                </h:form>   
    </div>

    </body>

  </af:document>

</f:view>