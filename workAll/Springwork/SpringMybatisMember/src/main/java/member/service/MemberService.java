package member.service;

import lombok.RequiredArgsConstructor;
import member.dao.MemberDao;
import member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MemberService {
    private final MemberDao memberDao;

    public int getTotalCount(){
        return memberDao.getTotalCount();
    }

    public List<MemberDto> getMemberList(){
        return memberDao.getMemberList();
    }

    public int idCheck(String id){
        return memberDao.idCheck(id);
    }

    public void insertMember(MemberDto memberDto){
        memberDao.insertMember(memberDto);
    }

    public int deleteByNum(int num){
        return memberDao.deleteByNum(num);
    }

    public MemberDto findByNum(int num){
        return memberDao.findByNum(num);
    }

    public int updatePhotoByNum(Map<String, Object> updateData) {
        return memberDao.updatePhotoByNum(updateData);
    }

    public void updatePhoto(int num,String photo)
    {
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("num", num);
        map.put("photo", photo);
        memberDao.updatePhoto(map);
    }

    public int updateMemberByDto(MemberDto memberDto){
        return memberDao.updateMemberByDto(memberDto);
    }


}
