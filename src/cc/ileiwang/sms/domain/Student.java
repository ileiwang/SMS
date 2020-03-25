package cc.ileiwang.sms.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import cc.ileiwang.sms.domain.Course;
import cc.ileiwang.sms.domain.Score;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018��5��8�� ����4:40:38
*/
public class Student {
	public Student(int id, String num, String name, Date birthday, String idcard, String sex, String password,
			String tel, String qq, String email, String address, List<Course> courses, List<Score> scores) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.birthday = birthday;
		this.idcard = idcard;
		this.sex = sex;
		this.password = password;
		this.tel = tel;
		this.qq = qq;
		this.email = email;
		this.address = address;
		this.courses = courses;
		this.scores = scores;
	}
	public Student() {
		super();
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public List<Score> getScores() {
		return scores;
	}
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	private int id;//id
	private String num;//ѧ��
	private String name;//����
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;//����
	private String idcard;//���֤
	private String sex;//�Ա�
	private String password;//����
	private String tel;//�绰
	private String qq;//QQ
	private String email;//����
	private String address;//��ϵ��ʽ
	private List<Course> courses;//�γ̱�
	private List<Score> scores;//�ɼ���
}
