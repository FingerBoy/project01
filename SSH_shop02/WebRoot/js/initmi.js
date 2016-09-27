/*flash*/
function showflash(src, width, height, ID, wmode) {
	var contents = '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" id="' + ID  + '" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="' + width + '" height="' +height +'">';
	contents += '<param name="menu" value="false">';
	if (typeof(wmode) == "undefined") {
		contents += '<param name="wmode" value="transparent">';
	} else {
		contents += '<param name="wmode" value="' + wmode + '">';
	}
	contents += '<param name="movie" value="' + src + '">';
    contents += '<param name="quality" value="high">';
    contents += '<embed src="' + src + '" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" ';
	if (typeof(wmode) == "undefined") {
		contents += ' wmode="transparent" ';
	} else {
		contents += ' wmode="' + wmode + '" ';
	}
	contents += ' type="application/x-shockwave-flash" width="' + width + '" height="' + height +'"></embed></object>';
	document.write(contents);
}


function $$(id){return document.getElementById(id);}
function MI(){return;}
function notes(){$$('notes').innerHTML='';$$('notes').style.display='none';}

//验证表单validator
String.prototype.trim=function(){return this.replace(/(^[\s]*)|([\s]*$)/g, "");}
function isNumber(num){return /^[0-9.]+$/.test(num);}
function isEmail(email){return /^[^@]+@[^@]+\.[^@]+$/.test(email);}
function isMobile(mobile){return /^13\d{9}$/.test(mobile) | /^15\d{9}$/.test(mobile) | /^18\d{9}$/.test(mobile);}
function iscn(chinese){return /^[\u0391-\uFFE5]+$/.test(chinese);}
function isen(english){return /^[A-Za-z]+$/.test(english);}
function isennum(ennum){return /^[a-zA-Z].*$/.test(ennum) || /^[\w]+$/.test(ennum);}
function isMoney(money){return /^\d+(\.\d+)?$/.test(money);}
function showChecks(obj,iMsg,states){  //显示提示
	if (typeof obj == "string"){obj = $$(obj);}
	obj.innerHTML = iMsg;
	if(states==1){obj.className="error";}else{obj.className="success";}
}
//must(0为空,1不为空),character(0不限,1中文,2英文,3数字,4非中文,5字母数字下划线,6货币,7手机,8邮件,9复选框)
function checks(name,value,note,must,character,short,maxlength,minimum,maximal){
	var obj=$$(note);
	if(value==null || value=="" || value.trim()==""){
		if(must==1){showChecks(obj,name+"不能为空",1);return false;}else{return true;}
	}else{
		if(character==1 && !iscn(value)){showChecks(obj,name+"必须为中文字符",1);return false;}
		else if(character==2 && !isen(value)){showChecks(obj,name+"必须为英文字符",1);return false;}
		else if(character==3 && !isNumber(value)){showChecks(obj,name+"必须为数字",1);return false;}
		else if(character==4 &&  iscn(value)){showChecks(obj,name+"不能含有中文字符",1);return false;}
		else if(character==5 && !isennum(value)){showChecks(obj,name+"只能以字母开头的英文字母、数字和下划线组成",1);return false;}
		else if(character==6 && !isMoney(value)){showChecks(obj,name+"必须为货币",1);return false;}
		else if(character==7 && !isMobile(value)){showChecks(obj,name+"有误,请输入正确的手机号码",1);return false;}
		else if(character==8){
			var arr=value.split(",");
			for (var i=0; i<arr.length; i++){
				if (!isEmail(arr[i])){showChecks(obj,name+"有误,请输入正确的邮件",1);return false;}
			}			
		}
		else if(character==9){
			var selects=note.replace("Note","");
			var arr=document.getElementsByName(selects);
			var j=0;
			for (var i=0;i<arr.length;i++){
				if(arr[i].checked) j++;
			}
			if(minimum>0 && j<minimum){showChecks(obj,name+"最少选择"+minimum+"项",1);return false;}
			if(maximal>0 && j>maximal){showChecks(obj,name+"最多选择"+maximal+"项",1);return false;} 
		}
		
    	if( short>0 && maxlength>0 && short==maxlength && value.length!=short ){showChecks(obj, name+"字符长度应为"+short+"个字符",1);	return false;}
		if( short>0 && value.length < short ){showChecks(obj, name+"字符长度应不少于"+short+"个字符",1);return false;}
    	if( maxlength>0 && value.length > maxlength ){showChecks(obj, name+"字符长度应不多于"+maxlength+"个字符",1);return false;	}
		
    	if( (character==3 || character==6) && minimum>0 && value < minimum ){showChecks(obj, name+"值大小有误,应该不小于"+minimum,1);return false;}
    	if( (character==3 || character==6) && maximal>0 && value > maximal ){showChecks(obj, name+"值大小有误,应该不大于"+maximal,1);return false;}
		showChecks(obj, "正确",0);
		return true;		
	}
}

