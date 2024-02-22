package DAO;

import static DAO.ConnectDB.getConnection;
import java.sql.*;
import DTO.KhachHangDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class KhachHangDAO implements DaoInterface<KhachHangDTO> {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //FUNCTION FROM TRƯỞNG
    //BEGIN
    public static KhachHangDAO getIntance() {
        return new KhachHangDAO();
    }

    @Override
    public int them(KhachHangDTO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int capNhap(KhachHangDTO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int xoa(KhachHangDTO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ArrayList<KhachHangDTO> selectAll() {
        ArrayList<KhachHangDTO> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "select * from khachhang";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                KhachHangDTO a = new KhachHangDTO();
                a.setMaKH(rs.getString(1));
                a.setTenKH(rs.getString(2));
                a.setCMND(rs.getString(3));
                a.setGioiTinh(rs.getString(4));
                a.setSDT(rs.getString(5));
                a.setQueQuan(rs.getString(6));
                a.setQuocTich(rs.getString(7));
                a.setNgaySinhString(rs.getString(8));
                a.setXuLy(rs.getInt(9));
                list.add(a);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }

    public static ArrayList<KhachHangDTO> selectAll(String search) {
        ArrayList<KhachHangDTO> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "select * from khachhang " + search;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String date = sdf.format(rs.getTimestamp("ngaySinh"));
                KhachHangDTO a = new KhachHangDTO();
                a.setMaKH(rs.getString("maKH"));
                a.setTenKH(rs.getString("tenKH"));
                a.setCMND(rs.getString("CMND"));
                a.setGioiTinh(rs.getString("gioiTinh"));
                a.setSDT(rs.getString("sDT"));
                a.setQueQuan(rs.getString("queQuan"));
                a.setQuocTich(rs.getString("quocTich"));
                a.setNgaySinhString(date);
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

    @Override
    public KhachHangDTO selectById(KhachHangDTO t) {
        // TODO Auto-generated method stub
        return null;
    }

    public KhachHangDTO selectById(String t) {
        KhachHangDTO hoaDon = null;
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT * FROM khachhang WHERE maKH='" + t + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                KhachHangDTO hd = new KhachHangDTO();
                hd.setMaKH(rs.getString(1));
                hd.setTenKH(rs.getString(2));
                hd.setCMND(rs.getString(3));
                hd.setGioiTinh(rs.getString(4));
                hd.setSDT(rs.getString(5));
                hd.setQueQuan(rs.getString(6));
                hd.setQuocTich(rs.getString(7));
                hd.setNgaySinhString(rs.getString(8));
                hd.setXuLy(rs.getInt(9));
                hoaDon = hd;
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;

        }
        return hoaDon;
    }
    //END

    @Override
    public ArrayList<KhachHangDTO> selectBy(String condition) {
        // TODO Auto-generated method stub
        return null;
    }

    //get list
    public static ArrayList<KhachHangDTO> getListKH() {
        ArrayList<KhachHangDTO> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "select * from KHACHHANG";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String date = sdf.format(rs.getTimestamp("ngaySinh"));
                KhachHangDTO a = new KhachHangDTO();
                a.setMaKH(rs.getString("maKH"));
                a.setTenKH(rs.getString("tenKH"));
                a.setCMND(rs.getString("CMND"));
                a.setGioiTinh(rs.getString("gioiTinh"));
                a.setSDT(rs.getString("sDT"));
                a.setQueQuan(rs.getString("queQuan"));
                a.setQuocTich(rs.getString("quocTich"));
                a.setNgaySinhString(date);
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

    public static boolean checkID(String maKH) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "select * from KHACHHANG where maKH = '" + maKH + "'";
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

    public static int countKH() {
        int count = 0;
        try {
            java.sql.Connection conn = getConnection();
            String query = "select * from KHACHHANG";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                count++;
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return count + 1;
    }

    public static boolean insertKH(KhachHangDTO x) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "insert into KHACHHANG values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, x.getMaKH());
            ps.setString(2, x.getTenKH());
            ps.setString(3, x.getCMND());
            ps.setString(4, x.getGioiTinh());
            ps.setString(5, x.getSDT());
            ps.setString(6, x.getQueQuan());
            ps.setString(7, x.getQuocTich());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateNgaySinh = sdf.parse(x.getNgaySinhString());
            ps.setTimestamp(8, new java.sql.Timestamp(dateNgaySinh.getTime()));
            ps.setInt(9, x.getXuLy());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean updateKH(KhachHangDTO x) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update KHACHHANG set tenKH = ?, CMND = ?, GioiTinh = ?, SDT = ?, QueQuan = ?, QuocTich = ?, NgaySinh = ? where maKH = ?";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, x.getTenKH());
            ps.setString(2, x.getCMND());
            ps.setString(3, x.getGioiTinh());
            ps.setString(4, x.getSDT());
            ps.setString(5, x.getQueQuan());
            ps.setString(6, x.getQuocTich());
            ps.setString(7, x.getNgaySinhString());
            ps.setString(8, x.getMaKH());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean deleteKH(String maKH) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update KHACHHANG set xuLy = 1 where maKH = '" + maKH + "'";
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

    public static KhachHangDTO getKH(String maKH) {
        KhachHangDTO a = new KhachHangDTO();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Connection conn = getConnection();
            String query = "select * from KHACHHANG where maKH = '" + maKH + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String date = sdf.format(rs.getTimestamp("ngaySinh"));
                a.setMaKH(rs.getString("maKH"));
                a.setTenKH(rs.getString("tenKH"));
                a.setCMND(rs.getString("CMND"));
                a.setGioiTinh(rs.getString("gioiTinh"));
                a.setSDT(rs.getString("sDT"));
                a.setQueQuan(rs.getString("queQuan"));
                a.setQuocTich(rs.getString("quocTich"));
                a.setNgaySinhString(date);
                a.setXuLy(rs.getInt("xuLy"));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return a;
    }

    //hàm thêm mới 5/11/2023
    public int laySoLuongKH() {
        int sl = 0;
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT COUNT(*) FROM khachhang";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                sl = rs.getInt(1);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;

        }
        return sl;
    }
}
