$(function () {
    $.ajax({
        url: "/aidog/api/getindexmap",
        method: "GET",
        beforeSend: function(request) {
            request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
        },
        success: function (data) {
            if (data.data != null) {
                if (data.data.data1.privilegelevel == 1) {
                    //下面的表格
                    $("#proviceepidemictotal").text(data.data.data2.provinceepidemictotal);
                    $("#cityepidemictotal").text("73");
                    $("#countyepidemictotal").text("368");
                    $("#villageepidemictotal").text(data.data.data2.villageepidemictotal);
                    $("#hamletepidemictotal").text(data.data.data2.hamletepidemictotal);

                    $("#countryadmintotal").text(data.data.data2.countryadmintotal);
                    $("#proviceadmintotal").text(data.data.data2.provinceadmintotal);
                    $("#cityadmintotal").text(data.data.data2.cityadmintotal);
                    $("#countyadmintotal").text(data.data.data2.countyadmintotal);
                    $("#villageadmintotal").text(data.data.data2.villageadmintotal);
                    $("#hamletadmintotal").text(data.data.data2.hamletadmintotal);
                    $("#countrydognumtotal").text("5");
                    $("#countryalldognumtotal").text("3472856");
                    $("#countrywsqdognumtotal").text("0");
                    $("#countryratedognumtotal").text(((data.data.data2.countrydognumtotal + data.data.data2.feedernumtotal) * 100 / data.data.data2.alldognumtotal).toFixed(6));
                    $("#countrymednumtotal").text(data.data.data2.countrymednumtotal);
                }
                GetCountryEcharts(data.data);
            }
        }
    })
})

function objToArray(array) {
    var arr = []
    for (var i in array) {
        arr.push(array[i]);
    }
    return arr;
}


function GetCountryEcharts(data) {
    var p_names = new Array();
    var p_city_values = new Array();
    var p_dog_values = new Array();
    var p_manager_values = new Array();
    var p_necklet_values = new Array();
    var p_med_values = new Array();
    var p_percents = new Array();
    var p_feeders = new Array();

    var necklet_max = 100;
    var cur = 1;
    data.data3 = objToArray(data.data3);
    for (var t = 0; t < data.data3.length; t++) {
        p_names.push(data.data3[t].provincename);
        p_city_values.push({ "name": data.data3[t].provincename, "value_1": data.data3[t].citynum });
        p_dog_values.push({ "name": data.data3[t].provincename, "value_1": data.data3[t].dognum });
        p_manager_values.push({ "name": data.data3[t].provincename, "value_1": data.data3[t].managernum });
        p_necklet_values.push({ "name": data.data3[t].provincename, "value_1": data.data3[t].neckletnum });
        p_med_values.push({ "name": data.data3[t].provincename, "value_1": data.data3[t].mednum });
        p_feeders.push({ "name": data.data3[t].provincename, "value_1": 0 });

        percent = (data.data3[t].neckletnum / data.data3[t].dognum).toFixed(3);
        if (isNaN(percent)) {
            percent = 0.0;
        }
        p_percents.push({ "name": data.data3[t].provincename, "value": percent, "value_1": percent });
        cur = data.data3[t].neckletnum;
        cur > necklet_max ? necklet_max = cur : null;
    }

    // 路径配置
    require.config({
        paths: {
            echarts: '../ui_js'
        }
    });

    // 使用
    require(
        [
            'echarts',
            'echarts/chart/map' // 使用地图就加载map模块，按需加载
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('statsChart'));
            var valueAxis = [
                {
                    type: 'value',
                    boundaryGap: [0, 0.01]
                }
            ];

            var option = {
                title: {
                    text: '',
                    x: 'center',
                    textStyle: {
                        fontSize: 28,
                    }

                },
                tooltip: {
                    trigger: 'item',
                    formatter: function (params) {
                        var res = params.name + '<br />';
                        var myseries = option.series;
                        for (var i = 0; i < myseries.length; i++) {
                            for (var k = 0; k < myseries[i].data.length; k++) {
                                if (myseries[i].data[k].name == params.name) {
                                    res += myseries[i].name + ":" + myseries[i].data[k].value_1 + '<br />';
                                }
                            }
                            if (myseries[i].markPoint) {
                                for (var k = 0; k < myseries[i].markPoint.data.length; k++) {
                                    if (myseries[i].markPoint.data[k].name == params.name) {
                                        res += myseries[i].name + ":" + myseries[i].markPoint.data[k].value_1 + '<br />';
                                    }
                                }
                            }
                        }
                        return res;
                    },
                },
                dataRange: {
                    min: 0,
                    max: 1,
                    orient: 'horizontal',
                    x: 'left',
                    y: 'bottom',
                    text: ['高', '低'],           // 文本，默认为数值文本
                    color: ['#008000', '#FFFF00', '#FF0000', '#D6A4A4'],//, '#FF0000'
                    calculable: true
                },
                series: [
                    {
                        name: '流行城市数量',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        itemStyle: {
                            normal: { label: { show: true } },
                            emphasis: { label: { show: true } }
                        },
                        selectedMode: 'single',
                        data: p_city_values
                    },
                    {
                        name: '管理员总数量',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        itemStyle: {
                            normal: { label: { show: true } },
                            emphasis: { label: { show: true } }
                        },
                        selectedMode: 'single',
                        data: p_manager_values
                    },
                    {
                        name: '牧犬总数量',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        itemStyle: {
                            normal: { label: { show: true } },
                            emphasis: { label: { show: true } }
                        },
                        selectedMode: 'single',
                        data: p_dog_values
                    },
                    {
                        name: '项圈总数量',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        itemStyle: {
                            normal: { label: { show: true } },
                            emphasis: { label: { show: true } }
                        },
                        selectedMode: 'single',
                        data: p_necklet_values
                    },
                    {
                        name: '喂饲器数量',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        itemStyle: {
                            normal: { label: { show: true } },
                            emphasis: { label: { show: true } }
                        },
                        selectedMode: 'single',
                        data: p_feeders
                    },
                    {
                        name: '投药总次数',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        itemStyle: {
                            normal: { label: { show: true } },
                            emphasis: { label: { show: true } }
                        },
                        selectedMode: 'single',
                        data: p_med_values
                    },
                    {
                        name: '项圈犬占比',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        itemStyle: {
                            normal: { label: { show: true } },
                            emphasis: { label: { show: true } }
                        },
                        selectedMode: 'single',
                        data: p_percents
                    },
                ]
            };

            //responsive
            if (screen.width < 768) {
                option.series[0].itemStyle.normal.label.textStyle = { fontSize: 8 };
            }
            var name_selected = '';
            myChart.on("click", function (param) {
                if (param.seriesName != '' && param.name == name_selected) {
                    // window.location.href = encodeURI(encodeURI("../UI/provincemap.html?province=" + param.name));
                    window.location.href = "../UI/provincemap.html?province=" + escape(param.name);
                } else {
                    name_selected = param.name;
                }
            });
            myChart.setOption(option);
        }
    );
}