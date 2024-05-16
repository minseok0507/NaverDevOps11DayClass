package com.example.classjsp.data.dao;

import com.example.classjsp.DBconnect;
import com.example.classjsp.data.dto.ShopDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDao {
    DBconnect db = new DBconnect();

    public void insertShop(ShopDto dto) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "insert into myshop (name,price,count,color,photo,writeday)" +
                "values (?,?,?,?,?,now())";

        conn = db.getConnection();

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setInt(2, dto.getPrice());
            ps.setInt(3, dto.getCount());
            ps.setString(4, dto.getColor());
            ps.setString(5, dto.getPhoto());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }


    public List<ShopDto> getShopDataAll(int idx) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ShopDto> list = new ArrayList<>();
        String sql = "";
        if (idx == 1) {
            sql = "select * from myshop order by id";
        } else if (idx == 2) {
            sql = "select * from myshop order by price";
        } else if (idx == 3) {
            sql = "select * from myshop order by price desc";
        } else if (idx == 4) {
            sql = "select * from myshop order by name";
        }
        conn = db.getConnection();
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ShopDto dto = new ShopDto();
                dto.setId(rs.getLong("id"));
                dto.setName(rs.getString("name"));
                dto.setPrice(rs.getInt("price"));
                dto.setCount(rs.getInt("count"));
                dto.setColor(rs.getString("color"));
                dto.setPhoto(rs.getString("photo"));
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


    public List<ShopDto> selectAll() {
        List<ShopDto> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from myshop order by id desc";
        conn = db.getConnection();

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ShopDto dto = new ShopDto();
                dto.setId(rs.getLong("id"));
                dto.setName(rs.getString("name"));
                dto.setPrice(rs.getInt("price"));
                dto.setCount(rs.getInt("count"));
                dto.setColor(rs.getString("color"));
                dto.setPhoto(rs.getString("photo"));
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

    public ShopDto selectById(Long id) {
        ShopDto dto = new ShopDto();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from myshop where id=?";


        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                dto.setId(rs.getLong("id"));
                dto.setName(rs.getString("name"));
                dto.setPrice(rs.getInt("price"));
                dto.setCount(rs.getInt("count"));
                dto.setColor(rs.getString("color"));
                dto.setPhoto(rs.getString("photo"));
                dto.setWriteday(rs.getTimestamp("writeday"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }

        return dto;
    }

    public void update(ShopDto dto) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "UPDATE myshop SET name = ?, price = ?, count = ?, color = ?, photo = ? WHERE id = ?";

        try {
            conn = db.getConnection();

            ps = conn.prepareStatement(sql);

            ps.setString(1, dto.getName());
            ps.setInt(2, dto.getPrice());
            ps.setInt(3, dto.getCount());
            ps.setString(4, dto.getColor());
            ps.setString(5, dto.getPhoto());
            ps.setLong(6, dto.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }

    public void delete(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from myshop where id = ?";

        try {
            conn = db.getConnection();

            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }


}
