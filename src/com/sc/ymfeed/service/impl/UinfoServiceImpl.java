package com.sc.ymfeed.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.ymfeed.mybatis.dao.InfoMapper;
import com.sc.ymfeed.mybatis.dto.Info;
import com.sc.ymfeed.mybatis.dto.InfoExample;
import com.sc.ymfeed.service.UinfoService;

@Service("uinfoService")
public class UinfoServiceImpl implements UinfoService {

	@Resource
	private InfoMapper mapper;

	@Override
	public List<Info> getInfo() {
		InfoExample example = new InfoExample();
		return mapper.selectByExample(example);
	}

	@Override
	public int addInfo(Info info) {
		return mapper.insert(info);
	}

}
