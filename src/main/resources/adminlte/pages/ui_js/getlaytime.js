$(function(){
	$("#search_neckletid").click(function(){
		if($("#in_necketid").val() == ""){
			alert("搜索内容不能为空");
			return;
		}
		var startitem = 1;
		var pagesize = 10000;
		var data = {};
		data.startitem = startitem;
		data.pagesize = pagesize;
		data.mid = $("#in_necketid").val();
		$.ajax({
			url: '/aidog/api/getlaytimebynecid',
			method: "POST",
			// data: "mid="+$("#in_necketid").val(),
			data: data,
            beforeSend: function(request) {
                request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
            },
			success:function(data){
				if(data.code == 500){
					alert("未找到指定项圈！")
					return;
				}
				for(var i=0;i<data.data.length;i++){
					data.data[i].updatetime = timetrans(data.data[i].updatetime);
					data.data[i].grantgmt = timetrans(data.data[i].grantgmt);
				}
				layui.use('table', function(){
				  var table = layui.table;
				  table.render({
				    elem: '#table1',
				    cellMinWidth: 90,
				    response:{  
				    	statusName: 'code' ,// 对应 code
				    	statusCode: 200,
				    	msgName: 'success'  , // 对应 msg  
				    	countName: 'total' , // 对应 count  
				    	dataName: 'data'  // 对应 data
			    	},
					cols: [[
						{field:'updatetime', sort: true,title: '反馈时间'},
				    	{field:'longitude',title: '经度'},
				    	{field:'latitude', title: '维度'},
				    	{field:'grantgmt',title: '上次投药时间'},
				    	{field:'voltage',title: '电压'},
				    	{field:'temperature',title: '温度'},
				    	{field:'type', sort: true, title: '投药类型'},
				    	{field:'islay', title: '是否投药反馈'},
				    	{field:'signallevel', title: '信号强度'},
				    	{field:'err', title: '错误信息'}
		    	    ]],
				    data: data.data,
			    	id: 'testReload1',
				    page:false, 
					skin: 'row', 
					even: true,
					height: 500
				  });
				});
			}
		})
	})
})

$(window).resize(function(){
	var footerHeight  = $('.main-footer').outerHeight() || 0;
	var windowHeight  = $(window).height();
	$('.content').css('min-height', windowHeight - footerHeight)
}).resize();

layui.use('element', function(){
	  var $ = layui.jquery,
	  element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块 
});

function timetrans(date){
//  var date = new Date(date*1000);//如果date为13位不需要乘1000
	var date = new Date(date);
  var Y = date.getFullYear() + '-';
  var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
  var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + ' ';
  var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
  var m = (date.getMinutes() <10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
  var s = (date.getSeconds() <10 ? '0' + date.getSeconds() : date.getSeconds());
  return Y+M+D+h+m+s;
}