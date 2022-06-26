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
            <button type="button" class="btn btn-block btn-success btn-sm" id="editorBtn">Set Html</button>
        </div>
    </div>
    <div class="row" style="margin: 10px;font-weight: bold;color: darkgrey;">
        <p>* Editor</p>
    </div>
    <div class="row" style="width: 100%">
        <div id="editor"></div>
    </div>
    <div class="row" style="margin: 10px;font-weight: bold;color: darkgrey;">
        <p>* Viewer</p>
    </div>
    <div class="row">
        <div id="viewer"></div>
    </div>
</div>

</html>
