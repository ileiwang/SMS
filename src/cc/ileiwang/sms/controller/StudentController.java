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
* @version 2018��5��8�� ����5:50:08
*/
@Controller
public class StudentController {
	// �Զ�ע��Service
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
		
		// ����Ա
		if (type.equals("admin")) {

			Admin admin = Service.adminlogin(num, password);
			if (admin != null) {
				session.setAttribute(SMSConstants.USER_SESSION, admin);
				session.setMaxInactiveInterval(30 * 60);  
				mv.setViewName("redirect:/main");
			} else {
				mv.addObject("message", "��¼�����������!����������");
				mv.setViewName("forward:/loginForm");
			}
		}
	
		// ѧ��
		else {
			Student student = Service.studentlogin(num, password);
			if (student != null) {
				session.setAttribute(SMSConstants.USER_SESSION, student);
				mv.setViewName("redirect:/main");
			} else {
				mv.addObject("message", "��¼�����������!����������");
				mv.setViewName("forward:/loginForm");
			}
		}
		return mv;

	}

	// ����
	@RequestMapping(value = "/about")
	public String about() {
		return "about/about";
	}

	// ѡ��ѧ��
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
	
	
	//���ѧ��
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

	// ɾ��ѧ��
	@RequestMapping(value = "/student/removeStudent")
	public ModelAndView removeUser(String ids, ModelAndView mv) {
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			Service.deleteStudentById(Integer.parseInt(id));
		}
		mv.setViewName("redirect:/student/selectStudent");
		return mv;
	}

	// ����ѧ��
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
