/**
 * JS base.
 */
function Raptor() {
}

/**
 * 引入js文件
 * 
 * @param _path
 * @returns
 */
function $importjs(_path) {
	document.write("<script type='text/javascript' src='" + _path + "'></script>");
}

/**
 * 引入css文件
 * 
 * @param _path
 * @returns
 */
function $importcss(_path) {
	document.write("<link rel='stylesheet' type='text/css' href='" + _path + "'/>");
}

// 需要引入的公共文件 Please keep order, THK!!!
$importcss('css/bootstrap.css');
$importjs('js/jquery-3.2.0.min.js');
$importjs('js/bootstrap.js');
$importcss('css/toastr.min.css');
$importjs('js/toastr.min.js');
$importcss('css/showLoading.css');
$importjs('js/jquery.showLoading.js');
$importcss('css/ymfeed.css');
$importjs('js/ymfeed.js');