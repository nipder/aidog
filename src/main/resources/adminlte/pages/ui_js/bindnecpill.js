var necid = "";
var viewdata;
$(function () {
    var datares = {};
    var hamletcode = "";
    setDistrictSelectDisabled(true);
    $.getJSON ("/aidog/adminlte/pages/ui_js/district.json", function (data)
    {
        datares = data;
        setDistrictSelectDisabled(false);
        initSelDistrictCtrl(datares);
        if(g_privilegelevel==6){
            hamletcode = $('#select_hamlet').find('option:selected').val();

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
                        viewdata = $.extend(true, [], data.data.data);
                        for (var i = viewdata.length - 1; i >= 0; i--) {
                            viewdata[i].check = "<input name='check' id='\"" + viewdata[i].necId + "\"' class=\"checkbox neccheck\" type=\"checkbox\" />";
                            if (viewdata[i]. == "-1") {
                                viewdata.splice(i, 1);
                            }
                        }
                    }
                }
            })
        }
    });

    function getpilllist(){
        var senddata = {};
        senddata.startitem = 1;
        senddata.pagesize = 100000;
        senddata.districtcode = "";
        senddata.level = "";
        $.ajax({
            url:  "/aidog/api/getpilllist",
            type: "POST",
            data:  senddata,
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                var select_pill = document.getElementById("select_pill");
                var pillarray = objToArray(data.data.data);
                if(pillarray && pillarray.length>0) {
                    for (var i = 0; i < pillarray.length; i++) {
                        //遍历后台传回的结果，一项项往select中添加option
                        select_pill.options.add(new Option(pillarray[i].pillCode + " " + pillarray[i].pillName, pillarray[i].pillCode));
                    }
                }
            }
        })
    };

    getpilllist();
    
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
    });
    $("#select_county").on('change', function () {
        var selectvalue = $(this).find('option:selected').val();
        selectvalue = selectvalue.substring(0, 6);
        var select_village = document.getElementById("select_village");
        FillVillageCmd(datares.data3, select_village, selectvalue);
        var select_hamlet = document.getElementById("select_hamlet");
        FillHamletCmd(datares.data4, select_hamlet);        
    });
    $("#select_village").on('change', function () {
        var selectvalue = $(this).find('option:selected').val();
        selectvalue = selectvalue.substring(0, 9);
        var select_hamlet = document.getElementById("select_hamlet");
        FillHamletCmd(datares.data4, select_hamlet, selectvalue);        
    });

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
                    viewdata = $.extend(true, [], data.data.data);
                    for (var i = viewdata.length - 1; i >= 0; i--) {
                        viewdata[i].check = "<input name='check' id='\"" + viewdata[i].necId + "\"' class=\"checkbox neccheck\" type=\"checkbox\" />";
                        if (viewdata[i].necId == "-1") {
                            viewdata.splice(i, 1);
                        }
                    }
                }
            }
        })
    });


    //日历控件
    $("#input_lay").val(timeinput((new Date()).valueOf()));

    $("#batchnec").click(function () {
        $("#doglist").modal('show');
        $("#doglist").on("shown.bs.modal", function () {
            var dt = $('#datatable').DataTable({
                data: viewdata,
                "jQueryUI": true,
                'paging': false,
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

    $("#a_bindnecpill").click(function () {
        var necids = $("#selectnecs").html();
        if (necids == "" || necids == null) {
            alert("请先批量获取项圈！");
            return;
        }
        if(!pill_code || pill_code == ""){
            alert("请选择药饵！");
            return;
        }
        if(configtime == "2017-06-30T00:00"){
            alert("请输入配对时间！");
            return;
        }
        configtime = $("#input_lay").val()+":00";

        var data = {};
        data.mids = necids.substring(0, necids.length - 1);
        data.pill_code = pill_code;
        data.configtime = configtime;
        $.ajax({
            url: "/aidog/api/batchnecpillbind",
            type: "POST",
            dataType : "json",
            contentType: "application/json;charset=utf-8",
            data:  JSON.stringify(data),
            beforeSend: function (request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
            success: function (data) {
                alert(data.msg);
            }
        });
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

function timeinput(date){
    var date = new Date(date);
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + 'T';
    var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
    var m = (date.getMinutes() <10 ? '0' + date.getMinutes() : date.getMinutes());
    return Y+M+D+h+m;
}

function objToArray(array) {
    var arr = []
    for (var i in array) {
        arr.push(array[i]);
    }
    return arr;
}