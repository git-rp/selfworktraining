<%
%><%
%><%@page session="false" %><%
%><%
    // TODO add you code here
%>
<head>
    <title>AEM</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

</head>
<%@include file="../../../global.jsp"%>

<%@include file="../../../init.jsp"%>
<cq:includeClientLib categories="cq.jquery"/>
<cq:include script="/libs/wcm/mobile/components/simulator/simulator.jsp"/>
<div class="parviv">
<cq:include path="parsys" resourceType="foundation/components/parsys" />
</div>