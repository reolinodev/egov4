let chart;
let allChartData;
let chartData = [];

const drilldown = async function (e) {
    chartData = [];
    if (!e.seriesOptions) {
        const mapChart = this, mapKey = `${e.point.drilldown}`;

        mapChart.showLoading('<i class="icon-spinner icon-spin icon-3x"></i>');

        const mapData = await fetch(`/api/admin/pilot/json/seoul/${mapKey}`).then(response => response.json());
        const popData = await fetch(`/api/admin/pilot/json/house/${mapKey}`).then(response => response.json());
        const data = Highcharts.geojson(mapData);

        data.forEach((d, i) => {
            const adm_cd = d.properties['adm_cd'];
            const arr = _.filter(popData.result, { adm_cd: adm_cd});
            const obj = arr[0];

            d.name = d.properties.adm_nm.split(" ")[2];
            d.value = parseInt(obj.house_cnt);
            const chartArr = [d.name, d.value];
            chartData.push(chartArr);
        });

        // Hide loading and add series
        mapChart.hideLoading();
        mapChart.addSeriesAsDrilldown(e.point, {
            name: e.point.name,
            data,
            dataLabels: {
                enabled: true,
                format: '{point.name}',
                backgroundColor: 'rgba(255,255,255,0.7)',
                borderRadius: 5,
                padding: 3,
                color: 'black',
                style: {
                    textOutline: 'none',
                    fontSize: '1.2em'
                }
            },
        });

        allChartData = chart.series[0].options.data;

        chart.series[0].update({
            data: chartData
        });
    }
};

const drillup = function (e) {
    chart.series[0].update({
        data: allChartData
    });
};

(async () => {

    const mapData = await fetch('/api/admin/pilot/json/seoul').then(response => response.json());
    const popData = await fetch('/api/admin/pilot/json/house').then(response => response.json());
    const data = Highcharts.geojson(mapData);
    chartData = [];

    data.forEach((d, i) => {
        const adm_cd = d.properties['adm_cd'];
        const arr = _.filter(popData.result, {adm_cd: adm_cd});
        const obj = arr[0];
        d.drilldown = adm_cd;
        d.value = parseInt(obj.house_cnt);
        const chartArr = [d.name, d.value];
        chartData.push(chartArr);
    });

    // format : thousands separator
    Highcharts.setOptions({
        lang: {
            thousandsSep: ','
        }
    });

    // Instantiate the map
    Highcharts.mapChart('map', {
        chart: {
            style: {
                fontFamily: "'Noto Sans KR', sans-serif"
            },
            events: {
                drilldown,
                drillup
            }
        },

        title: {
            text: '서울시 주택 통계',
            style: {
                fontSize: '2em'
            }
        },

        colorAxis: {
            min: 0,
            minColor: '#FFFDE4',
            maxColor: '#005AA7'
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
            pointFormat: '<span class="f32">' +
              '</span></span> {point.name}<br>' +
              '<span style="font-size:30px">{point.value}</span>',
            positioner: function () {
                return {x: 10, y: 100};
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

        drilldown: {
            activeDataLabelStyle: {
                color: '#0D211D',
                textDecoration: 'none',
            },
        }
    });

    chart = new Highcharts.chart('chart', {
        chart: {
            type: 'column'
        },
        title: {
            text: '2022년 주택 수'
        },
        xAxis: {
            type: 'category',
            labels: {
                rotation: -45,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: '주택수 '
            }
        },
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: '<b>{point.y:.1f} 호</b>'
        },
        series: [{
            name: 'Population',
            data: chartData,
            dataLabels: {
                enabled: false,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                y: 10, // 10 pixels down from the top
            }
        }],
        credits: {
            enabled: false
        },
    });
})();
