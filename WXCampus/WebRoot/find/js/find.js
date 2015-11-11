/**
 * Created by ASUS on 2015/11/8.
 */
//搜索零食
function findFood(){
    var foodInfo=document.getElementById("foodInfo").value;
    var dataInfo=foodInfo;
    $.ajax(
        {
            url:url,
            dataType: "json",
            type: 'GET',
            data:dataInfo,
            success:backFoodList,
            error: function () {
                alert("error");
            }
        }
    );
}
//搜索成功，返回商品列表
function backFoodList(data){
    document.getElementById("bottom_center").innerHTML="";
    var foodList='';
    for(var i=0;i<data.itemList.length;i++){
        foodList+=' <div class="food_info">'+
                    '<div class="food_info_left">'+
                    '<img src="'+data.itemList[i].icon+'" style="width:10em;height:10em;margin-left:20px">'+
                    '</div>'+
                    '<div class="food_info_center">'+
                    '<p style="color: #843534;font-size: 2em;margin-left: 10px">'+data.itemList[i].iname+'</p>'+
                    '<p style="color: #843534;font-size: 2em;margin-left: 10px">'+data.itemList[i].resNum+'</p>'+
                    '<p style="color: #843534;font-size: 2em;margin-left: 10px">'+data.itemList[i].realPrice+'￥</p>'+
                    '</div>'+
                    '<div class="food_info_right" style="text-align: right">'+
                        '<p style="margin-top: 1em"><img src="image_find/save.png" style="width:3em;height: 3em;margin-right: 1em "></p>'+
                        '<p style="margin-top: 3em"><span><img src="image_find/add.png" style="width: 2.5em;height: 2.5em;float: right;margin-right: 1em"></span>'+
                        ' <span id="kuankuan">2</span>'+
                        '<span><img src="image_find/reduce.png" style="width: 2.5em;height: 2.5em;margin-right: 1em;float: right "></span></p>'+
                    '</div>'+
                    '</div>'+
                    '<HR style="float: left;width: 100%;height: 2px;color: #080808">';
    }
    $("#bottom_center").append(foodList);
}
/**
 * Created by ASUS on 2015/11/8.
 */
