package DAO;

import DTO.ChiTietTienIchDTO;
import static DAO.ConnectDB.getConnection;
import DTO.TienIchDTO;
import java.sql.*;
import java.util.ArrayList;

public class ChiTietTienIchDAO {

    public static boolean insertCTTI(ChiTietTienIchDTO x) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "insert into CHITIETTIENICH values (?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, x.getMaP());
            ps.setString(2, x.getMaTI());
            ps.setInt(3, x.getSoLuong());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static int laySoLuongTienIchHienTai(String maP, String maTI) {
        int soLuong = 0;
        try {
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT soLuong FROM chitiettienich WHERE maP= '" + maP + "' and maTI= '" + maTI + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                soLuong = rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return soLuong;
    }

    public static boolean capNhatSL(String maP, String maTI, int soLuong) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update chitiettienich set soLuong = " + soLuong + " where maTI = '" + maTI + "'" + " AND maP = '" + maP + "'";
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

    public static ChiTietTienIchDAO getInstance() {
        return new ChiTietTienIchDAO();
    }

    public ArrayList<TienIchDTO> layDStienIchBangMaPhong(String maP) {
        ArrayList<TienIchDTO> ctt = new ArrayList<>();
//		ChiTietThuePhongDTO ctt=null;
        try {
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT tienich.maTI, tienich.tenTI, chitiettienich.soLuong "
                    + "FROM tienich "
                    + "INNER JOIN chitiettienich ON tienich.maTI = chitiettienich.maTI "
                    + "WHERE chitiettienich.maP = '" + maP + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                TienIchDTO hd = new TienIchDTO();
                hd.setMaTI(rs.getString("maTI"));
                hd.setTenTI(rs.getString("tenTI"));
                hd.setSoLuong(rs.getInt("soLuong"));
                ctt.add(hd);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;

        }
        return ctt;
    }

    public ArrayList<ChiTietTienIchDTO> selectAll() {
        ArrayList<ChiTietTienIchDTO> listHD = new ArrayList<>();
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT * FROM chitiettienich";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ChiTietTienIchDTO TI = new ChiTietTienIchDTO();
                TI.setMaP(rs.getString(1));
                TI.setMaTI(rs.getString(2));
                TI.setSoLuong(rs.getInt(3));
                listHD.add(TI);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;

        }
        return listHD;
    }

}
