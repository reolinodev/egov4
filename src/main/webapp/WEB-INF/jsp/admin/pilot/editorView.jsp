<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Seoul Verse</title>
    <%@include file ="../include/config.jsp" %>
    <script type="module" src="/dist/adminEditor.js"></script>
</head>

<div id="container">
    <div class="row justify-content-end" style="margin-bottom: 10px">
        <div class="col-2">
            <button type="button" class="btn btn-block btn-success btn-sm" id="editorBtn">Get Html</button>
        </div>
    </div>
    <div class="row">
        <div id="editor"></div>
    </div>
</div>

</html>
