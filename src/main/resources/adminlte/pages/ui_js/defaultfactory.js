var necid = "";
var viewdata;
$(function () {
    //Initialize Select2 Elements
    //            $(".select2").select2();
    var datares = {};
    //            $.ajax({
    //                url: "/aidog/api/register/4",
    //                async: false,
    //                type: "GET",
    //                success: function (data) {
    //                    datares = eval("(" + data + ")");
    //                }
    //            });
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
        // if ($('#modalselect_adminlevel').find('option:selected').text() != "省级") {
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
        var senddata = {};
        senddata.startitem = 1;
        senddata.pagesize = 100000;
        senddata.districtcode = hamletcode;
        senddata.level = "hamlet";

        $.ajax({
            url: "/aidog/api/getdoglist",
            type: "POST",
            data: senddata,
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                if (data.data.data == null) {
                    alert(data.data.msg);
                    return;
                }
                else {
                    //                            var select_necklet = document.getElementById("select_necklet");
                    viewdata = $.extend(true, [], data.data.data);
                    for (var i = viewdata.length - 1; i >= 0; i--) {
                        //                                if(data.data.data[i].necId!="-1"){
                        //                                    //遍历后台传回的结果，一项项往select中添加option
                        //                                    select_necklet.options.add(new Option(data.data.data[i].necId, data.data.data[i].dogId));

                        //                                }
                        viewdata[i].check = "<input name='check' id='\"" + viewdata[i].necId + "\"' class=\"checkbox neccheck\" type=\"checkbox\" />";
                        if (viewdata[i].necId == "-1") {
                            viewdata.splice(i, 1);
                        }
                    }
                }
            }
        })
    })

    $("#batchnec").click(function () {
        $("#doglist").modal('show');
        $("#doglist").on("shown.bs.modal", function () {
            var dt = $('#datatable').DataTable({
                data: viewdata,
                "jQueryUI": true,
                'paging': true,
                lengthMenu: [　//显示几条数据设置
                    [10, 20, 30, 50, -1],
                    ['10 条', '20 条', '30条', '50 条', '全部']
                ],
                'searching': true,
                'ordering': true,
                "pageLength": 10, //每行显示记录数
                'info': true,
                'bAutoWidth': false,
                "responsive": false,
                //允许重建
                "destroy": true,
                "scrollX": true,
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
                "scrollY": "200px",
                "dom": 'Bfrtip',
                "processing": true,
                "columns": [
                    {
                        "class": "details-control",
                        "orderable": false,
                        "data": "check",
                        "defaultContent": "",
                        "width": "1px"
                    },
                    { "data": "ownerName", "width": "60px" },
                    { "data": "dogName", "width": "60px" },
                    { "data": "dogGovcode", "width": "70px" },
                    { "data": "necId", "width": "70px" }
                ]
            });
            //                    $('#tbody').on( 'click', 'tr td.details-control', function () {
            //                        var tr = $(this).closest('tr');
            //                        var row = dt.row( tr );
            //                        var idx = $.inArray( tr.attr('id'), detailRows );
            //
            //                        if ( row.child.isShown() ) {
            //                            tr.removeClass( 'details' );
            //                            row.child.hide();
            //
            //                            // Remove from the 'open' array
            //                            detailRows.splice( idx, 1 );
            //                        }
            //                        else {
            //                            tr.addClass( 'details' );
            //                            row.child( format( row.index() ) ).show();
            //
            //                            // Add to the 'open' array
            //                            if ( idx === -1 ) {
            //                                detailRows.push( tr.attr('id') );
            //                            }
            //                        }
            //                    });
        });

    });

    //页面上点击此属性，将当前页的列表数据全部选中
    $('.select-all').on('click', function () {
        if (this.checked) {
            $('.checkbox.neccheck').each(function () {
                this.checked = true;
            });
        } else {
            $('.checkbox.neccheck').each(function () {
                this.checked = false;
            });
        }
    });

    $("#a_thirtyday").click(function () {
        var date = fixDate($("#input_lay").val());
        var date1 = new Date(date);
        var date2 = new Date(date);
        var date3 = new Date(date);
        var date4 = new Date(date);
        var date5 = new Date(date);
        var date6 = new Date(date);
        var date7 = new Date(date);
        var date8 = new Date(date);
        var date9 = new Date(date);
        var date10 = new Date(date);
        var date11 = new Date(date);
        var date12 = new Date(date);
        date1.setDate(date.getDate());
        date2.setDate(date.getDate() + 30);
        date3.setDate(date.getDate() + 60);
        date4.setDate(date.getDate() + 90);
        date5.setDate(date.getDate() + 120);
        date6.setDate(date.getDate() + 150);
        date7.setDate(date.getDate() + 180);
        date8.setDate(date.getDate() + 210);
        date9.setDate(date.getDate() + 240);
        date10.setDate(date.getDate() + 270);
        date11.setDate(date.getDate() + 300);
        date12.setDate(date.getDate() + 330);
        $("#input_lay1").val((timetrans(date1)));
        $("#input_lay2").val((timetrans(date2)));
        $("#input_lay3").val((timetrans(date3)));
        $("#input_lay4").val((timetrans(date4)));
        $("#input_lay5").val((timetrans(date5)));
        $("#input_lay6").val((timetrans(date6)));
        $("#input_lay7").val((timetrans(date7)));
        $("#input_lay8").val((timetrans(date8)));
        $("#input_lay9").val((timetrans(date9)));
        $("#input_lay10").val((timetrans(date10)));
        $("#input_lay11").val((timetrans(date11)));
        $("#input_lay12").val((timetrans(date12)));
    });

    $("#a_sixtyday").click(function () {
        var date = fixDate($("#input_lay").val());
        var date1 = new Date(date);
        var date2 = new Date(date);
        var date3 = new Date(date);
        var date4 = new Date(date);
        var date5 = new Date(date);
        var date6 = new Date(date);
        var date7 = new Date(date);
        var date8 = new Date(date);
        var date9 = new Date(date);
        var date10 = new Date(date);
        var date11 = new Date(date);
        var date12 = new Date(date);
        date1.setDate(date.getDate());
        date2.setDate(date.getDate() + 60);
        date3.setDate(date.getDate() + 120);
        date4.setDate(date.getDate() + 180);
        date5.setDate(date.getDate() + 240);
        date6.setDate(date.getDate() + 300);
        date7.setDate(date.getDate() + 360);
        date8.setDate(date.getDate() + 420);
        date9.setDate(date.getDate() + 480);
        date10.setDate(date.getDate() + 540);
        date11.setDate(date.getDate() + 600);
        date12.setDate(date.getDate() + 660);
        $("#input_lay1").val((timetrans(date1)));
        $("#input_lay2").val((timetrans(date2)));
        $("#input_lay3").val((timetrans(date3)));
        $("#input_lay4").val((timetrans(date4)));
        $("#input_lay5").val((timetrans(date5)));
        $("#input_lay6").val((timetrans(date6)));
        $("#input_lay7").val((timetrans(date7)));
        $("#input_lay8").val((timetrans(date8)));
        $("#input_lay9").val((timetrans(date9)));
        $("#input_lay10").val((timetrans(date10)));
        $("#input_lay11").val((timetrans(date11)));
        $("#input_lay12").val((timetrans(date12)));
    });

    $("#a_ninetyday").click(function () {
        var date = fixDate($("#input_lay").val());
        var date1 = new Date(date);
        var date2 = new Date(date);
        var date3 = new Date(date);
        var date4 = new Date(date);
        var date5 = new Date(date);
        var date6 = new Date(date);
        var date7 = new Date(date);
        var date8 = new Date(date);
        var date9 = new Date(date);
        var date10 = new Date(date);
        var date11 = new Date(date);
        var date12 = new Date(date);
        date1.setDate(date.getDate());
        date2.setDate(date.getDate() + 90);
        date3.setDate(date.getDate() + 180);
        date4.setDate(date.getDate() + 270);
        date5.setDate(date.getDate() + 360);
        date6.setDate(date.getDate() + 450);
        date7.setDate(date.getDate() + 540);
        date8.setDate(date.getDate() + 630);
        date9.setDate(date.getDate() + 720);
        date10.setDate(date.getDate() + 810);
        date11.setDate(date.getDate() + 900);
        date12.setDate(date.getDate() + 990);
        $("#input_lay1").val((timetrans(date1)));
        $("#input_lay2").val((timetrans(date2)));
        $("#input_lay3").val((timetrans(date3)));
        $("#input_lay4").val((timetrans(date4)));
        $("#input_lay5").val((timetrans(date5)));
        $("#input_lay6").val((timetrans(date6)));
        $("#input_lay7").val((timetrans(date7)));
        $("#input_lay8").val((timetrans(date8)));
        $("#input_lay9").val((timetrans(date9)));
        $("#input_lay10").val((timetrans(date10)));
        $("#input_lay11").val((timetrans(date11)));
        $("#input_lay12").val((timetrans(date12)));
    });

    $("#a_180day").click(function () {
        var date = fixDate($("#input_lay").val());
        var date1 = new Date(date);
        var date2 = new Date(date);
        var date3 = new Date(date);
        var date4 = new Date(date);
        var date5 = new Date(date);
        var date6 = new Date(date);
        var date7 = new Date(date);
        var date8 = new Date(date);
        var date9 = new Date(date);
        var date10 = new Date(date);
        var date11 = new Date(date);
        var date12 = new Date(date);
        date1.setDate(date.getDate());
        date2.setDate(date.getDate() + 180);
        date3.setDate(date.getDate() + 360);
        date4.setDate(date.getDate() + 540);
        date5.setDate(date.getDate() + 720);
        date6.setDate(date.getDate() + 900);
        date7.setDate(date.getDate() + 1080);
        date8.setDate(date.getDate() + 1260);
        date9.setDate(date.getDate() + 1440);
        date10.setDate(date.getDate() + 1620);
        date11.setDate(date.getDate() + 1800);
        date12.setDate(date.getDate() + 1980);
        $("#input_lay1").val((timetrans(date1)));
        $("#input_lay2").val((timetrans(date2)));
        $("#input_lay3").val((timetrans(date3)));
        $("#input_lay4").val((timetrans(date4)));
        $("#input_lay5").val((timetrans(date5)));
        $("#input_lay6").val((timetrans(date6)));
        $("#input_lay7").val((timetrans(date7)));
        $("#input_lay8").val((timetrans(date8)));
        $("#input_lay9").val((timetrans(date9)));
        $("#input_lay10").val((timetrans(date10)));
        $("#input_lay11").val((timetrans(date11)));
        $("#input_lay12").val((timetrans(date12)));
    });

    $("#a_setday").click(function () {
        //                var date = new Date($("#input_lay").val());
        var date = fixDate($("#input_lay").val());
        $("#input_lay1").val(timetrans(date));
        $("#input_lay2").val(timetrans(addMouthHandle(date, 1)));
        $("#input_lay3").val(timetrans(addMouthHandle(date, 2)));
        $("#input_lay4").val(timetrans(addMouthHandle(date, 3)));
        $("#input_lay5").val(timetrans(addMouthHandle(date, 4)));
        $("#input_lay6").val(timetrans(addMouthHandle(date, 5)));
        $("#input_lay7").val(timetrans(addMouthHandle(date, 6)));
        $("#input_lay8").val(timetrans(addMouthHandle(date, 7)));
        $("#input_lay9").val(timetrans(addMouthHandle(date, 8)));
        $("#input_lay10").val(timetrans(addMouthHandle(date, 9)));
        $("#input_lay11").val(timetrans(addMouthHandle(date, 10)));
        $("#input_lay12").val(timetrans(addMouthHandle(date, 11)));
    });

    function addMouthHandle(date, addnum) {
        var nowDate = addMonth(addnum);

        function addMonth(addMonth) {
            var y = date.getFullYear();
            var m = date.getMonth();
            var nextY = y;
            var nextM = m;
            //如果当前月+要加上的月>11 这里之所以用11是因为 js的月份从0开始
            if ((m + addMonth) > 11) {
                nextY = y + 1;
                nextM = parseInt(m + addMonth) - 12;
            } else {
                nextM = date.getMonth() + addMonth
            }
            var daysInNextMonth = daysInMonth(nextY, nextM);
            var day = date.getDate();
            if (day > daysInNextMonth) {
                day = daysInNextMonth;
            }
            var dayh = date.getHours()
            var daym = date.getMinutes()
            var days = date.getSeconds()
            return new Date(nextY, nextM, day, dayh, daym, days);
        };
        function daysInMonth(year, month) {
            if (month == 1) {
                if (year % 4 == 0 && year % 100 != 0)
                    return 29;
                else
                    return 28;
            } else if ((month <= 6 && month % 2 == 0) || (month = 6 && month % 2 == 1))
                return 31;
            else
                return 30;
        };
        return nowDate;
    }


    $("#a_timesconfig").click(function () {
        var necids = $("#selectnecs").html();
        if (necids == "" || necids == null) {
            alert("请先批量获取项圈！");
            return;
        }
        if($("#input_basetimes").val()>60 || $("#input_basetimes").val()<20 || $("#input_gpstimes").val()>120 || $("#input_gpstimes").val()<60){
            alert("定位时间填写有误！");
            return;
        }
        if($("#input_areacycle").val() == ""){
            alert("请填写反馈周期！");
            return;
        }
        var mid = "mid=" + necids.substring(0, necids.length - 1) + "&";
        var bastimes = "bastimes=" + $("#input_basetimes").val()+"&";
        var gpstimes = "gpstimes=" + ($("#input_gpstimes").val())+"&";
        var infoupdatecycle = "infoupdatecycle=" + $("#input_areacycle").val();
        var senddata = mid + bastimes + gpstimes + infoupdatecycle;
        $.ajax({
            url: "/aidog/api/setdeviceconfigbynecid",
            method: "POST",
            data: senddata,
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                } else {
                    alert(data.msg);
                }
            }
        })
    });

    $("#a_zeroconfig").click(function () {
        var necids = $("#selectnecs").html();
        if (necids == "" || necids == null) {
            alert("请先批量获取项圈！");
            return;
        }
        if($("#input_areacycle").val() == ""){
            alert("请填写反馈周期！");
            return;
        }
        var necid = "necid=" + necids.substring(0, necids.length - 1) + "&";
        var one1 = new Date($("#input_lay1").val()).valueOf();
        var two2 = new Date($("#input_lay2").val()).valueOf();
        var three3 = new Date($("#input_lay3").val()).valueOf();
        var four4 = new Date($("#input_lay4").val()).valueOf();
        var five5 = new Date($("#input_lay5").val()).valueOf();
        var six6 = new Date($("#input_lay6").val()).valueOf();
        var seven7 = new Date($("#input_lay7").val()).valueOf();
        var eight8 = new Date($("#input_lay8").val()).valueOf();
        var nine9 = new Date($("#input_lay9").val()).valueOf();
        var ten10 = new Date($("#input_lay10").val()).valueOf();
        var eleven11 = new Date($("#input_lay11").val()).valueOf();
        var twelve12 = new Date($("#input_lay12").val()).valueOf();
        var areacycle = $("#input_areacycle").val() == "" ? 60 : $("#input_areacycle").val();
        areacycle = "areacycle=" + areacycle;
        if (twelve12 >= eleven11 && eleven11 > ten10 && ten10 >= nine9 && nine9 >= eight8 && eight8 >= seven7
            && seven7 >= six6 && six6 >= five5 && five5 >= four4 && four4 >= three3 && three3 >= two2 && two2 >= one1) {
            var one = "one=" + $("#input_lay1").val() + ":00&";
            var two = "two=" + $("#input_lay2").val() + ":00&";
            var three = "three=" + $("#input_lay3").val() + ":00&";
            var four = "four=" + $("#input_lay4").val() + ":00&";
            var five = "five=" + $("#input_lay5").val() + ":00&";
            var six = "six=" + $("#input_lay6").val() + ":00&";
            var seven = "seven=" + $("#input_lay7").val() + ":00&";
            var eight = "eight=" + $("#input_lay8").val() + ":00&";
            var nine = "nine=" + $("#input_lay9").val() + ":00&";
            var ten = "ten=" + $("#input_lay10").val() + ":00&";
            var eleven = "eleven=" + $("#input_lay11").val() + ":00&";
            var twelve = "twelve=" + $("#input_lay12").val() + ":00&";
            var senddata = necid + one + two + three + four + five + six + seven + eight + nine + ten + eleven + twelve + areacycle;
            $.ajax({
                url: "/aidog/api/zeroconfig",
                method: "POST",
                data: senddata,
                beforeSend: function (request) {
                    request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
                },
                success: function (data) {
                    if (data.data == null) {
                        alert("清零失败，该项圈不存在！");
                        return;
                    } else {
                        alert(data.msg);
                    }
                }
            })
        } else {
            alert("时间设置有误！后投药时间应在前一次投药时间之后！");
        }
    });

    function getDogInfo() {
        $.ajax({
            url: "/aidog/api/dosingtimeconfig",
            method: "POST",
            data: senddata,
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                if (data.data != null) {
                    //牧犬信息
                    alert(data.data.msg);
                }
            }
        })
    }
});

