package DAO;

import static DAO.ConnectDB.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import DTO.ChiTietThueDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ChiTietThueDAO implements DaoInterface<ChiTietThueDTO> {

    public static ChiTietThueDAO getInstance() {
        return new ChiTietThueDAO();
    }

    public static int soLanKhachThue(String maKH) {
        int count = 0;
        try {
            java.sql.Connection conn = getConnection();
            String query = "SELECT COUNT(*) AS soLanThue FROM chitietthue WHERE maKH = '" + maKH + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return count;
    }

    public static int capNhatTinhTrangXL(String maCTT, int tinhTrangXL, int xl) {
        int check = 0;
        try {
            Connection con = new ConnectDB().getConnection();
            Statement st = con.createStatement();

            String sql = "UPDATE chitietthue\r\n"
                    + "SET "
                    + "tinhTrangXuLy= ?, "
                    + "xuLy= ? "
                    + "WHERE maCTT = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, tinhTrangXL);
            prep.setInt(2, xl);
            prep.setString(3, maCTT);
            //thuc thi cau lenh sql va tra ve so dong bi thay doi
//			int check=st.executeUpdate(sql);
            check = prep.executeUpdate();
            if (check > 0) {
                System.out.println("thêm dữ liệu thành công");
            } else {
                System.out.println("thất bại 8987");
            }
            System.out.println("ban da thucc thi: " + sql);
            System.out.println("so dong thay doi: " + check);

            //buoc 5 ngat ket noi
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("thất bại");
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int them(ChiTietThueDTO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int capNhap(ChiTietThueDTO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int xoa(ChiTietThueDTO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ArrayList<ChiTietThueDTO> selectAll() {
        ArrayList<ChiTietThueDTO> listHD = new ArrayList<>();
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT * FROM chitietthue";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ChiTietThueDTO hd = new ChiTietThueDTO();
                hd.setMaCTT(rs.getString(1));
                hd.setMaKH(rs.getString(2));
                hd.setMaNV(rs.getString(3));
                DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
                java.sql.Timestamp time = rs.getTimestamp(4);
                LocalDateTime localDateTime = time.toLocalDateTime();
                hd.setNgayLapPhieu(dateTimeFormat.format(localDateTime));
                hd.setTienDatCoc(rs.getInt(5));
                hd.setTinhTrangXuLy(rs.getInt(6));
                hd.setXuLy(rs.getInt(7));
                listHD.add(hd);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;

        }
        return listHD;
    }

    @Override
    public ChiTietThueDTO selectById(ChiTietThueDTO t) {
        // TODO Auto-generated method stub
        return null;
    }

    public ChiTietThueDTO selectById(String maCTT) {
        ChiTietThueDTO ctt = null;
        try {
            Connection conn = getConnection();
            String query = "select * from chitietthue where maCTT = '" + maCTT + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ChiTietThueDTO a = new ChiTietThueDTO();
                a.setMaCTT(rs.getString(1));
                a.setMaKH(rs.getString(2));
                a.setMaNV(rs.getString(3));
                a.setNgayLapPhieu(rs.getString(4));
                a.setTienDatCoc(rs.getInt(5));
                a.setTinhTrangXuLy(rs.getInt(6));
                a.setXuLy(rs.getInt(7));
                ctt = a;
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return ctt;
    }

    @Override
    public ArrayList<ChiTietThueDTO> selectBy(String condition) {
        // TODO Auto-generated method stub
        return null;
    }

    public static boolean checkID(String maCTT) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "select * from CHITIETTHUE where maCTT = '" + maCTT + "'";
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

    public static boolean insertCTT(ChiTietThueDTO ctt) {
        boolean check = false;
        try {
            java.sql.Connection conn = getConnection();
            String query = "insert into CHITIETTHUE values (?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, ctt.getMaCTT());
            ps.setString(2, ctt.getMaKH());
            ps.setString(3, ctt.getMaNV());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date = sdf.parse(ctt.getNgayLapPhieu());
            ps.setTimestamp(4, new java.sql.Timestamp(date.getTime()));
            ps.setInt(5, ctt.getTienDatCoc());
            ps.setInt(6, ctt.getTinhTrangXuLy());
            ps.setInt(7, ctt.getXuLy());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static int countCTT() {
        int count = 0;
        try {
            java.sql.Connection conn = getConnection();
            String query = "select * from CHITIETTHUE";
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

    public static ChiTietThueDTO getCTT(String maCTT) {
        ChiTietThueDTO ctt = new ChiTietThueDTO();
        try {
            Connection conn = getConnection();
            String query = "select * from CHITIETTHUE where maCTT = '" + maCTT + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ChiTietThueDTO a = new ChiTietThueDTO();
                a.setMaCTT(rs.getString(1));
                a.setMaKH(rs.getString(2));
                a.setMaNV(rs.getString(3));
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String date = sdf.format(rs.getTimestamp(4));
                a.setNgayLapPhieu(date);
                a.setTienDatCoc(rs.getInt(5));
                a.setTinhTrangXuLy(rs.getInt(6));
                a.setXuLy(rs.getInt(7));
                ctt = a;
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return ctt;
    }
}
