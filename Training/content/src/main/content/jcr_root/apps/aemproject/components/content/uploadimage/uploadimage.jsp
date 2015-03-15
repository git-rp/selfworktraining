<%@include file="../../../global.jsp"%>
<%@include file="../../../init.jsp"%>
<%@page session="false" %>
<cq:includeClientLib categories = "cq.jquery"/>
<div class="imageupload">
    <script>
        $(document).ready(function(){
            $("button").click(function(){
                $.ajax({
                    url : '/bin/wem/uploadimage',
                    data : {
                        imagepath : $('#img').val()
                    },
                    success : function(responseText) {
                        $('#success').text(responseText);
                    }
                });
            });

        });
    </script>
    <input id="img" type="file" name="pic" accept="image/*">
    <button>Upload Image in DAM</button>
</div>
<div id="success"></div>
