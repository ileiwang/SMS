package cc.ileiwang.sms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.sms.domain.*;
import cc.ileiwang.sms.service.SMSService;
import cc.ileiwang.sms.util.tag.PageModel;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月8日 下午5:27:09
*/
@Controller
public class ScoreController {
	
	// 自动注入Service
	@Autowired
	@Qualifier("Service")
	private SMSService Service;
	
	// 选择成绩
	@RequestMapping(value = "/score/selectScore")
	public String selectScore(Integer pageIndex, @ModelAttribute Score score, Model model) {
		PageModel pageModel = new PageModel();
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		List<Score> scores = Service.findScore(score, pageModel);
		model.addAttribute("scores", scores);
		return "score/score";
	}
	
	//查询成绩
	@RequestMapping(value = "/score/searchScore")
	public String searchScore(Integer pageIndex, int id, Model model) {
		PageModel pageModel = new PageModel();
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		List<Score> scores = Service.selectScoreByStudentId(id);
		model.addAttribute("scores", scores);
		return "score/score";
	}
	
	//添加成绩
	@RequestMapping(value = "/score/addScore")
	public ModelAndView addScore(String flag, @ModelAttribute Score score,String student_num,Integer course_id, ModelAndView mv) {
		if (flag.equals("1")) {
			List<Course> courses = Service.findAllCourse();
			mv.addObject("courses", courses);
			mv.setViewName("score/addScore");
		} else {
			this.genericAssociation(student_num, course_id, score);
			Service.addScore(score);
			mv.setViewName("redirect:/score/selectScore");
		}
		return mv;

	}

	// 删除成绩
	@RequestMapping(value = "/score/removeScore")
	public ModelAndView removeUser(String ids, ModelAndView mv) {
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			Service.deleteScoreById(Integer.parseInt(id));
		}
		mv.setViewName("redirect:/score/selectScore");
		return mv;
	}

	// 更新成绩
	@RequestMapping(value = "/score/updateScore")
	public ModelAndView updateScore(String flag, @ModelAttribute Score score, ModelAndView mv) {
		if (flag.equals("1")) {
			Score target = Service.selectScoreById(score.getId());
			mv.addObject("score", target);
			mv.setViewName("score/showUpdateScore");
		} else {
			Service.modifyScore(score);
			mv.setViewName("redirect:/score/selectScore");
		}
		return mv;
	}
	private void genericAssociation(String student_num,Integer course_id,
			Score score){
		if(student_num != null){
			Student student = Service.selectStudentByNum(student_num);
			score.setStudent(student);
		}
		if(course_id != null){
			Course course = new Course();
			course.setId(course_id);
			score.setCourse(course);
		}
	}

}
