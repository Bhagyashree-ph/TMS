<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
  <af:document id="d1">
   <html>
    <head>
      <meta http-equiv="Content-Type"
            content="text/html; charset=windows-1252"/>
      <title>RTOHome</title>
      <style type="text/css">
        #bg{
            background: url("CopHome.jpg") ;
            background-repeat: no-repeat;
             background-size: cover;
              background-position: center;
              width: 100%;
              height: 500px;
        }
      </style>
    </head>
    <body>
        <jsp:include page="/copheader.html"/>
        <div id="bg">
        </div>
    </body>
  </html>
  </af:document>
</f:view>