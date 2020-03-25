package cc.ileiwang.sms.domain;

import cc.ileiwang.sms.domain.Course;
import cc.ileiwang.sms.domain.Student;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月8日 下午4:41:32
*/
public class Score {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Score(int id, int score, Course course, Student student) {
		super();
		this.id = id;
		this.score = score;
		this.course = course;
		this.student = student;
	}
	public Score() {
		super();
	}
	int id;//id
	int score;//分数
	Course course;//对应课程
	Student student;//对应学生

}
