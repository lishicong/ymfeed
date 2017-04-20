(function($) {
	jQuery.fn.extend({
		rzAlertTips : function(settings) {
			$(this).each(
					function() {
						// 初始化配置信息
						var options = jQuery.extend({
							flagCss : "tip",
							flagWidth : $(this).outerWidth(),
							flagInfo : $(this).attr("placeholder"),
							isAnimate : true
						}, settings);
						if (!options.flagInfo) {
							return;
						}
						$(this).removeAttr("title");
						var obj = $(this);
						var oToolTip = null;
						var fun_show = function() {
							// 设置提示信息最小宽度为163

							options.flagWidth = "auto"; // (parseInt(options.flagWidth)
							// <
							// 100)
							// ? 163
							// :
							// parseInt(options.flagWidth);+
							// "px"
							var oTip = $("<div class='ui-slider-tooltip  ui-corner-all'  id='tipWrap_"
									+ $(this).attr("id") + "'></div>");
							var oPointer = $("<div class='ui-tooltip-pointer-down'>"
									+ "<div class='ui-tooltip-pointer-down-inner'></div></div>");
							var oTipInfo = $("<div>" + options.flagInfo + "</div>").attr("class", options.flagCss).css(
									"width", options.flagWidth);
							// 合并提示信息
							oToolTip = $(oTip).append(oTipInfo).append(oPointer);
							if ($("#tipWrap_" + $(this).attr("id")).length > 0)
								$("#tipWrap_" + $(this).attr("id")).remove();
							// 添加淡入效果
							if (options.isAnimate) {
								$(oToolTip).fadeIn("slow");
							}
							$(obj).after(oToolTip);
							// 计算提示信息的top、left和width
							// //position.top
							var position = $(obj).position();
							var oTipTop = eval(position.top - $(oTip).outerHeight() - 8);
							var oTipLeft = position.left;

							$(oToolTip).css("top", oTipTop + "px").css("left", oTipLeft + "px");
						};
						fun_show();
						$('.error').removeClass('error');
						$(this).addClass("error");
						setTimeout(function() {
							$(oToolTip).remove();
						}, 5000);
					});
			return this;
		}
	})
})(jQuery);