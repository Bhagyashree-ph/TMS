<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
<af:document id="av"  title="Reports">
  <html>
    <head>
      <meta http-equiv="Content-Type"
            content="text/html; charset=windows-1252"/>
      <title>reports</title>
      <link rel="stylesheet" type="text/css" href="rtostyles.css"/>
    </head>
    <body>
      <jsp:include page="/rtoheader.html"/> <br>
    <h1 id="heading">Generate Report</h1>
    <div id="pageContainer">
        <h:form>
            <div class="form-group">
                <h:outputLabel for="registrationId" styleClass="cusLabel">Registration ID:</h:outputLabel>
                <h:inputText id="registrationId" styleClass="custInText"/>
                <h:commandButton type="submit" value="Generate Report" styleClass="custBtn"/>
            </div>
        </h:form>
        <div class="preview">
            <h2>Preview:</h2>
            <p>This is where the preview for the document will be displayed.</p>
        </div>
    </div>
    </body>
  </html>
</af:document>
</f:view>