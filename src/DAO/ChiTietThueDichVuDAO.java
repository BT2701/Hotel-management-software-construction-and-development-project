package DAO;

import DTO.ChiTietThueDichVuDTO;
import static DAO.ConnectDB.getConnection;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ChiTietThueDichVuDAO {

    public static boolean checkCTTDV(String maCTT, String maDV, String ngaySuDung) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "select * from CHITIETTHUEDICHVU where maCTT = '" + maCTT + "' and maDV = '" + maDV + "' and ngaySuDung = '" + ngaySuDung + "'";
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            check = rs.next();
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static int SoLuongCTTDV(String maCTT, String maDV, String ngaySuDung) {
        int sl = 0;
        try {
            Connection conn = getConnection();
            String query = "select SoLuong from CHITIETTHUEDICHVU where maCTT = '" + maCTT + "' and maDV = '" + maDV + "' and ngaySuDung = '" + ngaySuDung + "'";
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sl = rs.getInt("SoLuong");
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
        }
        return sl;
    }

    public static boolean updateCTTDV(String maCTT, String maDV, String ngaySuDung, int SL) {
        boolean check = false;
        int SoLuong = SL + SoLuongCTTDV(maCTT, maDV, ngaySuDung);
        try {
            Connection conn = getConnection();
            String query = "update CHITIETTHUEDICHVU set SoLuong = " + SoLuong + " where maCTT = '" + maCTT + "' and maDV = '" + maDV + "' and ngaySuDung = '" + ngaySuDung + "'";
            PreparedStatement ps = conn.prepareCall(query);
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }
    public static boolean updateCTTDV2(String maCTT, String maDV, String ngaySuDung, int SL) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update CHITIETTHUEDICHVU set SoLuong = " + SL + " where maCTT = '" + maCTT + "' and maDV = '" + maDV + "' and ngaySuDung = '" + ngaySuDung + "'";
            PreparedStatement ps = conn.prepareCall(query);
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean insertCTTDV(ChiTietThueDichVuDTO cttDV) {
        boolean check = false;
        try {
            Connection conn = getConnection();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String query = "insert into CHITIETTHUEDICHVU values (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);

            ps.setString(1, cttDV.getMaCTT());
            ps.setString(2, cttDV.getMaDV());

            java.util.Date dateNgaySuDung = sdf.parse(cttDV.getNgaySuDung());
            ps.setTimestamp(3, new java.sql.Timestamp(dateNgaySuDung.getTime()));

            ps.setInt(4, cttDV.getSoLuong());
            ps.setInt(5, cttDV.getGiaDV());

            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static ArrayList<ChiTietThueDichVuDTO> getListTDVofCTT(String maChiTietThue) {
        ArrayList<ChiTietThueDichVuDTO> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String sql = "SELECT * FROM CHITIETTHUEDICHVU where maCTT = '" + maChiTietThue + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ChiTietThueDichVuDTO ct = new ChiTietThueDichVuDTO();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String dateNgaySuDung = sdf.format(rs.getTimestamp(3));
                ct.setMaCTT(rs.getString(1));
                ct.setMaDV(rs.getString(2));
                ct.setNgaySuDung(dateNgaySuDung);

                ct.setSoLuong(rs.getInt(4));
                ct.setGiaDV(rs.getInt(5));
                list.add(ct);
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }

    public static boolean deleteCTTDV(String maCTT, String maDV, String dateTimeSuDung) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "Delete CHITIETTHUEDICHVU where maCTT = '" + maCTT + "' and maDV ='" + maDV + "' and ngaySuDung = '" + dateTimeSuDung + "'";
            Statement stmt = conn.createStatement();
            if (stmt.executeUpdate(query) >= 1) {
                check = true;
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }
}
