package DAO;

import static DAO.ConnectDB.getConnection;
import DTO.ChiTietNhapDTO;
import java.sql.*;
import java.util.ArrayList;

public class ChiTietNhapDAO {

    public static ChiTietNhapDAO getInstance() {
        return new ChiTietNhapDAO();
    }

    public double layTongChiTheoNgay(int ngay, int thang, int nam) {
        double tongchi = 0;
        try {
            Connection conn = getConnection();
            String query = "SELECT CAST(ngayLap AS DATE) AS Ngay, SUM(giaDVNhap * soLuong) AS TongChiTieu FROM phieunhap \n"
                    + "INNER JOIN chitietnhap ON phieunhap.maPN = chitietnhap.maPN \n"
                    + "WHERE CAST(ngayLap AS DATE) = '" + nam + "-" + thang + "-" + ngay + "'\n"
                    + "GROUP BY CAST(ngayLap AS DATE)";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tongchi = rs.getDouble("TongChiTieu");
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return tongchi;
    }

    public long layTongChi() {
        long tongchi = 0;
        try {
            Connection conn = getConnection();
            String query = "SELECT SUM(giaDVNhap * soLuong) AS tongtien FROM chitietnhap";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tongchi = rs.getLong("tongtien");
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return tongchi;
    }

    public static boolean insertCTPN(ChiTietNhapDTO x) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "insert into CHITIETNHAP values (?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, x.getMaPN());
            ps.setString(2, x.getMaDV());
            ps.setInt(3, x.getGiaDVNhap());
            ps.setInt(4, x.getSoLuong());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean updateCTN(ChiTietNhapDTO x) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update CHITIETNHAP set giaDVNhap = ? , soLuong = ? where maPN = ? and maDV = ?";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setInt(1, x.getGiaDVNhap());
            ps.setInt(2, x.getSoLuong());
            ps.setString(3, x.getMaPN());
            ps.setString(4, x.getMaDV());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean deleteCTN(String maPN, String maDV) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "delete CHITIETNHAP where maPN = '" + maPN + "' and maDV = '" + maDV + "'";
            Statement st = conn.createStatement();
            if (st.executeUpdate(query) >= 1) {
                check = true;
            }
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static ArrayList<ChiTietNhapDTO> getListCTN(String maPN) {
        ArrayList<ChiTietNhapDTO> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "select * from CHITIETNHAP where maPN = '" + maPN + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ChiTietNhapDTO a = new ChiTietNhapDTO();
                a.setMaPN(rs.getString("maPN"));
                a.setMaDV(rs.getString("maDV"));
                a.setSoLuong(rs.getInt("soLuong"));
                a.setGiaDVNhap(rs.getInt("giaDVNhap"));
                list.add(a);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }
}
