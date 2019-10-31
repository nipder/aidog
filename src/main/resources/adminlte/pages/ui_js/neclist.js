/**
 * Created by 03010335 on 2018/8/22.
 */
var viewdata;
var checkdogid;
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
    var districtcode = "";
    var level = "";
    setDistrictSelectDisabled(true);
    $.getJSON ("/aidog/adminlte/pages/ui_js/district.json", function (data)
    {
        datares = data;
        setDistrictSelectDisabled(false);
        initSelDistrictCtrl(datares);
        districtcode = g_districtcode;
        level = g_level;
    });
    
    $("#select_province").on('change', function () {
        districtcode = $(this).find('option:selected').val();
        level = "province";
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
        districtcode = $(this).find('option:selected').val();
        level = "city";
        if (districtcode == "-1") {
            districtcode = $("#select_province").find('option:selected').val();
            level = "province";
        }
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
        districtcode = $(this).find('option:selected').val();
        level = "county";
        if (districtcode == "-1") {
            districtcode = $("#select_city").find('option:selected').val();
            level = "city";
        }
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
        districtcode = $(this).find('option:selected').val();
        level = "village";
        if (districtcode == "-1") {
            districtcode = $("#select_county").find('option:selected').val();
            level = "county";
        }
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
        districtcode = $(this).find('option:selected').val();
        level = "hamlet";
        if (districtcode == "-1") {
            districtcode = $("#select_village").find('option:selected').val();
            level = "village";
        }
        var selectvalue = $(this).find('option:selected').text();
        $("#input_dogbelonghamlet").val(selectvalue);

    });

    function distrctcodetoaddr(districtcode) {
        var province = "";
        var city = "";
        var county = "";
        var village = "";
        var hamlet = "";
        switch (districtcode.substring(0, 2)){
            case "15":
                province = "内蒙古自治区";
                break;
            case "51":
                province = "四川省";
                break;
            case "53":
                province = "云南省";
                break;
            case "54":
                province = "西藏自治区";
                break;
            case "61":
                province = "陕西省";
                break;
            case "62":
                province = "甘肃省";
                break;
            case "63":
                province = "青海省";
                break;
            case "64":
                province = "宁夏回族自治区";
                break;
            case "65":
                province = "新疆维吾尔族自治区";
                break;
            case "66":
                province = "建设兵团";
                break;
        }
        for (var i = 0; i < datares.data1.length; i++) {
            if (datares.data1[i].districtcode.toString() == districtcode.substring(0, 4)+"00000000") {
                city = datares.data1[i].districtname;
            }
        }
        for (var i = 0; i < datares.data2.length; i++) {
            if (datares.data2[i].districtcode.toString() == districtcode.substring(0, 6)+"000000") {
                county = datares.data2[i].districtname;
            }
        }
        for (var i = 0; i < datares.data3.length; i++) {
            if (datares.data3[i].districtcode.toString() == districtcode.substring(0, 9)+"000") {
                village = datares.data3[i].districtname;
            }
        }
        for (var i = 0; i < datares.data4.length; i++) {
            if (datares.data4[i].districtcode.toString() == districtcode) {
                hamlet = datares.data4[i].districtname;
            }
        }
        return province+city+county+village+hamlet;
    }

    // @add zyj 2019.07.31 begin
    var dataTable;
    // @add zyj 2019.07.31 end
    
    $("#a_getdoglist").click(function () {
        var senddata = {};
        senddata.startitem = 1;
        senddata.pagesize = 100000;
        // @chg zyj 2019.07.30 begin
        //senddata.districtcode = districtcode;
		//senddata.level = level;
        senddata.districtcode = districtcode == "0" ? "" : districtcode;
        senddata.level = districtcode == "0" ? "" : level;
        // @chg zyj 2019.07.30 end 
        $.ajax({
            url:  "/aidog/api/getneclist",
            type: "POST",
            data:  senddata,
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                if (data.data.data == null) {
                    alert(data.data.msg);
                    return;
                }else{
                    var countnum = 0;
                    for(var i = 0;i<data.data.data.length;i++){
                        // if(data.data.data[i].necId == "-1"){
                        //     data.data.data[i].necId = "测试";
                        // }
                        // data.data.data[i].dosingstatus = "正常";
                        // data.data.data[i].firstdosingtime = "2019-04-20 09:00:00";
                        // data.data.data[i].nextdosingtime = "2019-05-20 09:00:00";
                        // data.data.data[i].leftnum = 11;
                        // data.data.data[i].power = "3.6";
                        // data.data.data[i].temperature = "21"
                        // data.data.data[i].pillcode = "gov-23124";
                        // data.data.data[i].confstatus = "硬件信息接收中";
                        if(data.data.data[i].firstDosingTime!=null){
                            data.data.data[i].firstDosingTime = timetrans(data.data.data[i].firstDosingTime);
                        }else{
                            data.data.data[i].firstDosingTime = "无";
                        }
                        if(data.data.data[i].nextDosingTime!=null){
                            data.data.data[i].nextDosingTime = timetrans(data.data.data[i].nextDosingTime);
                        }else{
                            data.data.data[i].nextDosingTime = "无";
                        }
                        if(data.data.data[i].lastUpdateTime!=null){
                            data.data.data[i].lastUpdateTime = timetrans(data.data.data[i].lastUpdateTime);
                        }else{
                            data.data.data[i].lastUpdateTime = "无";
                        }
                        data.data.data[i].countnum = i+1;
                        data.data.data[i].dosingstatus = "<a href='javascript:void(0);'onclick='detailNecTimeInfo(\""+ data.data.data[i].necId + "\")' ><i class='fa fa-arrow-down'></i>"+data.data.data[i].dosingstatus+"</a>";
                        data.data.data[i].detailaddr = distrctcodetoaddr(data.data.data[i].districtcode);
                    }
                    viewdata = $.extend(true,[],data.data.data);
                    // @add zyj 2019.07.31 begin
                    if(dataTable){
                    	dataTable.clear();//清空数据.fnClearTable();//清空数据						
                    	dataTable.destroy(); //还原初始化了的datatable												
						if(detailRows){
							detailRows = [];
						}
                    }
					
                    // @add zyj 2019.07.31 end
                    // @chg zyj 2019.07.31 begin
                    //var dt = $('#datatable').DataTable({					
                    dataTable = $('#datatable').DataTable({
                    // @chg zyj 2019.07.31 end
                    	data: data.data.data,
                        "jQueryUI": true,
                        'paging'      : true,
                        lengthMenu: [　//显示几条数据设置
                            [10, 20,30, 50,-1],
                            ['10 条', '20 条','30条', '50 条','全部']
                        ],
                        'searching'   : true,
                        'ordering'    : true,
                        "pageLength": 10, //每行显示记录数
                        'info'        : true,
                        'bAutoWidth'  : false,
                        "responsive": false,
                         //允许重建
                        "destroy": true,
                        "scrollX":true,
                        "oLanguage": {
                            buttons: {
                                pageLength: {
                                    _: "每页%d条记录",
                                    '-1': "显示所有记录"
                                }
                            },
                            "sLengthMenu": "每页显示 _MENU_ 条记录",
                            "sZeroRecords": "暂无数据",
                            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
                            "sInfoEmtpy": "暂无数据",
                            "sInfoFiltered": "数据表中共为 _MAX_ 条记录)",
                            "sProcessing": "正在加载中",
                            "sSearch": "搜索",
                            "sUrl": "",
                            "oPaginate": {
                                "sFirst": "第一页",
                                "sPrevious": " 上一页 ",
                                "sNext": " 下一页 ",
                                "sLast": " 最后一页 "
                            }
                        },
                        "scrollY": "450px",
                        "dom": 'Bfrtip',
                        "processing": true,
                        "columns": [
                            {
                                "class":          "details-control",
                                "orderable":      false,
                                "data":           null,
                                "defaultContent": "",
                                "width": "1px"
                            },
                            { "data": "countnum","width":"30px" },
                            { "data": "necId","width":"60px" },
                            { "data": "pillcode","width":"60px"  },
                            { "data": "dosingstatus","width":"100px"  },
                            { "data": "firstDosingTime","width":"125px"  },
                            { "data": "nextDosingTime","width":"125px"  },
                            { "data": "leftnum","width":"60px"},
                            { "data": "power","width":"50px" },
                            { "data": "temperature","width":"80px" },
                            { "data": "confstatus","width":"100px"},
                            { "data": "lastUpdateTime","width":"125px"}
                        ],
                        "columnDefs": [
                            {
                                "targets": 10,
                                "createdCell": function (td, cellData, rowData, row, col) {
                                    if (cellData == '硬件接收配置中') {
                                        $(td).css('color', 'black');
                                    }else if (cellData == '硬件已完成配置') {
                                        $(td).css('color', 'green');
                                    }else{
                                        $(td).css('color', 'red');
                                    }
                                }
                            }
                        ],
                        buttons: [
                            'pageLength',
                            {
                                text: "导出Excel",
                                extend: 'excelHtml5',
                                filename:"用户信息报表"+"_"+new Date(),
                                exportOptions: {
                                    format: {
                                    }
                                },
                                customize: function (win) {
                                    console.log(win);
                                    var sheet = win.xl.worksheets['sheet1.xml'];
                                    $('cols col', sheet).attr({'width':30});
                                }
                            },
                            {
                                extend: 'print',
                                text:"打印报表",
                                messageTop: function () {
                                }
                            }
                        ]
                    });


                    // Array to track the ids of the details displayed rows
                    /*var detailRows = [];

                    $('#tbody').on( 'click', 'tr td.details-control', function () {                    
                        var tr = $(this).closest('tr');
                        var row = dataTable.row( tr );
                        var idx = $.inArray( tr.attr('id'), detailRows );

                        if ( row.child.isShown() ) {
                            tr.removeClass( 'details' );
                            row.child.hide();

                            // Remove from the 'open' array
                            detailRows.splice( idx, 1 );
                        }
                        else {
                            tr.addClass( 'details' );
                            row.child( format( row.index() ) ).show();

                            // Add to the 'open' array
                            if ( idx === -1 ) {
                                detailRows.push( tr.attr('id') );
                            }
                        }
                    } );*/

                    // On each draw, loop over the `detailRows` array and show any child rows
                    dataTable.on( 'draw', function () {
                        $.each( detailRows, function ( i, id ) {
                            $('#'+id+' td.details-control').trigger( 'click' );
                        } );
                    });
                }
            }
        })
    });

	var detailRows = [];

    $('#tbody').on( 'click', 'tr td.details-control', function () {                    
        var tr = $(this).closest('tr');
        var row = dataTable.row( tr );
        var idx = $.inArray( tr.attr('id'), detailRows );

        if ( row.child.isShown() ) {
            tr.removeClass( 'details' );
            row.child.hide();

            // Remove from the 'open' array
            detailRows.splice( idx, 1 );
        }
        else {
            tr.addClass( 'details' );
            row.child( format( row.index() ) ).show();

            // Add to the 'open' array
            if ( idx === -1 ) {
                detailRows.push( tr.attr('id') );
            }
        }
    } );

    // On each draw, loop over the `detailRows` array and show any child rows
    //dataTable.on( 'draw', function () {
    //    $.each( detailRows, function ( i, id ) {
    //        $('#'+id+' td.details-control').trigger( 'click' );
    //    } );
    //});

    function format ( index ) {
        return '最近同步时间: '+viewdata[index].lastUpdateTime+' &nbsp;&nbsp; 详细归属地：'+viewdata[index].detailaddr+'';
    }

    function timetrans(date){
//    var date = new Date(date*1000);//如果date为13位不需要乘1000
        var date = new Date(date);
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + ' ';
        var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
        var m = (date.getMinutes() <10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
        var s = (date.getSeconds() <10 ? '0' + date.getSeconds() : date.getSeconds());
        return Y+M+D+h+m+s;
    }

    $("#a_dogmodify").click(function () {
        var dogid = $('#dogid').html();
        //修改牧犬
        var clicktype = "dogmodify";
        var dogid = dogid;
        var dogname = $("#modalinput_dogname").val();
        var dogsex = $("#modalselect_dogsex").find("option:selected").text();
        var dogweight = $("#modalinput_dogweight").val();
        var dogcolor = $("#modalinput_dogcolor").val();
        var dogage = $("#modalinput_dogage").val();
        var senddata = {};
        senddata.clicktype = clicktype;
        senddata.dogid = dogid;
        senddata.dogname = dogname;
        senddata.dogsex = dogsex;
        senddata.dogweight = dogweight;
        senddata.dogcolor = dogcolor;
        senddata.dogage = dogage;
        $.ajax({
            url: "/aidog/api/bindoraddapi",
            type: "POST",
            data:  JSON.stringify(senddata),
            contentType: "application/json",
            dataType: "text",    // 控制回来的数据类型
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                alert(data);
                window.location.reload();
            }
        })
    });
})

