package com.example.demo.data.mapper;

import com.example.demo.data.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapperInter {
    @Select("select * from member_board order by ref, step;")
    @ResultMap("boardResultMap")
    List<BoardDto> selectAll();

    @Select("SELECT * FROM member_board ORDER BY ref, step  LIMIT #{index}, #{offset}")
    @ResultMap("boardResultMap")
    List<BoardDto> getBoardPage(@Param("index") int index, @Param("offset") int offset);

    @Select("select count(*) from member_board")
    int getBoardCountAll();

    @Insert("INSERT INTO member_board (board_title, board_content, view_count, recommend_count, write_user, ref, step, level) " +
            "VALUES (#{boardTitle}, #{boardContent}, #{viewCount}, #{recommendCount}, #{writeUser}, #{ref}, #{step}, #{level})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertBoard(BoardDto boardDto);

    @Update("UPDATE member_board SET ref = #{id} WHERE id = #{id} AND ref = 0")
    void updateRef(BoardDto boardDto);

    @Update("update member_board set step=step+1 where ref=#{ref} and step>=#{step}")
    void updateStep(@Param("ref") int ref, @Param("step") int step);


    @Select("select * from member_board where id=#{id}")
    @ResultMap("boardResultMap")
    public BoardDto selectById(@Param("id") int id);

    @Update("update member_board set view_count=view_count+1 where id=#{id}")
    void updateViewCount(@Param("id") int id);

    @Update("update member_board set board_title = #{title}, board_content = #{content} where id=#{id}")
    void updateBoard(@Param("title") String title, @Param("content") String content, @Param("id") int id);

//
//    int updateStep(int ref, int step);
//
//    public int getMaxNum();
//    public void updateRestep(Map<String, Integer> map);//regroup,restep
////    public void insertBoard(ReBoardDto dto);
//    public int getTotalCount();
////    public List<ReBoardDto> getPagingList(Map<String, Integer> map);//start,perpage
//    public void updateReadcount(int num);
////    public ReBoardDto getData(int num);


}
