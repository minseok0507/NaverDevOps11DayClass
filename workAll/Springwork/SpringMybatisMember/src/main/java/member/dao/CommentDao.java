package member.dao;

import lombok.RequiredArgsConstructor;
import member.dto.CommentDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentDao {
    private final SqlSessionTemplate sqlSessionTemplate;

    public List<CommentDto> getCommentsByMemberNum(int memberNum) {
        return sqlSessionTemplate.selectList("getCommentsByMemberNum", memberNum);
    }

    public int insertComment(CommentDto commentDto) {
        return sqlSessionTemplate.insert("insertComment", commentDto);
    }

    public int updateComment(CommentDto commentDto) {
        return sqlSessionTemplate.update("updateComment", commentDto);
    }

    public int deleteComment(int commentId) {
        return sqlSessionTemplate.delete("deleteComment", commentId);
    }
}
