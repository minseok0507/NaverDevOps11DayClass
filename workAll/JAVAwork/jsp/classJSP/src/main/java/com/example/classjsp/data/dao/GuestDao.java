package com.example.classjsp.data.dao;

import com.example.classjsp.DBconnect;
import com.example.classjsp.data.dto.GuestDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestDao {
    DBconnect db = new DBconnect();

    public List<GuestDto> getSearchGuest(String searchWord) {
        List<GuestDto> guests = new ArrayList<>();
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from guest where nickname like ? order by num desc";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + searchWord + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                GuestDto guest = new GuestDto();

                guest.setWriteday(rs.getTimestamp("writeday"));
                guest.setNum(rs.getInt("num"));
                guest.setAvata(rs.getString("avata"));
                guest.setNickname(rs.getString("nickname"));
                guest.setContent(rs.getString("content"));

                guests.add(guest);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return guests;
    }


    public void insertMeno(GuestDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into guest (nickname, avata, content, writeday) values(?,?,?,now())";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getNickname());
            ps.setString(2, dto.getAvata());
            ps.setString(3, dto.getContent());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }

    public List<GuestDto> selectAll() {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<GuestDto> list = new ArrayList<>();
        String sql = "select * from guest order by num desc";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                GuestDto dto = new GuestDto();
                dto.setNum(rs.getInt("num"));
                dto.setNickname(rs.getString("nickname"));
                dto.setAvata(rs.getString("avata"));
                dto.setContent(rs.getString("content"));
                dto.setWriteday(rs.getTimestamp("writeday"));

                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }

        return list;
    }

    public GuestDto selectByNum(int num) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        GuestDto dto = new GuestDto();
        String sql = "select * from guest where num = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, num);
            rs = ps.executeQuery();
            if (rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setNickname(rs.getString("nickname"));
                dto.setAvata(rs.getString("avata"));
                dto.setContent(rs.getString("content"));
                dto.setWriteday(rs.getTimestamp("writeday"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }

        return dto;
    }

    public void deleteByNum(int num) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from guest where num = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, num);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }

    public void update(GuestDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        String sql = "update guest set nickname = ?, content = ? where num = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getNickname());
            ps.setString(2, dto.getContent());
            ps.setInt(3, dto.getNum());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
}
