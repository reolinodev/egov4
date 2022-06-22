<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Seoul Verse</title>
    <%@include file ="../include/config.jsp" %>
    <script src="https://code.highcharts.com/maps/highmaps.js"></script>
    <script src="https://code.highcharts.com/maps/modules/data.js"></script>
    <script src="https://code.highcharts.com/maps/modules/drilldown.js"></script>
    <script src="https://code.highcharts.com/maps/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/maps/modules/offline-exporting.js"></script>
    <script src="https://code.highcharts.com/maps/modules/accessibility.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <link href="https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
    <script type="module" src="/dist/adminGis.js"></script>
    <style>
        * {
            font-family: sans-serif;
        }
        /*#map {*/
        /*    width: 100%;*/
        /*    height: 75vh;*/
        /*}*/
        #container {
            width: 100%;
            margin: 0 auto;
            padding: 0;
            overflow: visible;
        }

        #map {
            float: left;
            height: 75vh;
            width: 60%;
            margin: 0;
        }

        #chart_area {
            float: left;
            width: 35%;
        }

        @media screen and (max-width: 920px) {
            #container,
            #map,
            #chart_area {
                float: none;
                width: 100%;
                height: auto;
                margin: 0.5em 0;
                padding: 0;
                border: none;
            }
        }
    </style>
</head>

<div id="container">
    <div id="map"></div>
    <div id="chart_area">
        <div id="chart"></div>
    </div>
</div>


</html>
