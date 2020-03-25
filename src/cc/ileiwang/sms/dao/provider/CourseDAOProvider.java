package cc.ileiwang.sms.dao.provider;
import static cc.ileiwang.sms.util.common.SMSConstants.COURSETABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cc.ileiwang.sms.domain.Course;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018��5��8�� ����5:22:00
*/
public class CourseDAOProvider {
	
	// ��ҳ��̬��ѯ
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(COURSETABLE);
				if (params.get("course") != null) {
					Course course = (Course) params.get("course");
					if (course.getName() != null && !course.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{course.name},'%') ");
					}
				}
			}
		}.toString();

		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		return sql;
	}

	// ��̬��ѯ������
	public String countCourse(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(COURSETABLE);
				if (params.get("course") != null) {
					Course course = (Course) params.get("course");
					if (course.getName() != null && !course.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{course.name},'%') ");
					}
				}
			}
		}.toString();
	}

	// ��̬����
	public String insertCourse(Course course) {

		return new SQL() {
			{
				INSERT_INTO(COURSETABLE);
				if (course.getNum() != null && !course.getNum().equals("")) {
					VALUES("num", "#{num}");
				}
				if (course.getDay() != 0) {
					VALUES("day", "#{day}");
				}
				if (course.getCoursetime()!=0) {
					VALUES("coursetime", "#{coursetime}");
				}
				if (course.getStart()!=0) {
					VALUES("start", "#{start}");
				}
				if (course.getLast() != 0) {
					VALUES("last", "#{last}");
				}
				if (course.getCredit() != 0) {
					VALUES("credit", "#{credit}");
				}
				if (course.getPlace() != null && !course.getPlace().equals("")) {
					VALUES("place", "#{place}");
				}
				if (course.getName() != null && !course.getName().equals("")) {
					VALUES("name", "#{name}");
				}
			}
		}.toString();
	}

	// ��̬����
	public String updateCourse(Course course) {

		return new SQL() {
			{
				UPDATE(COURSETABLE);
				if (course.getNum() != null && !course.getNum().equals("")) {
					SET("num = #{num}");
				}
				if (course.getDay() != 0) {
					SET("day = #{day}");
				}
				if (course.getCoursetime()!=0) {
					SET("coursetime = #{coursetime}");
				}
				if (course.getStart()!=0) {
					SET("start = #{start}");
				}
				if (course.getLast() != 0) {
					SET("last = #{last}");
				}
				if (course.getCredit() != 0) {
					SET("credit = #{credit}");
				}
				if (course.getPlace() != null && !course.getPlace().equals("")) {
					SET("place = #{place}");
				}
				if (course.getName() != null && !course.getName().equals("")) {
					SET("name = #{name}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}
