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

function initSelDistrictCtrl(datares){
	var select_province = document.getElementById("select_province");
	FillProvinceCmd(dlvl0, select_province);
	var select_city = document.getElementById("select_city");
	FillCityCmd(datares.data1, select_city);
	var select_county = document.getElementById("select_county");
	FillCountyCmd(datares.data2, select_county);
	var select_village = document.getElementById("select_village");
	FillVillageCmd(datares.data3, select_village);
	var select_hamlet = document.getElementById("select_hamlet");
	FillHamletCmd(datares.data4, select_hamlet);
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
	var select_province = document.getElementById("select_province");
	FillProvinceCmd(dlvl0, select_province);
	var select_city = document.getElementById("select_city");
	FillCityCmd(datares.data1, select_city);
	var select_county = document.getElementById("select_county");
	FillCountyCmd(datares.data2, select_county);
	var select_village = document.getElementById("select_village");
	FillVillageCmd(datares.data3, select_village);
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

function FillProvinceCmd(list, select_province){
	if(select_province) {
		$(select_province).find("option").remove();
		select_province.options.add(new Option("全国", "0"));
		if (list){
			for (var i = 0; i < list.length; i++) {
				select_province.options.add(new Option(list[i].districtname, list[i].districtcode));
			}
		}
	}
}

function FillCityCmd(list, select_city, selectvalue){
	if(select_city){
		$(select_city).find("option").remove();
		select_city.options.add(new Option("请选择", "-1"));

		if(selectvalue && selectvalue.length>0){
			if(list) {
				for (var i = 0; i < list.length; i++) {
					if (list[i].districtcode.toString().substring(0, 2) == selectvalue) {
						//遍历后台传回的结果，一项项往select中添加option
						select_city.options.add(new Option(list[i].districtname, list[i].districtcode));
					}
				}
			}
		}
	}
}

function FillCountyCmd(list, select_county, selectvalue){
	if(select_county){
		$(select_county).find("option").remove();
		select_county.options.add(new Option("请选择", "-1"));

		if(selectvalue && selectvalue.length>0){
			if(list) {
				for (var i = 0; i < list.length; i++) {
					if (list[i].districtcode.toString().substring(0, 4) == selectvalue) {
						//遍历后台传回的结果，一项项往select中添加option
						select_county.options.add(new Option(list[i].districtname, list[i].districtcode));
					}
				}
			}
		}
	}
}

function FillVillageCmd(list, select_village, selectvalue){
	if(select_village){
		$(select_village).find("option").remove();
		select_village.options.add(new Option("请选择", "-1"));

		if(selectvalue && selectvalue.length>0){
			if(list) {
				for (var i = 0; i < list.length; i++) {
					if (list[i].districtcode.toString().substring(0, 6) == selectvalue) {
						//遍历后台传回的结果，一项项往select中添加option
						select_village.options.add(new Option(list[i].districtname, list[i].districtcode));
					}
				}
			}
		}
	}
}

function FillHamletCmd(list, select_hamlet, selectvalue){
	if(select_hamlet){
		$(select_hamlet).find("option").remove();
		select_hamlet.options.add(new Option("请选择", "-1"));

		if(selectvalue && selectvalue.length>0){
			if(list) {
				for (var i = 0; i < list.length; i++) {
					if (list[i].districtcode.toString().substring(0, 9) == selectvalue) {
						//遍历后台传回的结果，一项项往select中添加option
						select_hamlet.options.add(new Option(list[i].districtname, list[i].districtcode));
					}
				}
			}
		}
	}
}