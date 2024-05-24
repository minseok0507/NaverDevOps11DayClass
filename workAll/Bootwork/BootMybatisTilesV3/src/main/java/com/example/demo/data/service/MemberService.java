package com.example.demo.data.service;

import com.example.demo.data.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.mapper.MemberMapperInter;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
	@Autowired
	private MemberMapperInter memberMapperInter;
	
	public int getTotalCount()
	{
		return memberMapperInter.getTotalCount();
	}

	@Transactional
	public void insertMember(MemberDto memberDto) {
		try {
			int check = memberMapperInter.insertMember(memberDto);
			if (check != 1) {
				// 오류 처리
				throw new RuntimeException("데이터 삽입 실패");
			}
		} catch (Exception e) {
			// 오류 처리
			throw new RuntimeException("데이터 삽입 중 오류가 발생했습니다.", e);
		}
	}
}
