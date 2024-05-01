package com.example.classjsp.data.dao;

import com.example.classjsp.DBconnect;
import com.example.classjsp.data.dto.SawonDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SawonDao {
    DBconnect db = new DBconnect();

    public void insertSawon(SawonDto dto){
        String sql = "insert into mysawon (name, buseo, age, addr, photo, gender, birthday) values(?,?,?,?,?,?,?)";

        Connection con = db.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getBuseo());
            ps.setInt(3, dto.getAge());
            ps.setString(4, dto.getAddr());
            ps.setString(5, dto.getPhoto());
            ps.setString(6, dto.getGender());
            ps.setString(7, dto.getBirthday());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, con);
        }


    }

    public List<SawonDto> selectAllSawon(){
        List<SawonDto> list = new ArrayList<>();
        String sql = "select * from mysawon order by num desc";

        Connection con = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SawonDto dto = new SawonDto();

                dto.setNum(rs.getInt("num"));
                dto.setName(rs.getString("name"));
                dto.setBuseo(rs.getString("buseo"));
                dto.setAge(rs.getInt("age"));
                dto.setAddr(rs.getString("addr"));
                dto.setPhoto(rs.getString("photo"));
                dto.setGender(rs.getString("gender"));
                dto.setBirthday(rs.getString("birthday"));

                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, con);
        }

        return list;
    }

    public SawonDto getData(int num){
        SawonDto dto = new SawonDto();
        String sql = "select * from mysawon where num = ?";

        Connection con = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, num);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setName(rs.getString("name"));
                dto.setBuseo(rs.getString("buseo"));
                dto.setAge(rs.getInt("age"));
                dto.setAddr(rs.getString("addr"));
                dto.setPhoto(rs.getString("photo"));
                dto.setGender(rs.getString("gender"));
                dto.setBirthday(rs.getString("birthday"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, con);
        }

        return dto;
    }

    public void updateData(SawonDto dto){
        Connection con = db.getConnection();
        PreparedStatement ps = null;

        String sql = "UPDATE mysawon SET name = ?, buseo = ?, age = ?, addr = ?, photo = ?, gender = ?, birthday = ? WHERE num = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getBuseo());
            ps.setInt(3, dto.getAge());
            ps.setString(4, dto.getAddr());
            ps.setString(5, dto.getPhoto());
            ps.setString(6, dto.getGender());
            ps.setString(7, dto.getBirthday());
            ps.setInt(8, dto.getNum());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, con);
        }
    }

    public void deleteData(int num){
        Connection con = db.getConnection();
        PreparedStatement ps = null;

        String sql = "delete from mysawon where num = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, num);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, con);
        }
    }

    public List<Map<String, String>> selectGenderAnal(){
        List<Map<String, String>> list = new ArrayList<>();

        String sql = "SELECT gender, COUNT(*) count, ROUND(AVG(age),1) age from mysawon group by gender";

        Connection con = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                String gender = rs.getString("gender");
                String count = rs.getString("count");
                String age = rs.getString("age");

                map.put("gender", gender);
                map.put("count", count);
                map.put("age", age);

                list.add(map);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, con);
        }

        return list;
    }

    public List<Map<String, String>> selectBuseoAnal(){
        List<Map<String, String>> list = new ArrayList<>();
        String sql = "SELECT buseo , COUNT(*) count, ROUND(AVG(age),1) age from mysawon group by buseo";

        Connection con = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                String buseo = rs.getString("buseo");
                String count = rs.getString("count");
                String age = rs.getString("age");

                map.put("buseo", buseo);
                map.put("count", count);
                map.put("age", age);

                list.add(map);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
