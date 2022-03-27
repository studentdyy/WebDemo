window.onload=function (){
    var btn = document.getElementsByClassName("btn");
}


function deleteFruit(uid){
    if(confirm('是否确认删除')){
        window.location.href="delete.do?uid=" + uid;
    }

}

function pageContext(pageNum){
    window.location.href="fruit?pageNum="+pageNum;
}