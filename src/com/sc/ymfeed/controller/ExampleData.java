package com.sc.ymfeed.controller;

import java.util.ArrayList;
import java.util.List;

import com.sc.ymfeed.mybatis.dto.FeedInfo;

public class ExampleData {

	static List<FeedInfo> getExample() {
		List<FeedInfo> infos = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			FeedInfo info = new FeedInfo();
			info.setId((long) i);
//			info.setHeader(
//					"https://gss0.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/8ad4b31c8701a18bbef9f231982f07082838feba.jpg");
			if (i != 2 && i != 3)
				info.setPreviewImg(
						"https://gss0.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/42a98226cffc1e17e769296a4e90f603728de993.jpg");
			//info.setAuthorId(123);
			info.setTitle("悦读 |《解忧杂货店》到底想告诉我们什么？");
			info.setContent(
					"《解忧杂货店》是一部让人意外的作品，很多人说它跳出了作者东野圭吾的惯常套路，不算是推理小说。但我恰恰觉得，这是作者推理小说的一个里程碑。因为，通常的推理小说，推理只是小说人物...");
			infos.add(info);
		}

		return infos;
	}

}
