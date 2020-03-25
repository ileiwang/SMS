package cc.ileiwang.sms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.sms.domain.Student;
import cc.ileiwang.sms.util.common.SMSConstants;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018��5��8�� ����5:46:46
*/
public class AuthorizedInterceptor implements HandlerInterceptor{
	
	/** ���岻��Ҫ���ص����� */
	private static final String[] IGNORE_URI = { "/loginForm", "/login", "/404.html" };

	/**
	 * �÷�����ҪpreHandle�����ķ���ֵΪtrueʱ�Ż�ִ�С� �÷������������������֮��ִ�У���Ҫ����������������Դ��
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

	}

	/**
	 * ���������preHandle��������ֵΪtrue��ʱ��Ż�ִ�С� ִ��ʱ�����ڴ��������д���֮ ��Ҳ������Controller�ķ�������֮��ִ�С�
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {

	}

	/**
	 * preHandle�����ǽ��д����������õģ��÷�������Controller����֮ǰ���е��ã�
	 * ��preHandle�ķ���ֵΪfalse��ʱ����������ͽ����ˡ�
	 * ���preHandle�ķ���ֵΪtrue��������ִ��postHandle��afterCompletion��
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/** Ĭ���û�û�е�¼ */
		boolean flag = false;
		/** ��������ServletPath */
		String servletPath = request.getServletPath();
		/** �ж������Ƿ���Ҫ���� */
		for (String s : IGNORE_URI) {
			if (servletPath.contains(s)) {
				flag = true;
				break;
			}
		}
		/** �������� */
		if (!flag) {
			/** 1.��ȡsession�е��û� */
			Student student = (Student) request.getSession().getAttribute(SMSConstants.USER_SESSION);
			/** 2.�ж��û��Ƿ��Ѿ���¼ */
			if (student == null) {
				/** ����û�û�е�¼����ת����¼ҳ�� */
				request.setAttribute("message", "���ȵ�¼�ٷ�����վ!");
				request.getRequestDispatcher(SMSConstants.LOGIN).forward(request, response);
				return flag;
			} else {
				flag = true;
			}
		}
		return flag;
	}

}
