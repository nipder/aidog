/**
 * Created by 03010335 on 2018/8/22.
 */
var viewdata;
var checkuserid;
$(function () {
    var senddata = {};
    // senddata.startitem = 1;
    // senddata.pagesize = 10;
    $.ajax({
        url: "/aidog/api/getunderuserlist",
        method: "GET",
        data: senddata,
        beforeSend: function(request) {
            request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
        },
        success: function (data) {
            if (data.data == null) {
                alert(data.msg);
                return;
            }else{
                for(var i = 0;i<data.data.length;i++){
                    data.data[i].register_time = timetrans(data.data[i].register_time).replace('T'," ");
                    data.data[i].manager_status = data.data[i].manager_status==0?"未激活":"已激活";
                    data.data[i].action = "<a href='javascript:void(0);'onclick='activeUser(\""+ data.data[i].manager_id + "\")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 激活</a>&nbsp;&nbsp;<a href='javascript:void(0);'onclick='freezeUser(\""+ data.data[i].manager_id + "\")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 冻结</a>&nbsp;&nbsp;<a href='javascript:void(0);'onclick='pwdReset(\""+ data.data[i].manager_id + "\")'  class='down btn btn-default btn-xs'><i class='fa fa-arrow-down'></i> 密码重置</a>";
                }
                viewdata = $.extend(true,[],data.data);
                var dt = $('#datatable').DataTable({
                    data: data.data,
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
                        { "data": "id","width":"58px"},
                        { "data": "username","width":"105px" },
                        { "data": "manager_name","width":"100px"  },
                        { "data": "register_time","width":"130px"},
                        { "data": "manager_tel","width":"130px" },
                        { "data": "manager_status","width":"58px" },
                        { "data": "action" ,"width":"150px"}
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


    function format ( index ) {
        return '所属地址: '+viewdata[index].addr+'';
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

function activeUser(id) {
    var tempdata = {};
    tempdata.managerid = id;
    tempdata.flag = 1;
    $.ajax({
        url: '/aidog/api/activeorfreezeuser',
        method: "POST",
        data: tempdata,
        beforeSend: function(request) {
            request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
        },
        success:function(data){
            alert(data.msg);
            window.location.reload();
        }
    });
}

function freezeUser(id) {
    var tempdata = {};
    tempdata.managerid = id;
    tempdata.flag = 0;
    $.ajax({
        url: '/aidog/api/activeorfreezeuser',
        method: "POST",
        data: tempdata,
        beforeSend: function(request) {
            request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
        },
        success:function(data){
            alert(data.msg);
            window.location.reload();
        }
    });
}

function pwdReset(id) {
    var tempdata = {};
    tempdata.managerid = id;
    tempdata.flag = 2;
    $.ajax({
        url: '/aidog/api/activeorfreezeuser',
        method: "POST",
        data: tempdata,
        beforeSend: function(request) {
            request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
        },
        success:function(data){
            alert(data.msg);
            window.location.reload();
        }
    });
}