function choosedog() {
    var neccheck = $('.neccheck');
    var arr = []
    var spanarr = "";
    neccheck.map(function (item) {
        if (neccheck[item].checked) {
            arr.push(neccheck[item].id);
            spanarr += neccheck[item].id + "|";
        }
    })
    spanarr = spanarr.replace(/\"/g, "");
    $("#selectnecs").html(spanarr);
    $("#doglist").modal('hide');
}

function ChangeTimeFormat(logintime) {
    //	20170926084552 ---> 2017.09.26 08:45:52
    var year = logintime.substring(0, 4);
    var month = logintime.substring(4, 6);
    var day = logintime.substring(6, 8);
    var hour = logintime.substring(8, 10);
    var min = logintime.substring(10, 12);
    var sec = logintime.substring(12);
    return year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec;
}

function timetrans(date) {
    //    var date = new Date(date*1000);//如果date为13位不需要乘1000
    var date = new Date(date);
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + 'T';
    var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
    var m = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
    var s = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
    return Y + M + D + h + m + s;
}

function fixDate(strTime) {
    if (!strTime) {
        return '';
    }
    var tempDate = new Date(strTime + ':00+0800');
    if (tempDate == 'Invalid Date') {
        strTime = strTime.replace(/T/g, ' ');
        strTime = strTime.replace(/-/g, '/');
        //                strTime = strTime.replace(/\.\d+/, ' ');
        tempDate = new Date(strTime + ':00+0800');
    }
    return tempDate;
}