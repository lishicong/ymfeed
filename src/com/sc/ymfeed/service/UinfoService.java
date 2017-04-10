package com.sc.ymfeed.service;

import java.util.List;

import com.sc.ymfeed.mybatis.dto.Info;

public interface UinfoService {

	public List<Info> getInfo();

	public int addInfo(Info info);

}
