package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DTO.HoaDonDTO;

public class HoaDonDAO implements DaoInterface<HoaDonDTO> {

    private SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static HoaDonDAO getIntance() {
        return new HoaDonDAO();
    }

    @Override
    public int them(HoaDonDTO t) {
        // TODO Auto-generated method stub
        int check = 0;
        try {
            Connection con = new ConnectDB().getConnection();
            Statement st = con.createStatement();
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            String sql = "INSERT INTO hoadon(maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy)\r\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, t.getMaHD());
            prep.setString(2, t.getMaCTT());
            prep.setInt(3, t.getTienP());
            prep.setInt(4, t.getTienDV());
            prep.setInt(5, t.getGiamGia());
            prep.setInt(6, t.getPhuThu());
            prep.setInt(7, t.getTongTien());
            prep.setTimestamp(8, new Timestamp(sdf.parse(t.getNgayThanhToan()).getTime()));
            prep.setString(9, t.getPhuongThucThanhToan());
            prep.setInt(10, t.getXuLy());
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
    public int capNhap(HoaDonDTO t) {
        int check = 0;
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            Statement st = con.createStatement();

            String sql = "UPDATE hoadon\r\n"
                    + "SET "
                    + "tienP= ?, "
                    + "tienDV= ?, "
                    + "giamGia= ?, "
                    + "phuThu= ?, "
                    + "tongTien= ?, "
                    + "ngayThanhToan= ?, "
                    + "phuongThucThanhToan= ?, "
                    + "xuLy= ? "
                    + "WHERE MA_HD = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, t.getTienP());
            prep.setInt(2, t.getTienDV());
            prep.setInt(3, t.getGiamGia());
            prep.setInt(4, t.getPhuThu());
            prep.setInt(5, t.getTongTien());
            prep.setTimestamp(6, new Timestamp(sdf.parse(t.getNgayThanhToan()).getTime()));
            prep.setString(7, t.getPhuongThucThanhToan());
            prep.setInt(8, t.getXuLy());
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
    public int xoa(HoaDonDTO t) {
        // TODO Auto-generated method stub
        int check = 0;
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            Statement st = con.createStatement();
            String sql = "DELETE FROM hoadon "
                    + "WHERE maHD = '" + t.getMaHD() + "';";
            check = st.executeUpdate(sql);
            if (check > 1) {
                System.out.println("thành công");
            }

            con.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<HoaDonDTO> selectAll() {
        ArrayList<HoaDonDTO> listHD = new ArrayList<>();
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT * FROM hoadon";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaCTT(rs.getString(2));
                hd.setTienP(rs.getInt(3));
                hd.setTienDV(rs.getInt(4));
                hd.setGiamGia(rs.getInt(5));
                hd.setPhuThu(rs.getInt(6));
                hd.setTongTien(rs.getInt(7));
                hd.setNgayThanhToan(sdf.format(rs.getTimestamp(8)));
                hd.setPhuongThucThanhToan(rs.getString(9));
                hd.setXuLy(rs.getInt(10));
                listHD.add(hd);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;

        }
        return listHD;
    }

    @Override
    public HoaDonDTO selectById(HoaDonDTO t) {
        HoaDonDTO hoaDon = null;
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT * FROM hoadon WHERE maHD='" + t.getMaHD() + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaCTT(rs.getString(2));
                hd.setTienP(rs.getInt(3));
                hd.setTienDV(rs.getInt(4));
                hd.setGiamGia(rs.getInt(5));
                hd.setPhuThu(rs.getInt(6));
                hd.setTongTien(rs.getInt(7));
                hd.setNgayThanhToan(sdf.format(rs.getTimestamp(8)));
                hd.setPhuongThucThanhToan(rs.getString(9));
                hd.setXuLy(rs.getInt(10));
                hoaDon = hd;
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;

        }
        return hoaDon;
    }

    @Override
    public ArrayList<HoaDonDTO> selectBy(String condition) {
        // TODO Auto-generated method stub
        return null;
    }

    public double thongKeTheoKhoangThoiGian(Date tuNgay, Date denNgay) {
        double doanhThu = 0;
//		SELECT SUM(TONG_TIEN_PHAI_TRA) AS total_cost
//		FROM hoa_don
//		WHERE THOI_DIEM_LAP BETWEEN '2023-04-19' AND '2023-04-30';
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT SUM(tongTien) AS total_cost "
                    + "FROM hoadon "
                    + "WHERE ngayThanhToan BETWEEN '" + sdf1.format(tuNgay) + "' AND '" + sdf1.format(denNgay) + "';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                doanhThu = rs.getDouble(1);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;

        }

        return doanhThu;

    }

    public ArrayList<String> layMaHoaDonTheoKhoangThoiGian(Date tuNgay, Date denNgay) {
        ArrayList<String> listHD = new ArrayList<>();
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT maHD "
                    + "FROM hoadon "
                    + "WHERE ngayThanhToan BETWEEN '" + sdf1.format(tuNgay) + "' AND '" + sdf1.format(denNgay) + "';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                listHD.add(rs.getString(1));
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;

        }
        return listHD;
    }

