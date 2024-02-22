package DAO;

import static DAO.ConnectDB.getConnection;
import DTO.TaiKhoanDTO;
import com.itextpdf.text.pdf.qrcode.ByteArray;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;

/**
 *
 * @author SYN
 */
public class TaiKhoanDAO {

    //get list
    //FUNCTION FROM TRƯỞNG
    //BEGIN
    public static TaiKhoanDAO getInstance() {
        return new TaiKhoanDAO();
    }
    //END

    public TaiKhoanDTO selectNameByID(String taiKhoan) {
        TaiKhoanDTO tk = null;
        try {
            Connection conn = getConnection();
            String query = "select * from TaiKhoan where taiKhoan = '" + taiKhoan + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                TaiKhoanDTO a = new TaiKhoanDTO();
                a.setTaiKhoan(rs.getString("taiKhoan"));
                a.setMaNV(rs.getString("maNV"));
                a.setVaiTro(rs.getString("vaiTro"));
                a.setTinhTrang(rs.getInt("tinhTrang"));
                tk = a;
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return tk;
    }

    //get list
    public static ArrayList<TaiKhoanDTO> getListNV() {
        ArrayList<TaiKhoanDTO> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "select nv.maNV,taiKhoan,vaiTro,tinhTrang from NHANVIEN as nv left join TAIKHOAN as tk on nv.maNV=tk.maNV ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                TaiKhoanDTO a = new TaiKhoanDTO();
                a.setMaNV(rs.getString("maNV"));
                //String=null; but int!=null; int phai khac null
                Object tinhTrang = rs.getObject("tinhTrang");
                if (tinhTrang == null) {
                    a.setTinhTrang(-1);
                    a.setTaiKhoan("null");
                    a.setVaiTro("null");
                } else if (tinhTrang instanceof Integer) {
                    a.setTaiKhoan(rs.getString("taiKhoan"));
                    a.setVaiTro(rs.getString("vaiTro"));
                    a.setTinhTrang(rs.getInt("tinhTrang"));
                }
                list.add(a);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }

    public static boolean checkID(String taiKhoan) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "select * from taiKhoan where taiKhoan = '" + taiKhoan + "'";
            System.out.println(query);
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

    public static byte[] createHashMK(String maNV) {
        String ngaySinhStr;
        byte[] matKhau = null;
        Date ngaySinh = null;
        try {
            Connection conn = getConnection();
            String query = "select ngaySinh from nhanVien where maNV= '" + maNV + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ngaySinh = rs.getDate("ngaySinh");
            }
            DateFormat df = new SimpleDateFormat("ddMMyyyy");
            ngaySinhStr = df.format(ngaySinh);

            //salting
            //ngaySinhStr="mat"+ngaySinhStr+"khau";
            // Băm dữ liệu
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] data = ngaySinhStr.getBytes();
            matKhau = md.digest(data);
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matKhau;
    }

    public static boolean insertTK(TaiKhoanDTO x) {
        boolean check = false;
        try {
            byte[] mK = createHashMK(x.getMaNV());
            Connection conn = getConnection();
            String query = "insert into TaiKhoan(taiKhoan,maNV,matKhau,tinhTrang,vaiTro) values (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, x.getTaiKhoan());
            ps.setString(2, x.getMaNV());
            ps.setBytes(3, mK);
            ps.setInt(4, x.getTinhTrang());
            ps.setString(5, x.getVaiTro());
            if (ps.executeUpdate() >= 1) {
                System.out.println("insertOK");
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean lockTK(String taiKhoan) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update TaiKhoan set tinhTrang = 1 where taiKhoan = '" + taiKhoan + "'";
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

    public static boolean updateTK(TaiKhoanDTO x) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "update TaiKhoan set maNV = ?, vaiTro = ?, tinhTrang = ? where taiKhoan = '" + x.getTaiKhoan() + "'";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, x.getMaNV());
            ps.setString(2, x.getVaiTro());
            ps.setInt(3, x.getTinhTrang());
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
    public static ArrayList<TaiKhoanDTO> searchTK(boolean[] attri, String[] values, String top, String order) {
        ArrayList<TaiKhoanDTO> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(getStm(attri, values, top, order));
            while (rs.next()) {
                TaiKhoanDTO a = new TaiKhoanDTO();
                a.setMaNV(rs.getString("maNV"));
                //String=null; but int!=null; int phai khac null
                Object tinhTrang = rs.getObject("tinhTrang");
                if (tinhTrang == null) {
                    a.setTinhTrang(-1);
                    a.setTaiKhoan("null");
                    a.setVaiTro("null");
                } else if (tinhTrang instanceof Integer) {
                    a.setTaiKhoan(rs.getString("taiKhoan"));
                    a.setVaiTro(rs.getString("vaiTro"));
                    a.setTinhTrang(rs.getInt("tinhTrang"));
                }
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
        sql += "nv.maNV,taiKhoan,vaiTro,tinhTrang from NHANVIEN as nv left join TAIKHOAN as tk on nv.maNV=tk.maNV where ";
        boolean flag = false; //neu khong co thuoc tinh nao
        for (int i = 0; i < 4; i++) {
            if (attri[i] == true) { //neu co thuoc tinh i
                flag = true;
                if (i == 0) {
                    sql += "nv.maNV like '%" + values[0] + "%' and ";
                }
                if (i == 1) {
                    sql += "taiKhoan like '%" + values[1] + "%' and ";
                }
                if (i == 2) {
                    sql += "vaiTro like '%" + values[2] + "%' and ";
                }
                if (i == 3) { //tinhTrang co them item[0]="Tình Trạng"
                    if (values[3].equals("3")) { //khi chưa mở tài khoản
                        sql += "tinhTrang IS NULL" + "and ";
                    } else { //khi mở tài khoản, các tình trạng trừ đi 1
                        sql += "tinhTrang = " + values[3] + "-1 and ";
                    }
                }
            }
        }
        if (flag) {
            sql = sql.substring(0, sql.length() - 4); //-and
        } else {
            sql = sql.substring(0, sql.length() - 6);//-where
        }        //add order
        sql += order;
        System.out.println(sql);
        return sql;
    }

    //Duy
    public static ArrayList<TaiKhoanDTO> getAllTaiKhoan() {
        ArrayList<TaiKhoanDTO> listAccount = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "Select * from TaiKhoan";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                TaiKhoanDTO tk = new TaiKhoanDTO();
                tk.setTaiKhoan(rs.getString("taiKhoan"));
                byte[] data = rs.getBytes("matKhau");
                StringBuilder sb = new StringBuilder();
                for (byte b : data) {
                    sb.append(String.format("%02x", b));
                }
                tk.setMatKhau(sb.toString());
                tk.setMaNV(rs.getString("maNV"));
                tk.setVaiTro(rs.getString("vaiTro"));
                tk.setTinhTrang(rs.getInt("tinhTrang"));
                listAccount.add(tk);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception ex) {
        }
        return listAccount;
    }

    public static boolean changePassword(String taiKhoan, String matKhau) {
        boolean check = false;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] data = matKhau.getBytes();
            byte[] mk = md.digest(data);
            Connection conn = getConnection();
            String query = "update TaiKhoan set matKhau = ? where taiKhoan = ?";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setBytes(1, mk);
            ps.setString(2, taiKhoan);
            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
        }
        return check;
    }
}
