package member.dao;

import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MemberDao {
    private final SqlSession sqlSession;
    private final String namespace = "member.dao.MemberDao.";

    public int getTotalCount(){
        return sqlSession.selectOne(namespace+"memberTotalCount");
    }

    public List<MemberDto> getMemberList(){
        return sqlSession.selectList(namespace+"selectAll");
    }

    public int idCheck(String id){
        return sqlSession.selectOne(namespace+"idCheck",id);
    }

    public int insertMember(MemberDto memberDto){
        return sqlSession.insert(namespace+"insertMember",memberDto);
    }

    public int deleteByNum(int num){
        return sqlSession.delete(namespace+"deleteByNum",num);
    }

    public MemberDto findByNum(int num){
        return sqlSession.selectOne(namespace+"findByNum",num);
    }

    public int updatePhotoByNum(Map<String, Object> updateData) {
        return sqlSession.update(namespace + "updatePhotoByNum", updateData);
    }

    public void updatePhoto(Map<String, Object> map) {
        sqlSession.update(namespace+"updatePhoto", map);
    }

    public int updateMemberByDto(MemberDto memberDto) {
        return sqlSession.update(namespace+"updateMemberByDto", memberDto);
    }


}
