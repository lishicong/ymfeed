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

/**
 * 以新窗口打开链接
 * 
 * @param url
 * @returns
 */
function openwin(url) {
	var a = document.createElement('a');
	a.href = url;
	a.target = '_blank';
	document.body.appendChild(a);
	a.click();
}