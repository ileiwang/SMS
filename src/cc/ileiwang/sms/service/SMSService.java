package cc.ileiwang.sms.service;
import java.util.List;

import cc.ileiwang.sms.domain.Admin;
import cc.ileiwang.sms.domain.Course;
import cc.ileiwang.sms.domain.Score;
import cc.ileiwang.sms.domain.Student;
import cc.ileiwang.sms.util.tag.PageModel;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月8日 下午5:28:36
*/
public interface SMSService {
	//Admin操作
	
	//批查找
	public List<Admin> findAdmin(Admin admin,PageModel pageModel);
	public List<Admin> findAllAdmin();
	//单查找
	public Admin selectAdminById(int id);
	public Admin selectAdminByNum(String num);
	//添加
	public void addAdmin(Admin admin);
	//修改
	public void modifyAdmin(Admin admin);
	//删除
	public void deleteAdminById(int id);
	public void deleteAdminByNum(String num);
	
	
	//Course操作
	
	//批查找
	public List<Course> findCourse(Course course,PageModel pageModel);
	public List<Course> findAllCourse();
	public List<Course> selectCourseByStudentId(int student_id);
	//单查找
	public Course selectCourseById(int id);
	public Course selectCourseByNum(String num);
	//添加
	public void addCourse(Course course);
	//修改
	public void modifyCourse(Course course);
	//删除
	public void deleteCourseById(int id);
	public void deleteCourseByNum(String num);
	
	
	//Score操作
	
	//批查找
	public List<Score> findScore(Score score,PageModel pageModel);
	public List<Score> findAllScore();
	public List<Score> selectScoreByStudentId(int student_id);
	//单查找
	public Score selectScoreById(int id);
	//添加
	public void addScore(Score score);
	//修改
	public void modifyScore(Score score);
	//删除
	public void deleteScoreById(int id);
	public void deleteScoreByStudentId(int student_id);
	
	
	
	//Student操作
	
	//批查找
	public List<Student> findStudent(Student student,PageModel pageModel);
	public List<Student> findAllStudent();
	public List<Student> selectStudentByClazzId(int clazz_id);
	public List<Student> selectStudentByCourseId(int course_id);
	//单查找
	public Student selectStudentById(int id);
	public Student selectStudentByNum(String num);
	//添加
	public void addStudent(Student student);
	//修改
	public void modifyStudent(Student student);
	//删除
	public void deleteStudentById(int id);
	public void deleteStudentByNum(String num);
	public void deleteByCourseId(int course_id);
	
	
	
	//选课操作-选课
	public void chooseCourse(int student_id,int course_id);
	
	//选课操作-退选
	public void unchooseCourse(int student_id,int course_id);
	
	
	//Login操作
	
	public Student studentlogin(String num,String password);
	public Admin adminlogin(String num,String password);

}
