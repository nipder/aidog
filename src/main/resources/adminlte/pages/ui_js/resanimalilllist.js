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
    var reginput_district = "全国";
    $("#select_province").on('change', function () {
        districtcode = $(this).find('option:selected').val();
        reginput_district = $(this).find('option:selected').text();
        level = "province";
        var selectvalue = $(this).find('option:selected').val();
        if(selectvalue == "0"){
            level = "";
        }else{
            selectvalue = selectvalue.substring(0,2);
        }
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
        reginput_district = $(this).find('option:selected').text();
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
        reginput_district = $(this).find('option:selected').text();
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
        reginput_district = $(this).find('option:selected').text();
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
        reginput_district = $(this).find('option:selected').text();
        level = "hamlet";
        var selectvalue = $(this).find('option:selected').text();
    });

    $("#regmodalselect_checkres").on('change', function () {
        if($("#regmodalselect_method").find('option:selected').text() == "PCR" && $(this).find('option:selected').text()  == "阳性"){
            $("#div_regsqjqdcnum").css("display","block");
            $("#div_regdfjqdcnum").css("display","block");
            $("#div_regxljqdcnum").css("display","block");
            $("#div_regillplace").css("display","none");
            $("#div_regillsize").css("display","none");
            $("#div_regillnum").css("display","none");
        }else if($("#regmodalselect_method").find('option:selected').text() == "视检触检" && $(this).find('option:selected').text()  == "阳性"){
            $("#div_regsqjqdcnum").css("display","none");
            $("#div_regdfjqdcnum").css("display","none");
            $("#div_regxljqdcnum").css("display","none");
            $("#div_regillplace").css("display","block");
            $("#div_regillsize").css("display","block");
            $("#div_regillnum").css("display","block");
        }else{
            $("#div_regsqjqdcnum").css("display","none");
            $("#div_regdfjqdcnum").css("display","none");
            $("#div_regxljqdcnum").css("display","none");
            $("#div_regillplace").css("display","none");
            $("#div_regillsize").css("display","none");
            $("#div_regillnum").css("display","none");
        }
    });

    $("#regmodalselect_method").on('change', function () {
        if($(this).find('option:selected').text() == "PCR" && $("#regmodalselect_checkres").find('option:selected').text()  == "阳性"){
            $("#div_regsqjqdcnum").css("display","block");
            $("#div_regdfjqdcnum").css("display","block");
            $("#div_regxljqdcnum").css("display","block");
            $("#div_regillplace").css("display","none");
            $("#div_regillsize").css("display","none");
            $("#div_regillnum").css("display","none");
        }else if($(this).find('option:selected').text() == "视检触检" && $("#regmodalselect_checkres").find('option:selected').text()  == "阳性"){
            $("#div_regsqjqdcnum").css("display","none");
            $("#div_regdfjqdcnum").css("display","none");
            $("#div_regxljqdcnum").css("display","none");
            $("#div_regillplace").css("display","block");
            $("#div_regillsize").css("display","block");
            $("#div_regillnum").css("display","block");
        }else{
            $("#div_regsqjqdcnum").css("display","none");
            $("#div_regdfjqdcnum").css("display","none");
            $("#div_regxljqdcnum").css("display","none");
            $("#div_regillplace").css("display","none");
            $("#div_regillsize").css("display","none");
            $("#div_regillnum").css("display","none");
        }
    });


    $("#a_addnew").click(function () {
        $("#reginput_district").val(reginput_district);
        $("#addNew").modal('show');
    });

    $("#a_addanimalill").click(function () {
        if(districtcode == ""){
            alert("请选择省级或以下行政级别！");
            return;
        }
        var clicktype = "addanimalill";
        var killplace = $("#addinput_killplace").val();
        var code = $("#addinput_code").val();
        var type = $("#addinput_type").val();
        var age = $("#addinput_age").val();
        var sex = $("#addmodalselect_sex").find('option:selected').text();
        var ressenddata = {};
        ressenddata.clicktype = clicktype;
        ressenddata.districtcode = districtcode;
        ressenddata.killplace = killplace;
        ressenddata.code = code;
        ressenddata.age = age;
        ressenddata.type = type;
        ressenddata.sex = sex;

        $.ajax({
            url: "/aidog/api/operateapi",
            type: "POST",
            data:  JSON.stringify(ressenddata),
            contentType: "application/json",
            dataType: "text",    // 控制回来的数据类型
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                data = eval("("+data+")");
                alert(data.msg);
                $("#addNew").modal('hide');

                var tableSetings = dt.fnSettings();
                var paging_length = tableSetings._iDisplayLength;//当前每页显示多少
                var page_start = tableSetings._iDisplayStart;//当前页开始
                var page = (page_start/paging_length); //得到页数值  比页码小1

                dt.fnClearTable();
                var senddata = {};
                senddata.startitem = 1;
                senddata.pagesize = 100000;
                senddata.districtcode = districtcode;
                senddata.level = level;
                $.ajax({
                    url:  "/aidog/api/getanimallist",
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
                                data.data.data[i].countnum = i+1;
                                data.data.data[i].school = data.data.data[i].school || "--";
                                data.data.data[i].name = data.data.data[i].name || "--";
                                data.data.data[i].age = data.data.data[i].age || 0;
                                data.data.data[i].classname =  data.data.data[i].classname || "--";
                                data.data.data[i].sex =  data.data.data[i].sex || "--";
                                data.data.data[i].bcheckres = data.data.data[i].bcheckres;
                                data.data.data[i].checkperson = data.data.data[i].checkperson;
                                data.data.data[i].checkdate = data.data.data[i].checkdate == null ? null:timetrans(data.data.data[i].checkdate).replace('T'," ");
                                if(data.data.data[i].checkres != null && data.data.data[i].checkperson!=null){
                                    data.data.data[i].action = "<a href='javascript:void(0);'onclick='ShowRowDetail("+ JSON.stringify(data.data.data[i]) + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 详情</a>";
                                }else{
                                    data.data.data[i].action = "<a href='javascript:void(0);'onclick='modifyIll("+ JSON.stringify(data.data.data[i]) + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 录入检测结果</a>&nbsp;&nbsp<a href='javascript:void(0);'onclick='ShowRowDetail("+ JSON.stringify(data.data.data[i]) + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 详情</a>";
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

    $("#a_animalmodify").click(function () {
        var id = $('#illid').html();
        //修改录入信息
        var clicktype = "modifyanimalill";
        var checkdate = $("#reginput_checkdate").val()+":00";
        var sex = $("#addmodalselect_sex").find('option:selected').text()
        var method = $("#regmodalselect_method").find("option:selected").text();
        var checkres = $("#regmodalselect_checkres").find("option:selected").text();
        var checkperson = $("#reginput_checkperson").val();
        if(method == null || checkdate == null || checkres == null || checkperson == null
            || method == "" || checkdate == "" || checkres == "" || checkperson == ""){
            alert("信息填写不完整！");
            return;
        }

        var PcrSqjqdc = $("#reginput_sqjqdcnum").val();
        var PcrDfjqdc = $("#reginput_dfjqdcnum").val();
        var PcrXljqdc = $("#reginput_xljqdcnum").val();

        var illplace = $("#reginput_illplace").val();
        var illsize = $("#reginput_illsize").val();
        var illnum = $("#reginput_illnum").val();

        var inputsenddata = {};
        inputsenddata.clicktype = clicktype;
        inputsenddata.id = id;
        inputsenddata.checkdate = checkdate;
        inputsenddata.sex = sex;
        inputsenddata.method = method;
        inputsenddata.checkres = checkres;
        inputsenddata.checkperson = checkperson;
        inputsenddata.PcrSqjqdc = PcrSqjqdc;
        inputsenddata.PcrDfjqdc = PcrDfjqdc;
        inputsenddata.PcrXljqdc = PcrXljqdc;
        inputsenddata.illplace = illplace;
        inputsenddata.illsize = illsize;
        inputsenddata.illnum = illnum;

        $.ajax({
            url: "/aidog/api/operateapi",
            type: "POST",
            data:  JSON.stringify(inputsenddata),
            contentType: "application/json",
            dataType: "text",    // 控制回来的数据类型
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                data = eval("("+data+")");
                alert(data.msg);
                $("#checkModifyDiv").modal('hide');

                var tableSetings = dt.fnSettings();
                var paging_length = tableSetings._iDisplayLength;//当前每页显示多少
                var page_start = tableSetings._iDisplayStart;//当前页开始
                var page = (page_start/paging_length); //得到页数值  比页码小1

                dt.fnClearTable();
                var senddata = {};
                senddata.startitem = 1;
                senddata.pagesize = 100000;
                senddata.districtcode = districtcode;
                senddata.level = level;
                $.ajax({
                    url:  "/aidog/api/getanimallist",
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
                                data.data.data[i].countnum = i+1;
                                data.data.data[i].killplace = data.data.data[i].killplace || "--";
                                data.data.data[i].code = data.data.data[i].code || "--";
                                data.data.data[i].type = data.data.data[i].type || 0;
                                data.data.data[i].sex =  data.data.data[i].sex || "--";
                                data.data.data[i].age =  data.data.data[i].age || "--";
                                data.data.data[i].method = data.data.data[i].method;
                                data.data.data[i].checkres = data.data.data[i].checkres;
                                data.data.data[i].checkperson = data.data.data[i].checkperson;
                                data.data.data[i].checkdate = data.data.data[i].checkdate == null ? null:timetrans(data.data.data[i].checkdate).replace('T'," ");

                                if(data.data.data[i].checkres != null && data.data.data[i].checkperson!=null){
                                    data.data.data[i].action = "<a href='javascript:void(0);'onclick='ShowRowDetail("+ JSON.stringify(data.data.data[i]) + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 详情</a>";
                                }else{
                                    data.data.data[i].action = "<a href='javascript:void(0);'onclick='modifyIll("+ JSON.stringify(data.data.data[i]) + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 录入检测结果</a>&nbsp;&nbsp<a href='javascript:void(0);'onclick='ShowRowDetail("+ JSON.stringify(data.data.data[i]) + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 详情</a>";
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

    var dt = $('#datatable').dataTable();

    $("#a_getanimallist").click(function () {
        var senddata = {};
        senddata.startitem = 1;
        senddata.pagesize = 100000;
        senddata.districtcode = districtcode;
        senddata.level = level;
        $.ajax({
            url:  "/aidog/api/getanimallist",
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
                        data.data.data[i].countnum = i+1;
                        data.data.data[i].killplace = data.data.data[i].killplace || "--";
                        data.data.data[i].code = data.data.data[i].code || "--";
                        data.data.data[i].type = data.data.data[i].type || 0;
                        data.data.data[i].sex =  data.data.data[i].sex || "--";
                        data.data.data[i].age =  data.data.data[i].age || "--";
                        data.data.data[i].method = data.data.data[i].method;
                        data.data.data[i].checkres = data.data.data[i].checkres;
                        data.data.data[i].checkperson = data.data.data[i].checkperson;
                        data.data.data[i].checkdate = data.data.data[i].checkdate == null ? null:timetrans(data.data.data[i].checkdate).replace('T'," ");

                        if(data.data.data[i].checkres != null && data.data.data[i].checkperson!=null){
                            data.data.data[i].action = "<a href='javascript:void(0);'onclick='ShowRowDetail("+ JSON.stringify(data.data.data[i]) + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 详情</a>";
                        }else{
                            data.data.data[i].action = "<a href='javascript:void(0);'onclick='modifyIll("+ JSON.stringify(data.data.data[i]) + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 录入检测结果</a>&nbsp;&nbsp<a href='javascript:void(0);'onclick='ShowRowDetail("+ JSON.stringify(data.data.data[i]) + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 详情</a>";
                        }
                    }
                    viewdata = $.extend(true,[],data.data.data);
                    dt = $('#datatable').dataTable({
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
                            { "data": "countnum","width":"40px" },
                            { "data": "killplace","width":"80px"  },
                            { "data": "code","width":"85px"},
                            { "data": "type","width":"40px" },
                            { "data": "sex","width":"70px" },
                            { "data": "age" ,"width":"50px"},
                            { "data": "method" ,"width":"90px"},
                            { "data": "checkres" ,"width":"90px"},
                            { "data": "checkperson" ,"width":"50px"},
                            { "data": "checkdate" ,"width":"120px"},
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
        return '';
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

})

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

function modifyIll(obj) {
    $("#div_regsqjqdcnum").css("display","none");
    $("#div_regdfjqdcnum").css("display","none");
    $("#div_regxljqdcnum").css("display","none");
    $("#div_regillplace").css("display","none");
    $("#div_regillsize").css("display","none");
    $("#div_regillnum").css("display","none");


    $('#illid').html(obj.id);
    $("#reginput_killplace").val(obj.killplace);
    $("#reginput_code").val(obj.code);
    $("#reginput_type").val(obj.type);
    $("#reginput_sex").val(obj.sex);
    $("#reginput_age").val(obj.age);
    $("#regmodalselect_method").val(obj.method);
    $("#regmodalselect_checkres").val(obj.checkres);
    $("#reginput_checkperson").val(obj.checkperson);
    if(obj.checkdate==null){
        $("#reginput_checkdate").val(timeinput((new Date()).valueOf()));
    }else{
        $("#reginput_checkdate").val(obj.checkdate.replace(' ',"T"));
    }

    if(obj.method!=null && obj.method =="PCR" && obj.checkres!=null && obj.checkres =="阳性"){
        $("#reginput_illplace").val(null);
        $("#reginput_illsize").val(null);
        $("#reginput_illnum").val(null);
        $("#reginput_sqjqdcnum").val(obj.pcrSqjqdc);
        $("#reginput_dfjqdcnum").val(obj.pcrDfjqdc);
        $("#reginput_xljqdcnum").val(obj.pcrXljqdc);
        $("#div_regsqjqdcnum").css("display","block");
        $("#div_regdfjqdcnum").css("display","block");
        $("#div_regxljqdcnum").css("display","block");
        $("#div_regillplace").css("display","none");
        $("#div_regillsize").css("display","none");
        $("#div_regillnum").css("display","none");
    }
    if(obj.method!=null && obj.method =="视检触检" && obj.checkres!=null && obj.checkres =="阳性"){
        $("#reginput_illplace").val(obj.eyeIllplace);
        $("#reginput_illsize").val(obj.eyeSize);
        $("#reginput_illnum").val(obj.eyeNum);
        $("#reginput_sqjqdcnum").val(null);
        $("#reginput_dfjqdcnum").val(null);
        $("#reginput_xljqdcnum").val(null);
        $("#div_regsqjqdcnum").css("display","none");
        $("#div_regdfjqdcnum").css("display","none");
        $("#div_regxljqdcnum").css("display","none");
        $("#div_regillplace").css("display","block");
        $("#div_regillsize").css("display","block");
        $("#div_regillnum").css("display","block");
    }
    $("#checkModifyDiv").modal('show');
}

function ShowRowDetail(obj) {

    $("#div_sqjqdcnum").css("display","none");
    $("#div_dfjqdcnum").css("display","none");
    $("#div_xljqdcnum").css("display","none");
    $("#div_illplace").css("display","none");
    $("#div_illsize").css("display","none");
    $("#div_illnum").css("display","none");


    $('#illid').html(obj.id);
    $("#input_killplace").val(obj.killplace);
    $("#input_code").val(obj.code);
    $("#input_type").val(obj.type);
    $("#input_sex").val(obj.sex);
    $("#input_age").val(obj.age);
    $("#input_method").val(obj.method);
    $("#input_checkres").val(obj.checkres);
    $("#input_checkperson").val(obj.checkperson);
    if(obj.checkdate==null){
        $("#input_checkdate").val(timeinput((new Date()).valueOf()));
    }else{
        $("#input_checkdate").val(obj.checkdate.replace(' ',"T"));
    }

    if(obj.method!=null && obj.method =="PCR" && obj.checkres!=null && obj.checkres =="阳性"){
        $("#input_illplace").val(null);
        $("#input_illsize").val(null);
        $("#input_illnum").val(null);
        $("#input_sqjqdcnum").val(obj.pcrSqjqdc);
        $("#input_dfjqdcnum").val(obj.pcrDfjqdc);
        $("#input_xljqdcnum").val(obj.pcrXljqdc);
        $("#div_sqjqdcnum").css("display","block");
        $("#div_dfjqdcnum").css("display","block");
        $("#div_xljqdcnum").css("display","block");
        $("#div_illplace").css("display","none");
        $("#div_illsize").css("display","none");
        $("#div_illnum").css("display","none");
    }
    if(obj.method!=null && obj.method =="视检触检" && obj.checkres!=null && obj.checkres =="阳性"){
        $("#input_illplace").val(obj.eyeIllplace);
        $("#input_illsize").val(obj.eyeSize);
        $("#input_illnum").val(obj.eyeNum);
        $("#input_sqjqdcnum").val(null);
        $("#input_dfjqdcnum").val(null);
        $("#input_xljqdcnum").val(null);
        $("#div_sqjqdcnum").css("display","none");
        $("#div_dfjqdcnum").css("display","none");
        $("#div_xljqdcnum").css("display","none");
        $("#div_illplace").css("display","block");
        $("#div_illsize").css("display","block");
        $("#div_illnum").css("display","block");
    }
    $("#checkInfoDiv").modal('show');
}

