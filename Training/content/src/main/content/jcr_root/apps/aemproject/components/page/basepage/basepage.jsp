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
 <%@include file="../../../init.jsp"%>
<cq:includeClientLib categories = "commons.aeem" />
<cq:includeClientLib categories="cq.jquery"/>
<cq:includeClientLib categories = "cq.social.hbs.rating" />
    <cq:include script="/libs/wcm/mobile/components/simulator/simulator.jsp"/>

<body>
<div id="top">

    </div>
<div id="banner">
  <h1> <a href="#">AEM Experts</a></h1>
</div>
<div id="menuh-container">
  <div id="menuh">
    <ul>
      <li><a href="#" class="top_parent">Homepage</a> </li>
    </ul>
    <ul>
      <li><a href="#" class="top_parent">About</a>
        <ul>
          <li><a href="#">Link 1</a></li>
          <li><a href="#">Link 2</a></li>
        </ul>
      </li>
    </ul>
    <ul>
      <li><a href="#" class="top_parent">Projects</a>
        <ul>
          <li><a href="#">Link 1</a></li>
          <li><a href="#">Link 2</a></li>
          <li><a href="#">Link 3</a></li>
        </ul>
      </li>
    </ul>
    <ul>
      <li><a href="#" class="top_parent">Portfolio</a> </li>
    </ul>
    <ul>
      <li><a href="#" class="top_parent">Contact</a> </li>
    </ul>
  </div>
</div>
<div id="container">
  <div id="sidebar">
    <h3>Links</h3>
    <ul>
      <li><a href="#">Snapp Happy</a></li>
      <li><a href="#">TODC</a></li>
      <li><a href="#">OWD</a></li>
      <li><a href="#">OSWD</a></li>
      <li><a href="#">CSS play</a></li>
      <li><a href="#">Andreas Viklund</a></li>
      <li><a href="#">James Koster</a></li>
    </ul>
    <h3>Sub Menu</h3>
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">Products</a></li>
      <li><a href="#" class="selected">What we do</a></li>
      <li><a href="#">Contact us</a></li>
      <li><a href="#">Privacy Policy</a></li>
      <li><a href="#">Links</a></li>
    </ul>
    <h3>Archives</h3>
    <ul>
      <li><a href="#">January</a></li>
      <li><a href="#">February</a></li>
      <li><a href="#">March</a></li>
      <li><a href="#">April</a></li>
    </ul>
    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec non ante.</p>
  </div>
  <div id="content">
    <h3>Welcome to <span style="color:#710069;font-family: georgia,sans-serif;font-weight: bold;">LILAC</span> Template</h3>
    <blockquote>This template has been tested in Mozilla and IE6/7. The page validates as XHTML 1.0 Transitional using valid CSS. For more FREE templates visit <a href="http://www.mitchinson.net"> my website</a>.</blockquote>
    <p>This is a <a href="#">link</a> to nowhere. Donec lorem. Quisque eu pede ac ligula bibendum cursus. Nulla tristique diam sit amet lacus. Nulla ut magna. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nullam diam orci, scelerisque quis, fermentum non, volutpat non, libero. In hac habitasse platea dictumst. Fusce ut urna. Donec lorem. Quisque eu pede ac ligula bibendum cursus. Nulla tristique diam sit amet lacus. Nulla ut magna. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nullam diam orci, scelerisque quis, fermentum non, volutpat non, libero. In hac habitasse platea dictumst. Fusce ut urna.</p>
    <h3> News &amp; Updates</h3>
    <div class="scroll">
      <h4>May 3rd 2006</h4>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nunc venenatis rhoncus libero. Quisque et elit luctus diam ornare sollicitudin. Quisque nec elit. Quisque vehicula metus vel nisi hendrerit cursus.</p>
      <h4>May 1st 2006</h4>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nunc venenatis rhoncus libero. Quisque et elit luctus diam ornare sollicitudin. Quisque nec elit. Quisque vehicula metus vel nisi hendrerit cursus.</p>
    </div>
    <h3>Articles</h3>

  </div>
    <div id="parsys">
        <%--<div class="page-systemnav">
            <div class="sys-nav-wrapper">
              <cq:include path="userinfo" resourceType="geometrixx-outdoors/components/page/userinfo"/>
            </div>
        </div>--%>
            <cq:include path="parsys" resourceType="foundation/components/parsys"/>
    </div>


</div>

<div id="footer"> <a href="#">homepage</a> | <a href="mailto:denise@mitchinson.net">contact</a> | <a href="http://validator.w3.org/check?uri=referer">html</a> | <a href="http://jigsaw.w3.org/css-validator">css</a> | &copy; 2007 Anyone | Design by <a href="http://www.mitchinson.net"> www.mitchinson.net</a> | This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attribution 3.0 License</a> </div>
</body>
</html>
