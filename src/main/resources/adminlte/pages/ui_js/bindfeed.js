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
    var hamletcode = "";
    setDistrictSelectDisabled(true);
    $.getJSON ("/aidog/adminlte/pages/ui_js/district.json", function (data)
    {
        datares = data;
        setDistrictSelectDisabled(false);
        initSelDistrictCtrl(datares);
        if(g_privilegelevel==6){
            hamletcode = $('#select_hamlet').find('option:selected').val();
            var selectvalue = $('#select_hamlet').find('option:selected').text();
            $("#input_dogbelonghamlet").val(selectvalue);
        }
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

    $("#select_hamlet").on('change', function () {
        hamletcode = $(this).find('option:selected').val();
        var selectvalue = $(this).find('option:selected').text();
        $("#input_dogbelonghamlet").val(selectvalue);
    });

    var unbindfeedlist = [];
    var feedflag = false;
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
                if(data.data == null){
                    alert("信息填写有误或无此人！");
                    return;
                }
                alert(data.msg);
                if(data.success == true){
                    $("#input_ownerid").val(data.data.dogowner.ownerId);
                    $("#input_ownername").val(data.data.dogowner.ownerName);
                    document.getElementById("input_ownername").readOnly = true;
                    $("#input_owneridentity").val(data.data.dogowner.ownerIdentity);
                    document.getElementById("input_owneridentity").readOnly = true;
                    $("#input_telphone").val(data.data.dogowner.ownerTel);
                    document.getElementById("input_telphone").readOnly = true;

                    var senddata = {};
                    senddata.hamletcode = hamletcode;
                    $.ajax({
                        url:  "/aidog/api/getunbinddogandfeed",
                        type: "POST",
                        data:  senddata,
                        beforeSend: function (request) {
                            request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
                        },
                        success: function (data) {
                            var select_doggovcode = document.getElementById("select_doggovcode");
                            // data.data = objToArray(data.data);
                            for (var i = 0; i < data.data.govcodelist.length; i++) {
                                if(data.data.govcodelist[i].ownerName == $("#input_ownername").val()){
                                    //遍历后台传回的结果，一项项往select中添加option
                                    select_doggovcode.options.add(new Option(data.data.govcodelist[i].dogGovcode, data.data.govcodelist[i].dogId+" "+data.data.govcodelist[i].dogName));
                                }
                             }

                            // var select_dogfeedid = document.getElementById("select_dogfeedid");
                            // // data.data = objToArray(data.data);
                            // for (var i = 0; i < data.data.feedlist.length; i++) {
                            //     //遍历后台传回的结果，一项项往select中添加option
                            //     select_dogfeedid.options.add(new Option(data.data.feedlist[i], data.data.feedlist[i]));
                            // }
                            unbindfeedlist = data.data.feedlist;
                            //
                            // $("#input_dogownername").val(data.data.govcodelist[0].ownerName);
                            if(select_doggovcode.options.length > 0){
                                $("#input_dogname").val(select_doggovcode.options[0].value.split(' ')[1]);
                            }
                            $("#select_doggovcode").on('change', function () {
                                var selectvalue = $(this).find('option:selected').val();
                                var index = $(this).find('option:selected').index();
                                // $("#input_dogownername").val(data.data.govcodelist[index].ownerName);
                                $("#input_dogname").val(selectvalue.split(' ')[1]);
                            });
                        }
                    })

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
        $("#input_telphone").val("");
        document.getElementById("input_telphone").readOnly = false;
        var select_doggovcode = document.getElementById("select_doggovcode");
        select_doggovcode.options.length = 0;
        // var select_dogfeedid = document.getElementById("select_dogfeedid");
        // select_dogfeedid.options.length = 0;
        $("#input_dogfeedid").val("");
        $("#input_dogname").val("");
    });



    //喂饲器配对激活
    $("#a_bindfeed").click(function () {
        if(hamletcode == ""){
            alert("请先选择主人所属行政村！");
            return;
        }
        if(!feedflag){
            alert("填写的喂饲器不符合绑定要求！");
            return;
        }
        var dogid = $("#select_doggovcode").find('option:selected').val().split(' ')[0];
        // var feedid = $("#select_dogfeedid").find('option:selected').text();
        var feedid = $("#input_dogfeedid").val();
        var senddata = {};
        senddata.dogid = dogid;
        senddata.feedid = feedid;
        $.ajax({
            url: "/aidog/api/bindfeedklet",
            type: "POST",
            data:  senddata,
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                alert(data.msg);
                $("#select_dogfeedid").val("");
                feedflag =false;
            }
        })
    });


    $("#a_checkfeed").click(function () {
        if($("#input_dogfeedid").val()==""){
            alert("请输入喂饲器编号，然后校验！");
            return;
        }
        if(unbindfeedlist.indexOf($("#input_dogfeedid").val())!="-1"){
            alert("填写喂饲器符合要求！");
            feedflag = true;
            return;
        }else{
            alert("不符合要求的喂饲器！");
            return;
        }
    });
})


function objToArray(array) {
    var arr = []
    for (var i in array) {
        arr.push(array[i]);
    }
    return arr;
}