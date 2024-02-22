package DAO;

import static DAO.ConnectDB.getConnection;
import java.sql.*;
import DTO.DichVuDTO;
import java.util.ArrayList;

public class DichVuDAO implements DaoInterface<DichVuDTO> {

    public static DichVuDAO getInstance() {
        return new DichVuDAO();
    }

    @Override
    public int them(DichVuDTO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int capNhap(DichVuDTO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int xoa(DichVuDTO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ArrayList<DichVuDTO> selectAll() {
        ArrayList<DichVuDTO> list = new ArrayList<>();
        try {
            //madv, tendv, loaidv, soluong, giadv, xuly
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT * FROM dichvu";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DichVuDTO ct = new DichVuDTO();
                ct.setMaDV(rs.getString(1));
                ct.setTenDV(rs.getString(2));
                ct.setLoaiDV(rs.getString(3));
                ct.setSoLuong(rs.getInt(4));
                ct.setGiaDV(rs.getInt(5));
                ct.setHinhAnh(rs.getString(6));
                ct.setXuLy(rs.getInt(7));
                list.add(ct);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;

        }
        return list;
    }

    @Override
    public DichVuDTO selectById(DichVuDTO t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<DichVuDTO> selectBy(String condition) {
        // TODO Auto-generated method stub
        return null;
    }

    //get list
    public static ArrayList<DichVuDTO> getListDV() {
        ArrayList<DichVuDTO> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "select * from DICHVU";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                DichVuDTO a = new DichVuDTO();
                a.setMaDV(rs.getString("maDV"));
                a.setTenDV(rs.getString("tenDV"));
                a.setLoaiDV(rs.getString("loaiDV"));
                a.setSoLuong(rs.getInt("soLuong"));
                a.setGiaDV(rs.getInt("giaDV"));
                a.setHinhAnh(rs.getString("hinhAnh"));
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

    public static int getSL(String maDV) {
        int count = 0;
        try {
            Connection conn = getConnection();
            String query = "select soLuong from DICHVU where maDV = '" + maDV + "'";
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

    public static int getSLNhap(String maDV) {
        int count = 0;
        try {
            Connection conn = getConnection();
            String query = "select case when SUM(CHITIETNHAP.soLuong) is not null then SUM(CHITIETNHAP.soLuong) else 0 end as TongSL from PHIEUNHAP, CHITIETNHAP, DICHVU\n"
                    + "where PHIEUNHAP.maPN = CHITIETNHAP.maPN \n"
                    + "and DICHVU.maDV = CHITIETNHAP.maDV \n"
                    + "and CHITIETNHAP.maDV = '" + maDV + "'\n"
                    + "and tinhTrangXuLy = 0\n"
                    + "and PHIEUNHAP.xuLy = 0";
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("TongSL");
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return count;
    }

    public static boolean updateSL(String maDV, int SL) {
        int soLuong = DichVuDAO.getSL(maDV) + SL;
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update DICHVU set soLuong = ? where maDV = ?";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setInt(1, soLuong);
            ps.setString(2, maDV);
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean checkID(String maDV) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "select * from DICHVU where maDV = '" + maDV + "'";
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

    public static DichVuDTO searchDV(String maDV) {
        DichVuDTO a = new DichVuDTO();
        try {
            Connection conn = getConnection();
            String query = "select * from DICHVU where maDV = '" + maDV + "'";
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a.setMaDV(rs.getString("maDV"));
                a.setTenDV(rs.getString("tenDV"));
                a.setLoaiDV(rs.getString("loaiDV"));
                a.setSoLuong(rs.getInt("soLuong"));
                a.setGiaDV(rs.getInt("giaDV"));
                a.setHinhAnh(rs.getString("hinhAnh"));
                a.setXuLy(rs.getInt("xuLy"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return a;
    }

    public static boolean insertDV(DichVuDTO x) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "insert into DICHVU values (?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, x.getMaDV());
            ps.setString(2, x.getTenDV());
            ps.setString(3, x.getLoaiDV());
            ps.setInt(4, x.getSoLuong());
            ps.setInt(5, x.getGiaDV());
            ps.setString(6, x.getHinhAnh());
            ps.setInt(7, x.getXuLy());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean updateDV(DichVuDTO x) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update DICHVU set tenDV = ?, loaiDV = ?, soLuong = ?, giaDV = ?, hinhAnh = ?, xuLy = ? where maDV = ?";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, x.getTenDV());
            ps.setString(2, x.getLoaiDV());
            ps.setInt(3, x.getSoLuong());
            ps.setInt(4, x.getGiaDV());
            ps.setString(5, x.getHinhAnh());
            ps.setInt(6, x.getXuLy());
            ps.setString(7, x.getMaDV());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean deleteDV(String maDV) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update DICHVU set xuLy = 1 where maDV = '" + maDV + "'";
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
