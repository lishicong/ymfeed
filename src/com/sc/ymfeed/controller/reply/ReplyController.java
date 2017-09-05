package com.sc.ymfeed.controller.reply;

import javax.annotation.Resource;

import com.sc.ymfeed.controller.BaseController;
import com.sc.ymfeed.service.ReplyService;

public abstract class ReplyController extends BaseController {

	@Resource
	ReplyService replyService;

}
