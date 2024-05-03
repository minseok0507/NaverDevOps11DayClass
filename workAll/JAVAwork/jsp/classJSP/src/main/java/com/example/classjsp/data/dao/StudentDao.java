package com.example.classjsp.data.dao;

import com.example.classjsp.DBconnect;
import com.example.classjsp.data.dto.StudentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    DBconnect db = new DBconnect();


    public void insertStudent(StudentDto studentDto) {
        Connection conn = db.getConnection();
        String sql = "insert into mystudent (name, blood, license, java, spring, html, writeday) values(?,?,?,?,?,?,now())";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, studentDto.getName());
            ps.setString(2, studentDto.getBlood());
            ps.setBoolean(3, studentDto.getLicense());
            ps.setInt(4, studentDto.getJava());
            ps.setInt(5, studentDto.getSpring());
            ps.setInt(6, studentDto.getHtml());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }


    }

    public List<StudentDto> findAll() {
        List<StudentDto> list = new ArrayList<>();

        Connection conn = db.getConnection();
        String sql = "select * from mystudent order by num";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentDto studentDto = new StudentDto();
                studentDto.setNum(rs.getInt("num"));
                studentDto.setName(rs.getString("name"));
                studentDto.setBlood(rs.getString("blood"));
                studentDto.setLicense(rs.getBoolean("license"));
                studentDto.setJava(rs.getInt("java"));
                studentDto.setSpring(rs.getInt("spring"));
                studentDto.setHtml(rs.getInt("html"));
                studentDto.setWriteday(rs.getDate("writeday"));
                list.add(studentDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }


        return list;
    }

    public StudentDto findByNum(int num) {
        Connection conn = db.getConnection();
        String sql = "select * from mystudent where num = ?";

        PreparedStatement ps = null;
        StudentDto studentDto = null;

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                studentDto = new StudentDto();
                studentDto.setNum(rs.getInt("num"));
                studentDto.setName(rs.getString("name"));
                studentDto.setBlood(rs.getString("blood"));
                studentDto.setJava(rs.getInt("java"));
                studentDto.setSpring(rs.getInt("spring"));
                studentDto.setHtml(rs.getInt("html"));
                studentDto.setLicense(rs.getBoolean("license"));
                studentDto.setWriteday(rs.getDate("writeday"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }


        return studentDto;
    }

    public void deleteStudent(int num) {
        Connection conn = db.getConnection();
        String sql = "delete from mystudent where num = ?";
        PreparedStatement ps = null;

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

    public void updateStudent(StudentDto studentDto) {
        Connection conn = db.getConnection();
        String sql = "UPDATE mystudent SET name = ?, blood = ?, license = ?, java = ?, spring = ?, html = ? WHERE num = ?";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, studentDto.getName());
            ps.setString(2, studentDto.getBlood());
            ps.setBoolean(3, studentDto.getLicense());
            ps.setInt(4, studentDto.getJava());
            ps.setInt(5, studentDto.getSpring());
            ps.setInt(6, studentDto.getHtml());
            ps.setInt(7, studentDto.getNum());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }


}
