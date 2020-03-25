package cc.ileiwang.sms.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Many;

import cc.ileiwang.sms.domain.*;
import cc.ileiwang.sms.dao.provider.*;

import static cc.ileiwang.sms.util.common.SMSConstants.*;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月8日 下午5:18:17
*/
public interface StudentDAO {
	
	//根据页码选择学生（分页使用）
	@SelectProvider(type=StudentDAOProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.sms.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.sms.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	List<Student> selectByPage(Map<String, Object> params);
	
	//统计学生数
	@SelectProvider(type=StudentDAOProvider.class,method="countStudent")
	int count(Map<String, Object> params);

	//添加
	@SelectProvider(type=StudentDAOProvider.class,method="insertStudent")
	void save(Student student);
	
	
	
	//更新
	@SelectProvider(type=StudentDAOProvider.class,method="updateStudent")
	void update(Student student);
	
	//选择全部学生
	@Select("select * from "+STUDENTTABLE)
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.sms.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.sms.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	List<Student> selectAllStudent();
	
	//根据ID选择学生
	@Select("select * from "+STUDENTTABLE+" where id = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.sms.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.sms.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	Student selectById(int id);
	
	//根据学号选择学生
	@Select("select * from "+STUDENTTABLE+" where num = #{num}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.sms.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.sms.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	Student selectByNum(@Param("num")String num);
	
	//根据学号密码查询
	@Select("select * from "+STUDENTTABLE+" where num = #{num} and password = #{password}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.sms.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.sms.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	Student selectByNumAndPassword(@Param("num")String num,@Param("password")String password);
	
	// 根据班级id查询班级所有学生
	@Select("select * from student where clazz_id = #{clazz_id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.sms.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.sms.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	List<Student> selectByClazzId(int clazz_id);
	
	
	// 根据学生-课程表查询所有学生
	@Select("select * from student where id in (SELECT student_id FROM stucou_item where course_id = #{course_id})")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.sms.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.sms.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	List<Student> selectByCourseId(int course_id);
	
	
	
	
	//根据ID删除学生
	@Delete("delete from "+STUDENTTABLE+" where id = #{id} ")
	void deleteById(int id);
	
	
	//根据学号删除学生
	@Delete("delete from "+STUDENTTABLE+" where num = #{num} ")
	void deleteByNum(String num);
	
	
	//根据班级删除所有学生
	@Delete("delete from "+STUDENTTABLE+" where clazz_id = #{clazz_id} ")
	void deleteByClazzId(int clazz_id);
	
	
	//根据课程号删除所有学生（从学生-课程表里获取所有学生ID）
	@Delete("delete from "+STUDENTTABLE+" where id in (select student_id from stucou_item where course_id = #{course_id})")
	void deleteByCourseId(int course_id);
	
	
	
	//添加课程
//	@InsertProvider(type=StudentDAOProvider.class,method="saveCourse")
//	void saveCourse(int student_id,int course_id);
	
//	@Delete("delete from "+STUCOUTABLE+" where course_id = '1'")
//	void savCourse(int student_id,int course_id);
	
	//选课
	@Insert("insert into "+STUCOUTABLE+" (student_id,course_id) VALUES (${student_id},${course_id})")
	void chooseCourse(@Param("student_id") int student_id,@Param("course_id") int course_id);
	
	//退选
	@Delete("delete from "+STUCOUTABLE+" where student_id = ${student_id} and course_id = ${course_id}")
	void unchooseCourse(@Param("student_id") int student_id,@Param("course_id") int course_id);
}
