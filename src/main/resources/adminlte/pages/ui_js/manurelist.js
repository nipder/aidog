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
    $.getJSON ("/aidog/adminlte/pages/ui_js/district.json", function (data)
    {
        datares = data;
    });
    var districtcode = "";
    var level = "";

    $("#select_province").on('change', function () {
        districtcode = $(this).find('option:selected').val();
        level = "province";
        var selectvalue = $(this).find('option:selected').val();
        selectvalue = selectvalue.substring(0,2);
        $("#select_city").find("option").remove();
        var select_city = document.getElementById("select_city");
        select_city.options.add(new Option("请选择", "-1"));
        if ($('#modalselect_adminlevel').find('option:selected').text()!="省级") {
            for (var i = 0; i < datares.data1.length; i++) {
                if (datares.data1[i].districtcode.toString().substring(0, 2) == selectvalue) {
                    //遍历后台传回的结果，一项项往select中添加option
                    select_city.options.add(new Option(datares.data1[i].districtname, datares.data1[i].districtcode));
                }
            }
        }
        $("#select_county").find("option").remove();
        var select_county = document.getElementById("select_county");
        select_county.options.add(new Option("请选择", "-1"));

        $("#select_village").find("option").remove();
        var select_village = document.getElementById("select_village");
        select_village.options.add(new Option("请选择", "-1"));

        $("#select_hamlet").find("option").remove();
        var select_hamlet = document.getElementById("select_hamlet");
        select_hamlet.options.add(new Option("请选择", "-1"));
    });
    $("#select_city").on('change', function () {
        districtcode = $(this).find('option:selected').val();
        level = "city";
        var selectvalue = $(this).find('option:selected').val();
        $("#select_county").find("option").remove();
        selectvalue = selectvalue.substring(0, 4);
        var select_county = document.getElementById("select_county");
        select_county.options.add(new Option("请选择", "-1"));
        if ($('#modalselect_adminlevel').find('option:selected').text() != "市级") {
            for (var i = 0; i < datares.data2.length; i++) {
                if (datares.data2[i].districtcode.toString().substring(0, 4) == selectvalue) {
                    //遍历后台传回的结果，一项项往select中添加option
                    select_county.options.add(new Option(datares.data2[i].districtname, datares.data2[i].districtcode));
                }
            }
        }
        $("#select_village").find("option").remove();
        var select_village = document.getElementById("select_village");
        select_village.options.add(new Option("请选择", "-1"));

        $("#select_hamlet").find("option").remove();
        var select_hamlet = document.getElementById("select_hamlet");
        select_hamlet.options.add(new Option("请选择", "-1"));
    });
    $("#select_county").on('change', function () {
        districtcode = $(this).find('option:selected').val();
        level = "county";
        var selectvalue = $(this).find('option:selected').val();
        $("#select_village").find("option").remove();
        selectvalue = selectvalue.substring(0, 6);
        var select_village = document.getElementById("select_village");
        select_village.options.add(new Option("请选择", "-1"));
        if ($('#modalselect_adminlevel').find('option:selected').text() != "县级") {
            for (var i = 0; i < datares.data3.length; i++) {
                if (datares.data3[i].districtcode.toString().substring(0, 6) == selectvalue) {
                    //遍历后台传回的结果，一项项往select中添加option
                    select_village.options.add(new Option(datares.data3[i].districtname, datares.data3[i].districtcode));
                }
            }
        }
        $("#select_hamlet").find("option").remove();
        var select_hamlet = document.getElementById("select_hamlet");
        select_hamlet.options.add(new Option("请选择", "-1"));
    });
    $("#select_village").on('change', function () {
        districtcode = $(this).find('option:selected').val();
        level = "village";
        var selectvalue = $(this).find('option:selected').val();
        $("#select_hamlet").find("option").remove();
        selectvalue = selectvalue.substring(0, 9);
        var select_hamlet = document.getElementById("select_hamlet");
        select_hamlet.options.add(new Option("请选择", "-1"));
        if ($('#modalselect_adminlevel').find('option:selected').text() != "乡级") {
            for (var i = 0; i < datares.data4.length; i++) {
                if (datares.data4[i].districtcode.toString().substring(0, 9) == selectvalue) {
                    //遍历后台传回的结果，一项项往select中添加option
                    select_hamlet.options.add(new Option(datares.data4[i].districtname, datares.data4[i].districtcode));
                }
            }
        }
    });

    $("#select_hamlet").on('change', function () {
        districtcode = $(this).find('option:selected').val();
        level = "hamlet";
        var selectvalue = $(this).find('option:selected').text();
        $("#input_dogbelonghamlet").val(selectvalue);

    });

    $("#regselect_testresult").on('change', function () {
        if($("#regselect_testmethod").find('option:selected').text() == "PCR" && $(this).find('option:selected').text()  == "阳性"){
            $("#div_regsqjqdcnum").css("display","block");
            $("#div_regdfjqdcnum").css("display","block");
            $("#div_regxljqdcnum").css("display","block");
        }else{
            $("#div_regsqjqdcnum").css("display","none");
            $("#div_regdfjqdcnum").css("display","none");
            $("#div_regxljqdcnum").css("display","none");
        }
    });

    $("#regselect_testmethod").on('change', function () {
        if($(this).find('option:selected').text() == "PCR" && $("#regselect_testresult").find('option:selected').text()  == "阳性"){
            $("#div_regsqjqdcnum").css("display","block");
            $("#div_regdfjqdcnum").css("display","block");
            $("#div_regxljqdcnum").css("display","block");
        }else{
            $("#div_regsqjqdcnum").css("display","none");
            $("#div_regdfjqdcnum").css("display","none");
            $("#div_regxljqdcnum").css("display","none");
        }
    });

    $("#a_getmanurelist").click(function () {
        var senddata = {};
        senddata.startitem = 1;
        senddata.pagesize = 100000;
        senddata.districtcode = districtcode;
        senddata.level = level;
        $.ajax({
            url:  "/aidog/api/getmanurelist",
            type: "POST",
            data:  senddata,
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                if (data.data.data.length == 0) {
                    return;
                }else{
                    for(var i = 0;i<data.data.data.length;i++){
                        data.data.data[i].collectionDate = timetrans(data.data.data[i].collectionDate).replace('T'," ");
                        if(data.data.data[i].testingDate != null){
                            data.data.data[i].testingDate = timetrans(data.data.data[i].testingDate).replace('T'," ");
                        }
                        var valueStr = JSON.stringify(data.data.data[i]);  //对象转字符串
                        if(data.data.data[i].testingResult != null){
                            data.data.data[i].action = "<a href='javascript:void(0);'onclick='ShowRowDetail("+ valueStr + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 详情</a>";
                        }else{
                            data.data.data[i].action = "<a href='javascript:void(0);'onclick='TestThisRow("+ valueStr + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 录入检测结果</a>&nbsp;&nbsp<a href='javascript:void(0);'onclick='ShowRowDetail("+ valueStr + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 详情</a>";
                        }
                    }
                    viewdata = $.extend(true,[],data.data.data);
                    var dt = $('#datatable').DataTable({
                        data: data.data.data,
                        "jQueryUI": true,
                        'paging': true,
                        lengthMenu: [　//显示几条数据设置
                            [10, 20,30, 50,-1],
                            ['10 条', '20 条','30条', '50 条','全部']
                        ],
                        'searching'   : true,
                        'ordering'    : true,
                        "pageLength": 10, //每行显示记录数
                        'info'        : true,
                        'bAutoWidth'  : false,
                        "responsive": true,
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
                            // {
                            //     "class":          "details-control",
                            //     "orderable":      false,
                            //     "data":           null,
                            //     "defaultContent": "",
                            //     "width": "1px"
                            // },
                            { "data": "num","width":"30px" },
                            { "data": "dogmanureCode","width":"60px" },
                            { "data": "ownerName","width":"60px" },
                            // { "data": "ownerIndentity","width":"120px" },
                            { "data": "dogGovcode","width":"90px"},
                            { "data": "managemethod","width":"60px"  },
                            { "data": "deviceId","width":"60px"  },
                            // { "data": "collectionDate","width":"120px" },
                            { "data": "testingMethod" ,"width":"60px"},
                            { "data": "testingResult" ,"width":"60px"},
                            { "data": "testingPerson" ,"width":"50px"},
                            { "data": "testingDate" ,"width":"120px"},
                            { "data": "action" ,"width":"120px"}
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
                    var detailRows = [];

                    $('#tbody').on( 'click', 'tr td.details-control', function () {
                        var tr = $(this).closest('tr');
                        var row = dt.row( tr );
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
                    dt.on( 'draw', function () {
                        $.each( detailRows, function ( i, id ) {
                            $('#'+id+' td.details-control').trigger( 'click' );
                        } );
                    });
                }
            }
        })
    });

    function format ( index ) {
        return '主人姓名: '+viewdata[index].ownerName+'';
    }

    var dt = $('#datatable').dataTable();

    $("#a_manurereg").click(function () {
        var manureid = $('#manureid').html();
        //修改或录入犬粪信息
        var clicktype = "manuremodify";
        var testdate = $("#reginput_testdate").val()+":00";
        // var testmethod = $("#reginput_testmethod").val();
        var testmethod = $("#regselect_testmethod").find("option:selected").text();
        // var testresult = $("#reginput_testresult").val();
        var testresult = $("#regselect_testresult").find("option:selected").text();
        var testperson = $("#reginput_testperson").val();
        if(testdate == null || testmethod == null || testresult == null || testperson == null ||
            testdate == "" || testmethod == "" || testresult == "" || testperson == ""){
            alert("信息填写不完整！");
            return;
        }

        var PcrSqjqdc = $("#reginput_sqjqdcnum").val();
        var PcrDfjqdc = $("#reginput_dfjqdcnum").val();
        var PcrXljqdc = $("#reginput_xljqdcnum").val();

        var senddata = {};
        senddata.clicktype = clicktype;
        senddata.manureid = manureid;
        senddata.testdate = testdate;
        senddata.testmethod = testmethod;
        senddata.testresult = testresult;
        senddata.testperson = testperson;
        senddata.PcrSqjqdc = PcrSqjqdc;
        senddata.PcrDfjqdc = PcrDfjqdc;
        senddata.PcrXljqdc = PcrXljqdc;
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

                var tableSetings = dt.fnSettings();
                var paging_length = tableSetings._iDisplayLength;//当前每页显示多少
                var page_start = tableSetings._iDisplayStart;//当前页开始
                var page = (page_start/paging_length); //得到页数值  比页码小1
                $("#dogManureReg").modal('hide');

                dt.fnClearTable();
                var senddata = {};
                senddata.startitem = 1;
                senddata.pagesize = 100000;
                senddata.districtcode = districtcode;
                senddata.level = level;
                $.ajax({
                    url:  "/aidog/api/getmanurelist",
                    type: "POST",
                    data:  senddata,
                    beforeSend: function (request) {
                        request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
                    },
                    success: function (data) {
                        if (data.data.data.length == 0) {
                            return;
                        }else{
                            for(var i = 0;i<data.data.data.length;i++){
                                data.data.data[i].collectionDate = timetrans(data.data.data[i].collectionDate).replace('T'," ");
                                if(data.data.data[i].testingDate != null){
                                    data.data.data[i].testingDate = timetrans(data.data.data[i].testingDate).replace('T'," ");
                                }
                                var valueStr = JSON.stringify(data.data.data[i]);  //对象转字符串
                                if(data.data.data[i].testingResult != null){
                                    data.data.data[i].action = "<a href='javascript:void(0);'onclick='ShowRowDetail("+ valueStr + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 详情</a>";
                                }else{
                                    data.data.data[i].action = "<a href='javascript:void(0);'onclick='TestThisRow("+ valueStr + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 录入检测结果</a>&nbsp;&nbsp<a href='javascript:void(0);'onclick='ShowRowDetail("+ valueStr + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 详情</a>";
                                }
                            }
                            viewdata = $.extend(true,[],data.data.data);
                            dt.fnAddData(viewdata);
                            dt.fnPageChange(page);//加载跳转
                        }
                    }
                })
            }
        })
    });
})


