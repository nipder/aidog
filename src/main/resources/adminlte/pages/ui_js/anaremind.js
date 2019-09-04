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
    setDistrictSelectDisabled4(true);
    $.getJSON ("/aidog/adminlte/pages/ui_js/district.json", function (data)
    {
        datares = data;
        setDistrictSelectDisabled4(false);
        initSelDistrictCtrl4(datares);
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
    });

    $("#a_getdogstalist").click(function () {
        var senddata = {};
        senddata.startitem = 1;
        senddata.pagesize = 100000;
        // @chg zyj 2019.08.09 begin
        //senddata.districtcode = districtcode;
        //senddata.level = level;
        senddata.districtcode = districtcode == "0" ? "" : districtcode;
        senddata.level = districtcode == "0" ? "" : level;
        // @chg zyj 2019.08.09 end
        $.ajax({
            url:  "/aidog/api/getdogstalist",
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
                        data.data.data[i].necbadnum = 0;
                        data.data.data[i].necbadnumper = 0;
                        data.data.data[i].appbadnum = 0;
                        data.data.data[i].appbadnumper = 0;
                        data.data.data[i].allbadnum = 0;
                        data.data.data[i].allbadnumper = 0;
                    }
                    viewdata = $.extend(true,[],data.data.data);
                    var dt = $('#datatable').DataTable({
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
                            // {
                            //     "class":          "details-control",
                            //     "orderable":      false,
                            //     "data":           null,
                            //     "defaultContent": "",
                            //     "width": "1px"
                            // },
                            { "data": "countnum","width":"50px" },
                            { "data": "districtname","width":"130px"  },
                            { "data": "necdognum","width":"80px"},
                            { "data": "necbadnum","width":"120px" },
                            { "data": "necbadnumper","width":"120px" },
                            { "data": "appdognum" ,"width":"100px"},
                            { "data": "appbadnum" ,"width":"140px"},
                            { "data": "appbadnumper" ,"width":"120px"},
                            { "data": "allbadnum" ,"width":"90px"},
                            { "data": "allbadnumper" ,"width":"90px"}
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



