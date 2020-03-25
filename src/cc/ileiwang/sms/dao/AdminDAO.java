package cc.ileiwang.sms.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import cc.ileiwang.sms.dao.provider.AdminDAOProvider;
import cc.ileiwang.sms.domain.Admin;

import static cc.ileiwang.sms.util.common.SMSConstants.ADMINTABLE;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月8日 下午5:19:37
*/
public interface AdminDAO {
	
	@SelectProvider(type=AdminDAOProvider.class,method="selectWhitParam")
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
		@Result(column="address",property="address")
	})
	List<Admin> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=AdminDAOProvider.class,method="countAdmin")
	int count(Map<String, Object> params);

	@SelectProvider(type=AdminDAOProvider.class,method="insertAdmin")
	void save(Admin admin);
	
	@SelectProvider(type=AdminDAOProvider.class,method="updateAdmin")
	void update(Admin admin);
	
	@Select("select * from "+ADMINTABLE)
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
		@Result(column="address",property="address")
	})
	List<Admin> selectAll();
	
	@Select("select * from "+ADMINTABLE+" where id = #{id}")
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
		@Result(column="address",property="address")
	})
	Admin selectById(int id);
	
	@Select("select * from "+ADMINTABLE+" where num = #{num}")
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
		@Result(column="address",property="address")
	})
	Admin selectByNum(String num);
	
	@Select("select * from "+ADMINTABLE+" where num = #{num} and password = #{password}")
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
		@Result(column="address",property="address")
	})
	Admin selectByNumAndPassword(String num,String password);
	
	@Delete("delete from "+ADMINTABLE+" where id = #{id} ")
	void deleteById(int id);
	
	@Delete("delete from "+ADMINTABLE+" where num = #{num} ")
	void deleteByNum(String num);

}
