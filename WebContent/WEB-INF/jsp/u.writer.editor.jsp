<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/css/wangEditor.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/wangEditor.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/plupload.full.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/qiniu.js"></script>

<style type="text/css">
#editor-trigger {
	height: 400px;
	/*max-height: 500px;*/
}

.input-group {
	margin-top: 24px;
}

.input-group-addon {
	cursor: pointer;
	background: #f05858;
	color: #ffffff;
	width: 100px;
}

.ym-writer-content {
	margin-top: 24px;
}
</style>

<div class="input-group">
	<input type="text" class="form-control" id="writer_title"
		placeholder="请输入文章标题"> <span class="input-group-addon"
		onclick="writerPublish();">发布</span>
</div>

<div id="editor-container" class="ym-writer-content">
	<div id="editor-trigger"></div>
</div>

<script type="text/javascript">
	//发布文章
	function writerPublish() {
		var title = $("#writer_title").val();
		var content = $("#editor-trigger").html();

		$.ajax({
			type : "post",
			url : raptor.getRootPath() + "/writer/publish",
			data : {
				"title" : title,
				"content" : content
			},
			dataType : "json",
			success : function(data) {
				alert(data);
			}
		});
	}

	// ------------------------------------------------------------------------------------------
	// ------------------------------------- editor start --------------------------------------
	// ------------------------------------------------------------------------------------------
	function uploadInit() {

		var editor = this; // this即editor对象
		var btnId = editor.customUploadBtnId; // 触发选择文件的按钮的id
		var containerId = editor.customUploadContainerId; // 触发选择文件的按钮的父容器的id

		// 创建上传对象
		var uploader = Qiniu.uploader({
			runtimes : 'html5,flash,html4', //上传模式,依次退化
			browse_button : btnId, //上传选择的点选按钮，**必需**
			uptoken_url : raptor.getRootPath() + '/writer/qntok',//Ajax请求upToken的Url
			unique_names : true, //自动生成图片名字
			domain : 'http://oo1oxm04z.bkt.clouddn.com/', // bucket
			container : containerId, //上传区域DOM ID，默认是browser_button的父元素，
			max_file_size : '2mb', //最大文件体积限制
			flash_swf_url : raptor.getRootPath() + '/js/Moxie.swf', //引入flash,相对路径
			filters : {
				mime_types : [
				//只允许上传图片文件 （注意，extensions中，逗号后面不要加空格）
				{
					title : "image",
					extensions : "JPEG,JPG,PNG,BMP"
				} ]
			},
			resize : {
				width : 600,
				height : 480,
				crop : true,
				quality : 90,
				preserve_headers : false
			},
			max_retries : 3, //上传失败最大重试次数
			dragdrop : true, //开启可拖曳上传
			drop_element : 'editor-container', //拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
			auto_start : true, //选择文件后自动上传，若关闭需要自己绑定事件触发上传

			init : {
				'FilesAdded' : function(up, files) {
					plupload.each(files, function(file) {
						// 文件添加进队列后,处理相关的事情
					});
				},
				'BeforeUpload' : function(up, file) {
					// 每个文件上传前,处理相关的事情
				},
				'UploadProgress' : function(up, file) {
					// 显示进度条
					editor.showUploadProgress(file.percent);
				},
				'FileUploaded' : function(up, file, info) {

					var domain = up.getOption('domain');
					var res = $.parseJSON(info);
					var sourceLink = domain + res.key; //获取上传成功后的文件的Url

					// 插入图片到editor
					editor.command(null, 'insertHtml', '<img src="' + sourceLink + '" style="max-width:100%;"/>')
				},
				'Error' : function(up, err, errTip) {
				},
				'UploadComplete' : function() {
					// 隐藏进度条
					editor.hideUploadProgress();
				}
			}
		});
	}

	// 生成编辑器
	var editor = new wangEditor('editor-trigger');
	editor.config.printLog = false;
	editor.config.customUpload = true; // 设置自定义上传的开关
	editor.config.customUploadInit = uploadInit; // 配置自定义上传初始化事件，uploadInit方法在上面定义了

	editor.config.pasteText = true; // 只粘贴纯文本
	editor.config.emotionsShow = 'icon'; // 表情显示项
	editor.config.emotions = {
		'default' : {
			title : '表情',
			data : [ {
				icon : raptor.getRootPath() + '/face/f000.png',
				value : '[草泥马]'
			}, {
				icon : raptor.getRootPath() + '/face/f001.png',
				value : '[神马]'
			}, {
				icon : raptor.getRootPath() + '/face/f002.png',
				value : '[浮云]'
			}, {
				icon : raptor.getRootPath() + '/face/f003.png',
				value : '[给力]'
			}, {
				icon : raptor.getRootPath() + '/face/f004.png',
				value : '[围观]'
			}, {
				icon : raptor.getRootPath() + '/face/f005.png',
				value : '[威武]'
			}, {
				icon : raptor.getRootPath() + '/face/f007.png',
				value : '[草泥马]'
			}, {
				icon : raptor.getRootPath() + '/face/f008.png',
				value : '[神马]'
			} ]
		}
	};

	//onchange 事件
	editor.onchange = function() {
		//console.log(this.$txt.html());
	};
	editor.create();

	// ------------------------------------------------------------------------------------------
	// -------------------------------------- editor end ---------------------------------------
	// ------------------------------------------------------------------------------------------
</script>
