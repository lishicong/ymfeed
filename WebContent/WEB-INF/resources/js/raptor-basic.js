/**
 * JS base.
 */
function Raptor() {
}

/**
 * 获取系统根路径
 */
Raptor.prototype.getRootPath = function() {

	var url = window.document.location.href; // http://localhost:8080/ymfeed/xxx/x.jsp
	var path = window.document.location.pathname; // ymfeed/xxx/x.jsp
	var pos = url.indexOf(path);
	var host = url.substring(0, pos); // http://localhost:8080
	var project = path.substring(0, path.substr(1).indexOf('/') + 1); // /ymfeed
	return (host + project);
}

var raptor = new Raptor();

/**
 * 引入js文件
 * 
 * @param _path
 * @returns
 */
function $importjs(_path) {
	document.write("<script type='text/javascript' src='" + _path
			+ "'></script>");
}

/**
 * 引入css文件
 * 
 * @param _path
 * @returns
 */
function $importcss(_path) {
	document.write("<link rel='stylesheet' type='text/css' href='" + _path
			+ "'/>");
}

// 需要引入的公共文件 Please keep order, THK!!!
$importcss(raptor.getRootPath() + '/css/bootstrap.css');
$importjs(raptor.getRootPath() + '/js/jquery-3.2.0.min.js');
$importjs(raptor.getRootPath() + '/js/bootstrap.js');
$importcss(raptor.getRootPath() + '/css/ymfeed.css');
$importjs(raptor.getRootPath() + '/js/ymfeed.js');