package DAO;

import DTO.PhongDTO;
import java.util.ArrayList;
import java.sql.*;
import static DAO.ConnectDB.getConnection;

public class PhongDAO {

    public static PhongDAO getInstance() {
        return new PhongDAO();
    }

    //hàm thêm mới ngày 7/11/2023
    public ArrayList<Integer> layDuLieuSoLuongPhongTheoLoai(int nam, int options) {
        ArrayList<Integer> list = new ArrayList<>();
        if (options == 0) {
            try {
                //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
                Connection con = new ConnectDB().getConnection();
                Statement st = con.createStatement();

                String sql = "SELECT p.loaiP, COUNT(*) AS soluong "
                        + "FROM phong p "
                        + "JOIN chitietthuephong c ON p.maP = c.maP "
                        + "WHERE YEAR(c.ngayThue) = ? "
                        + "GROUP BY p.loaiP";
                PreparedStatement prep = con.prepareStatement(sql);
                prep.setInt(1, nam);
                //thuc thi cau lenh sql va tra ve so dong bi thay doi
//				int check=st.executeUpdate(sql);
                ResultSet resultSet = prep.executeQuery();

                while (resultSet.next()) {
                    String loaiPhong = resultSet.getString("loaiP");
                    int soLuong = resultSet.getInt("soluong");
                    list.add(soLuong);
                    System.out.println("Số lượng phòng loại " + loaiPhong + " năm " + nam + ": " + soLuong);
                }

                //buoc 5 ngat ket noi
                con.close();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("thất bại");
                e.printStackTrace();
            }
        } else {
            try {
                //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
                Connection con = new ConnectDB().getConnection();
                Statement st = con.createStatement();

                String sql = "SELECT p.chiTietLoaiP, COUNT(*) AS soluong "
                        + "FROM phong p "
                        + "JOIN chitietthuephong c ON p.maP = c.maP "
                        + "WHERE YEAR(c.ngayThue) = ? "
                        + "GROUP BY p.chiTietLoaiP";
                PreparedStatement prep = con.prepareStatement(sql);
                prep.setInt(1, nam);
                //thuc thi cau lenh sql va tra ve so dong bi thay doi
//				int check=st.executeUpdate(sql);
                ResultSet resultSet = prep.executeQuery();

                while (resultSet.next()) {
                    String loaiPhong = resultSet.getString("chiTietLoaiP");
                    int soLuong = resultSet.getInt("soluong");
                    list.add(soLuong);
                    System.out.println("Số lượng phòng loại " + loaiPhong + " năm " + nam + ": " + soLuong);
                }

                //buoc 5 ngat ket noi
                con.close();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("thất bại");
                e.printStackTrace();
            }
        }
        return list;
    }

    public static ArrayList<PhongDTO> getListP() {
        ArrayList<PhongDTO> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "select * from PHONG";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                PhongDTO x = new PhongDTO();
                x.setMaP(rs.getString("maP"));
                x.setTenP(rs.getString("tenP"));
                x.setLoaiP(rs.getString("loaiP"));
                x.setGiaP(rs.getInt("giaP"));
                x.setChiTietLoaiP(rs.getString("chiTietLoaiP"));
                x.setTinhTrang(rs.getInt("tinhTrang"));
                x.setHienTrang(rs.getInt("hienTrang"));
                x.setXuLy(rs.getInt("xuLy"));
                list.add(x);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static boolean checkID(String maP) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "select * from PHONG where maP = '" + maP + "'";
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

    public static boolean insertP(PhongDTO x) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "insert into PHONG values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, x.getMaP());
            ps.setString(2, x.getTenP());
            ps.setString(3, x.getLoaiP());
            ps.setInt(4, x.getGiaP());
            ps.setString(5, x.getChiTietLoaiP());
            ps.setInt(6, x.getTinhTrang());
            ps.setInt(7, x.getHienTrang());
            ps.setInt(8, x.getXuLy());
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean updateTT(String maP, int tinhTrang) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update PHONG set tinhTrang = " + tinhTrang + " where maP = '" + maP + "'";
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

    public static PhongDTO getP(String maP) {
        PhongDTO x = new PhongDTO();
        try {
            Connection conn = getConnection();
            String query = "select * from PHONG where maP = '" + maP + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                x.setMaP(rs.getString("maP"));
                x.setTenP(rs.getString("tenP"));
                x.setLoaiP(rs.getString("loaiP"));
                x.setGiaP(rs.getInt("giaP"));
                x.setChiTietLoaiP(rs.getString("chiTietLoaiP"));
                x.setTinhTrang(rs.getInt("tinhTrang"));
                x.setHienTrang(rs.getInt("hienTrang"));
                x.setXuLy(rs.getInt("xuLy"));
            }
        } catch (Exception e) {
        }
        return x;
    }

    public static ArrayList<PhongDTO> getListPhong(String datetimeThue, String datetimeTra, boolean check) {
        ArrayList<PhongDTO> listPhong = new ArrayList<>();
        try {
            java.sql.Connection conn = getConnection();
            String query = "";
            if (check) {
                query = "select * from phong "
                        + "where tinhTrang = 0 and MAP not in "
                        + "(select MAP from ChiTietThue, CHITIETTHUEPHONG where ChiTietThue.maCTT = CHITIETTHUEPHONG.maCTT and tinhTrangXuLy = 0 and xuLy = 0 and ngayThue <= '" + datetimeTra + "' and (ngayTra >= '" + datetimeThue + "' or ngayTra is null))";
            } else {
                query = "select * from phong "
                        + "where tinhTrang = 0 and MAP not in "
                        + "(select MAP from ChiTietThue, CHITIETTHUEPHONG where ChiTietThue.maCTT = CHITIETTHUEPHONG.maCTT and tinhTrangXuLy = 0 and xuLy = 0 and "
                        + "(ngayThue <= '" + datetimeThue + "' and (ngayTra >= '" + datetimeThue + "' or ngayTra is null) "
                        + "or (ngayThue >= '" + datetimeThue + "')))";
            }
            PreparedStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhongDTO x = new PhongDTO();
                x.setMaP(rs.getString("maP"));
                x.setTenP(rs.getString("tenP"));
                x.setLoaiP(rs.getString("loaiP"));
                x.setGiaP(rs.getInt("giaP"));
                x.setChiTietLoaiP(rs.getString("chiTietLoaiP"));
                x.setTinhTrang(rs.getInt("tinhTrang"));
                x.setHienTrang(rs.getInt("hienTrang"));
                x.setXuLy(rs.getInt("xuLy"));
                listPhong.add(x);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return listPhong;
    }

    public static boolean delete(String maP, int xuLy) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update PHONG set xuLy = " + xuLy + " where maP = '" + maP + "'";
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

    public int capNhap(PhongDTO t) {
        int check = 0;
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            Statement st = con.createStatement();

            String sql = "UPDATE phong "
                    + "SET tenP = ?, loaiP = ?, giaP = ?, chiTietLoaiP = ?, hienTrang = ? "
                    + "WHERE maP = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, t.getTenP());
            prep.setString(2, t.getLoaiP());
            prep.setInt(3, t.getGiaP());
            prep.setString(4, t.getChiTietLoaiP());
            prep.setInt(5, t.getHienTrang());
            prep.setString(6, t.getMaP());
            //thuc thi cau lenh sql va tra ve so dong bi thay doi
//			check=st.executeUpdate(sql);
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
}
