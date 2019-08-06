$(function () {
    //注册相关
    var datares = {};
    // $.ajax({
    //     url: "/aidog/api/register/4",
    //     async:false,
    //     type: "GET",
    //     success: function (data) {
    //         datares = eval("(" + data + ")");
    //     }
    // });
	setDistrictSelectDisabled(true);
	$.getJSON ("/aidog/adminlte/pages/ui_js/district.json", function (data)
    {
        datares = data;
		setDistrictSelectDisabled(false);
        initSelDistrictCtrl(datares);
    });	

    $("#select_province").on('change', function () {
        var selectvalue = $(this).find('option:selected').val();
        selectvalue = selectvalue.substring(0,2);
        var select_city = document.getElementById("select_city");
        FillCityCmd(datares.data1, select_city, selectvalue);
        var select_county = document.getElementById("select_county");
        FillCountyCmd(datares.data2, select_county);
        var select_village = document.getElementById("select_village");
        FillVillageCmd(datares.data3, select_village);
        var select_hamlet = document.getElementById("select_hamlet");
        FillHamletCmd(datares.data4, select_hamlet);

        // $("#select_city").find("option").remove();
        // var select_city = document.getElementById("select_city");
        // select_city.options.add(new Option("请选择", "-1"));
        // if ($('#modalselect_adminlevel').find('option:selected').text()!="省级") {
        //     for (var i = 0; i < datares.data1.length; i++) {
        //         if (datares.data1[i].districtcode.toString().substring(0, 2) == selectvalue) {
        //             //遍历后台传回的结果，一项项往select中添加option
        //             select_city.options.add(new Option(datares.data1[i].districtname, datares.data1[i].districtcode));
        //         }
        //     }
        // }
        // $("#select_county").find("option").remove();
        // var select_county = document.getElementById("select_county");
        // select_county.options.add(new Option("请选择", "-1"));
        //
        // $("#select_village").find("option").remove();
        // var select_village = document.getElementById("select_village");
        // select_village.options.add(new Option("请选择", "-1"));
        //
        // $("#select_hamlet").find("option").remove();
        // var select_hamlet = document.getElementById("select_hamlet");
        // select_hamlet.options.add(new Option("请选择", "-1"));
    });
    $("#select_city").on('change', function () {
        var selectvalue = $(this).find('option:selected').val();
        selectvalue = selectvalue.substring(0, 4);
        var select_county = document.getElementById("select_county");
        FillCountyCmd(datares.data2, select_county, selectvalue);
        var select_village = document.getElementById("select_village");
        FillVillageCmd(datares.data3, select_village);
        var select_hamlet = document.getElementById("select_hamlet");
        FillHamletCmd(datares.data4, select_hamlet);

        // $("#select_county").find("option").remove();
        // selectvalue = selectvalue.substring(0, 4);
        // var select_county = document.getElementById("select_county");
        // select_county.options.add(new Option("请选择", "-1"));
        // if ($('#modalselect_adminlevel').find('option:selected').text() != "市级") {
        //     for (var i = 0; i < datares.data2.length; i++) {
        //         if (datares.data2[i].districtcode.toString().substring(0, 4) == selectvalue) {
        //             //遍历后台传回的结果，一项项往select中添加option
        //             select_county.options.add(new Option(datares.data2[i].districtname, datares.data2[i].districtcode));
        //         }
        //     }
        // }
        // $("#select_village").find("option").remove();
        // var select_village = document.getElementById("select_village");
        // select_village.options.add(new Option("请选择", "-1"));
        //
        // $("#select_hamlet").find("option").remove();
        // var select_hamlet = document.getElementById("select_hamlet");
        // select_hamlet.options.add(new Option("请选择", "-1"));
    });
    $("#select_county").on('change', function () {
        var selectvalue = $(this).find('option:selected').val();
        selectvalue = selectvalue.substring(0, 6);
        var select_village = document.getElementById("select_village");
        FillVillageCmd(datares.data3, select_village, selectvalue);
        var select_hamlet = document.getElementById("select_hamlet");
        FillHamletCmd(datares.data4, select_hamlet);

        // $("#select_village").find("option").remove();
        // selectvalue = selectvalue.substring(0, 6);
        // var select_village = document.getElementById("select_village");
        // select_village.options.add(new Option("请选择", "-1"));
        // if ($('#modalselect_adminlevel').find('option:selected').text() != "县级") {
        //     for (var i = 0; i < datares.data3.length; i++) {
        //         if (datares.data3[i].districtcode.toString().substring(0, 6) == selectvalue) {
        //             //遍历后台传回的结果，一项项往select中添加option
        //             select_village.options.add(new Option(datares.data3[i].districtname, datares.data3[i].districtcode));
        //         }
        //     }
        // }
        // $("#select_hamlet").find("option").remove();
        // var select_hamlet = document.getElementById("select_hamlet");
        // select_hamlet.options.add(new Option("请选择", "-1"));
    });
    $("#select_village").on('change', function () {
        var selectvalue = $(this).find('option:selected').val();
        selectvalue = selectvalue.substring(0, 9);
        var select_hamlet = document.getElementById("select_hamlet");
        FillHamletCmd(datares.data4, select_hamlet, selectvalue);

        // $("#select_hamlet").find("option").remove();
        // selectvalue = selectvalue.substring(0, 9);
        // var select_hamlet = document.getElementById("select_hamlet");
        // select_hamlet.options.add(new Option("请选择", "-1"));
        // if ($('#modalselect_adminlevel').find('option:selected').text() != "乡级") {
        //     for (var i = 0; i < datares.data4.length; i++) {
        //         if (datares.data4[i].districtcode.toString().substring(0, 9) == selectvalue) {
        //             //遍历后台传回的结果，一项项往select中添加option
        //             select_hamlet.options.add(new Option(datares.data4[i].districtname, datares.data4[i].districtcode));
        //         }
        //     }
        // }
    });

    var hamletcode = "";
    $("#select_hamlet").on('change', function () {
        hamletcode = $(this).find('option:selected').val();
        var selectvalue = $(this).find('option:selected').text();
        $("#select_ownerhamlet").val(selectvalue);
        var managerdata = {};
        managerdata.hamletcode = hamletcode;
        $.ajax({
            url:  "/aidog/api/gethamletmanagerlist",
            type: "POST",
            data:  managerdata,
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                var modalselect_dogmanagername = document.getElementById("select_managername");
                data.data = objToArray(data.data);
                for (var i = 0; i < data.data.length; i++) {
                    //遍历后台传回的结果，一项项往select中添加option
                    modalselect_dogmanagername.options.add(new Option(data.data[i].managername, data.data[i].managerusername));
                }
            }
        })
    });

    $("#a_checkowner").click(function () {
        if(hamletcode == ""){
            alert("请先选定行政村！");
            return;
        }
        var clicktype = "ownercheck";
        var ownername = $("#input_ownername").val()==null?"":$("#input_ownername").val();
        var owneridentity = $("#input_owneridentity").val()==null?"":$("#input_owneridentity").val();
        var telphone = $("#input_telphone").val()==null?"":$("#input_telphone").val();
        var checkdata = {};
        checkdata.clicktype = clicktype;
        checkdata.ownername = ownername;
        checkdata.owneridentity = owneridentity;
        checkdata.ownerhamletcode = hamletcode;
        checkdata.telphone = telphone;
        $.ajax({
            url: "/aidog/api/operateapi",
            type: "POST",
            data: JSON.stringify(checkdata),
            contentType: "application/json",
            // dataType: "text",    // 控制回来的数据类型
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                alert(data.msg);
                if(data.success == true){
                    $("#input_ownerid").val(data.data.dogowner.ownerId);
                    $("#input_ownername").val(data.data.dogowner.ownerName);
                    document.getElementById("input_ownername").readOnly = true;
                    $("#input_owneridentity").val(data.data.dogowner.ownerIdentity);
                    document.getElementById("input_owneridentity").readOnly = true;
                    $("#select_ownersex").find("option[value='"+data.data.dogowner.ownerSex+"']").prop("selected",true);
                    $("#select_ownersex").attr("disabled","disabled");
                    $("#input_ownerage").val(data.data.dogowner.ownerAge);
                    document.getElementById("input_ownerage").readOnly = true;
                    $("#input_ownerjob").val(data.data.dogowner.ownerJob);
                    document.getElementById("input_ownerjob").readOnly = true;
                    $("#input_homeaddress").val(data.data.dogowner.ownerAddr);
                    document.getElementById("input_homeaddress").readOnly = true;
                    $("#input_telphone").val(data.data.dogowner.ownerTel);
                    document.getElementById("input_telphone").readOnly = true;
                    var select_dogname = document.getElementById("select_dogname");
                    data.data = objToArray(data.data.doglist);
                    for (var i = 0; i < data.data.length; i++) {
                        //遍历后台传回的结果，一项项往select中添加option
                        select_dogname.options.add(new Option(data.data[i].dogName, data.data[i].dogId));
                    }
                }else{
                    return;
                }
            }
        })
    });

    $("#a_reset").click(function () {
        $("#input_ownerid").val("");
        $("#input_ownername").val("");
        document.getElementById("input_ownername").readOnly = false;
        $("#input_owneridentity").val("");
        document.getElementById("input_owneridentity").readOnly = false;
        $("#select_ownersex").find("option[value='男']").prop("selected",true);
        $("#select_ownersex").removeAttr("disabled")
        $("#input_ownerage").val("");
        document.getElementById("input_ownerage").readOnly = false;
        $("#input_ownerjob").val("");
        document.getElementById("input_ownerjob").readOnly = false;
        $("#input_homeaddress").val("");
        document.getElementById("input_homeaddress").readOnly = false;
        $("#input_telphone").val("");
        document.getElementById("input_telphone").readOnly = false;
        // var select_dogname = document.getElementById("select_dogname");
        // select_dogname.options.length = 0;
        $("#select_dogname").empty();

    });

    $("#a_addowner").click(function () {
        var clicktype = "owneradd";
        var ownername = $("#input_ownername").val()==null?"":$("#input_ownername").val();
        var owneridentity = $("#input_owneridentity").val();
        var ownersex = $("#select_ownersex").find("option:selected").text();
        if(hamletcode == ""){
            alert("请先选择主人所属行政村！");
            return;
        }
        var ownerhamlet = $("#select_ownerhamlet").val();
        var ownerage = $("#input_ownerage").val();
        var ownerjob = $("#input_ownerjob").val();
        var homeaddress = $("#input_homeaddress").val();
        var telphone = $("#input_telphone").val();
        var senddata = {};
        senddata.clicktype = clicktype;
        senddata.ownername = ownername;
        senddata.owneridentity = owneridentity;
        senddata.ownersex = ownersex;
        senddata.ownerhamlet = ownerhamlet;
        senddata.ownerhamletcode = hamletcode;
        senddata.ownerage = ownerage;
        senddata.ownerjob = ownerjob;
        senddata.homeaddress = homeaddress;
        senddata.telphone = telphone;
        $.ajax({
            url: "/aidog/api/operateapi",
            type: "POST",
            data: JSON.stringify(senddata),
            contentType: "application/json",
            // dataType: "text",    // 控制回来的数据类型
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                alert(data.msg);
                if(data.success == true){
                    $("#input_ownerid").val(data.data.ownerId);
                    $("#input_ownername").val(data.data.ownerName);
                    document.getElementById("input_ownername").readOnly = true;
                    $("#input_owneridentity").val(data.data.ownerIdentity);
                    document.getElementById("input_owneridentity").readOnly = true;
                    $("#select_ownersex").find("option[value='"+data.data.ownerSex+"']").prop("selected",true);
                    $("#select_ownersex").attr("disabled","disabled");
                    $("#input_ownerage").val(data.data.ownerAge);
                    document.getElementById("input_ownerage").readOnly = true;
                    $("#input_ownerjob").val(data.data.ownerJob);
                    document.getElementById("input_ownerjob").readOnly = true;
                    $("#input_homeaddress").val(data.data.ownerAddr);
                    document.getElementById("input_homeaddress").readOnly = true;
                    $("#input_telphone").val(data.data.ownerTel);
                    document.getElementById("input_telphone").readOnly = true;
                }else{
                    return;
                }
            }
        })
    });

    //添加牧犬
    $("#a_adddog").click(function () {
        var clicktype = "dogadd";
        if($("#input_ownerid").val()==""){
            alert("请先选定左侧主人信息！");
            return;
        }
        var dogname = $("#input_dogname").val();
        var dogsex = $("#select_dogsex").find("option:selected").text();
        if(hamletcode == ""){
            alert("请先选择主人所属行政村！");
            return;
        }
        var dogbelonghamlet = $("#select_ownerhamlet").val();
        var govcode = $("#input_doggovcode").val();
        var dogownerid = $("#input_ownerid").val();
        var username = $("#select_managername").val();
        var dogweight = $("#input_dogweight").val();
        var dogcolor = $("#input_dogcolor").val();
        var dogage = $("#input_dogage").val();
        var senddata = {};
        senddata.clicktype = clicktype;
        senddata.username = username;
        senddata.dogname = dogname;
        senddata.dogsex = dogsex;
        senddata.dogbelonghamlet = dogbelonghamlet;
        senddata.ownerhamletcode = hamletcode;
        senddata.dogownerid = dogownerid;
        senddata.dogweight = dogweight;
        senddata.dogcolor = dogcolor;
        senddata.dogage = dogage;
        senddata.govcode = govcode;
        $.ajax({
            url: "/aidog/api/operateapi",
            type: "POST",
            data:  JSON.stringify(senddata),
            contentType: "application/json",
            // dataType: "text",    // 控制回来的数据类型
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                alert(data.msg);
                if(data.success==true){
                    $("#input_dogname").val("");
                    $("#input_doggovcode").val("");
                    $("#input_dogweight").val("");
                    $("#input_dogcolor").val("");
                    $("#input_dogage").val("");
                    var select_dogname = document.getElementById("select_dogname");
                    select_dogname.options.add(new Option(data.data.dogName, data.data.dogId));
                }else{
                    return;
                }
            }
        })
    });

})

function objToArray(array) {
    var arr = []
    for (var i in array) {
        arr.push(array[i]);
    }
    return arr;
}