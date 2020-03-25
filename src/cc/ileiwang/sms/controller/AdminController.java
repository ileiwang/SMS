package cc.ileiwang.sms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.sms.domain.Admin;
import cc.ileiwang.sms.service.SMSService;
import cc.ileiwang.sms.util.tag.PageModel;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018��5��8�� ����5:26:33
*/
@Controller
public class AdminController {
	
	// �Զ�ע��Service
	@Autowired
	@Qualifier("Service")
	private SMSService Service;
	
	// ѡ�����Ա
	@RequestMapping(value = "/admin/selectAdmin")
	public String selectAdmin(Integer pageIndex, @ModelAttribute Admin admin, Model model) {
		PageModel pageModel = new PageModel();
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		List<Admin> admins = Service.findAdmin(admin, pageModel);
		model.addAttribute("admins", admins);
		return "admin/admin";

	}
	
	
	//��ӹ���Ա
	@RequestMapping(value = "/admin/addAdmin")
	public ModelAndView addAdmin(String flag, @ModelAttribute Admin admin, ModelAndView mv) {
		if (flag.equals("1")) {
			mv.setViewName("admin/addAdmin");
		} else {
			Service.addAdmin(admin);
			mv.setViewName("redirect:main");
		}
		return mv;
	}

	// ɾ������Ա
	@RequestMapping(value = "/admin/removeAdmin")
	public ModelAndView removeUser(String ids, ModelAndView mv) {
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			Service.deleteAdminById(Integer.parseInt(id));
		}
		mv.setViewName("redirect:/admin/selectAdmin");
		return mv;
	}

	// ���¹���Ա
	@RequestMapping(value = "/admin/updateAdmin")
	public ModelAndView updateAdmin(String flag, @ModelAttribute Admin admin, ModelAndView mv) {
		if (flag.equals("1")) {
			Admin target = Service.selectAdminById(admin.getId());
			mv.addObject("admin", target);
			mv.setViewName("admin/showUpdateAdmin");
		} else {
			Service.modifyAdmin(admin);
			mv.setViewName("redirect:/admin/selectAdmin");
		}
		return mv;
	}

}
