package com.sc.ymfeed.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.ymfeed.mybatis.dao.ArchivedateMapper;
import com.sc.ymfeed.mybatis.dto.Archivedate;
import com.sc.ymfeed.mybatis.dto.ArchivedateExample;
import com.sc.ymfeed.service.SampleService;

/**
 * spring service implement demo.
 * 
 * @author lishicong
 */
@Service("sampleService")
public class SampleServiceImpl implements SampleService {

	@Resource
	private ArchivedateMapper mapper;

	@Override
	public List<Archivedate> getSampleData() {
		ArchivedateExample example = new ArchivedateExample();
		return mapper.selectByExample(example);
	}
}
