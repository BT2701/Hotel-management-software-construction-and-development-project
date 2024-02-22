package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static DAO.ConnectDB.getConnection;
import DTO.ChiTietThuePhongDTO;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ChiTietThuePhongDAO implements DaoInterface<ChiTietThuePhongDTO> {

    public static ChiTietThuePhongDAO getInstance() {
        return new ChiTietThuePhongDAO();
    }

    public static int capNhatTinhTrang(String maCTT, int tinhTrang) {
        int check = 0;
        try {
            Connection con = new ConnectDB().getConnection();
            Statement st = con.createStatement();

            String sql = "UPDATE chitietthuephong\r\n"
                    + "SET "
                    + "tinhTrang= ? "
                    + "WHERE maCTT = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, tinhTrang);
            prep.setString(2, maCTT);
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
    public int them(ChiTietThuePhongDTO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int capNhap(ChiTietThuePhongDTO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int xoa(ChiTietThuePhongDTO t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ArrayList<ChiTietThuePhongDTO> selectAll() {
        ArrayList<ChiTietThuePhongDTO> list = new ArrayList<>();
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT * FROM chitietthuephong";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ChiTietThuePhongDTO ct = new ChiTietThuePhongDTO();
                ct.setMaCTT(rs.getString(1));
                ct.setMaP(rs.getString(2));

                ct.setDateThue(rs.getDate(3));
                if (rs.getDate(4) != null) {
                    ct.setDateTra(rs.getDate(4));
                }
                if (rs.getDate(5) != null) {
                    ct.setDateCheckOut(rs.getDate(5));
                }

                ct.setLoaiHinhThue(rs.getInt(6));
                ct.setGiaThue(rs.getInt(7));
                ct.setTinhTrang(rs.getInt(8));
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
    public ChiTietThuePhongDTO selectById(ChiTietThuePhongDTO t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<ChiTietThuePhongDTO> selectBy(String condition) {
        // TODO Auto-generated method stub
        return null;
    }

    public static boolean insertCTTP(ChiTietThuePhongDTO cttP) {
        boolean check = false;
        try {
            Connection conn = getConnection();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String query = "insert into CHITIETTHUEPHONG values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);

            ps.setString(1, cttP.getMaCTT());
            ps.setString(2, cttP.getMaP());

            Date dateThue = sdf.parse(cttP.getNgayThue());
            ps.setTimestamp(3, new java.sql.Timestamp(dateThue.getTime()));

            if (cttP.getNgayTra() == null) {
                ps.setTimestamp(4, null);
            } else {
                Date dateTra = sdf.parse(cttP.getNgayTra());
                ps.setTimestamp(4, new java.sql.Timestamp(dateTra.getTime()));
            }
            if (cttP.getNgayCheckOut() == null) {
                ps.setTimestamp(5, null);
            } else {
                Date dateCheckOut = sdf.parse(cttP.getNgayCheckOut());
                ps.setTimestamp(5, new java.sql.Timestamp(dateCheckOut.getTime()));
            }

            ps.setInt(6, cttP.getLoaiHinhThue());
            ps.setInt(7, cttP.getGiaThue());
            ps.setInt(8, cttP.getTinhTrang());

            if (ps.executeUpdate() >= 1) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static ArrayList<ChiTietThuePhongDTO> getListTPofCTT(String maChiTietThue) {
        ArrayList<ChiTietThuePhongDTO> list = new ArrayList<>();
        try {
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT * FROM CHITIETTHUEPHONG where maCTT = '" + maChiTietThue + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ChiTietThuePhongDTO ct = new ChiTietThuePhongDTO();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String dateNgayThue = sdf.format(rs.getTimestamp(3));
                try {
                    String dateNgayTra = sdf.format(rs.getTimestamp(4));
                    ct.setNgayTra(dateNgayTra);
                } catch (Exception ex) {
                    ct.setNgayTra("");
                }

                try {
                    String dateNgayCheckOut = sdf.format(rs.getTimestamp(5));
                    ct.setNgayCheckOut(dateNgayCheckOut);
                } catch (Exception ex) {
                    ct.setNgayCheckOut("");
                }

                ct.setMaCTT(rs.getString(1));
                ct.setMaP(rs.getString(2));
                ct.setNgayThue(dateNgayThue);

                ct.setLoaiHinhThue(rs.getInt(6));
                ct.setGiaThue(rs.getInt(7));
                ct.setTinhTrang(rs.getInt(8));
                list.add(ct);
            }
            con.close();
        } catch (Exception e) {
        }
        return list;
    }

    public static boolean deleteCTTPhong(String maCTT, String maP, String dateTimeThue) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "Delete ChiTietThuePhong where maCTT = '" + maCTT + "' and maP ='" + maP + "' and ngayThue = '" + dateTimeThue + "'";
            Statement stmt = conn.createStatement();
            if (stmt.executeUpdate(query) >= 1) {
                check = true;
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean updateTT(String maCTT, String maP, String dateTimeThue, int tt) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "Update ChiTietThuePhong set tinhTrang = " + tt + " where maCTT = '" + maCTT + "' and maP ='" + maP + "' and ngayThue = '" + dateTimeThue + "'";
            Statement stmt = conn.createStatement();
            if (stmt.executeUpdate(query) >= 1) {
                check = true;
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static int getGiaThue(String maCTT, String maP, String dateTimeThue) {
        int gia = 0;
        try {
            Connection conn = getConnection();
            String query = "Select giaThue from ChiTietThuePhong where maCTT = '" + maCTT + "' and maP ='" + maP + "' and ngayThue = '" + dateTimeThue + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                gia = rs.getInt(1);
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
        }
        return gia;
    }

    public static boolean setGiaThue(String maCTT, String maP, String dateTimeThue, int gia) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "Update ChiTietThuePhong set giaThue = " + gia + " where maCTT = '" + maCTT + "' and maP ='" + maP + "' and ngayThue = '" + dateTimeThue + "'";
            Statement stmt = conn.createStatement();
            if (stmt.executeUpdate(query) >= 1) {
                check = true;
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean updateCK(String maCTT, String maP, String dateTimeThue, String dateCheckOut) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "Update ChiTietThuePhong set ngayCheckOut = '" + dateCheckOut + "' where maCTT = '" + maCTT + "' and maP ='" + maP + "' and ngayThue = '" + dateTimeThue + "'";
            Statement stmt = conn.createStatement();
            if (stmt.executeUpdate(query) >= 1) {
                check = true;
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean updateT(String maCTT, String maP, String dateTimeThue, String dateTra) {
        boolean check = false;
        try {
            Connection conn = getConnection();
            String query = "Update ChiTietThuePhong set ngayTra = '" + dateTra + "' where maCTT = '" + maCTT + "' and maP ='" + maP + "' and ngayThue = '" + dateTimeThue + "'";
            Statement stmt = conn.createStatement();
            if (stmt.executeUpdate(query) >= 1) {
                int giaP = getGiaThue(maCTT, maP, dateTimeThue);
                int gia = 0;
                DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTimeThuestr = LocalDateTime.parse(dateTimeThue, dateTimeFormat);
                LocalDateTime dateTimeTrastr = LocalDateTime.parse(dateTra, dateTimeFormat);

                int countHour = (int) ChronoUnit.HOURS.between(dateTimeThuestr, dateTimeTrastr);
                if (countHour <= 24) {
                    if (countHour == 1) {
                        gia = giaP * 15 / 100;
                    } else if (countHour == 2) {
                        gia = giaP * 20 / 100;
                    } else if (countHour == 3) {
                        gia = giaP * 30 / 100;
                    } else if (countHour > 3 && countHour <= 12) {
                        gia = giaP / 2;
                    } else {
                        gia = giaP;
                    }
                } else {
                    gia = (countHour / 24) * giaP;
                    if (countHour % 24 == 1) {
                        gia += giaP * 15 / 100;
                    } else if (countHour % 24 == 2) {
                        gia += giaP * 20 / 100;
                    } else if (countHour % 24 == 3) {
                        gia += giaP * 30 / 100;
                    } else if (countHour % 24 > 3 && countHour % 24 <= 12) {
                        gia += giaP / 2;
                    } else {
                        gia += giaP;
                    }
                }
                if (setGiaThue(maCTT, maP, dateTimeThue, gia)) {
                    check = true;
                }
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
        }
        return check;
    }

    public static int count(String maCTT) {
        int count = 0;
        try {
            Connection conn = getConnection();
            String query = "select COUNT(maP) as Count from CHITIETTHUEPHONG where maCTT = '" + maCTT + "' and tinhTrang = 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                count = rs.getInt(1);
            }
            conn.close();
        } catch (Exception ex) {
        }
        return count;
    }

    public ChiTietThuePhongDTO selectByMaPhong(String maP) {
        ArrayList<ChiTietThuePhongDTO> ctt = new ArrayList<>();
//		ChiTietThuePhongDTO ctt=null;
        try {
            Connection con = new ConnectDB().getConnection();
            String sql = "SELECT * FROM chitietthuephong WHERE maP='" + maP + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ChiTietThuePhongDTO hd = new ChiTietThuePhongDTO();
                hd.setMaCTT(rs.getString(1));
                hd.setMaP(rs.getString(2));
                hd.setDateThue(rs.getDate(3));
                if (rs.getDate(4) != null) {
                    hd.setDateTra(rs.getDate(4));
                }
                if (rs.getDate(5) != null) {
                    hd.setDateCheckOut(rs.getDate(5));
                }

                hd.setLoaiHinhThue(rs.getInt(6));
                hd.setGiaThue(rs.getInt(7));
                hd.setTinhTrang(rs.getInt(8));
                ctt.add(hd);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;

        }
        return ctt.get(0);
    }
}
