var TYPE_QUESTION = 1;// 回复问题
var TYPE_COMMENT = 2;// 回复二级评论

/**
 * 提交评论
 */
function sendComment(targetId, type, content) {
    if (!content) {
        alert("不能回复空内容！！！");
        return;
    }
    $.ajax({
        url: "/comment",
        type: "post",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            "parentId": targetId,
            "type": type,
            "content": content
        }),
        dataType: "json",
        success: function (data) {
            console.log(data)
            if (data.code == 200) {
                window.location.reload();//重新刷新页面
            } else {
                if (data.code == 2003) {
                    var isAccepted = confirm(data.message);
                    if (isAccepted) {
                        window.open("http://localhost:8080/login");
                        window.localStorage.setItem("closable", "true");
                    }
                } else {
                    alert(data.message);
                }
            }
        }
    });
}

/**
 * 最底下的问题评论按钮
 */
function postQuestionComment() {
    var targetId = $("[name='questionId']").val();
    var content = $("[name='questionCommentContent']").val();
    sendComment(targetId, TYPE_QUESTION, content);
}

/**
 * 回复评论按钮(二级评论)
 */
function postReplyComment(e) {
    var id = e.getAttribute("data-id");
    var input = $("#input-" + id);
    sendComment(id, TYPE_COMMENT, $(input).val());
}

/**
 * 清空输入内容
 * @param e
 */
function cancelReply(e) {
    var id = e.getAttribute("data-id");
    var input = $("#input-" + id);
    input.val("");
}

function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var toggleClass = $(e).toggleClass("in");
    if(toggleClass.hasClass("in")){
        $.getJSON("http://localhost:8080/comment/" + id, function (data) {
            // 不需要循环数据的部分（头）
            var part1 = "<div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12 collapse in comment-sub-list-box\"\n" +
                "                                 id=\"comment-" + id + "\">\n";
            // 需要循环数据的部分
            var part2 = "";
            $.each(data.data, function (index, comment) {
                part2 +=
                    "                                <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12 comment-list-box comment-icon\">\n" +
                    "                                    <div class=\"media\">\n" +
                    "                                        <div class=\"media-left\">\n" +
                    "                                            <a href=\"javascript:;\">\n" +
                    "                                                <img class=\"media-object img-rounded media-icon\"\n" +
                    "                                                     src=\"" + comment.user.avatarUrl + "\">\n" +
                    "                                            </a>\n" +
                    "                                        </div>\n" +
                    "                                        <div class=\"media-body\">\n" +
                    "                                            <h4>" + comment.user.name + "</h4>\n" +
                    "                                            <div>" + comment.content + "</div>\n" +
                    "                                            <span class=\"pull-right\">" + comment.gmtCreate + "</span>\n" +
                    "                                        </div>\n" +
                    "                                    </div>\n" +
                    "                                </div>\n";
            });
            // 不需要循环数据的部分（尾）
            var part3 =
                "                                <input class=\"form-control\" type=\"input\" placeholder=\"评论\" id=\"input-" + id + "\">\n" +
                "                                <button type=\"button\" class=\"btn pull-right btn-comment\" onclick=\"cancelReply(this)\" data-id=\"" + id + "\">取消</button>\n" +
                "                                <button type=\"button\" class=\"btn btn-success pull-right btn-comment\" onclick=\"postReplyComment(this)\" data-id=\"" + id + "\">评论</button>\n" +
                "                            </div>";
            // 头+变化+尾 ==> 合并
            var template = part1 + part2 + part3;
            $("#comment-body-" + id).append(template);
        });
        $("#comment-" + id).addClass("in");// 显示块
    }else{
        $("#comment-" + id).remove();// 删除块
    }
}