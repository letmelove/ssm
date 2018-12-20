package com.accp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.accp.pojo.User;
import com.accp.service.UserService;
import com.accp.util.Excel;
import com.github.pagehelper.PageInfo;
//提交测试
@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	private List<User> list;
	@RequestMapping(value="/showuser",method=RequestMethod.GET)
	public String showUser(Model model, HttpServletRequest req) {
		int currentPage = req.getParameter("pageNum") == null ? 1 : Integer.parseInt(req.getParameter("pageNum"));
		PageInfo<User> pageinfo = service.page(currentPage);
		list = pageinfo.getList();
		model.addAttribute("page", pageinfo);
		return "index";
	}
	@RequestMapping(value="/showuser",method=RequestMethod.POST)
	@ResponseBody
	public PageInfo<User> showUser(String pageNum){
		int currentPage = pageNum == null ? 1 : Integer.parseInt(pageNum);
		PageInfo<User> pageinfo = service.page(currentPage);
		list = pageinfo.getList();
		return pageinfo;
	}
	@RequestMapping("/down")
	public void Download(HttpServletResponse resp) throws IOException {
		Excel ex = new Excel();
		ex.exportexcel(list,resp);
		
	}
}
