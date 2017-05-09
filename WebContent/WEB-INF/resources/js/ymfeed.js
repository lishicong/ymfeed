/**
 * 封装 console.log 函数
 */
function printLog(title, info) {
	window.console && console.log(title, info);
}

/**
 * 判断是否桌面系统
 */
function isPC() {
	var userAgentInfo = navigator.userAgent;
	var Agents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");
	var flag = true;
	for (var v = 0; v < Agents.length; v++) {
		if (userAgentInfo.indexOf(Agents[v]) > 0) {
			flag = false;
			break;
		}
	}
	return flag;
}
// --------------------------------------------------------------------------------
/**
 * 以指定方式打开链接
 * 
 * @param url
 * @param target
 * @returns
 */
function openHyperlink(url, target) {
	var a = document.createElement('a');
	a.href = url;
	a.target = target;
	document.body.appendChild(a);
	a.click();
}

/**
 * 以指定方式打开链接(post)
 * 
 * @param url
 * @param target
 * @returns
 */
function openHyperlinkPost(url, target) {
	var temp = document.createElement("form"); // 创建form表单
	temp.action = url;
	temp.method = "post";
	temp.style.display = "none";// 表单样式为隐藏
	for ( var item in params) {// 初始化表单内部的控件
		// 根据实际情况创建不同的标签元素
		var opt = document.createElement("input"); // 添加input标签
		opt.type = "text"; // 类型为text
		opt.id = item; // 设置id属性
		opt.name = item; // 设置name属性
		opt.value = params[item]; // 设置value属性
		temp.appendChild(opt);
	}

	document.body.appendChild(temp);
	temp.submit();
	return temp;
}

/**
 * 以新窗口打开链接
 * 
 * @param url
 * @returns
 */
function openWin(url) {
	openHyperlink(url, '_blank');
}

function openWinPost(url) {
	openHyperlinkPost(url, '_bland');
}

/**
 * 当前窗口打开链接
 * 
 * @param url
 * @returns
 */
function openSelf(url) {
	openHyperlink(url, '_self');
}

/**
 * 以新窗口打开登录页面
 * 
 * @returns
 */
function ymSignInWin() {
	openWin('signin');
}

/**
 * 以当前窗口打开登录页面
 * 
 * @returns
 */
function ymSignInSelf() {
	openSelf('signin');
}