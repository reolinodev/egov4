import Highcharts from 'highcharts/highmaps';

export async function getSeoulMapData() {
    return Highcharts.geojson(await fetch('/api/admin/pilot/json/seoul').then(response => response.json()));
}

export function setDataClassMap (id, data, mapOption ,highOption) {

    Highcharts.mapChart(id, {
        chart: {
            style: {
                fontFamily: "'Noto Sans KR', sans-serif"
            },
            events: {
                // drilldown,
                // drillup
            }
        },

        title: {
            text: mapOption.title,
            style: {
                fontSize: '2em'
            }
        },

        colorAxis: {
            min: 0,
            minColor: mapOption.minColor,
            maxColor: mapOption.maxColor
        },

        mapNavigation: {
            enabled: true,
            buttonOptions: {
                verticalAlign: 'bottom'
            }
        },

        tooltip: {
            backgroundColor: 'none',
            borderWidth: 0,
            shadow: false,
            useHTML: true,
            padding: 0,
            pointFormat: '<span class="f32"></span>' +
                '<span>{point.name}</span><br>' +
                '<span style="font-size:30px">{point.value}</span>',
            positioner: function () {
                return {x: 50, y: 100};
            }
        },

        plotOptions: {
            map: {
                states: {
                    hover: {
                        color: '#EEDD66'
                    }
                }
            },
        },

        series: [{
            data,
            name: '서울특별시',
            dataLabels: {
                enabled: true,
                format: '{point.properties.name}',
                backgroundColor: 'rgba(255,255,255,0.7)',
                borderRadius: 5,
                padding: 3,
                style: {
                    textOutline: 'none',
                    fontSize: '1.2em'
                }
            },
        }],

        credits: {
            enabled: false
        },

        // drilldown: {
        //     activeDataLabelStyle: {
        //         color: '#0D211D',
        //         textDecoration: 'none',
        //     },
        // }
    });

    Highcharts.setOptions(highOption);

}