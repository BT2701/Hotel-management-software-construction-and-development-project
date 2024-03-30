package DAO;

import static DAO.ConnectDB.getConnection;
import DTO.PhieuNhapDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PhieuNhapDAO {

    public static ArrayList<PhieuNhapDTO> getListPN() {
        ArrayList<PhieuNhapDTO> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "select * from PHIEUNHAP";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String date = sdf.format(rs.getTimestamp("ngayLap"));
                PhieuNhapDTO a = new PhieuNhapDTO();
                a.setMaPN(rs.getString("maPN"));
                a.setMaNV(rs.getString("maNV"));
                a.setNgayLapPhieu(date);
                a.setTinhTrangXuLy(rs.getInt("tinhTrangXuLy"));
                a.setXuLy(rs.getInt("xuLy"));
                list.add(a);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }
    
    public static ArrayList<PhieuNhapDTO> getListPN(int tinhTrang) {
        ArrayList<PhieuNhapDTO> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "select * from PHIEUNHAP where tinhTrangXuLy = "+tinhTrang;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String date = sdf.format(rs.getTimestamp("ngayLap"));
                PhieuNhapDTO a = new PhieuNhapDTO();
                a.setMaPN(rs.getString("maPN"));
                a.setMaNV(rs.getString("maNV"));
                a.setNgayLapPhieu(date);
                a.setTinhTrangXuLy(rs.getInt("tinhTrangXuLy"));
                a.setXuLy(rs.getInt("xuLy"));
                list.add(a);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }

    public static ArrayList<PhieuNhapDTO> getListPN(String[] field) {
        ArrayList<PhieuNhapDTO> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "select maPN, PHIEUNHAP.maNV, ngayLap, tinhTrangXuLy, PHIEUNHAP.xuLy from PHIEUNHAP, NHANVIEN where PHIEUNHAP.maNV = NHANVIEN.maNV";
            if (field[0] != null) {
                query += " and maPN like '%" + field[0] + "%'";
            }
            if (field[1] != null) {
                query += " and tenNV like N'%" + field[1] + "%'";
            }
            if (field[2] != null) {
                query += " and ngayLap >= '" + field[2] + "'";
            }
            if (field[3] != null) {
                query += " and ngayLap <= '" + field[3] + "'";
            }
            if (field[4] != null) {
                query += " and tinhTrangXuLy = "+field[4];
            }
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String date = sdf.format(rs.getTimestamp("ngayLap"));
                PhieuNhapDTO a = new PhieuNhapDTO();
                a.setMaPN(rs.getString("maPN"));
                a.setMaNV(rs.getString("maNV"));
                a.setNgayLapPhieu(date);
                a.setTinhTrangXuLy(rs.getInt("tinhTrangXuLy"));
                a.setXuLy(rs.getInt("xuLy"));
                list.add(a);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }

    public static boolean updateXuLy(String maPN) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update PHIEUNHAP set tinhTrangXuLy = 1 where maPN = '" + maPN + "'";
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

    public static PhieuNhapDTO searchPN(String maPN) {
        PhieuNhapDTO a = new PhieuNhapDTO();
        try {
            Connection conn = getConnection();
            String query = "select * from PHIEUNHAP where maPN = '" + maPN + "'";
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String date = sdf.format(rs.getTimestamp("ngayLap"));
                a.setMaPN(rs.getString("maPN"));
                a.setMaNV(rs.getString("maNV"));
                a.setNgayLapPhieu(date);
                a.setTinhTrangXuLy(rs.getInt("tinhTrangXuLy"));
                a.setXuLy(rs.getInt("xuLy"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return a;
    }

    public static int getCountImportToDay() {
        int check = 0;
        try {
            Connection conn = getConnection();
            String query = "select count(PHIEUNHAP.maPN) as COUNT from PHIEUNHAP where Year(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and DAY(ngayLap) = DAY(GETDATE())";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                check = rs.getInt("COUNT");
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean checkID(String maPN) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "select * from PHIEUNHAP where maPN = '" + maPN + "'";
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

    public static boolean deletePN(String maPN) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update PHIEUNHAP set xuLy = 1 where maPN = '" + maPN + "'";
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

    public static boolean insertPN(PhieuNhapDTO x) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "insert into PHIEUNHAP values (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, x.getMaPN());
            ps.setString(2, x.getMaNV());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date = sdf.parse(x.getNgayLapPhieu());
            ps.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
            ps.setInt(4, x.getTinhTrangXuLy());
            ps.setInt(5, x.getXuLy());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }
}
