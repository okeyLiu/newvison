/**
 * 提交评论
 */
function ajaxPostSendComment() {
    var formObject = {};
    var formArray = $("#comment-form").serializeArray();
    $.each(formArray, function (i, item) {
        formObject[item.name] = item.value;
    });
    $.ajax({
        url: $("#comment-form").prop("action"),
        type: "post",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(formObject),
        dataType: "json",
        success: function (data) {
            if(data.code == 200){
                $("#comment-form").hide();
            }else{
                if (data.code == 2003) {
                    var isAccepted = confirm(data.message);
                    if(isAccepted){
                        window.open("http://localhost:8080/login");
                        window.localStorage.setItem("closable","true");
                    }
                }else{
                    alert(data.message);
                }
            }
        }
    });
}