function TestThisRow(data) {

    $("#div_regsqjqdcnum").css("display","none");
    $("#div_regdfjqdcnum").css("display","none");
    $("#div_regxljqdcnum").css("display","none");

    if (data != null) {
        //牧犬信息
        $('#manureid').html(data.id);
        $("#reginput_manurecode").val(data.dogmanureCode);
        $("#reginput_ownername").val(data.ownerName);
        if(data.testingDate == null || data.testingDate == ""){
            $("#reginput_testdate").val("");
        }else{
            $("#reginput_testdate").val(timetrans(data.testingDate));
        }
        if(data.testingMethod == null || data.testingMethod == ""){
            $("#reginput_testmethod").val("");
        }else{
            $("#reginput_testmethod").val(data.testingMethod);
        }
        if(data.testingResult == null || data.testingResult == ""){
            $("#reginput_testresult").val("");
        }else{
            $("#reginput_testresult").val(data.testingResult);
        }
        if(data.testingPerson == null || data.testingPerson == ""){
            $("#reginput_testperson").val("");
        }else{
            $("#reginput_testperson").val(data.testingPerson);
        }
    }
    if(data.testingMethod!=null && data.testingMethod =="PCR" && data.testingResult!=null && data.testingResult =="阳性"){
        $("#reginput_sqjqdcnum").val(data.PcrSqjqdc);
        $("#reginput_dfjqdcnum").val(data.PcrDfjqdc);
        $("#reginput_xljqdcnum").val(data.PcrXljqdc);
        $("#div_regsqjqdcnum").css("display","block");
        $("#div_regdfjqdcnum").css("display","block");
        $("#div_regxljqdcnum").css("display","block");
    }
    //日历控件
    $("#reginput_testdate").val(timeinput((new Date()).valueOf()));
    $("#dogManureReg").modal('show');
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

function timeinput(date){
//    var date = new Date(date*1000);//如果date为13位不需要乘1000
    var date = new Date(date);
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + 'T';
    var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
    var m = (date.getMinutes() <10 ? '0' + date.getMinutes() : date.getMinutes());
    return Y+M+D+h+m;
}

function ShowRowDetail(data) {
    $("#div_sqjqdcnum").css("display","none");
    $("#div_dfjqdcnum").css("display","none");
    $("#div_xljqdcnum").css("display","none");

    if (data != null) {
        //牧犬信息
        $("#input_manurecode").val(data.dogmanureCode);
        $("#input_ownername").val(data.ownerName);
        $("#input_ownerindentity").val(data.ownerIndentity);
        $("#input_doggovcode").val(data.dogGovcode);
        $("#input_managemethod").val(data.managemethod);
        $("#input_deviceid").val(data.deviceId);
        $("#input_collectiondate").val(timetrans(data.collectionDate));
        $("#input_collectionperson").val(data.collectionPerson);
        $("#input_testdate").val(timetrans(data.testingDate));
        $("#input_testmethod").val(data.testingMethod);
        $("#input_testresult").val(data.testingResult);
        $("#input_testperson").val(data.testingPerson);
        if(data.testingMethod!=null && data.testingMethod =="PCR" && data.testingResult!=null && data.testingResult =="阳性"){
            $("#input_sqjqdcnum").val(data.pcrDfjqdc);
            $("#input_dfjqdcnum").val(data.pcrSqjqdc);
            $("#input_xljqdcnum").val(data.pcrXljqdc);
            $("#div_sqjqdcnum").css("display","block");
            $("#div_dfjqdcnum").css("display","block");
            $("#div_xljqdcnum").css("display","block");
        }else{
            $("#input_sqjqdcnum").val(null);
            $("#input_dfjqdcnum").val(null);
            $("#input_xljqdcnum").val(null);
        }
    }
    $("#manureInfoDiv").modal('show');
}


function objToArray(array) {
    var arr = []
    for (var i in array) {
        arr.push(array[i]);
    }
    return arr;
}

