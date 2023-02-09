package com.xzy.web.ajax.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xzy.web.ajax.dao.BaseDao;
import com.xzy.web.ajax.dao.ZoneDao;
import com.xzy.web.ajax.entity.City;
import com.xzy.web.ajax.entity.County;
import com.xzy.web.ajax.entity.Province;

public class ZoneDaoImpl extends BaseDao implements ZoneDao {

    @Override
    public List<Province> queryProvince() {
        List<Province> provinceList = new ArrayList<Province>();
        Connection conn = getConnection();
        if (null != conn) {
            String sql = "select PROV_ID,CODE,NAME,PINYIN from BASE_PROVINCE";
            Statement s = null;
            ResultSet rs = null;
            try {
                s = conn.createStatement();
                rs = s.executeQuery(sql);
                while (rs.next()) {
                    Integer proId = rs.getInt("PROV_ID");
                    String name = rs.getString("NAME");
                    String code = rs.getString("CODE");
                    String pinYin = rs.getString("PINYIN");
                    Province p = new Province();
                    p.setCode(code);
                    p.setName(name);
                    p.setPinYin(pinYin);
                    p.setProId(proId);
                    provinceList.add(p);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                provinceList = null;
            } catch (Exception e) {
                e.printStackTrace();
                provinceList = null;
            }
            closeAll(rs, s, conn);
        }
        return provinceList;
    }

    @Override
    public List<City> queryCity(Integer proId) {
        List<City> cityList = new ArrayList<City>();
        Connection conn = getConnection();
        if (null != conn) {
            String sql = "select CITY_ID,CODE,NAME,PINYIN from BASE_CITY where PROV_ID=?";
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, proId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Integer cityId = rs.getInt("CITY_ID");
                    String code = rs.getString("CODE");
                    String name = rs.getString("NAME");
                    String pinYin = rs.getString("PINYIN");
                    City c = new City();
                    c.setCode(code);
                    c.setName(name);
                    c.setPinYin(pinYin);
                    c.setProId(proId);
                    c.setCityId(cityId);
                    cityList.add(c);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                cityList = null;
            } catch (Exception e) {
                e.printStackTrace();
                cityList = null;
            }
            closeAll(rs, ps, conn);
        }
        return cityList;
    }

    @Override
    public List<County> queryCounty(Integer cityId) {
        List<County> countyList = new ArrayList<County>();
        Connection conn = getConnection();
        if (null != conn) {
            String sql = "select COUNTY_ID,CODE,NAME,PINYIN from BASE_COUNTY where CITY_ID=?";
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, cityId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Integer countyId = rs.getInt("COUNTY_ID");
                    String code = rs.getString("CODE");
                    String name = rs.getString("NAME");
                    String pinYin = rs.getString("PINYIN");
                    County c = new County();
                    c.setCode(code);
                    c.setName(name);
                    c.setPinYin(pinYin);
                    c.setCountyId(countyId);
                    c.setCityId(cityId);
                    countyList.add(c);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                countyList = null;
            } catch (Exception e) {
                e.printStackTrace();
                countyList = null;
            }
            closeAll(rs, ps, conn);
        }
        return countyList;
    }
}
