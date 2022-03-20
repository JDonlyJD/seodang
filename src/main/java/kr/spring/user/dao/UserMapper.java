package kr.spring.user.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.user.vo.UserVO;

public interface UserMapper {
	//사용자
	@Select("SELECT ouser_seq.nextval FROM dual")
	public int selectUser_num();
	@Insert("INSERT INTO ouser (user_num,id,auth) VALUES (#{user_num},#{id},#{auth})")
	public void insertUser(UserVO user);
	@Insert("INSERT INTO ouser_detail(user_num,name,age,passwd,phone,email,zipcode,address1,address2) VALUES (#{user_num},#{name},#{age},#{passwd},#{phone},#{email},#{zipcode},#{address1},#{address2})")
	public void insertUser_detail(UserVO user);
	@Select("SELECT u.user_num,d.name,u.auth,d.passwd,d.photo FROM ouser u LEFT OUTER JOIN ouser_detail d ON u.user_num=d.user_num WHERE u.id=#{id}")
	public UserVO selectCheckUser(String id);
	@Select("SELECT * FROM ouser u JOIN ouser_detail d "
			+ "ON u.user_num=d.user_num WHERE u.user_num=#{user_num}")
	public UserVO selectUser(Integer user_num);
	@Update("UPDATE ouser_detail SET name=#{name},phone=#{phone},zipcode=#{zipcode},"
			+ "address1=#{address1},address2=#{address2},email=#{email},age=#{age},modify_date=SYSDATE "
			+ "WHERE user_num=#{user_num}")
	public void updateUser(UserVO user);
	@Update("UPDATE ouser_detail SET passwd=#{passwd} WHERE user_num=#{user_num}")
	public void updatePassword(UserVO user);
	public void deleteUser(Integer user_num);
	public void deleteUser_detail(Integer user_num);
	public void updateProfile(UserVO user);
}
