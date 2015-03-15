<%--

  handlebars component.

  

--%><%
%><%@include file="../../../init.jsp"%><%
%><%@page session="false" %><%
%><%
	// TODO add you code here
%>
<cq:includeClientLib categories="cq.jquery"/>
<cq:includeClientLib categories = "cq.handlebars" />
<cq:include script="/libs/wcm/mobile/components/simulator/simulator.jsp"/>



<body>
    <h1>Lets say Hello</h1>
    <div id="nameoutput"></div>


<script id="person-template" type="text/x-handlebars-template">
    <p class="person">{{firstname}}{{lastname}}</p>
</script>
<script>
    window.onload = function(){
        var source = document.getElementById("person-template").innerHTML;
        var template = Handlebars.compile(source);
        var context = {firstname : "vivek", lastname :"Dhiman"};
        var output = template(context);
        document.getElementById("nameoutput").innerHTML = output;
    }
</script>



    <h1>List of Animals and Sounds</h1>
    <div id="animalList">
    </div>

    <!-- HANDLEBARS TEMPLATE -->
<%--
    <script id="animalTemplate" type="text/x-handlebars-template">
        <ul>
            {{#animals}}
            <li class="animal">{{type}} says {{sound}}</li>
            {{/animals}}
        </ul>
    </script>
--%>
##

    <script id="animalTemplate" type="text/x-handlebars-template">
        {{#if animals}}
        <ul>
            {{#each animals}}
            <li class="animal">{{type}} says {{sound}}</li>
            {{/each}}
        </ul>
        {{else}}
        <p>There are no animals.</p>
        {{/if}}
       <p>{{helper}}</p>
        <%-- <p>{{multiply 7 16}}</p>--%>

    </script>
    <cq:includeClientLib categories="custom.hbs" />

    <!-- RENDER TEMPLATE AFTER EVERYTHING ELSE LOADED -->
</body>
