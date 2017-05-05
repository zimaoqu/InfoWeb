var xmlHttpRequest;
var NewsID;

function createXmlHttpRequest()   
{   
    if(window.ActiveXObject)   
    {   
        return new ActiveXObject("Microsoft.XMLHTTP");   
    }   
    else if(window.XMLHttpRequest)   
    {   
        return new XMLHttpRequest();   
    }       
}

function void_fb()
{
	//alert("...");
}

function FeedBack()   
{   
	
	var v="-1";
	//var radio=document.getElementsByName("fb");
	if($("#ra1").prop("checked"))
	{
		v="1";
	}
	else if($("#ra2").prop("checked"))
	{
		v="2";
	}
	//alert(newsID);
	//alert(value);
	var url="FeedBack?newsID="+NewsID+"&useful="+v;     //后台请求的路径   
    xmlHttpRequest=createXmlHttpRequest(); 
    //xmlHttpRequest.onreadystatechange=void_fb;   //将回调函数注册给状态改变事件     
    xmlHttpRequest.open("GET",url,true);   
    xmlHttpRequest.send(null);     
}

function ShowDial(nid)
{
	NewsID=nid;
	//alert("!!!");
	$("#fbModal").modal();
}

function getfb(nid){
	var value="";
	var radio=document.getElementsByName("fb");
	for(var i=0;i<radio.length;i++){
		if(radio[i].checked==true){
			value=radio[i].value;
			break;
		}
	}
	FeedBack(nid, value);
}