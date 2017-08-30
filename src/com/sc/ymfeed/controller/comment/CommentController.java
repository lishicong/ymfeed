package com.sc.ymfeed.controller.comment;

import javax.annotation.Resource;

import com.sc.ymfeed.controller.BaseController;
import com.sc.ymfeed.service.CommentService;

public abstract class CommentController extends BaseController {

	@Resource
	CommentService commentService;
}
