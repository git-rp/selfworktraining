<%--

  adaptiveimage component.

  

--%><%
%><%@include file="../../../../init.jsp"%><%
%><%@page session="false" %><%
%><%
	// TODO add you code here
%>
<cq:includeClientLib categories="cq.adaptiveimage"/>
Hello
${properties['text']}
${properties['img']}
<div data-picture>
    <div data-src="${properties['img']}"></div>
    <div data-src="${properties['img']}/jcr:content/renditions/cq5dam.thumbnail.319.319.png"    data-media="(min-width: 769px)"></div>
    <div data-src="${properties['img']}/jcr:content/renditions/cq5dam.thumbnail.140.100.png"   data-media="(min-width: 481px)"></div>
</div>