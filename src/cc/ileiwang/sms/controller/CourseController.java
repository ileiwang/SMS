package cc.ileiwang.sms.controller;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.sms.service.SMSService;
import cc.ileiwang.sms.domain.Course;
import cc.ileiwang.sms.util.tag.PageModel;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018��5��8�� ����5:27:28
*/
@Controller
public class CourseController {
	
	// �Զ�ע��Service
	@Autowired
	@Qualifier("Service")
	private SMSService Service;
	
	// ѡ��γ�
	@RequestMapping(value = "/course/selectCourse")
	public String selectCourse(Integer pageIndex, @ModelAttribute Course course, int student_id,Model model) {
		PageModel pageModel = new PageModel();
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		List<Course> courses = Service.selectCourseByStudentId(student_id);
		model.addAttribute("courses", courses);
		return "course/course";

	}
	
	
	//��ӿγ�
	@RequestMapping(value = "/course/addCourse")
	public ModelAndView addCourse(String flag, @ModelAttribute Course course, ModelAndView mv) {
		if (flag.equals("1")) {
			mv.setViewName("course/addCourse");
		} else {
			Service.addCourse(course);
			mv.setViewName("redirect:/main");
		}
		return mv;

	}

	// ɾ���γ�
	@RequestMapping(value = "/course/removeCourse")
	public ModelAndView removeUser(String ids, ModelAndView mv) {
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			Service.deleteCourseById(Integer.parseInt(id));
		}
		mv.setViewName("redirect:/course/selectCourse");
		return mv;
	}

	// ���¿γ�
	@RequestMapping(value = "/course/updateCourse")
	public ModelAndView updateCourse(String flag, @ModelAttribute Course course, ModelAndView mv) {
		if (flag.equals("1")) {
			Course target = Service.selectCourseById(course.getId());
			mv.addObject("course", target);
			mv.setViewName("course/showUpdateCourse");
		} else {
			Service.modifyCourse(course);
			mv.setViewName("redirect:/course/selectCourse");
		}
		return mv;
	}
	
	// ѡ�β���
	@RequestMapping(value = "/course/chooseCourse")
	public ModelAndView chooseCourse(String flag,@ModelAttribute Course course,ModelAndView mv) {
		if (flag.equals("1")) {
			List<Course> courses = Service.findAllCourse();
			mv.addObject("courses", courses);
			mv.setViewName("course/chooseCourse");
		}
		else 
		{
			//mv.setViewName("redirect:/course/selectCourse");
		}
		return mv;
	}
	
	//����ѡ����Ϣ-ѡ��
	@RequestMapping(value = "/course/saveCourse")
	public ModelAndView saveCourse(@Param("student_id") int student_id,@Param("course_id") int course_id,ModelAndView mv) {
		if(student_id!=0&&course_id!=0)
		{
			Service.chooseCourse(student_id,course_id);
			System.out.println("STU:"+student_id+"---COU:"+course_id);
		}
			mv.setViewName("course/chooseCourse");
			return mv;
	}
	
	//ɾ��ѡ����Ϣ-��ѡ
	@RequestMapping(value = "/course/deleteCourse")
	public ModelAndView deleteCourse(@Param("student_id") int student_id,@Param("course_id") int course_id,ModelAndView mv) {
		if(student_id!=0&&course_id!=0)
		{
			Service.unchooseCourse(student_id,course_id);
			System.out.println("STU:"+student_id+"---COU:"+course_id);
		}
			mv.setViewName("course/chooseCourse");
			return mv;
	}
}
