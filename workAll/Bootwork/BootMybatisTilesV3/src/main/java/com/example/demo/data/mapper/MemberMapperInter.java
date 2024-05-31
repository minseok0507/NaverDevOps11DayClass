package com.example.demo.data.mapper;

import com.example.demo.data.dto.MemberDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapperInter {
	@Select("select * from memberdb")
	List<MemberDto> selectAll();

	@Select("select * from memberdb where num = #{num}")
	MemberDto selectByNum(@Param("num") int num);

	@Select("select * from memberdb where myid = #{myid}")
	MemberDto selectByMyid(@Param("myid") String myid);

	@Select("select count(*) from memberdb")
	int getTotalCount();

	@Select("select count(*) from memberdb where myid = #{myid}")
	int searchIdCheck(@Param("myid") String myid);

	@Insert("insert into memberdb (name, myid, passwd, addr, hp, email, photo, birthday, registday) "
			+ "values (#{name}, #{myid}, #{passwd}, #{addr}, #{hp}, #{email}, #{photo}, #{birthday}, now())")
	int insertMember(MemberDto memberDto);

	@Update("UPDATE memberdb SET photo = #{photo} WHERE num = #{num}")
	int updatePhoto(@Param("photo") String photo, @Param("num") int num);

	@Update("UPDATE memberdb SET name = #{name}, myid = #{myid}, hp = #{hp}, email = #{email}, addr = #{addr} WHERE num = #{num}")
	int updateMemberByDto(MemberDto memberDto);

	@Delete("DELETE FROM memberdb WHERE num = #{num}")
	int deleteMemberByNum(@Param("num") int num);



//	로그인
	@Select("select count(*) from memberdb where myid = #{myid} and passwd = #{passwd}")
	int loginCheck(@Param("myid") String myid, @Param("passwd") String passwd);

}
