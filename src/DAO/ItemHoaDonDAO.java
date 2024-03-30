package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import DTO.HoaDonDTO;
import DTO.ItemHoaDon;

public class ItemHoaDonDAO {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    DecimalFormat dcf = new DecimalFormat("###,###");

    public static ItemHoaDonDAO getInstance() {
        return new ItemHoaDonDAO();
    }

    public ArrayList<ItemHoaDon> selectAll(String mactt) {
        ArrayList<ItemHoaDon> listHD = new ArrayList<>();
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            String sql = "select DISTINCT phong.tenP, chitietthuephong.loaiHinhThue,chitietthuephong.ngayThue,chitietthuephong.ngayCheckOut, chitietthuephong.giaThue\r\n"
                    + "from CHITIETTHUE inner join CHITIETTHUEPHONG on  CHITIETTHUE.maCTT = CHITIETTHUEPHONG.maCTT\r\n"
                    + "				inner join PHONG on CHITIETTHUEPHONG.maP = PHONG.maP\r\n"
                    + "				left join HoaDon on HOADON.maCTT = CHITIETTHUE.maCTT\r\n"
                    + "				where CHITIETTHUEPHONG.maCTT = '" + mactt + "' and chitietthuephong.tinhtrang = 2";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ItemHoaDon hd = new ItemHoaDon();
                hd.setTenP(rs.getString(1));
                hd.setLoaiHinhThue(rs.getInt(2));
                hd.setNgayThue(sdf.format(rs.getDate(3)));
                hd.setNgayTra(sdf.format(rs.getDate(4)));
                hd.setGiaThue(dcf.format(rs.getInt(5)));
                listHD.add(hd);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;

        }
        return listHD;
    }

}
