$(function() {
    var province = "";
    var city = "";
    var county = "";
    var village = "";
    var hamlet = "";
    if (location.search.length > 0) {
        province = unescape(location.search.split('?')[1].split('&')[4].split("=")[1]);
        city = unescape(location.search.split('?')[1].split('&')[3].split("=")[1]);
        county = unescape(location.search.split('?')[1].split('&')[2].split("=")[1]);
        village = unescape(location.search.split('?')[1].split('&')[1].split("=")[1]);
        hamlet = unescape(location.search.split('?')[1].split('&')[0].split("=")[1]);
    }

    var senddata = {};
    senddata.province = province;
    senddata.city = city;
    senddata.county = county;
    senddata.village = village;
    senddata.hamlet = hamlet;
    $.ajax({
        url: "/aidog/api/gethamletmap",
        method: "GET",
        data: senddata,
        beforeSend: function (request) {
            request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
        },
        success: function (data) {
            if (data.data != null) {
                data = eval("("+ data.data +")");
                GetHamletEcharts(data);
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

function add0(m){return m<10?'0'+m:m }

function ChangeTimeFormat(logintime) {
    //	20170926084552 ---> 2017.09.26 08:45:52
    if(logintime == "--"){
        return logintime;
    }
    // var year = logintime.substring(0, 4);
    // var month = logintime.substring(4, 6);
    // var day = logintime.substring(6, 8);
    // var hour = logintime.substring(8, 10);
    // var min = logintime.substring(10, 12);
    // var sec = logintime.substring(12);
    // return year + "." + month + "." + day + " " + hour + ":" + min + ":" + sec;

    var time = new Date(logintime.time);
    var y = time.getFullYear();
    var m = time.getMonth()+1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var s = time.getSeconds();
    return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
}

var district, map = null;
function GetHamletEcharts(data) {

    //初始化地图对象，加载地图
    district, map = new AMap.Map("statsChart", {
        resizeEnable: true,
        //center: [116.40, 39.91],//地图中心点
        zoom: 10 //地图显示的缩放级别
    });


    AMapUI.loadUI(['control/BasicControl'], function (BasicControl) {
        var zoomCtrl2 = new BasicControl.Zoom({
            position: 'br',
            showZoomNum: true
        });

        //map.addControl(zoomCtrl1);
        map.addControl(zoomCtrl2);
    });


    var harmletname = data.data4.hamletname;
    $("#h3_logtitle").html(harmletname);
    function addMarker(point, title, content, dogid) {
        marker = new AMap.Marker({
            //icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
            icon: "../../dist/img/necklet_1.png",
            //position: [116.41, 39.91]
            position: point,
            //icon: new AMap.Icon({
            //    size: new AMap.Size(40, 50),  //图标大小
            //    //image: "http://webapi.amap.com/theme/v1.3/images/newpc/way_btn2.png",
            //    image: "../img/dog.png",
            //    imageOffset: new AMap.Pixel(0, -60)
            //})
        });

        marker.content = title + "<br>" + content;
        //marker.on('click', function (e) {

        //    //"<a onclick=\"GetDogPage(" + n["dogid"] + ")\"><b>" + p_titles[i] + "</b></a>"

        //    //window.location.href = "GetDogPage(" + dogid + ")\";

        //    GetDogPage(dogid);

        //});
        //marker.on('mouseover', markerOver);
        marker.on('click', markerOver);
        //marker.on('mouseout', markerOut);
        //marker.emit('click', { target: marker });
        marker.setMap(map);
        return marker;
    }



    function addNeckletMarker(point, title, content, dogid) {
        marker = new AMap.Marker({
            //icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
            icon: "../../dist/img/necklet_1.png",
            //position: [116.41, 39.91]
            position: point,
            //icon: new AMap.Icon({
            //    size: new AMap.Size(40, 50),  //图标大小
            //    //image: "http://webapi.amap.com/theme/v1.3/images/newpc/way_btn2.png",
            //    image: "../img/dog.png",
            //    imageOffset: new AMap.Pixel(0, -60)
            //})
        });

        marker.content = title + "<br>" + content;
        //marker.on('click', function (e) {

        //    //"<a onclick=\"GetDogPage(" + n["dogid"] + ")\"><b>" + p_titles[i] + "</b></a>"

        //    //window.location.href = "GetDogPage(" + dogid + ")\";

        //    GetDogPage(dogid);

        //});
        //marker.on('mouseover', markerOver);
        marker.on('click', markerOver);
        //marker.on('mouseout', markerOut);
        //marker.emit('click', { target: marker });

        marker.setMap(map);

        return marker;
    }

    function addFeederMarker(point, title, content, dogid) {

        marker = new AMap.Marker({
            //icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
            icon: "../../dist/img/feeder_2.ico",
            //position: [116.41, 39.91]
            position: point,
            //icon: new AMap.Icon({
            //    size: new AMap.Size(40, 50),  //图标大小
            //    //image: "http://webapi.amap.com/theme/v1.3/images/newpc/way_btn2.png",
            //    image: "../img/dog.png",
            //    imageOffset: new AMap.Pixel(0, -60)
            //})
        });

        marker.content = title + "<br>" + content;
        //marker.on('click', function (e) {

        //    //"<a onclick=\"GetDogPage(" + n["dogid"] + ")\"><b>" + p_titles[i] + "</b></a>"

        //    //window.location.href = "GetDogPage(" + dogid + ")\";

        //    GetDogPage(dogid);

        //});
        //marker.on('mouseover', markerOver);
        marker.on('click', markerOver);
        //marker.on('mouseout', markerOut);
        //marker.emit('click', { target: marker });

        marker.setMap(map);

        return marker;
    }

    function markerOver(e) {
        this.icon = "../../dist/img/necklet_4_2.png"
        infoWindow.setContent(e.target.content);
        infoWindow.open(map, e.target.getPosition());
    }

    function markerOut(e) {
        //infoWindow.setContent("");
        infoWindow.close();
    }
    //=========================================//

    //==================全局变量========================//

    var infoWindow = new AMap.InfoWindow({ offset: new AMap.Pixel(0, -30) });
    var cluster, markers = [];

    //==========================================//

    var all_necklet_dogs_num = 0;
    var all_feeder_dogs_num = 0;

    var p_necklet_ids = [];
    var p_necklet_Xs = [];
    var p_necklet_Ys = [];
    var p_necklet_titles = [];
    var p_necklet_dognames = [];
    var p_necklet_nextmedtimes = [];
    var p_necklet_lastupdatetime = [];
    var p_necklet_mangers = [];

    var p_feeder_ids = [];
    var p_feeder_Xs = [];
    var p_feeder_Ys = [];
    var p_feeder_titles = [];
    var p_feeder_dognames = [];
    var p_feeder_times = [];
    var p_feeder_nextmedtimes = [];
    var p_feeder_mangers = [];

    $.each(data.data3, function (i, n) {
        //alert("进入data");
        p_necklet_ids[i] = n["neckletid"];

        p_necklet_Xs[i] = n["lng"];
        // p_necklet_Xs[i] = p_necklet_Xs[i] - Math.random()/10000.00;
        // p_necklet_Xs[i] = p_necklet_Xs[i] + Math.random()/10000.00;
        //alert("X=" + p_categories[i]);
        p_necklet_Ys[i] = n["lat"];
        // p_necklet_Ys[i] = p_necklet_Ys[i] - Math.random()/10000.00;
        // p_necklet_Ys[i] = p_necklet_Ys[i] + Math.random()/10000.00;

        p_necklet_titles[i] = "项圈编号：" + n["dogid"];

        p_necklet_dognames[i] = n["dogname"];
        //p_figs[i] = n["fig"];
        p_necklet_mangers[i] = n["manager"];
        p_necklet_nextmedtimes[i] = n["nextmedtime"]==null?"--":n["nextmedtime"];
        p_necklet_lastupdatetime[i] = n["lastupdatetime"]==null?"--":n["lastupdatetime"];
        //var one_title = p_titles[i];

        var one_title = "设备编号：<a onclick=\"GetDogPage(" + n["dogid"] + ")\">" + p_necklet_ids[i] + "</a>"

        var one_content = "<div><table>" +
            "<tr><th>牧犬名字：</th><th>" + p_necklet_dognames[i] + "</th></tr>" +
            "<tr><th>所属村庄：</th><th>" + harmletname + "</th></tr>" +
            "<tr><th>管理员：</th><th>" + p_necklet_mangers[i] + "</th></tr>" +
            "<tr><th>下次投药时间：</th><th>" + ChangeTimeFormat(p_necklet_nextmedtimes[i]) + "</th></tr>" +
            "<tr><th>最近同步时间：</th><th>" + ChangeTimeFormat(p_necklet_lastupdatetime[i]) + "</th></tr>" +
            "</table></div>";

        markers.push(addNeckletMarker([p_necklet_Xs[i], p_necklet_Ys[i]], one_title, one_content, n["dogid"]));

    });

    $.each(data.data6, function (i, n) {
        //alert("进入data");

        p_feeder_ids[i] = n["feederid"];

        p_feeder_Xs[i] = n["lng"];
        //alert("X=" + p_categories[i]);
        p_feeder_Ys[i] = n["lat"];

        p_feeder_titles[i] = "喂饲器编号：" + n["dogid"];

        p_feeder_dognames[i] = n["dogname"];
        //p_figs[i] = n["fig"];
        p_feeder_mangers[i] = n["manager"];
        p_feeder_nextmedtimes[i] = n["nextmedtime"]==null?"--":n["nextmedtime"];


        //var one_title = p_titles[i];

        var one_title = "设备编号：<a onclick=\"GetDogPage(" + n["dogid"] + ")\">" + p_feeder_ids[i] + "</a>"

        var one_content = "<div><table>" +
            "<tr><th>牧犬名字：</th><th>" + p_feeder_dognames[i] + "</th></tr>" +
            "<tr><th>所属村庄：</th><th>" + harmletname + "</th></tr>" +
            "<tr><th>管理员：</th><th>" + p_feeder_mangers[i] + "</th></tr>" +
            // "<tr><th>下次投药时间：</th><th>" + ChangeTimeFormat(p_feeder_nextmedtimes[i]) + "</th></tr>" +
            "</table></div>";

        markers.push(addFeederMarker([p_feeder_Xs[i], p_feeder_Ys[i]], one_title, one_content, n["dogid"]));


    });
    map.setFitView();//地图自适应
}

function GetDogPage(id) {
    $("#dogid").html(id);
    $("#dogInfoDiv").modal({
        remote: 'dogmodal.html'

    });
    $("#dogInfoDiv").modal('show');
    //Bootstrap v3
    $("#dogInfoDiv").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });
}