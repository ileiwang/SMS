package cc.ileiwang.sms.dao;import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.One;

import cc.ileiwang.sms.dao.provider.ScoreDAOProvider;
import cc.ileiwang.sms.domain.Score;

import static cc.ileiwang.sms.util.common.SMSConstants.SCORETABLE;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月8日 下午5:19:15
*/
public interface ScoreDAO {
	
	@SelectProvider(type=ScoreDAOProvider.class,method="selectWhitParam")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "score", property = "score"),
		@Result(column = "course_id", property = "course", 
			one = @One(select = "cc.ileiwang.sms.dao.CourseDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "student_id", property = "student", 
			one = @One(select = "cc.ileiwang.sms.dao.StudentDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	List<Score> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=ScoreDAOProvider.class,method="countScore")
	int count(Map<String, Object> params);

	@SelectProvider(type=ScoreDAOProvider.class,method="insertScore")
	void save(Score score);
	
	@SelectProvider(type=ScoreDAOProvider.class,method="updateScore")
	void update(Score score);
	
	@Select("select * from "+SCORETABLE)
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "score", property = "score"),
		@Result(column = "course_id", property = "course", 
			one = @One(select = "cc.ileiwang.sms.dao.CourseDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "student_id", property = "student", 
			one = @One(select = "cc.ileiwang.sms.dao.StudentDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	List<Score> selectAll();
	
	@Select("select * from "+SCORETABLE+" where id = #{id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "score", property = "score"),
		@Result(column = "course_id", property = "course", 
			one = @One(select = "cc.ileiwang.sms.dao.CourseDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "student_id", property = "student", 
			one = @One(select = "cc.ileiwang.sms.dao.StudentDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	Score selectById(int id);
	
	@Select("select * from "+SCORETABLE+" where student_id = #{student_id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "score", property = "score"),
		@Result(column = "course_id", property = "course", 
			one = @One(select = "cc.ileiwang.sms.dao.CourseDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "student_id", property = "student", 
			one = @One(select = "cc.ileiwang.sms.dao.StudentDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	List<Score> selectByStudentId(int student_id);
	
	@Delete("delete from "+SCORETABLE+" where id = #{id} ")
	void deleteById(int id);
	
	@Delete("delete from "+SCORETABLE+" where student_id = #{student_id} ")
	void deleteByStudentId(int student_id);

}