//color
var ColorImg;
var ColorValue;
var ColorText
function hideColourPallete(){
	document.getElementById("colourPalette").style.visibility="hidden";
}
function Getcolor(img_val,input_val,text_val){
	var obj = document.getElementById("colourPalette");
	ColorImg = img_val;
	ColorValue = document.getElementById(input_val);
	colorText = document.getElementById(text_val);
	if (obj){
	obj.style.left = getOffsetLeft(ColorImg) + "px";
	obj.style.top = (getOffsetTop(ColorImg) + ColorImg.offsetHeight) + "px";
	if (obj.style.visibility=="hidden")	{
	obj.style.visibility="visible";
	}else{
	obj.style.visibility="hidden";
	}
	}
}
//Colour pallete top offset
function getOffsetTop(elm){
	var mOffsetTop = elm.offsetTop;
	var mOffsetParent = elm.offsetParent;
	while(mOffsetParent){
		mOffsetTop += mOffsetParent.offsetTop;
		mOffsetParent = mOffsetParent.offsetParent;
	}
	return mOffsetTop;
}
//Colour pallete left offset
function getOffsetLeft(elm){
	var mOffsetLeft = elm.offsetLeft;
	var mOffsetParent = elm.offsetParent;
	while(mOffsetParent){
		mOffsetLeft += mOffsetParent.offsetLeft;
		mOffsetParent = mOffsetParent.offsetParent;
	}
	return mOffsetLeft;
}
function setColor(color){
	if (ColorValue){ColorValue.value = color;colorText.style.color = color;}
	if (ColorImg){ColorImg.style.backgroundColor = color;}
	document.getElementById("colourPalette").style.visibility="hidden";
}
//帮助提示
function ShowQuickHelp(container, title, desc){
	div = document.createElement("div");
	div.style.display = 'block';
	div.style.position = 'absolute';
	div.style.width = '185px';
	div.style.backgroundColor = '#FEFCD5';
	div.style.border = 'solid 1px #E7E3BE';
	div.style.padding = '10px';
	div.className = "helpHover";

	var offset = $(container).offset();
	div.style.top = (offset.top + 35) + 'px';
	div.style.left = offset.left + 'px';

	if(title != ''){
		div.innerHTML = '<div class="helpTip"><strong>' + title + '</strong></div><br />';
	}
	div.innerHTML += '<div style="width:185px; padding-left:0px" class="helpTip">' + desc + '</div>';
	document.body.appendChild(div);
}
function HideQuickHelp(p){
	$('.helpHover').remove();
}

function ShowHelp(divid, title, desc){
	var div = $$(divid);
	div.style.display = 'inline';
	div.style.position = 'absolute';
	div.style.width = '190px';
	div.style.backgroundColor = '#FEFCD5';
	div.style.color = '#000000';
	div.style.border = 'solid 1px #E7E3BE';
	div.style.padding = '10px';
	div.innerHTML = '<span class="helpTip"><b>' + title + '<\/b><\/span><br><div class="helpTip">' + desc + '<\/div>';
}

function HideHelp(divid){
	var div = $$(divid);
	div.style.display = 'none';
}

//全选
function checkAll(form){
	for (var i=0;i<form.elements.length;i++){
		var e = form.elements[i];
		if (e.Name != 'chkAll'&&e.disabled==false)
		e.checked = form.chkAll.checked;
	}
}
//hover效果
$(document).ready(function() {
	$(".table tr").hover(function() {
		$(this).addClass("tablehover");
	}, function() {
		$(this).removeClass("tablehover");
	});
});

function showTab(T) {
	var i=0;
	while ($$("tab"+i) != null){
		$$("box"+i).style.display = "none";
		$$("tab"+i).className = "";
		i++;
	}
	$$("box"+T).style.display = "";
	$$("tab"+T).className = "active";
	$$("tab"+T).setAttribute("hideFocus","hideFocus");
}

function showID(id) {
	var target=$$(id);
	if (target.style.display==""){
		target.style.display="none";
		if($$("img"+id) != null){$$('img'+id).src="images/parent.gif"}
	}else{
		target.style.display="";
		if($$("img"+id) != null){$$('img'+id).src="images/child.gif"}
	};
}

//show-hide:layer
var nolayer=1;
function showlayer(obj){nolayer=0;hidelayer();$$(obj).style.display="block";}
function hidelayer(){
	var i=1;
	while ($$("layer"+i) != null){
		$$("layer"+i).style.display="none";
		i++;
	}
	i=1;
	while ($$("menu"+i) != null){
		$$("menu"+i).style.display="none";
		i++;
	}
	if ($$("divCalendar") != null){$$("divCalendar").style.display="none";}
}
$(document).ready(function(){
	document.onclick=function(){if(nolayer){hidelayer();}nolayer=1;}
});
function mainmenu(){
$(" .navlist ul ").css({display: "none"}); // Opera Fix
$(" .navlist li").hover(function(){
		$(this).find('ul:first').css({visibility: "visible",display: "none"}).show(400);
		},function(){
		$(this).find('ul:first').css({visibility: "hidden"});
		});
}
$(document).ready(function(){					
	mainmenu();
});