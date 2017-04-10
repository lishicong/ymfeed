package com.sc.ymfeed.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.ymfeed.mybatis.dao.InfoMapper;
import com.sc.ymfeed.mybatis.dto.Info;
import com.sc.ymfeed.mybatis.dto.InfoExample;
import com.sc.ymfeed.service.SampleService;

/**
 * spring service implement demo.
 * 
 * @author lishicong
 */
@Service("sampleService")
public class SampleServiceImpl implements SampleService {

	@Resource
	private InfoMapper mapper;

	@Override
	public List<Info> getSampleData() {
		InfoExample example = new InfoExample();
		return mapper.selectByExample(example);
	}
}
