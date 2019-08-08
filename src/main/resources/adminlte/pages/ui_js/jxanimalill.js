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
    setDistrictSelectDisabled4(true);
    $.getJSON ("/aidog/adminlte/pages/ui_js/district.json", function (data)
    {
        datares = data;
        setDistrictSelectDisabled4(false);
        initSelDistrictCtrl4(datares);
    });
    var districtcode = "";
    var level = "";
    $("#select_province").on('change', function () {
        districtcode = $(this).find('option:selected').val();
        level = "province";
        var selectvalue = $(this).find('option:selected').val();
        if(selectvalue == "0"){
            level = "";
        }else{
            selectvalue = selectvalue.substring(0,2);
        }
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
    });

    $("#modalinput_bpersonillnum").blur(function () {
        if($("#modalinput_bpersonnum").val() == null || $("#modalinput_bpersonnum").val == ""){
            alert("请先输入家畜检查数量！");
        }else{
            if(parseInt($("#modalinput_bpersonillnum").val()) == 0){
                $("#modalinput_checklv").val(0);
            }else if(parseInt($("#modalinput_bpersonillnum").val()) > parseInt($("#modalinput_bpersonnum").val())){
                alert("家畜患病数大于检查数！");
            }else{
                $("#modalinput_checklv").val((($("#modalinput_bpersonillnum").val()*1.00/$("#modalinput_bpersonnum").val())*100).toFixed(2));
            }
        }
    });

    $("#a_illmodify").click(function () {
        var id = $('#illid').html();
        //修改录入信息
        var clicktype = "animalillmodify";
        var achecknum = $("#modalinput_bpersonnum").val();
        var aillnum = $("#modalinput_bpersonillnum").val();
        var ailllv = $("#modalinput_checklv").val();
        var acheckyear = $("#modalinput_pchechyear").val();

        var illsenddata = {};
        illsenddata.clicktype = clicktype;
        illsenddata.id = id;
        illsenddata.achecknum = achecknum;
        illsenddata.aillnum = aillnum;
        illsenddata.ailllv = ailllv;
        illsenddata.acheckyear = acheckyear;

        $.ajax({
            url: "/aidog/api/operateapi",
            type: "POST",
            data:  JSON.stringify(illsenddata),
            contentType: "application/json",
            dataType: "text",    // 控制回来的数据类型
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                data = eval("("+data+")");
                alert(data.msg);
                $("#illModifyDiv").modal('hide');

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
                    url:  "/aidog/api/getbillstalist",
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


                                data.data.data[i].achecknum = data.data.data[i].achecknum || 0;
                                data.data.data[i].aillnum = data.data.data[i].aillnum || 0;
                                data.data.data[i].ailllv = data.data.data[i].ailllv || 0;
                                data.data.data[i].acheckyear =  data.data.data[i].acheckyear || "--";
                                data.data.data[i].action = "<a href='javascript:void(0);'onclick='modifyIll("+ JSON.stringify(data.data.data[i]) + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 基线数据录入</a>";
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

    $("#a_getillstalist").click(function () {
        var senddata = {};
        senddata.startitem = 1;
        senddata.pagesize = 100000;
        senddata.districtcode = districtcode;
        senddata.level = level;
        $.ajax({
            url:  "/aidog/api/getbillstalist",
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
                        data.data.data[i].achecknum = data.data.data[i].achecknum || 0;
                        data.data.data[i].aillnum = data.data.data[i].aillnum || 0;
                        data.data.data[i].ailllv = data.data.data[i].ailllv || 0;
                        data.data.data[i].acheckyear =  data.data.data[i].acheckyear || "--";
                        data.data.data[i].action = "<a href='javascript:void(0);'onclick='modifyIll("+ JSON.stringify(data.data.data[i]) + ")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 基线数据录入</a>";
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
                            { "data": "districtName","width":"125px"  },
                            { "data": "achecknum","width":"85px"},
                            { "data": "aillnum","width":"75px" },
                            { "data": "ailllv","width":"70px" },
                            { "data": "acheckyear" ,"width":"60px"},
                            { "data": "action" ,"width":"85px"}
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

function modifyIll(obj) {

    $('#illid').html(obj.id);
    $("#modalinput_districtname").val(obj.districtName);
    $("#modalinput_bpersonnum").val(obj.achecknum);
    $("#modalinput_bpersonillnum").val(obj.aillnum);
    $("#modalinput_checklv").val(obj.ailllv);
    $("#modalinput_pchechyear").val(obj.acheckyear);
    $("#illModifyDiv").modal('show');
}

