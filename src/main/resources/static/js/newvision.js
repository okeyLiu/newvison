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
                    "                                            <span class=\"pull-right\">" + timeago(comment.gmtCreate) + "</span>\n" +
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

function timeago(dateTimeStamp){   //dateTimeStamp是一个时间毫秒，注意时间戳是秒的形式，在这个毫秒的基础上除以1000，就是十位数的时间戳。13位数的都是时间毫秒。
    var minute = 1000 * 60;      //把分，时，天，周，半个月，一个月用毫秒表示
    var hour = minute * 60;
    var day = hour * 24;
    var week = day * 7;
    var halfamonth = day * 15;
    var month = day * 30;
    var now = new Date().getTime();   //获取当前时间毫秒
    console.log(now)
    var diffValue = now - dateTimeStamp;//时间差

    if(diffValue < 0){
        return;
    }
    var minC = diffValue/minute;  //计算时间差的分，时，天，周，月
    var hourC = diffValue/hour;
    var dayC = diffValue/day;
    var weekC = diffValue/week;
    var monthC = diffValue/month;
    if(monthC >= 1 && monthC <= 3){
        result = " " + parseInt(monthC) + "月前"
    }else if(weekC >= 1 && weekC <= 3){
        result = " " + parseInt(weekC) + "周前"
    }else if(dayC >= 1 && dayC <= 6){
        result = " " + parseInt(dayC) + "天前"
    }else if(hourC >= 1 && hourC <= 23){
        result = " " + parseInt(hourC) + "小时前"
    }else if(minC >= 1 && minC <= 59){
        result =" " + parseInt(minC) + "分钟前"
    }else if(diffValue >= 0 && diffValue <= minute){
        result = "刚刚"
    }else {
        var datetime = new Date();
        datetime.setTime(dateTimeStamp);
        var Nyear = datetime.getFullYear();
        var Nmonth = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
        var Ndate = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
        var Nhour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
        var Nminute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
        var Nsecond = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
        result = Nyear + "-" + Nmonth + "-" + Ndate
    }
    return result;
}