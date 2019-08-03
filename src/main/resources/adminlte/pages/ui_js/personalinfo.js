$(function () {
    $.ajax({
        url: "/aidog/api/getuserinfo",
        method: "GET",
        beforeSend: function(request) {
            request.setRequestHeader("token", window.localStorage.getItem("aidog_token"));
        },
        success: function (data) {
            data = eval("(" + data.data + ")");
            //个人信息
            $("#loginuser").html(data.managerName);
            $("#userworkplace").html(data.workplace);
            $("#input_managername").val(data.managerName);
            $("#input_managerjob").val(data.workplace);
            $("#input_manageridentity").val(data.managerIdentity);
            $("#input_officecall").val(data.officetel);
            $("#input_managertel").val(data.managerTel);
            $("#input_manageraddress").val(data.managerAddr);
            $("#input_email").val(data.managerEmail);
            $("#input_username").val(data.username);
            $("#input_password").val(data.password);
            switch (data.privilegelevel)
            {
                case 1:
                    $("#input_managerarea").val("全国");
                    break;
                case 2:
                    $("#input_managerarea").val(data.province);

                    break;
                case 3:
                    $("#input_managerarea").val(data.province + data.city);
                    break;
                case 4:
                    $("#input_managerarea").val(data.province + data.city + data.county);

                    break;
                case 5:
                    $("#input_managerarea").val(data.province + data.city + data.county + data.village);

                    break;
                case 6:
                    $("#input_managerarea").val(data.province + data.city + data.county + data.village + data.hamlet);
                    break;
                case 7:
                    $("#input_managerarea").val("游客模式");
                    break;
            }
        }
    })

    $("#btn_modify").click(function () {
        var senddata = {};
        senddata.managername = $("#input_managername").val();
        senddata.managerarea = $("#input_managerarea").val();
        senddata.managerjob = $("#input_managerjob").val();
        senddata.manageridentity = $("#input_manageridentity").val();
        senddata.officecall = $("#input_officecall").val();
        senddata.managertel = $("#input_managertel").val();
        senddata.manageraddress = $("#input_manageraddress").val();
        senddata.email = $("#input_email").val();
        senddata.username = $("#input_username").val();
        senddata.password = $("#input_password").val();
        senddata.clicktype = "modifyself";
        $.ajax({
            url: "/aidog/api/modifypersonalinfo",
            type: "POST",
            data: JSON.stringify(senddata),
            contentType: "application/json",   // 控制去的数据类型
            dataType: "text",    // 控制回来的数据类型
            success: function (data) {
                alert(data);
                if(data == "修改成功！"){
                    $("#loginuser").html($("#input_managername").val());
                    $("#userworkplace").html($("#input_managerjob").val());
                }
            }
        })
    });
})