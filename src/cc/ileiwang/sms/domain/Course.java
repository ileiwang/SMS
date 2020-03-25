package cc.ileiwang.sms.domain;

import java.util.List;

import cc.ileiwang.sms.domain.Student;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月8日 下午4:41:43
*/
public class Course {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getCoursetime() {
		return coursetime;
	}
	public void setCoursetime(int coursetime) {
		this.coursetime = coursetime;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Course(int id, String num, int day, int coursetime, int start, int last, int credit, String place,
			String name, List<Student> students) {
		super();
		this.id = id;
		this.num = num;
		this.day = day;
		this.coursetime = coursetime;
		this.start = start;
		this.last = last;
		this.credit = credit;
		this.place = place;
		this.name = name;
		this.students = students;
	}
	public Course() {
		super();
	}
	private int id;//id
	private String num;//课程号
	private int day;//周次
	private int coursetime;//节次
	private int start;//开课周次
	private int last;//持续周次
	private int credit;//学分
	private String place;//授课地点
	private String name;//课程名称
	private List <Student> students;//选课学生
}
