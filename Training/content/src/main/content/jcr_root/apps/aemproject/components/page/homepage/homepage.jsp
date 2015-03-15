<%--

  homepage component.

  

--%><%
%> <%
%><%@page session="false" %><%
%><%
	// TODO add you code here
%>
<html>
<head>
    <title>Search Engine Title Goes Here</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

</head>
<body>
<%@include file="../../../global.jsp"%>
<%@include file="../../../init.jsp"%>


<div id="content">
    <cq:include path="parsys" resourceType="foundation/components/parsys"/>
</div>
<form action="/bin/crx/bootcamp" method="POST">
  Node Name  <input type="text" name="n1">
   <input type="submit">
</form>
</body>
</html>


