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
    setDistrictSelectDisabled(true);
    $.getJSON ("/aidog/adminlte/pages/ui_js/district.json", function (data)
    {
        datares = data;
        setDistrictSelectDisabled(false);
        initSelDistrictCtrl(datares);
    });
    var districtcode = "";
    var level = "";
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
        var selectvalue = $(this).find('option:selected').text();
        $("#input_dogbelonghamlet").val(selectvalue);

    });

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
            url:  "/aidog/api/getdoglist",
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
                    for(var i = 0;i<data.data.data.length;i++){
                        if(data.data.data[i].appId == "-1"){
                            data.data.data[i].appId = "测试";
                        }
                        data.data.data[i].status = "正常";
                        data.data.data[i].firstdosingtime = "2019-04-20 09:00:00";
                        data.data.data[i].nextdosingtime = "2019-05-20 09:00:00";
                        data.data.data[i].leftnum = 11;
                        data.data.data[i].power = "3.6";
                        data.data.data[i].temp = "21"
                    }
                    viewdata = $.extend(true,[],data.data.data);
                    
                    // @add zyj 2019.07.31 begin
                    if(dataTable){
                    	dataTable.clear();//清空数据.fnClearTable();//清空数据
                    	dataTable.destroy(); //还原初始化了的datatable						
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
                            { "data": "appId","width":"70px" },
                            { "data": "status","width":"70px"  },
                            { "data": "firstdosingtime","width":"120px"  },
                            { "data": "nextdosingtime","width":"120px"  },
                            { "data": "leftnum","width":"90px"},
                            { "data": "power","width":"80px" },
                            { "data": "temp","width":"80px" }
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
                    } );

                    // On each draw, loop over the `detailRows` array and show any child rows
                    dataTable.on( 'draw', function () {
                        $.each( detailRows, function ( i, id ) {
                            $('#'+id+' td.details-control').trigger( 'click' );
                        } );
                    });*/

                }
            }
        })
    });
	
	// Array to track the ids of the details displayed rows
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
    dataTable.on( 'draw', function () {
        $.each( detailRows, function ( i, id ) {
            $('#'+id+' td.details-control').trigger( 'click' );
        } );
    });

    function format ( index ) {
        return '主人姓名: '+viewdata[index].ownerName+'';
    }

    function timetrans(date){
//    var date = new Date(date*1000);//如果date为13位不需要乘1000
        var date = new Date(date);
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + 'T';
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

    // var dogsenddata = {};
    // dogsenddata.dogid = id;
    // $.ajax({
    //     url: "/aidog/api/getdoginfo",
    //     method: "POST",
    //     data: dogsenddata,
    //     beforeSend: function (request) {
    //         request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
    //     },
    //     success: function (data) {
    //         if (data.data != null) {
    //             //牧犬信息
    //             $("#input_dogname").val(data.data.dog.dogName);
    //             $("#input_dogsex").val(data.data.dog.dogSex);
    //             $("#input_dogbelonghamlet").val(data.data.hamlet);
    //             $("#input_dogweight").val(data.data.dog.dogWeight);
    //             $("#input_dogcolor").val(data.data.dog.dogColor);
    //             $("#input_dogage").val(data.data.dog.dogAge);
    //             $("#input_adminname").val(data.data.dog.managerName);
    //             $("#input_adminphone").html("<a href=\"tel:" + data.data.admintel + "\">" + data.data.admintel + "</a>");
    //
    //             //设备信息
    //             if(data.data.nec!=null && data.data.app==null){
    //                 $("#input_neckletid").val(data.data.nec.necId);
    //                 $("#input_appid").val("---");
    //                 $("#input_power").val(((data.data.nec.powerleft)/6).toFixed(2)*100+"%");
    //                 $("#input_medleft").val(data.data.nec.leftNum);
    //                 $("#input_endmedtime").val(ChangeTimeFormat(data.data.nec.enddosingTime));
    //                 $("#input_areacycle").val(data.data.nec.positioncycle);
    //                 $("#input_dosingcycle").val(data.data.nec.dosingcycle);
    //                 $("#input_firstmedtime").val(ChangeTimeFormat(data.data.nec.firstdosingTime));
    //                 $("#input_lastmedtime").val(ChangeTimeFormat(data.data.nec.lastdosingTime));
    //                 $("#input_nextmedtime").val(ChangeTimeFormat(data.data.nec.nextdosingTime));
    //             }else if(data.data.nec==null && data.data.app!=null){
    //                 $("#input_neckletid").val("---");
    //                 $("#input_appid").val(data.data.app.appId);
    //                 $("#input_power").val(((data.data.app.powerleft)/6).toFixed(2)*100+"%");
    //                 $("#input_medleft").val(data.data.app.leftNum);
    //                 $("#input_endmedtime").val(ChangeTimeFormat(data.data.app.enddosingTime));
    //                 $("#input_areacycle").val(data.data.app.positioncycle);
    //                 $("#input_dosingcycle").val(data.data.app.dosingcycle);
    //                 $("#input_firstmedtime").val(ChangeTimeFormat(data.data.app.firstdosingTime));
    //                 $("#input_lastmedtime").val(ChangeTimeFormat(data.data.app.lastdosingTime));
    //                 $("#input_nextmedtime").val(ChangeTimeFormat(data.data.app.nextdosingTime));
    //             }else{
    //                 $("#input_neckletid").val("---");
    //                 $("#input_appid").val("---");
    //                 $("#input_power").val("未绑定设备！");
    //                 $("#input_medleft").val("未绑定设备！");
    //                 $("#input_endmedtime").val("未绑定设备！");
    //                 $("#input_areacycle").val("未绑定设备！");
    //                 $("#input_dosingcycle").val("未绑定设备！");
    //                 $("#input_firstmedtime").val("未绑定设备！");
    //                 $("#input_lastmedtime").val("未绑定设备！");
    //                 $("#input_nextmedtime").val("未绑定设备！");
    //             }
    //             //主人信息
    //             $("#input_ownername").val(data.data.owner.ownerName);
    //             $("#input_owneridentity").val(data.data.owner.ownerIdentity);
    //             $("#input_ownersex").val(data.data.owner.ownerSex);
    //             $("#input_ownerage").val(data.data.owner.ownerAge);
    //             $("#input_ownerjob").val(data.data.owner.ownerJob);
    //             $("#input_homeaddress").val(data.data.owner.ownerAddr);
    //             $("#input_ownertel").html("<a href=\"tel:" + data.data.owner.ownerTel + "\">" + data.data.owner.ownerTel + "</a>");
    //
    //         }
    //     }
    // })
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

