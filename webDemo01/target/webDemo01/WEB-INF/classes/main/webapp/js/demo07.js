window.onload=function(){
	var fruitTbl = document.getElementById("tbl_fruit");
	var rows = fruitTbl.rows;
	for(var i = 1; i < rows.length - 1;i++){
		var tr = rows[i];
		tr.onmouseover=chargeBGColor;
		tr.onmouseout = cleanBGColor;
		var cells = tr.cells;
		var num = cells[2];
		num.onmouseover= showHand;
		num.onclick = updateNum;
		var intput= cells[4].firstChild;
		if(intput && intput.value=="删除"){
			intput.onclick=delCol;
		}
		updateZJ();
		
			
	}
}
function updateNum(){
	if(event && event.srcElement && event.srcElement.tagName =="TD" ){
		var priceTD = event.srcElement;
		if(priceTD.firstChild && priceTD.firstChild.nodeType == 3){
			var oldPrice= priceTD.innerText;
			priceTD.innerHTML="<input type='text' size ='4' />";
			var intput = priceTD.firstChild;
			if( intput.tagName=="INPUT"){
				intput.value=oldPrice; 
				intput.select();
				intput.onblur=updatePrice;
				
			}		
		}		
	}
}



function  chargeBGColor(){
	if(event && event.srcElement && event.srcElement.tagName =="TD"){
		var td = event.srcElement;
		var tr = td.parentElement;
		tr.style.backgroundColor="red";
		var tbs = tr.cells;
		for(var i = 0; i < tbs.length ; i++){
			tbs[i].style.color="white";
		}
	}

}

function cleanBGColor(){
	if(event && event.srcElement && event.srcElement.tagName =="TD"){
		var td = event.srcElement;
		var tr = td.parentElement;
		tr.style.backgroundColor="transparent";
		var tbs = tr.cells;
		for(var i = 0; i < tbs.length ; i++){
			tbs[i].style.color="black";
		}
	}
}

function showHand(){
	if(event && event.srcElement && event.srcElement.tagName=="TD"){
		var td = event.srcElement;
		td.style.cursor="hand";
	}
}
function delCol(){
	if(event && event.srcElement){
		var intput = event.srcElement;
		var tr= intput.parentElement.parentElement;
		var fruitTbl = document.getElementById("tbl_fruit");
		fruitTbl.deleteRow(tr.rowIndex);
		updateZJ();	
	}		
}

function updatePrice(){
	if(event && event.srcElement && event.srcElement.tagName=="INPUT"){
		var intput = event.srcElement;
		var newPrice = intput.value;
		var priceTD = intput.parentElement;
		priceTD.innerText = newPrice;

		updateXJ(priceTD.parentElement);
		
	}	
}

function updateXJ(tr){
	if(tr && tr.tagName=="TR"){
		var tbs = tr.cells;
		var priceNum = tbs[2].innerText;
		var price=tbs[1].innerText;
		var xj = parseInt(price) * parseInt(priceNum);
		tbs[3].innerText = xj;
		updateZJ();
	}
	
}

function updateZJ(){
	var fruitTbl = document.getElementById("tbl_fruit");
	var rows =  fruitTbl.rows;
	var sum = 0;
	for(var i = 1; i < rows.length- 1 ; i++){
		var tr = rows[i];
		var xj = parseInt(tr.cells[3].innerText);
		sum = sum + xj;
	}
	rows[rows.length-1].cells[1].innerText = sum;	
}