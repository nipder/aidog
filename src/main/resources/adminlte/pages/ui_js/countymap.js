$(function() {
    var province = "";
    var city = "";
    var county = "";
    if (location.search.length > 0) {
        province = unescape(location.search.split('?')[1].split('&')[0].split("=")[1]);
        city = unescape(location.search.split('?')[1].split('&')[1].split("=")[1]);
        county = unescape(location.search.split('?')[1].split('&')[2].split("=")[1]);
    }

    var senddata = {};
    senddata.province = province;
    senddata.city = city;
    senddata.county = county;
    $.ajax({
        url: "/aidog/api/getcountymap",
        method: "GET",
        data: senddata,
        beforeSend: function (request) {
            request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
        },
        success: function (data) {
            if (data.data != null) {
                data = data.data;
                $("#td_areadognumtotal").html("全县总数");
                $("#td_areaalldognumtotal").html("全县总数");
                $("#td_areamednumtotal").html("全县总数");

                $("#villageepidemictotal").text(data.data2.villageepidemictotal);
                $("#hamletepidemictotal").text(data.data2.hamletepidemictotal);

                $("#countyadmintotal").text(data.data2.countyadmintotal);
                $("#villageadmintotal").text(data.data2.villageadmintotal);
                $("#hamletadmintotal").text(data.data2.hamletadmintotal);

                $("#neckdognumtotal").text(data.data2.neckdognumtotal);
                $("#countryalldognumtotal").text(data.data2.alldognumtotal);
                $("#countywsqdognumtotal").text(data.data2.feedernumtotal);
                if(data.data2.alldognumtotal == 0){
                    $("#countryratedognumtotal").text(0);
                }else{
                    $("#countryratedognumtotal").text(((data.data2.neckdognumtotal + data.data2.feedernumtotal) * 100 / data.data2.alldognumtotal).toFixed(6));
                }
                $("#countrymednumtotal").text(data.data2.countrymednumtotal);
                GetCountyEcharts(data);
            }
        }
    })
})



function objToArray(array) {
    var arr = []
    for (var i in array) {
        arr.push(array[i]);
    }
    console.log(arr);
    return arr;
}

