package DAO;

import DTO.TienIchDTO;
import java.util.ArrayList;
import static DAO.ConnectDB.getConnection;
import java.sql.*;

public class TienIchDAO {

    public static ArrayList<TienIchDTO> getList() {
        ArrayList<TienIchDTO> listTI = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "select * from TIENICH";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                TienIchDTO a = new TienIchDTO();
                a.setMaTI(rs.getString("maTI"));
                a.setTenTI(rs.getString("tenTI"));
                a.setSoLuong(rs.getInt("soLuong"));
                a.setXuLy(rs.getInt("xuLy"));
                listTI.add(a);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return listTI;
    }

    public static int getSL(String maTI) {
        int count = 0;
        try {
            Connection conn = getConnection();
            String query = "select soLuong from TIENICH where maTI = '" + maTI + "'";
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("soLuong");
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return count;
    }

    public static boolean updateSL(String maTI, int SL) {
        int soLuong = TienIchDAO.getSL(maTI) + SL;
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update TIENICH set soLuong = ? where maTI = ?";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setInt(1, soLuong);
            ps.setString(2, maTI);
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean checkID(String maTI) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "select * from TIENICH where maTI = '" + maTI + "'";
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

    public static boolean insertTI(TienIchDTO x) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "insert into TIENICH values (?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, x.getMaTI());
            ps.setString(2, x.getTenTI());
            ps.setInt(3, x.getSoLuong());
            ps.setInt(4, x.getXuLy());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean deleteTI(String maTI) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update TIENICH set xuLy = 1 where maTI = '" + maTI + "'";
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

    public static boolean updateTI(TienIchDTO x) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update TIENICH set tenTI = ?, soLuong = ?, xuLy = ? where maTI = ?";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, x.getTenTI());
            ps.setInt(2, x.getSoLuong());
            ps.setInt(3, x.getXuLy());
            ps.setString(4, x.getMaTI());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean capNhatSL(String maTI, int soLuong) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update tienich set soLuong = " + soLuong + " where maTI = '" + maTI + "'";
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
}
