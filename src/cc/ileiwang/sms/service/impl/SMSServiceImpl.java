package cc.ileiwang.sms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cc.ileiwang.sms.dao.AdminDAO;
import cc.ileiwang.sms.dao.CourseDAO;
import cc.ileiwang.sms.dao.ScoreDAO;
import cc.ileiwang.sms.dao.StudentDAO;
import cc.ileiwang.sms.domain.Admin;
import cc.ileiwang.sms.domain.Course;
import cc.ileiwang.sms.domain.Score;
import cc.ileiwang.sms.domain.Student;
import cc.ileiwang.sms.service.SMSService;
import cc.ileiwang.sms.util.tag.PageModel;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月8日 下午5:31:03
*/
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("Service")
public class SMSServiceImpl implements SMSService{
	
	@Autowired
	private AdminDAO adminDao;

	@Autowired
	private CourseDAO courseDao;

	@Autowired
	private ScoreDAO scoreDao;

	@Autowired
	private StudentDAO studentDao;
	


	// Admin操作
	// 批查找
	@Transactional(readOnly = true)
	@Override
	public List<Admin> findAdmin(Admin admin, PageModel pageModel) {

		Map<String, Object> params = new HashMap<>();
		params.put("admin", admin);
		int recordCount = adminDao.count(params);
		pageModel.setRecordCount(recordCount);
		if (recordCount > 0) {
			params.put("pageModel", pageModel);
		}
		List<Admin> admins = adminDao.selectByPage(params);
		return admins;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Admin> findAllAdmin() {
		return adminDao.selectAll();
	}

	// 单查找
	@Transactional(readOnly = true)
	@Override
	public Admin selectAdminById(int id) {
		return adminDao.selectById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Admin selectAdminByNum(String num) {
		return adminDao.selectByNum(num);
	}

	// 添加
	@Override
	public void addAdmin(Admin admin) {
		adminDao.save(admin);
	}

	// 修改
	@Override
	public void modifyAdmin(Admin admin) {
		adminDao.update(admin);
	}

	// 删除
	@Override
	public void deleteAdminById(int id) {
		adminDao.deleteById(id);
	}
	@Override
	public void deleteAdminByNum(String num) {
		adminDao.deleteByNum(num);
	}


	// Course操作
	// 批查找
	@Transactional(readOnly = true)
	@Override
	public List<Course> findCourse(Course course, PageModel pageModel) {
		Map<String, Object> params = new HashMap<>();
		params.put("course", course);
		int recordCount = courseDao.count(params);
		pageModel.setRecordCount(recordCount);
		if (recordCount > 0) {
			params.put("pageModel", pageModel);
		}
		List<Course> courses = courseDao.selectByPage(params);
		return courses;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Course> findAllCourse() {
		return courseDao.selectAll();
	}


	@Transactional(readOnly = true)
	@Override
	public List<Course> selectCourseByStudentId(int student_id) {
		return courseDao.selectByStudentId(student_id);
	}
	

	// 单查找
	@Transactional(readOnly = true)
	@Override
	public Course selectCourseById(int id) {
		return courseDao.selectById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Course selectCourseByNum(String num) {
		return courseDao.selectByNum(num);
	}

	// 添加
	@Override
	public void addCourse(Course course) {
		courseDao.save(course);
	}

	// 修改
	@Override
	public void modifyCourse(Course course) {
		courseDao.update(course);
	}

	// 删除
	@Override
	public void deleteCourseById(int id) {
		courseDao.deleteById(id);
	}
	@Override
	public void deleteCourseByNum(String num) {
		courseDao.deleteByNum(num);
	}


	// Score操作
	// 批查找
	@Transactional(readOnly = true)
	@Override
	public List<Score> findScore(Score score, PageModel pageModel) {
		Map<String, Object> params = new HashMap<>();
		params.put("score", score);
		int recordCount = scoreDao.count(params);
		pageModel.setRecordCount(recordCount);
		if (recordCount > 0) {
			params.put("pageModel", pageModel);
		}
		List<Score> scores = scoreDao.selectByPage(params);
		return scores;

	}

	@Transactional(readOnly = true)
	@Override
	public List<Score> findAllScore() {
		return scoreDao.selectAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Score> selectScoreByStudentId(int student_id) {
		return scoreDao.selectByStudentId(student_id);
	}

	// 单查找
	@Transactional(readOnly = true)
	@Override
	public Score selectScoreById(int id) {
		return scoreDao.selectById(id);

	}


	// 添加
	@Override
	public void addScore(Score score) {
		scoreDao.save(score);
	}

	// 修改
	@Override
	public void modifyScore(Score score) {
		scoreDao.update(score);
	}

	// 删除
	@Override
	public void deleteScoreById(int id) {
		scoreDao.deleteById(id);
	}
	@Override
	public void deleteScoreByStudentId(int student_id) {
		scoreDao.deleteByStudentId(student_id);
	}

	// Student操作
	// 批查找
	@Transactional(readOnly = true)
	@Override
	public List<Student> findStudent(Student student, PageModel pageModel) {
		Map<String, Object> params = new HashMap<>();
		params.put("student", student);
		int recordCount = studentDao.count(params);
		pageModel.setRecordCount(recordCount);
		if (recordCount > 0) {
			params.put("pageModel", pageModel);
		}
		List<Student> students = studentDao.selectByPage(params);
		return students;

	}

	@Transactional(readOnly = true)
	@Override
	public List<Student> findAllStudent() {
		return studentDao.selectAllStudent();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Student> selectStudentByClazzId(int clazz_id) {
		return studentDao.selectByClazzId(clazz_id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Student> selectStudentByCourseId(int course_id) {
		return studentDao.selectByCourseId(course_id);
	}

	// 单查找
	@Transactional(readOnly = true)
	@Override
	public Student selectStudentById(int id) {
		return studentDao.selectById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Student selectStudentByNum(String num) {
		return studentDao.selectByNum(num);
	}

	// 添加
	@Override
	public void addStudent(Student student) {
		studentDao.save(student);
	}

	// 修改
	@Override
	public void modifyStudent(Student student) {
		studentDao.update(student);
	}

	// 删除
	@Override
	public void deleteStudentById(int id) {
		studentDao.deleteById(id);
	}
	@Override
	public void deleteStudentByNum(String num) {
		studentDao.deleteByNum(num);
	}
	@Override
	public void deleteByCourseId(int course_id) {
		studentDao.deleteByCourseId(course_id);
	}
	
	
	
	//选课操作-选课
	@Override
	public void chooseCourse(int student_id,int course_id) {
		System.out.println("IN IMPL "+student_id+"**********");
		studentDao.chooseCourse(student_id,course_id);
	}
	
	//选课操作-退选
	@Override
	public void unchooseCourse(int student_id,int course_id) {
		System.out.println("IN IMPL "+student_id+"**********");
		studentDao.unchooseCourse(student_id,course_id);
	}
	

	// Login操作
	@Transactional(readOnly = true)
	@Override
	public Student studentlogin(String num, String password) {
		return studentDao.selectByNumAndPassword(num, password);
	}

	@Transactional(readOnly = true)
	@Override
	public Admin adminlogin(String num, String password) {
		return adminDao.selectByNumAndPassword(num, password);
	}

}
