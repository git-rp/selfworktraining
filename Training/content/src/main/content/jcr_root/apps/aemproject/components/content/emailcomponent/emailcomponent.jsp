<%--

  emailcomponent component.

  

--%><%
%><%@include file="../../../init.jsp"%><%
%><%@page session="false" %><%
%><%
	// TODO add you code here
%>
<%@page import="com.day.cq.wcm.api.WCMMode" %>

${properties['recipient']}
${properties['template']}

<form name="contact" id="contact" action="${resource.path}.emailcomponent.html" method="get">
    <fieldset>
        <legend><fmt:message key="Contact Us" /></legend>
        <label for="email"><fmt:message key="Email" /></label>
        <input type="email" id="email" name="email" /> <br>
        <label for="message"><fmt:message key="Message" /></label>
        <textarea id="message" name="message"></textarea><br>
        <input type="submit" value="<fmt:message key="Submit" />" />
    </fieldset>
</form>
