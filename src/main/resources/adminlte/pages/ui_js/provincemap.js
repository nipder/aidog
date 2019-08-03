$(function () {
    var province = "";
    if (location.search.length > 0) {
        province = unescape(location.search.split('?')[1].split('=')[1]);
    }
    var senddata = {};
    senddata.province = province;
    $.ajax({
        url: "/aidog/api/getprovincemap",
        method: "GET",
        data: senddata,
        beforeSend: function(request) {
            request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
        },
        success: function (data) {
            if (data.data != null) {
                data = data.data;
                $("#cityepidemictotal").text(data.data2.cityepidemictotal);
                $("#countyepidemictotal").text(data.data2.countyepidemictotal);
                $("#villageepidemictotal").text(data.data2.villageepidemictotal);
                $("#hamletepidemictotal").text(data.data2.hamletepidemictotal);

                //$("#tr_admincountry").css("display", "none");
                $("#provinceadmintotal").text(data.data2.provinceadmintotal);
                $("#cityadmintotal").text(data.data2.cityadmintotal);
                $("#countyadmintotal").text(data.data2.countyadmintotal);
                $("#villageadmintotal").text(data.data2.villageadmintotal);
                $("#hamletadmintotal").text(data.data2.hamletadmintotal);

                $("#neckdognumtotal").text(data.data2.neckdognumtotal);
                $("#countryalldognumtotal").text(data.data2.alldognumtotal);
                $("#countrywsqdognumtotal").text(data.data2.feedernumtotal);
                if(data.data2.alldognumtotal == 0){
                    $("#countryratedognumtotal").text(0);
                }else{
                    $("#countryratedognumtotal").text(((data.data2.neckdognumtotal + data.data2.feedernumtotal) * 100 / data.data2.alldognumtotal).toFixed(6));
                }
                $("#countrymednumtotal").text(data.data2.countrymednumtotal);

                GetProvinceEcharts(data);
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


function GetProvinceEcharts(data) {

    var p_names = new Array();
    var p_county_values = new Array();
    var p_dog_values = new Array();
    var p_manager_values = new Array();
    var p_necklet_values = new Array();
    var p_med_values = new Array();
    var p_percents = new Array();
    var p_feeders = new Array();

    var provinceGov = "" + data.data4.provinceGov;
    var provinceEchartsAreaName="" + data.data4.provinceEchartsAreaName;
    $("#h3_logtitle").html(provinceGov);
    var map_ctrl = {};
    map_ctrl[provinceEchartsAreaName] = true;

    var necklet_max = 100;
    var cur = 1;
    data.data3 = objToArray(data.data3);
    for (var t = 0; t < data.data3.length; t++) {

        p_names.push(data.data3[t].cityname);
        p_county_values.push({ "name": data.data3[t].cityname, "value_1": data.data3[t].countynum });
        p_dog_values.push({ "name": data.data3[t].cityname, "value_1": data.data3[t].dognum });
        p_manager_values.push({ "name": data.data3[t].cityname, "value_1": data.data3[t].managernum });
        p_necklet_values.push({ "name": data.data3[t].cityname, "value_1": data.data3[t].neckletnum});
        p_med_values.push({ "name": data.data3[t].cityname, "value_1": data.data3[t].mednum });
        cur = data.data3[t].neckletnum;
        cur > necklet_max ? necklet_max = cur : null;

        p_feeders.push({ "name": data.data3[t].cityname, "value_1": 0 });
        percent = (data.data3[t].neckletnum / data.data3[t].dognum).toFixed(3);
        if (isNaN(percent)) {
            percent = 0.0;
        }
        p_percents.push({ "name": data.data3[t].cityname, "value": percent, "value_1": percent });

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
            option = {
                title: {
                    text: "",
                    x: 'center',
                    textStyle: {
                        fontSize: 18,
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
                        name: '流行县数量',
                        type: 'map',
                        mapType: provinceEchartsAreaName,
                        roam: false,
                        itemStyle: {
                            normal: { label: { show: true } },
                            emphasis: { label: { show: true } }
                        },
                        selectedMode: 'single',
                        data: p_county_values
                    },
                    {
                        name: '管理员总数量',
                        type: 'map',
                        mapType: provinceEchartsAreaName,
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
                        mapType: provinceEchartsAreaName,
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
                        mapType: provinceEchartsAreaName,
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
                        mapType: provinceEchartsAreaName,
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
                        mapType: provinceEchartsAreaName,
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
                        mapType: provinceEchartsAreaName,
                        roam: false,
                        itemStyle: {
                            normal: { label: { show: true } },
                            emphasis: { label: { show: true } }
                        },
                        selectedMode: 'single',
                        data: p_percents
                    }
                ]
            };
            //responsive
            if (screen.width < 768) {
                option.series[0].itemStyle.normal.label.textStyle = { fontSize: 8 };
            }

            var name_selected = '';
            myChart.on("click", function (param) {
                // alert(param.seriesName + 'S'+ (param.name == name_selected));
                if (param.seriesName != '' && param.name == name_selected) {
                    window.location.href = "../UI/citymap.html?province=" + escape(provinceGov) + "&city=" + escape(param.name);
                    // window.location.href = encodeURI(encodeURI("../city/city.do?city=" + param.name + "&province=" + provinceGov));
                } else {
                    name_selected = param.name;
                }
            });
            // 为echarts对象加载数据
            myChart.setOption(option);
        }
    );
}