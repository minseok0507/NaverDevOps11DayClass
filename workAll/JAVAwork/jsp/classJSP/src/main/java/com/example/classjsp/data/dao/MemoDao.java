package com.example.classjsp.data.dao;

import com.example.classjsp.DBconnect;
import com.example.classjsp.data.dto.MemoDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemoDao {
    DBconnect db = new DBconnect();

    public void insertMeno(MemoDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into mymemo (uploadphoto, title, content, writeday) values(?,?,?,now())";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getUploadPhoto());
            ps.setString(2, dto.getTitle());
            ps.setString(3, dto.getContent());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }

    public List<MemoDto> selectAll() {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<MemoDto> list = new ArrayList<>();
        String sql = "select * from mymemo order by num desc";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MemoDto dto = new MemoDto();
                dto.setNum(rs.getInt("num"));
                dto.setUploadPhoto(rs.getString("uploadphoto"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriteDay(rs.getTimestamp("writeday"));

                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }

        return list;
    }

    public MemoDto selectByNum(int num) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        MemoDto dto = new MemoDto();
        String sql = "select * from mymemo where num = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, num);
            rs = ps.executeQuery();
            if (rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setUploadPhoto(rs.getString("uploadphoto"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriteDay(rs.getTimestamp("writeday"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }

        return dto;
    }
}
