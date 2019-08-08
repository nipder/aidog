function setSessionUserInfo(userinfo){
	if(userinfo){
		sessionStorage.UserInfo = JSON.stringify(userinfo);		
	}
}

function getSessionUserInfo(){
	var UserInfo = null;
    if (sessionStorage.UserInfo) {
        UserInfo = JSON.parse(sessionStorage.UserInfo);
    }
    
    return UserInfo;
}

function ssessionUserLogout() {
    if (sessionStorage.UserInfo) {
        sessionStorage.removeItem("UserInfo");
    }
}

var dlvl0 = [
	{ districtname: "内蒙古自治区", districtcode: "150000000000" },
	{ districtname: "四川省", districtcode: "510000000000" },
	{ districtname: "云南省", districtcode: "530000000000" },
	{ districtname: "西藏自治区", districtcode: "540000000000" },
	{ districtname: "陕西省", districtcode: "610000000000" },
	{ districtname: "甘肃省", districtcode: "620000000000" },
	{ districtname: "青海省", districtcode: "630000000000" },
	{ districtname: "宁夏回族自治区", districtcode: "640000000000" },
	{ districtname: "新疆维吾尔族自治区", districtcode: "650000000000" },
	{ districtname: "建设兵团", districtcode: "660000000" }];

function setDistrictSelectDisabled(val){
	$('#select_province').attr("disabled",val);
	$('#select_city').attr("disabled",val);
	$('#select_county').attr("disabled",val);
	$('#select_village').attr("disabled",val);
	$('#select_hamlet').attr("disabled",val);
	$('#select_province').css({"backgroundColor": "#fff","cursor":"default"});
	$('#select_city').css({"backgroundColor": "#fff","cursor":"default"});
	$('#select_county').css({"backgroundColor": "#fff","cursor":"default"});
	$('#select_village').css({"backgroundColor": "#fff","cursor":"default"});
	$('#select_hamlet').css({"backgroundColor": "#fff","cursor":"default"});
}


var gUserInfo = null;
var g_privilegelevel = -1;
var g_districtcode = "0";
var g_level = "";

function initSelDistrictCtrl(datares){

	gUserInfo = getSessionUserInfo();
	g_privilegelevel = gUserInfo.privilegelevel;
	g_districtcode = gUserInfo.districtcode;

	var select_province = document.getElementById("select_province");
	FillProvinceCmd(dlvl0, select_province, g_privilegelevel>1 ? g_districtcode : "");
	var select_city = document.getElementById("select_city");
	FillCityCmd(datares.data1, select_city, g_privilegelevel>=2 ? g_districtcode.substring(0, 2) : "", g_privilegelevel>2 ? g_districtcode : "");
	var select_county = document.getElementById("select_county");
	FillCountyCmd(datares.data2, select_county, g_privilegelevel>=3 ? g_districtcode.substring(0, 4) : "", g_privilegelevel>3 ? g_districtcode : "");
	var select_village = document.getElementById("select_village");
	FillVillageCmd(datares.data3, select_village, g_privilegelevel>=4 ? g_districtcode.substring(0, 6) : "", g_privilegelevel>4 ? g_districtcode : "");
	var select_hamlet = document.getElementById("select_hamlet");
	FillHamletCmd(datares.data4, select_hamlet, g_privilegelevel>=5 ? g_districtcode.substring(0, 9) : "", g_privilegelevel>5 ? g_districtcode : "");

}

function setDistrictSelectDisabled4(val){
	$('#select_province').attr("disabled",val);
	$('#select_city').attr("disabled",val);
	$('#select_county').attr("disabled",val);
	$('#select_village').attr("disabled",val);

	$('#select_province').css({"backgroundColor": "#fff","cursor":"default"});
	$('#select_city').css({"backgroundColor": "#fff","cursor":"default"});
	$('#select_county').css({"backgroundColor": "#fff","cursor":"default"});
	$('#select_village').css({"backgroundColor": "#fff","cursor":"default"});

}

function initSelDistrictCtrl4(datares){
	gUserInfo = getSessionUserInfo();
	g_privilegelevel = gUserInfo.privilegelevel;
	g_districtcode = gUserInfo.districtcode;

	var select_province = document.getElementById("select_province");
	FillProvinceCmd(dlvl0, select_province, g_privilegelevel>1 ? g_districtcode : "");
	var select_city = document.getElementById("select_city");
	FillCityCmd(datares.data1, select_city, g_privilegelevel>=2 ? g_districtcode.substring(0, 2) : "", g_privilegelevel>2 ? g_districtcode : "");
	var select_county = document.getElementById("select_county");
	FillCountyCmd(datares.data2, select_county, g_privilegelevel>=3 ? g_districtcode.substring(0, 4) : "", g_privilegelevel>3 ? g_districtcode : "");
	var select_village = document.getElementById("select_village");
	FillVillageCmd(datares.data3, select_village, g_privilegelevel>=4 ? g_districtcode.substring(0, 6) : "", g_privilegelevel>4 ? g_districtcode : "");

}

function getSessionPrivilegelevel(){
	var lvl = -1;

	if (sessionStorage.UserInfo) {
		var UserInfo = JSON.parse(sessionStorage.UserInfo);
		if(UserInfo && UserInfo.privilegelevel){
			lvl = UserInfo.privilegelevel;
		}
	}

	return lvl;
}


