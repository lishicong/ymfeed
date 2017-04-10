package com.sc.ymfeed;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sc.ymfeed.mybatis.dto.Info;
import com.sc.ymfeed.service.SampleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })

/**
 * 测试类
 * 
 * @author lishicong
 */
public class SampleTest {

	private static Logger logger = Logger.getLogger(SampleTest.class);
	@Resource
	private SampleService testService = null;

	@Before
	public void before() {
		// before the test
	}

	@Test
	public void test() {

		List<Info> user = testService.getSampleData();
		logger.info("user:" + user.get(0).getTitle());
	}

}
