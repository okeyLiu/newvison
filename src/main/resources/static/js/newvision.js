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
            alert(data.message);
        },
        error: function (e) {
            alert("错误！！");
        }
    });
}
