<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
    <af:document id="registrationPage" title="Register Vehicle">
        <jsp:include page="/rtoheader.html"/>
        <div class="pageContainer">
            <af:form id="addVehicle"
                     rendered="#{!rto.isVehicleAdded && !rto.isOwnerAdded}">
                <jsp:include page="/addVehicle.jsp"/>
            </af:form>
             
            <af:form id="addOwner"
                     rendered="#{rto.isVehicleAdded && !rto.isOwnerAdded}">
                <jsp:include page="/addOwner.jsp"/>
            </af:form>
             
            <af:form id="addReg"
                     rendered="#{rto.isVehicleAdded && rto.isOwnerAdded}">
                <jsp:include page="/addRegistration.jsp"/>
            </af:form>
        </div>
        <%-- oracle-jdev-comment:auto-binding-backing-bean-name:managedBean--%>

    </af:document>
</f:view>