var district, map = null;
function GetCountyEcharts(data) {

    var countyGov = "" + data.data4.countyGov;
    var countyEchartsAreaName="" + data.data4.countyEchartsAreaName;
    var cityGov = "" + data.data4.cityGov;
    var cityEchartsAreaName="" + data.data4.cityEchartsAreaName;
    var provinceGov = "" + data.data4.provinceGov;
    var provinceEchartsAreaName="" + data.data4.provinceEchartsAreaName;


    var centerx = data.data3[0].lng;
    var centery = data.data3[0].lat;

    district, map = new AMap.Map("statsChart", {
        resizeEnable: true,
        center: [centerx, centery],//地图中心点
        //zoom: 10 //地图显示的缩放级别
    });
    map.setFitView();

    AMapUI.loadUI(['control/BasicControl'], function (BasicControl) {


        var zoomCtrl2 = new BasicControl.Zoom({
            position: 'br',
            showZoomNum: true
        });

        //map.addControl(zoomCtrl1);

        map.addControl(zoomCtrl2);
    });

    $("#h3_logtitle").html(countyGov);

    //===============查找行政区划函数==========================//

    function lookforCounty(countyEchartsAreaName) {
        //加载行政区划插件
        AMap.service('AMap.DistrictSearch', function () {
            var opts = {
                subdistrict: 1,   //返回下一级行政区
                extensions: 'all',  //返回行政区边界坐标组等具体信息
                level: 'city'  //查询行政级别为 市
            };
            //实例化DistrictSearch
            district = new AMap.DistrictSearch(opts);
            district.setLevel('district');
            //行政区查询
            district.search(countyEchartsAreaName, function (status, result) {
                var bounds = result.districtList[0].boundaries;
                var polygons = [];
                if (bounds) {
                    for (var i = 0, l = bounds.length; i < l; i++) {
                        //生成行政区划polygon
                        var polygon = new AMap.Polygon({
                            map: map,
                            strokeWeight: 1,
                            path: bounds[i],
                            fillOpacity: 0.7,
                            fillColor: '#CCF3FF',
                            strokeColor: '#CC66CC'
                        });
                        polygons.push(polygon);
                    }
                    map.setFitView();//地图自适应
                }
            });
        });
    }


    //=========================================//

    //============添加点标记=============================//

    // 实例化点标记
    function addMarker(point, title, content, icondir) {
        marker = new AMap.Marker({
            //icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
            //icon: "img/town.ico",
            icon: icondir,
            //position: [116.41, 39.91]
            position: point,
            //icon: new AMap.Icon({
            //    size: new AMap.Size(40, 50),  //图标大小
            //    image: "http://webapi.amap.com/theme/v1.3/images/newpc/way_btn2.png",
            //    image: "img/village.ico",
            //    imageOffset: new AMap.Pixel(0, -60)
            //})
        });

        marker.content = title + "<br>" + content;

        marker.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
            offset: new AMap.Pixel(0, 27),//修改label相对于maker的位置
            content: title
        });


        //marker.on('mouseover', markerOver);

        marker.on('click', markerOver);
        //marker.on('mouseout', markerOut);

        //marker.on('dbclick', function () {
        //    alert("dbclick");
        //});

        //marker.on('click',markerClick);
        //marker.emit('click', { target: marker });

        marker.setMap(map);

        return marker;
    }

    function markerOver(e) {
        infoWindow.setContent(e.target.content);
        infoWindow.open(map, e.target.getPosition());
    }


    function markerOut(e) {
        infoWindow.close();
    }

    //=========================================//


    //=============点聚合=============================//

    function addCluster(tag) {
        if (cluster) {
            cluster.setMap(null);
        }
        if (tag == 2) {//完全自定义
            cluster = new AMap.MarkerClusterer(map, markers, {
                gridSize: 80,
                renderCluserMarker: _renderCluserMarker
            });
        } else if (tag == 1) {//自定义图标
            var sts = [{
                url: "http://a.amap.com/jsapi_demos/static/images/blue.png",
                size: new AMap.Size(32, 32),
                offset: new AMap.Pixel(-16, -16)
            }, {
                url: "http://a.amap.com/jsapi_demos/static/images/green.png",
                size: new AMap.Size(32, 32),
                offset: new AMap.Pixel(-16, -16)
            }, {
                url: "http://a.amap.com/jsapi_demos/static/images/orange.png",
                size: new AMap.Size(36, 36),
                offset: new AMap.Pixel(-18, -18)
            }, {
                url: "http://a.amap.com/jsapi_demos/static/images/red.png",
                size: new AMap.Size(48, 48),
                offset: new AMap.Pixel(-24, -24)
            }, {
                url: "http://a.amap.com/jsapi_demos/static/images/darkRed.png",
                size: new AMap.Size(48, 48),
                offset: new AMap.Pixel(-24, -24)
            }];
            cluster = new AMap.MarkerClusterer(map, markers, {
                styles: sts,
                gridSize: 80
            });
        } else {//默认样式
            cluster = new AMap.MarkerClusterer(map, markers, { gridSize: 80 });
        }
    }

    //==========================================//


    //==================全局变量========================//

    var infoWindow = new AMap.InfoWindow({ offset: new AMap.Pixel(0, -30) });
    var cluster, markers = [];

    //==========================================//


    lookforCounty(countyEchartsAreaName);

    var p_Xs = [];
    var p_Ys = [];
    var p_titles = [];
    var p_hamlets = [];
    var p_managernums = [];
    var p_dognums = [];
    var p_neckletnums = [];
    var p_mednums = [];
    $.each(data.data3, function (i, n) {
        //alert("进入data");
        //alert(n["lng"]);
        p_Xs[i] = n["lng"];
        //p_Xs[i] = data.data3[n].Lng;
        //alert("X=" + p_Xs[i]);
        p_Ys[i] = n["lat"];
        //p_Ys[i] = data.data3[n].Lat;


        p_titles[i] = n["townname"];
        p_hamlets[i] = n["hamletnum"];
        p_managernums[i] = n["managernum"];
        //p_figs[i] = n["fig"];
        p_dognums[i] = n["dognum"];
        p_neckletnums[i] = n["neckletnum"];
        p_mednums[i] = n["mednum"];
        //p_admins[i] = n["admin"];


        var one_title = null;
        var one_icondir = null;
        if (p_neckletnums[i] > 0) {
            one_title = "<a href=\"../UI/villagemap.html?village=" + escape(p_titles[i]) + "&county=" + escape(countyGov) + "&city=" + escape(cityGov) + "&province=" + escape(provinceGov) + "\"><font color='red'>" + p_titles[i] + "</font></a>";
            one_icondir = "../../dist/img/town.png";
            p_titles[i] = one_title;
        } else {
            one_title = "<font color='#C0C0C0'>" + p_titles[i] + "</font>";
            // one_title = "<a href=\"../UI/villagemap.html?village=" + escape(p_titles[i]) + "&county=" + escape(countyGov) + "&city=" + escape(cityGov) + "&province=" + escape(provinceGov) + "\"><font color='red'>" + p_titles[i] + "</font></a>";
            one_icondir = "../../dist/img/no.png";
            p_titles[i] = one_title;
        }

        var percentage = (p_neckletnums[i] / p_dognums[i]).toFixed(2);
        if (isNaN(percentage)) {
            percentage = 0.0;
        }

        var one_content = "<div>" +
            "<table><tr><th>流行村数量：</th><th>" + p_hamlets[i] + "</th></tr>" +
            "<table><tr><th>管理员人数：</th><th>" + p_managernums[i] + "</th></tr>" +
            "<tr><th>牧犬数量：</th><th>" + p_dognums[i] + "</th></tr>" +
            "<tr><th>项圈数量：</th><th>" + p_neckletnums[i] + "</th></tr>" +
            "<tr><th>喂饲器数量：</th><th>" + 0 + "</th></tr>" +
            "<tr><th>总投药次数：</th><th>" + p_mednums[i] + "</th></tr>" +
            "<tr><th>项圈犬占比：</th><th>" + percentage  + "</th></tr>" +
            //"<tr><th>管理员：</th><th>" + p_admins[i] + "</th></tr>" +
            "</table>" +
            "</div>";

        markers.push(addMarker([p_Xs[i], p_Ys[i]], one_title, one_content, one_icondir));
    });
    map.setFitView();//地图自适应
}