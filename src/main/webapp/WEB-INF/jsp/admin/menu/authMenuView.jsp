<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EX-EM</title>
    <%@include file ="../include/config.jsp" %>
    <script type="module" src="/dist/adminAuthMenu.js"></script>
</head>

<div id="container">
    <form name="menuFrm">
        <div class="row">
            <div class="col-md-5">
                <div class="card">
                    <div class="card-header">
                        <div class="row" >
                            <div class="col-6">
                                <select class="custom-select rounded-0" id="authRole" name="auth_role"></select>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <div id="tree" class="tui-tree-wrap" style="width: 100%;"></div>
                    </div>
                </div>
            </div>

            <div class="col-md-7">
                <div class="card">
                    <div class="card-header">
                        <div class="row justify-content-end">
                            <div class="col-3">
                                <button type="button" class="btn btn-block btn-success btn-sm" id="saveBtn">SAVE</button>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <p class="guide-word">* When adding or deleting permission in the upper menu, it affects the lower permission.</p>
                        <input type="hidden" id="menuId"/>
                        <div id="grid"></div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

</html>
