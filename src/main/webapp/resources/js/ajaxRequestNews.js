var url = "http://localhost:8080/corpsite.com/news/getLastNewsList";
$(document).ready(function() {

        $.ajax({
            url: url
        }).then(function (data) {
            //console.log(data);
            buildLatestNewsFlow(data.jsonArray);
            return false;
        });
});

function buildLatestNewsFlow(data) {
    var titleId = "#newsTitle";
    var textId = "#newsText"
    // var element = document.getElementById('news') ;
    // var h3 = document.createElement('h3');
    // h3 = data.title;
    // element.parentNode.insertBefore(h3,null);
    for(var i = 0; i<data.length; i++) {
        var titleIdMod = titleId;
        titleIdMod += i;
        $(titleIdMod).append(data[i].title);

        var textIdMod = textId;
        textIdMod += i;
        $(textIdMod).append(data[i].article);
    }
    // var elen = "#newsTitle0";
    // var dat = $(elen).html();
    // $(elen).append(elen);
    // console.log(dat);
}