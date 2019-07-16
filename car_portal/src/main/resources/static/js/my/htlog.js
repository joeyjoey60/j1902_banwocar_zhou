$("#btn_log").click(function () {

    var username=$("#iuname").val();
    var password=$("#ipwd").val();
   var verifycode= $("#ivc").val();
  // alert(username+password+verifycode);
    var args={"username":username,"password":password,"verifycode":verifycode};
    $.ajax({
        url: "/user/login",
        data: args,
        type: "post",
        success: function (data) {
            alert(data);
            if(data == "登录成功") {
                location.href = "htindex";
               // alert("ccccc");
            }
        }
    });
});