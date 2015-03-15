
function paginateAjax(path,link,nodeName){
$CQ.ajaxSetup({
xhrFields: {withCredentials: true}
});
$CQ.ajax(path+".html?"+link).done(
function(data) {
$CQ("#listId_"+nodeName).html($CQ(data));
});
}