    public ArrayList<HoaDonDTO> layDanhSachHoaDonTheoGia(double giaTu, double denGia) {
//		SELECT *
//		FROM hoa_don
//		WHERE TONG_TIEN_PHAI_TRA BETWEEN 1000000 AND 3000000;

        ArrayList<HoaDonDTO> listHD = new ArrayList<>();
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT * "
                    + "FROM hoadon "
                    + "WHERE tongTien BETWEEN " + giaTu + " AND " + denGia + ";";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaCTT(rs.getString(2));
                hd.setTienP(rs.getInt(3));
                hd.setTienDV(rs.getInt(4));
                hd.setGiamGia(rs.getInt(5));
                hd.setPhuThu(rs.getInt(6));
                hd.setTongTien(rs.getInt(7));
                hd.setNgayThanhToan(sdf.format(rs.getTimestamp(8)));
                hd.setPhuongThucThanhToan(rs.getString(9));
                hd.setXuLy(rs.getInt(10));
                listHD.add(hd);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;

        }
        return listHD;
    }

    public int thayDoiTrangThai(String maHD, int trangThai) {
        int check = 0;
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            Statement st = con.createStatement();

            String sql = "UPDATE hoadon\r\n"
                    + "SET "
                    + "xuLy= ? "
                    + "WHERE maHD = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, trangThai);
            prep.setString(2, maHD);
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

    public double layDuLieuTongThuTheoThang(int nam, int thang) {
        double x = 0;
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            Statement st = con.createStatement();

            String sql = "SELECT SUM(tongTien) AS tong_tien FROM hoadon WHERE YEAR(ngayThanhToan) = ? AND MONTH(ngayThanhToan) = ? ";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, nam);
            prep.setInt(2, thang);
            ResultSet resultSet = prep.executeQuery();

            if (resultSet.next()) {
                x = resultSet.getDouble("tong_tien");
                System.out.println("Tổng tiền trong tháng " + thang + " năm " + nam + " là: " + x);
            } else {
                System.out.println("Không có dữ liệu cho tháng " + thang + " năm " + nam);
            }

            //buoc 5 ngat ket noi
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("thất bại");
            e.printStackTrace();
        }
        return x;
    }

    public double layDuLieuTongChiTheoThang(int nam, int thang) {
        double list = 0;
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            Statement st = con.createStatement();

            String sql = "SELECT p.maPN, SUM(c.giaDVNhap * c.soLuong) AS tong_tien "
                    + "FROM phieunhap p "
                    + "JOIN chitietnhap c ON p.maPN = c.maPN "
                    + "WHERE YEAR(p.ngayLap) = ? AND MONTH(p.ngayLap) = ? "
                    + "GROUP BY p.maPN";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, nam);
            prep.setInt(2, thang);
            //thuc thi cau lenh sql va tra ve so dong bi thay doi
//			int check=st.executeUpdate(sql);
            ResultSet resultSet = prep.executeQuery();

            if (resultSet.next()) {
                list = resultSet.getDouble("tong_tien");
                System.out.println("Tổng tiền trong tháng " + thang + " năm " + nam + " là: " + list);
            } else {
                System.out.println("Không có dữ liệu cho tháng " + thang + " năm " + nam);
            }

            //buoc 5 ngat ket noi
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
