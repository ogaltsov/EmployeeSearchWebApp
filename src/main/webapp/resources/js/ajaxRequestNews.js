var url = "http://localhost:8080/corpsite.com/news/getLastNewsList";
$(document).ready(function() {

        $.ajax({
            url: url
        }).then(function (data) {
            buildLatestNewsFlow(data.jsonArray);
            return false;
        });
});

function buildLatestNewsFlow(data) {
    var titleId = "#newsTitle";
    var textId = "#newsText"
    for(var i = 0; i<data.length; i++) {
        var titleIdMod = titleId;
        titleIdMod += i;
        $(titleIdMod).append(data[i].title);

        var textIdMod = textId;
        textIdMod += i;
        $(textIdMod).append(data[i].article);
    }
}