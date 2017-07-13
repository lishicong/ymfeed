package com.sc.ymfeed.common.util;

import java.util.Random;

public class RandomUtil {

	private RandomUtil() {
	}

	/**
	 * 生成指定范围的随机数
	 *
	 * @param min
	 * @param max
	 *
	 * @return
	 */
	public static int getRandom(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

}
