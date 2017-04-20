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
 * 邮箱
 * 
 * @param str
 * @returns
 */
function checkEmail(str) {
	var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/
	if (re.test(str)) {
		return true;
	}
	return false;
}

/**
 * 手机号
 * 
 * @param str
 * @returns
 */
function checkMobile(str) {
	var re = /^1(3|4|5|7|8)\d{9}$/
	if (re.test(str)) {
		return true;
	}
	return false;
}
/**
 * 用户名 (验证规则：字母、数字、下划线组成，字母开头，2-16位)
 * 
 * @param str
 * @returns
 */
function checkUser(str) {
	var re = /^[a-zA-z]\w{1,15}$/;
	if (re.test(str)) {
		return true;
	}
	return false;
}

/**
 * 昵称长度2~16
 * 
 * @param str
 * @returns
 */
function checkNicknameLen(str) {
	var re = /^\S{1,15}$/;
	if (re.test(str)) {
		return true;
	}
	return false;
}

/**
 * 密码长度8~16
 * 
 * @param str
 * @returns
 */
function checkPasswordLen(str) {
	var re = /^\S{7,15}$/;
	if (re.test(str)) {
		return true;
	}
	return false;
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
 * 以新窗口打开链接
 * 
 * @param url
 * @returns
 */
function openWin(url) {
	openHyperlink(url, '_blank');
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