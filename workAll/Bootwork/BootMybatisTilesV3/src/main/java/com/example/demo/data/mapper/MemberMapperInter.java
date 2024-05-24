package com.example.demo.data.mapper;

import com.example.demo.data.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapperInter {
	@Select("select count(*) from memberdb")
	int getTotalCount();

	@Select("select count(*) from memberdb where myid = #{myid}")
	int searchIdCheck(@Param("myid") String myid);

	int insertMember(MemberDto memberDto);
}
