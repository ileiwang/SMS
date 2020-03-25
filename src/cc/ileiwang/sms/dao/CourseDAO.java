package cc.ileiwang.sms.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Many;

import cc.ileiwang.sms.dao.provider.CourseDAOProvider;
import cc.ileiwang.sms.domain.Course;

import static cc.ileiwang.sms.util.common.SMSConstants.COURSETABLE;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月8日 下午5:18:52
*/
public interface CourseDAO {
	
	@SelectProvider(type = CourseDAOProvider.class, method = "selectWhitParam")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"), 
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"),
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.sms.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	List<Course> selectByPage(Map<String, Object> params);

	@SelectProvider(type = CourseDAOProvider.class, method = "countCourse")
	int count(Map<String, Object> params);

	@SelectProvider(type = CourseDAOProvider.class, method = "insertCourse")
	void save(Course course);

	@SelectProvider(type = CourseDAOProvider.class, method = "updateCourse")
	void update(Course course);

	@Select("select * from " + COURSETABLE)
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"), 
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"), 
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.sms.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	List<Course> selectAll();
	
	
	@Select("select * from " + COURSETABLE +" where major_id = #{major_id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"), 
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"), 
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.sms.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	List<Course> selectByMajorId(int major_id);

	@Select("select * from " + COURSETABLE + " where id = #{id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"), 
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"), 
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.sms.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	Course selectById(int id);

	@Select("select * from " + COURSETABLE + " where num = #{num}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"), 
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"), 
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.sms.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	Course selectByNum(String num);

	@Select("select * from " + COURSETABLE
			+ " where id in (select course_id from stucou_item where student_id = #{student_id} )")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"),
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"),
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.sms.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	List<Course> selectByStudentId(int student_id);

	
	@Delete("delete from " + COURSETABLE + " where id = #{id} ")
	void deleteById(int id);

	@Delete("delete from " + COURSETABLE + " where num = #{num} ")
	void deleteByNum(String num);
	
	

}
