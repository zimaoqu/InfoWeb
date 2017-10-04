//为所有按钮动态添加事件
function IniButtonEvent() {
	console.log("button     asdas")
	var Items = document.getElementsByTagName("input");
	for (var i = 0; i < Items.length; i++) {
		var objTmp = Items[i];
		if (objTmp.type == "button") {
			objTmp.onclick = ButtonClickRead;
		}
		else if(objTmp.type == "submit"){
			objTmp.onclick = prom;
		}
	}
}
function prom()
{
    var name=prompt("请输入您的邮箱","");//将输入的内容赋给变量 name ，
    //这里需要注意的是，prompt有两个参数，前面是提示的话，后面是当对话框出来后，在对话框里的默认值
    if(name)//如果返回的有内容
    {
         alert("已发送至："+ name)
     }
}

function ButtonClickRead() {
	var Items = document.getElementsByTagName("input");
	for (var i = 0; i < Items.length; i++) {
		var objTmp = Items[i];
		if (objTmp.type == "button") {
			//判断是否是按钮
			//window.event.srcElement触发当前事件的元素
			//用来判断是否是当前单击的按钮
			if (objTmp == window.event.srcElement) {
				if (objTmp.value == "已读") {
					objTmp.value = "未读";
				} else if (objTmp.value == "未读") {
					objTmp.value = "已读";
				}
			}
		}
	}
}
