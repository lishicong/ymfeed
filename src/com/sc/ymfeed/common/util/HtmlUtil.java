package com.sc.ymfeed.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtil {

	private final static String REGXP_FOR_HTML = "<([^>]*)>"; // 过滤所有以<开头以>结尾的标签
	private static final String REGXP_FOR_IMG = "<img.*src\\s*=\\s*(.*?)[^>]*?>"; // 图片标签
	private static final String REGXP_FOR_IMG_SRC = "src\\s*=\\s*\"?(.*?)(\"|>|\\s+)"; // 图片链接src

	/**
	 * 过滤所有以"<"开头以">"结尾的标签
	 * 
	 * @param html
	 * @return
	 */
	public static String getFilterHtml(String html) {
		Pattern pattern = Pattern.compile(REGXP_FOR_HTML);
		Matcher matcher = pattern.matcher(html);
		StringBuffer sb = new StringBuffer();
		boolean result1 = matcher.find();
		while (result1) {
			matcher.appendReplacement(sb, "");
			result1 = matcher.find();
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 获取第一个图片链接（不包含添加的表情，表情图片不包含http://）
	 * 
	 * @param html
	 * @return
	 */
	public static String getFirstImgSrc(String html) {
		Pattern pattern = Pattern.compile(REGXP_FOR_IMG, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(html);

		String src = null;
		while (matcher.find()) {
			String img = matcher.group();
			Matcher m = Pattern.compile(REGXP_FOR_IMG_SRC).matcher(img);
			while (m.find()) {
				String str = m.group(1);
				if (str.startsWith("http://")) {
					src = str;
				}
			}
		}
		return src;
	}

	/**
	 * 按指定长度截串（中英文混合）
	 * 
	 * @param str
	 * @param len
	 * @return
	 */
	public static String subTextString(String str, int len) {
		if (str.length() < len / 2) {
			return str;
		}

		int count = 0;
		StringBuffer sb = new StringBuffer();
		String[] ss = str.split("");
		for (int i = 0; i < ss.length; i++) {
			count += ss[i].getBytes().length > 1 ? 2 : 1;
			sb.append(ss[i]);
			if (count >= len) {
				break;
			}
		}
		return (sb.toString().length() < str.length()) ? sb.append("...").toString() : str;
	}

	public static void main(String[] args) {
		String resource = "<p><u><b>2015纽约车展上,<img src=\"face/f002.png\">2016款梅赛德斯-AMGG65正式发布。同时，奔驰官方确认，新车终于要进入美国市场了。</b></u></p><p><u><b><br></b></u></p><p><img src=\"http://oo1oxm04z.bkt.clouddn.com/o_1bla4l5nr1ocf1j7j1t7l13b41979a.jpg\" style=\"max-width:100%;\"></p><p> asdf<br></p>";
		String str = getFilterHtml(resource);
		System.out.println(subTextString(str, 19));
		String src = getFirstImgSrc(resource);
		System.out.println(src);
	}
}
