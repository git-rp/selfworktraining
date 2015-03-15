
<%--

  editbehaviour component.

  

--%><%
%>
<%@include file="../../../global.jsp"%>
<%@include file="../../../init.jsp"%><%
%><%@page session="false" %>


<%
%><%
	// TODO add you code here
%>
Hello
<h3>${properties['title']}</h3>
<h4>${properties['desc']}</h4>
<%
    com.aem.services.DemoService service = sling.getService(com.aem.services.DemoService.class);
    out.println(service);
     service.demoMethod();

%>