function detailInfo(id) {
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

function detailNecTimeInfo(id) {
    $("#necid").html(id);
    $("#necTimeDiv").modal({
        remote: 'nectimemodal.html'

    });
    $("#necTimeDiv").modal('show');
    //Bootstrap v3
    $("#necTimeDiv").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });
}

function modifyDog(id) {
    $("#dogid").html(id);
    var modifydogsenddata = {};
    modifydogsenddata.dogid = id;
    $.ajax({
        url: "/aidog/api/getdoginfo",
        method: "POST",
        data: modifydogsenddata,
        beforeSend: function (request) {
            request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
        },
        success: function (data) {
            if (data.data != null) {
                //牧犬信息
                $("#modalinput_dogname").val(data.data.dog.dogName);
                $("#modalselect_dogsex").find("option[value='"+data.data.dog.dogSex+"']").prop("selected",true);
                $("#modalinput_dogbelonghamlet").val(data.data.hamlet);
                $("#modalinput_dogweight").val(data.data.dog.dogWeight);
                $("#modalinput_dogcolor").val(data.data.dog.dogColor);
                $("#modalinput_dogage").val(data.data.dog.dogAge);
            }
        }
    })
    $("#dogModifyDiv").modal('show');
}

function modifyNec(id) {
    alert(id);
}

function modifyApp(id) {
    alert(id);
}

function modifyOwner(id) {
    alert(id);
}

function objToArray(array) {
    var arr = []
    for (var i in array) {
        arr.push(array[i]);
    }
    return arr;
}