// 填充省级下拉框，设置选中的省选项
function FillProvinceCmd(list, select_province, select_item){
	if(select_province) {
		var jq_select_province = $(select_province);
		if(!jq_select_province) return ;
		jq_select_province.find("option").remove();
		select_province.options.add(new Option("全国", "0"));
		g_level = "";
		if (list){
			var selVal = "";
			for (var i = 0; i < list.length; i++) {
				select_province.options.add(new Option(list[i].districtname, list[i].districtcode));
				if (select_item && select_item.length>0 && list[i].districtcode.toString().substring(0, 2) == select_item.substring(0, 2)){
					selVal = list[i].districtcode;
				}
			}
			if(selVal && selVal.length>0) {
				jq_select_province.val(selVal);
				jq_select_province.attr("disabled",true);
				jq_select_province.css({ "backgroundColor": "#eee", "cursor": "no-drop" });
				g_level = "province";
			}
		}
	}
}


// 根据省级选项，填充市级下拉框，设置选中的市选项
function FillCityCmd(list, select_city, pval, select_item){
	if(select_city){
		var jq_select_city = $(select_city);
		if(!jq_select_city) return ;
		jq_select_city.find("option").remove();
		select_city.options.add(new Option("请选择", "-1"));        
		if(pval && pval.length>0) g_level = "province";
		if(pval && pval.length>0){
			if(list) {
				var selVal = "";
				for (var i = 0; i < list.length; i++) {
					if (list[i].districtcode.toString().substring(0, 2) == pval) {
						//遍历后台传回的结果，一项项往select中添加option
						select_city.options.add(new Option(list[i].districtname, list[i].districtcode));
						if (select_item && select_item.length>0 && list[i].districtcode.toString().substring(0, 4) == select_item.substring(0, 4)){
							selVal = list[i].districtcode;
						}
					}
				}
				if(selVal && selVal.length>0) {
					jq_select_city.val(selVal);
					jq_select_city.attr("disabled",true);
					jq_select_city.css({ "backgroundColor": "#eee", "cursor": "no-drop" });
					g_level = "city";
				}
			}
		}
	}
}

// 根据市级选项，填充县级下拉框，设置选中的县选项
function FillCountyCmd(list, select_county, pval, select_item){
	if(select_county){
		var jq_select_county = $(select_county);
		if(!jq_select_county) return ;
		jq_select_county.find("option").remove();
		select_county.options.add(new Option("请选择", "-1"));
		if (pval && pval.length > 0) g_level = "city";
		if(pval && pval.length>0){
			if(list) {
				var selVal = "";
				for (var i = 0; i < list.length; i++) {
					if (list[i].districtcode.toString().substring(0, 4) == pval) {
						//遍历后台传回的结果，一项项往select中添加option
						select_county.options.add(new Option(list[i].districtname, list[i].districtcode));
						if (select_item && select_item.length>0 && list[i].districtcode.toString().substring(0, 6) == select_item.substring(0, 6)){
							selVal = list[i].districtcode;
						}
					}
				}
				if(selVal && selVal.length>0) {
					jq_select_county.val(selVal);
					jq_select_county.attr("disabled",true);
					jq_select_county.css({ "backgroundColor": "#eee", "cursor": "no-drop" });
					g_level = "county";
				}
			}
		}
	}
}

// 根据县级选项，填充乡级下拉框，设置选中的乡选项
function FillVillageCmd(list, select_village, pval, select_item){
	if(select_village){
		var jq_select_village = $(select_village);
		if(!jq_select_village) return ;
		jq_select_village.find("option").remove();
		select_village.options.add(new Option("请选择", "-1"));
		if (pval && pval.length > 0) g_level = "county";
		if(pval && pval.length>0){
			if(list) {
				var selVal = "";
				for (var i = 0; i < list.length; i++) {
					if (list[i].districtcode.toString().substring(0, 6) == pval) {
						//遍历后台传回的结果，一项项往select中添加option
						select_village.options.add(new Option(list[i].districtname, list[i].districtcode));
						if (select_item && select_item.length>0 && list[i].districtcode.toString().substring(0, 9) == select_item.substring(0, 9)){
							selVal = list[i].districtcode;
						}
					}
				}
				if(selVal && selVal.length>0) {
					jq_select_village.val(selVal);
					jq_select_village.attr("disabled",true);
					jq_select_village.css({ "backgroundColor": "#eee", "cursor": "no-drop" });
					g_level = "village";
				}
			}
		}
	}
}

// 根据乡级选项，填充村级下拉框，设置选中的村选项
function FillHamletCmd(list, select_hamlet, pval, select_item)
{
	if(select_hamlet){
		var jq_select_hamlet = $(select_hamlet);
		if(!jq_select_hamlet) return ;
		jq_select_hamlet.find("option").remove();
		select_hamlet.options.add(new Option("请选择", "-1"));
		if (pval && pval.length > 0) g_level = "village";
		if(pval && pval.length>0){
			if(list) {
				var selVal = "";
				for (var i = 0; i < list.length; i++) {
					if (list[i].districtcode.toString().substring(0, 9) == pval) {
						//遍历后台传回的结果，一项项往select中添加option
						select_hamlet.options.add(new Option(list[i].districtname, list[i].districtcode));
						if (select_item && select_item.length>0 && list[i].districtcode.toString()== select_item){
							selVal = list[i].districtcode;
						}
					}
				}
				if(selVal && selVal.length>0) {
					jq_select_hamlet.val(selVal);
					jq_select_hamlet.attr("disabled",true);
					jq_select_hamlet.css({ "backgroundColor": "#eee", "cursor": "no-drop" });
					g_level = "hamlet";
				}
			}
		}
	}
}