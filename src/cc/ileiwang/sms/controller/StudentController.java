package cc.ileiwang.sms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.sms.domain.Admin;
import cc.ileiwang.sms.domain.Student;
import cc.ileiwang.sms.service.SMSService;
import cc.ileiwang.sms.util.common.SMSConstants;
import cc.ileiwang.sms.util.tag.PageModel;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月8日 下午5:50:08
*/
@Controller
public class StudentController {
	// 自动注入Service
	@Autowired
	@Qualifier("Service")
	private SMSService Service;

	@RequestMapping(value = "/logoff")
	public ModelAndView logoff(HttpSession session, ModelAndView mv) {
		session.invalidate();
		mv.setViewName("redirect:/off");
		return mv;
	}

	
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam("num") String num, @RequestParam("password") String password,
			@RequestParam("type")String type,HttpSession session, ModelAndView mv) {
		
		// 管理员
		if (type.equals("admin")) {

			Admin admin = Service.adminlogin(num, password);
			if (admin != null) {
				session.setAttribute(SMSConstants.USER_SESSION, admin);
				session.setMaxInactiveInterval(30 * 60);  
				mv.setViewName("redirect:/main");
			} else {
				mv.addObject("message", "登录名或密码错误!请重新输入");
				mv.setViewName("forward:/loginForm");
			}
		}
	
		// 学生
		else {
			Student student = Service.studentlogin(num, password);
			if (student != null) {
				session.setAttribute(SMSConstants.USER_SESSION, student);
				mv.setViewName("redirect:/main");
			} else {
				mv.addObject("message", "登录名或密码错误!请重新输入");
				mv.setViewName("forward:/loginForm");
			}
		}
		return mv;

	}

	// 关于
	@RequestMapping(value = "/about")
	public String about() {
		return "about/about";
	}

	// 选择学生
	@RequestMapping(value = "/student/selectStudent")
	public String selectStudent(Integer pageIndex, @ModelAttribute Student student, Model model) {
		PageModel pageModel = new PageModel();
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		List<Student> students = Service.findStudent(student, pageModel);
		model.addAttribute("students", students);
		model.addAttribute("pageModel", pageModel);
		return "student/student";

	}
	
	
	//添加学生
	@RequestMapping(value = "/student/addStudent")
	public ModelAndView addStudent(String flag, /*Integer clazz_id,*/@ModelAttribute Student student, ModelAndView mv) {
		if (flag.equals("1")) {
			//List<Clazz> clazzs = Service.findAllClazz();
			//mv.addObject("clazzs", clazzs);
			mv.setViewName("student/showAddStudent");
		} else {
			//this.genericAssociation(clazz_id,student);
			Service.addStudent(student);
			mv.setViewName("redirect:/student/selectStudent");
		}
		return mv;
	}

	// 删除学生
	@RequestMapping(value = "/student/removeStudent")
	public ModelAndView removeUser(String ids, ModelAndView mv) {
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			Service.deleteStudentById(Integer.parseInt(id));
		}
		mv.setViewName("redirect:/student/selectStudent");
		return mv;
	}

	// 更新学生
	@RequestMapping(value = "/student/updateStudent")
	public ModelAndView updateStudent(String flag, @ModelAttribute Student student, ModelAndView mv) {
		if (flag.equals("1")) {
			Student target = Service.selectStudentById(student.getId());
			//List<Clazz> clazzs = Service.findAllClazz();
			mv.addObject("student", target);
			//mv.addObject("clazzs", clazzs);
			mv.setViewName("student/showUpdateStudent");
		} else {
			Service.modifyStudent(student);
			mv.setViewName("redirect:/student/selectStudent");
		}
		return mv;
	}
	
//	private void genericAssociation(Integer clazz_id,
//			Student student){
//		if(clazz_id != null){
//			Clazz clazz = new Clazz();
//			clazz.setId(clazz_id);
//			student.setClazz(clazz);
//		}
//	}

}
