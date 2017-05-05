var saveab = "";
var kstr = "";

function trim(str) { //删除左右两端的空格 
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

function splithotw(str) {//处理新闻关键词，分割
	var res = "";
	if (str != null) {
		substr = str.split(";");
	}
	for (var i = 0; i < substr.length - 1; i++) {
		if (substr[i] != null) {
			temp = substr[i].split("/");
			res = res + temp[0] + " ";
		}
	}
	return res;
}

//悬浮鼠标，右边反显
function mOver(obj) {
	var relcom = obj.children[0].innerHTML;//相关企业
	var category = obj.children[1].innerHTML;//相关行业
	var keyw = obj.children[2].innerHTML;//关键词
	keyw = trim(keyw);
	subcategory = trim(category);
	relcom = trim(relcom);
	if (relcom != null) {
		subrelcom = relcom.split(";");
	}

	objDiv1 = document.getElementById("qy");//企业反显
	objDiv2 = document.getElementById("hy");//行业反显
	objDiv3 = document.getElementById("rc");//热词反显

	kstr = splithotw(keyw);
	subkstr = trim(kstr);
	subkstr = kstr.split(" ");
	for (var i = 0; i < subkstr.length - 1; i++) {
		objDiv3.innerHTML = objDiv3.innerHTML.replace(subkstr[i], "#"
				+ subkstr[i]);
	}

	saveab = obj.children[4].innerHTML;
	obj.children[4].innerHTML = obj.children[4].innerHTML + "&nbsp;&nbsp"
			+ kstr;

	for (var i = 0; i < subrelcom.length - 1; i++) {
		if (subrelcom[i] != null) {
			objDiv1.innerHTML = objDiv1.innerHTML.replace(subrelcom[i],
					subrelcom[i] + "###");
		}
	}
	if (subcategory != null) {
		objDiv2.innerHTML = objDiv2.innerHTML.replace(subcategory, "#"
				+ subcategory + "#");
	}
}
function mOut(obj) {
	var relcom = obj.children[0].innerHTML;
	var category = obj.children[1].innerHTML;
	var keyw = obj.children[2].innerHTML;
	keyw = trim(keyw);
	subcategory = trim(category);
	relcom = trim(relcom);
	if (relcom != null) {
		subrelcom = relcom.split(";");
	}

	objDiv1 = document.getElementById("qy");
	objDiv2 = document.getElementById("hy");
	objDiv3 = document.getElementById("rc");

	subkstr = trim(kstr);
	subkstr = kstr.split(" ");
	for (var i = 0; i < subkstr.length - 1; i++) {
		objDiv3.innerHTML = objDiv3.innerHTML.replace("#" + subkstr[i],
				subkstr[i]);
	}
	obj.children[4].innerHTML = saveab;

	for (var i = 0; i < subrelcom.length - 1; i++) {
		if (subrelcom[i] != null) {
			objDiv1.innerHTML = objDiv1.innerHTML.replace(subrelcom[i] + "###",
					subrelcom[i]);
		}
	}
	if (subcategory != null) {
		objDiv2.innerHTML = objDiv2.innerHTML.replace("#" + subcategory + "#",
				subcategory);
	}
}