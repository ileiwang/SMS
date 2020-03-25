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
* @version 2018��5��8�� ����5:28:36
*/
public interface SMSService {
	//Admin����
	
	//������
	public List<Admin> findAdmin(Admin admin,PageModel pageModel);
	public List<Admin> findAllAdmin();
	//������
	public Admin selectAdminById(int id);
	public Admin selectAdminByNum(String num);
	//���
	public void addAdmin(Admin admin);
	//�޸�
	public void modifyAdmin(Admin admin);
	//ɾ��
	public void deleteAdminById(int id);
	public void deleteAdminByNum(String num);
	
	
	//Course����
	
	//������
	public List<Course> findCourse(Course course,PageModel pageModel);
	public List<Course> findAllCourse();
	public List<Course> selectCourseByStudentId(int student_id);
	//������
	public Course selectCourseById(int id);
	public Course selectCourseByNum(String num);
	//���
	public void addCourse(Course course);
	//�޸�
	public void modifyCourse(Course course);
	//ɾ��
	public void deleteCourseById(int id);
	public void deleteCourseByNum(String num);
	
	
	//Score����
	
	//������
	public List<Score> findScore(Score score,PageModel pageModel);
	public List<Score> findAllScore();
	public List<Score> selectScoreByStudentId(int student_id);
	//������
	public Score selectScoreById(int id);
	//���
	public void addScore(Score score);
	//�޸�
	public void modifyScore(Score score);
	//ɾ��
	public void deleteScoreById(int id);
	public void deleteScoreByStudentId(int student_id);
	
	
	
	//Student����
	
	//������
	public List<Student> findStudent(Student student,PageModel pageModel);
	public List<Student> findAllStudent();
	public List<Student> selectStudentByClazzId(int clazz_id);
	public List<Student> selectStudentByCourseId(int course_id);
	//������
	public Student selectStudentById(int id);
	public Student selectStudentByNum(String num);
	//���
	public void addStudent(Student student);
	//�޸�
	public void modifyStudent(Student student);
	//ɾ��
	public void deleteStudentById(int id);
	public void deleteStudentByNum(String num);
	public void deleteByCourseId(int course_id);
	
	
	
	//ѡ�β���-ѡ��
	public void chooseCourse(int student_id,int course_id);
	
	//ѡ�β���-��ѡ
	public void unchooseCourse(int student_id,int course_id);
	
	
	//Login����
	
	public Student studentlogin(String num,String password);
	public Admin adminlogin(String num,String password);

}
