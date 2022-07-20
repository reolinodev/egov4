import {getSeoulMapData, setDataClassMap} from "../module/map";
import {setBasicColumnChart} from "../module/chart";
// let chart;
// let allChartData;
// let chartData = [];
//
// (async () => {
//
//     //서울시 각 구의 폴리곤 데이터
//     const mapData = await getSeoulMapData();
//
//     //각 구의 인구데이터
//     const popData = await fetch('/api/admin/pilot/json/poulation').then(response => response.json());
//
//     //데이터 변환 작업
//     mapData.forEach((d, i) => {
//         d.drilldown = d.properties['adm_cd']; //드릴 다운 기능을 할 경우 지역코드 값을 키로 설정
//         d.value =  _.filter(popData.result, {adm_cd: d.properties['adm_cd']})[0].population_cnt; //인구데이터 중 지역코드가 일치한 데이터를 필터해서 인구 수를 value에 넣음
//         chartData.push([d.name, d.value]); //차트의 값을 생성
//     });
//
//     //하이차트의 옵션
//     const highOption = {
//         lang: {
//             thousandsSep: ','//천단위 콤마 적용
//         }
//     }
//
//     const mapOption = {
//         title : '서울시 인구 통계',
//         minColor: '#FFFDE4',
//         maxColor: '#005AA7'
//     }
//
//     const chartOption = {
//         title : '2022년 5월 인구',
//         unit : '명',
//     }
//
//     setDataClassMap('map', mapData, mapOption, highOption);
//
//     setBasicColumnChart('chart', chartData, chartOption, highOption);
//
// })();
//
let chart;
let allChartData;
let chartData = [];

const drilldown = async function (e) {
    chartData = [];
    if (!e.seriesOptions) {
        const mapChart = this, mapKey = `${e.point.drilldown}`;

        mapChart.showLoading('<i class="icon-spinner icon-spin icon-3x"></i>');

        const mapData = await fetch(`/api/admin/pilot/json/seoul/${mapKey}`).then(response => response.json());
        const popData = await fetch(`/api/admin/pilot/json/poulation/${mapKey}`).then(response => response.json());
        const data = Highcharts.geojson(mapData);
        let total = 0, adm_cd, arr, obj;
        data.forEach((d, i) => {
            adm_cd = d.properties['adm_cd'];
            arr = _.filter(popData.result, { adm_cd: adm_cd});
            obj = arr[0];

            d.name = d.properties.adm_nm.split(" ")[2];
            d.value = obj.population_cnt;
            total += d.value;
        });

        data.forEach((d, i) => {
            d.percentage = (d.value / total) * 100;
            const chartArr = [d.name, d.value, d.percentage];
            chartData.push(chartArr);
        });

        // Hide loading and add series
        mapChart.hideLoading();
        mapChart.addSeriesAsDrilldown(e.point, {
            name: e.point.name,
            data,
            dataLabels: {
                enabled: true,
                format: '{point.name}<br>' + '{point.percentage: .2f}%',
                backgroundColor: 'rgba(255,255,255,0.7)',
                borderRadius: 5,
                padding: 3,
                color: 'black',
                style: {
                    textOutline: 'none',
                    fontSize: '1em'
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
    const popData = await fetch('/api/admin/pilot/json/poulation').then(response => response.json());
    const data = Highcharts.geojson(mapData);
    chartData = [];
    let total = 0, adm_cd, arr, obj;

    data.forEach((d, i) => {
        adm_cd = d.properties['adm_cd'];
        arr = _.filter(popData.result, {adm_cd: adm_cd});
        obj = arr[0];

        d.drilldown = adm_cd;
        d.value = obj.population_cnt;
        total += d.value;
    });

    data.forEach((d, i) => {
        d.percentage = (d.value / total) * 100;
        const chartArr = [d.name, d.value, d.percentage];
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
            text: '서울시 인구 통계',
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
                format: '{point.properties.name}<br>' + '{point.percentage: .2f}%',
                backgroundColor: 'rgba(255,255,255,0.7)',
                borderRadius: 5,
                padding: 3,
                align: 'right',
                style: {
                    textOutline: 'none',
                    fontSize: '1em',
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
            text: '2022년 5월 인구수'
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
                text: '인구수'
            }
        },
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: '<b>{point.y} 명</b>'
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