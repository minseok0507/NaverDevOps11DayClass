package com.example.demo.data.service;

import com.example.demo.data.dto.MemberDto;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.mapper.MemberMapperInter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapperInter memberMapperInter;

    public int getTotalCount() {
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

    public MemberDto getMemberById(int num) {
        return memberMapperInter.selectByNum(num);
    }

    public MemberDto selectByMyid(String myid) {
        return memberMapperInter.selectByMyid(myid);
    }

    public List<MemberDto> selectAll() {
        return memberMapperInter.selectAll();
    }

    public int updatePhoto(String photo, int num) {
        return memberMapperInter.updatePhoto(photo, num);
    }

    public int updateMember(MemberDto memberDto) {
        return memberMapperInter.updateMemberByDto(memberDto);
    }

    public int deleteMember(int num) {
        return memberMapperInter.deleteMemberByNum(num);
    }

    public int loginCheck(String myid, String passwd) {
        return memberMapperInter.loginCheck(myid, passwd);
    }
}
