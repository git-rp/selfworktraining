<%@include file="/apps/aemproject/init.jsp"%><%
%><%@page session="false" %><%
%>
<%
    String prop = properties.get("propadd","");
    out.println("prop :: "+prop);

    com.aem.services.WriteOpService writeOpService = sling.getService(com.aem.services.WriteOpService.class);
    com.aem.services.ReadOpService readOpService = sling.getService(com.aem.services.ReadOpService.class);
    //readOpService.readPropFromNode(prop);
     writeOpService.writePropToNode(prop);
%>
<h2>Use of getServiceResourceResolver()</h2>
