package cn.xiuyu.web.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xiuyu.web.data.MVCResult;

@RestController
@RequestMapping("test")
public class TestController {

	@RequestMapping("show")
	public MVCResult show() {
		return new MVCResult().message("ok").status(200).result("true");
	}
}
