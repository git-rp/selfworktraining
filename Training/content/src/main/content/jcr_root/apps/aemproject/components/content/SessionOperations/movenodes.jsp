<%@ page import="org.apache.sling.jcr.api.*" %>
<%--

  jcr:session-operations component.

  

--%><%
%><%@include file="/apps/aemproject/init.jsp"%><%
%><%@page session="false" %><%
%>
<%@taglib prefix="moveops" uri="http://com.aem/training" %>
<%
	// TODO add you code here
%>
<moveops:movenodes source="${properties.source}" destination="${properties.destination}" />
<h3>Node moved from  <u>${properties.source}</u> to <u>${properties.destination} </u></h3>
