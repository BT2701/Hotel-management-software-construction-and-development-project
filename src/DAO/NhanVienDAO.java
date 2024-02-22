package DAO;

import DTO.NhanVienDTO;
import java.util.ArrayList;
import static DAO.ConnectDB.getConnection;
import java.sql.*;
import java.text.SimpleDateFormat;

public class NhanVienDAO {

    //get list
    //FUNCTION FROM TRƯỞNG
    //BEGIN
    public static NhanVienDAO getInstance() {
        return new NhanVienDAO();
    }
    //END

    public NhanVienDTO selectNameByID(String maNV) {
        NhanVienDTO nv = null;
        try {
            Connection conn = getConnection();
            String query = "select * from NHANVIEN where maNV = '" + maNV + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                NhanVienDTO a = new NhanVienDTO();
                a.setMaNV(rs.getString("maP"));
                a.setTenNV(rs.getString("tenP"));
                a.setGioiTinh(rs.getString("gioiTinh"));
                a.setSoNgayPhep(rs.getInt("soNgayPhep"));
                a.setChucVu(rs.getString("chucVu"));
                a.setNgaySinh(rs.getDate("ngaySinh").toString());
                a.setNgayVaoLam(rs.getDate("ngayVaoLam").toString());
                a.setEmail(rs.getString("email"));
                a.setLuong1Ngay(rs.getInt("luong1Ngay"));
                a.setXuLy(rs.getInt("xuLy"));
                nv = a;
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return nv;
    }

    //get list
    public static ArrayList<NhanVienDTO> getListNV() {
        ArrayList<NhanVienDTO> list = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Connection conn = getConnection();
            String query = "select * from NHANVIEN";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                NhanVienDTO a = new NhanVienDTO();
                a.setMaNV(rs.getString("maNV"));
                a.setTenNV(rs.getString("tenNV"));
                a.setGioiTinh(rs.getString("gioiTinh"));
                a.setSoNgayPhep(rs.getInt("soNgayPhep"));
                a.setChucVu(rs.getString("chucVu"));
                Date ngaySinh = rs.getDate("ngaySinh");
                Date ngayVaoLam = rs.getDate("ngayVaoLam");
                a.setNgaySinh(sdf.format(ngaySinh));
                a.setNgayVaoLam(sdf.format(ngayVaoLam));
                a.setEmail(rs.getString("email"));
                a.setLuong1Ngay(rs.getInt("luong1Ngay"));
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

    public static NhanVienDTO getNV(String maNV) {
        NhanVienDTO a = new NhanVienDTO();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Connection conn = getConnection();
            String query = "select * from NHANVIEN where maNV = '" + maNV + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                a.setMaNV(rs.getString("maNV"));
                a.setTenNV(rs.getString("tenNV"));
                a.setGioiTinh(rs.getString("gioiTinh"));
                a.setSoNgayPhep(rs.getInt("soNgayPhep"));
                a.setChucVu(rs.getString("chucVu"));
                Date ngaySinh = rs.getDate("ngaySinh");
                Date ngayVaoLam = rs.getDate("ngayVaoLam");
                a.setNgaySinh(sdf.format(ngaySinh));
                a.setNgayVaoLam(sdf.format(ngayVaoLam));
                a.setEmail(rs.getString("email"));
                a.setLuong1Ngay(rs.getInt("luong1Ngay"));
                a.setXuLy(rs.getInt("xuLy"));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return a;
    }

    public static boolean checkID(String maNV) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "select * from NHANVIEN where maNV = '" + maNV + "'";
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

    public static boolean insertNV(NhanVienDTO x) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "insert into NHANVIEN values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, x.getMaNV());
            ps.setString(2, x.getTenNV());
            ps.setString(3, x.getGioiTinh());
            ps.setInt(4, x.getSoNgayPhep());
            ps.setString(5, x.getChucVu());
            ps.setString(8, x.getEmail());
            ps.setInt(9, x.getLuong1Ngay());
            ps.setInt(10, x.getXuLy());
            //duy
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            //duy
            java.util.Date date = sdf.parse(x.getNgaySinh());
            ps.setDate(6, new java.sql.Date(date.getTime()));
            date = sdf.parse(x.getNgayVaoLam());
            ps.setDate(7, new java.sql.Date(date.getTime()));
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean deleteNV(String maNV) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update NHANVIEN set xuLy = 1 where maNV = '" + maNV + "'";
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

    public static boolean updateNV(NhanVienDTO x) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update NHANVIEN set tenNV = ?, gioiTinh = ?, soNgayPhep = ?, chucVu = ?, ngaySinh = ?, ngayVaoLam = ?, email = ?, luong1Ngay = ?, xuLy = ? where maNV = '" + x.getMaNV() + "'";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, x.getTenNV());
            ps.setString(2, x.getGioiTinh());
            ps.setInt(3, x.getSoNgayPhep());
            ps.setString(4, x.getChucVu());
            ps.setString(7, x.getEmail());
            ps.setInt(8, x.getLuong1Ngay());
            ps.setInt(9, x.getXuLy());
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date date = sdf.parse(x.getNgaySinh());
            ps.setDate(5, new java.sql.Date(date.getTime()));
            date = sdf.parse(x.getNgayVaoLam());
            ps.setDate(6, new java.sql.Date(date.getTime()));
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    //Duy
    public static ArrayList<NhanVienDTO> searchNV(boolean[] attri, String[] values, String top, String order) {
        ArrayList<NhanVienDTO> list = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(getStm(attri, values, top, order));
            while (rs.next()) {
                NhanVienDTO a = new NhanVienDTO();
                a.setMaNV(rs.getString("maNV"));
                a.setTenNV(rs.getString("tenNV"));
                a.setGioiTinh(rs.getString("gioiTinh"));
                a.setSoNgayPhep(rs.getInt("soNgayPhep"));
                a.setChucVu(rs.getString("chucVu"));
                Date ngaySinh = rs.getDate("ngaySinh");
                Date ngayVaoLam = rs.getDate("ngayVaoLam");
                a.setNgaySinh(sdf.format(ngaySinh));
                a.setNgayVaoLam(sdf.format(ngayVaoLam));
                a.setEmail(rs.getString("email"));
                a.setLuong1Ngay(rs.getInt("luong1Ngay"));
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

    public static String getStm(boolean[] attri, String[] values, String top, String order) {
        String sql = "select ";
        //add top
        sql += top;
        sql += "* from NhanVien where ";
        boolean flag = false;
        for (int i = 0; i < 11; i++) {
            if (attri[i] == true) { //neu co thuoc tinh i
                flag = true;
                if (i == 0) {
                    sql += "maNV like '%" + values[0] + "%' and ";
                }
                if (i == 1) {
                    sql += "tenNV like N'%" + values[1] + "%' and ";
                }
                if (i == 2) {
                    sql += "gioiTinh like N'%" + values[2] + "%' and ";
                }
                if (i == 3) {
                    sql += "chucVu like N'%" + values[3] + "%' and ";
                }
                if (i == 4) {
                    String temp = "";
                    if (values[4].substring(0, 4).equals("Dưới")) {
                        temp = "soNgayPhep < " + values[4].substring(5, 6) + " and ";
                    } else if (values[4].substring(0, 4).equals("Trên")) {
                        temp = "soNgayPhep > " + values[4].substring(5, 6) + " and ";
                    } else if (values[4].substring(0, 2).equals("Từ")) {
                        temp = "soNgayPhep >= " + values[4].substring(3, 4) + " and " + "soNgayPhep <= " + values[4].substring(9, 10) + " and ";
                    }
                    sql += temp;
                }
                if (i == 5) {
                    sql += "ngaySinh >= '" + values[5] + "' and ";
                }
                if (i == 6) {
                    sql += "ngaySinh <= '" + values[6] + "' and  ";
                }
                if (i == 7) {
                    sql += "ngayVaoLam >= '" + values[7] + "' and ";
                }
                if (i == 8) {
                    sql += "ngayVaoLam <= '" + values[8] + "'  and ";
                }
                if (i == 9) {
                    String temp = "";
                    if (values[9].substring(0, 4).equals("Dưới")) {
                        temp = "luong1Ngay < " + values[9].substring(5, 11) + " and ";
                    } else if (values[9].substring(0, 4).equals("Trên")) {
                        temp = "luong1Ngay > " + values[9].substring(5, 12) + " and ";
                    } else if (values[9].substring(0, 2).equals("Từ")) {
                        temp = "luong1Ngay >= " + values[9].substring(3, 9) + " and " + "luong1Ngay <= " + values[9].substring(14, 20) + " and ";
                    }
                    sql += temp;
                }
                if (i == 10) {
                    sql += "email like '%" + values[10] + "%' and ";
                }
            }
        }
        if (flag) {
            sql = sql.substring(0, sql.length() - 4);
        } else {
            sql = sql.substring(0, sql.length() - 6);
        }
        //add order
        sql += order;
        return sql;
    }
}
