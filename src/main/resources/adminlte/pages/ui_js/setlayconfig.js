/**
 * 
 */
var neckletid = "";
$(function(){
	$("#search_neckletid").click(function(){
		$.ajax({
        	url: "/aidog/api/getlayconfigbynecid.do",
            method: "POST",
            data: "mid="+$("#in_necketid").val(),   //方法1
            success: function (data) {
            	if (data.data == null) {
            		alert(data.msg);
    	            return;
            	}else{
            		neckletid = data.data.mid;
            		$("#input_lay1").val((timetrans(data.data.one)));
            		$("#input_lay2").val((timetrans(data.data.two)));
            		$("#input_lay3").val((timetrans(data.data.three)));
            		$("#input_lay4").val((timetrans(data.data.four)));
            		$("#input_lay5").val((timetrans(data.data.five)));
            		$("#input_lay6").val((timetrans(data.data.six)));
            		$("#input_lay7").val((timetrans(data.data.seven)));
            		$("#input_lay8").val((timetrans(data.data.eight)));
            		$("#input_lay9").val((timetrans(data.data.nine)));
            		$("#input_lay10").val((timetrans(data.data.ten)));
            		$("#input_lay11").val((timetrans(data.data.eleven)));
            		$("#input_lay12").val((timetrans(data.data.twelve)));
            	}
            }
        })
	});
	
	$("#savelayconfig").click(function(){
		if(neckletid == ""){
			alert("请先查询获取项圈投药时间配置！");
			return;
		}
		var mid = "mid="+neckletid+"&";
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
		if(twelve12>=eleven11 && eleven11>ten10 && ten10>=nine9 && nine9>=eight8 && eight8>=seven7
				&& seven7>=six6 && six6>=five5 && five5>=four4 && four4>= three3 && three3>=two2 && two2>=one1){
			var one = "one=" + $("#input_lay1").val()+":00&";
			var two = "two=" + $("#input_lay2").val()+":00&";
			var three = "three=" + $("#input_lay3").val()+":00&";
			var four = "four=" +  $("#input_lay4").val()+":00&";
			var five = "five=" +  $("#input_lay5").val()+":00&";
			var six = "six=" + $("#input_lay6").val()+":00&";
			var seven = "seven=" + $("#input_lay7").val()+":00&";
			var eight = "eight=" + $("#input_lay8").val()+":00&";
			var nine = "nine=" +  $("#input_lay9").val()+":00&";
			var ten = "ten=" +  $("#input_lay10").val()+":00&";
			var eleven = "eleven=" +  $("#input_lay11").val()+":00&";
			var twelve = "twelve=" +  $("#input_lay12").val()+":00";
			var senddata = mid+one+two+three+four+five+six+seven+eight+nine+ten+eleven+twelve;
			$.ajax({
	        	url: "/sec/api/setlayconfigbynecid",
	            method: "POST",
	            data: senddata, 
	            success: function (data) {
	            	if (data.data == null) {
	            		alert("该项圈不存在！");
	    	            return;
	            	}else{
	            		alert(data.msg);
	            	}
	            }
	        })
		}else{
			alert("时间设置有误！后投药时间应在前一次投药时间之后！");
		}
	});
	
})

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