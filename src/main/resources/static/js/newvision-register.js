function showIconsWindow() {
    $("#iconsWindow").show();
}

function save(aLink) {
    var url = $(aLink).find("img").prop("src");
    $("[name='icon']").prop("value",url);
    $(".selected-image").prop("src",url);
    $("#iconsWindow").hide();
}