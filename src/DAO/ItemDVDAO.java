package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import DTO.ItemDV;
import DTO.ItemHoaDon;

public class ItemDVDAO {
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	DecimalFormat dcf=new DecimalFormat("###,###");
	public static ItemDVDAO getInstance() {
		return new ItemDVDAO();
	}
	public ArrayList<ItemDV> selectAll(String mactt, int options) {
        ArrayList<ItemDV> listHD = new ArrayList<>();
        try {
            //maHD,maCTT,tienP,tienDV,giamGia,phuThu,tongTien,ngayThanhToan,phuongThucThanhToan,xuLy
            Connection con = new ConnectDB().getConnection();
            String sql = "select DISTINCT tenDV, loaiDV,ngaySuDung, CHITIETTHUEDICHVU.SoLuong, CHITIETTHUEDICHVU.giaDV, \r\n"
            		+ "(CHITIETTHUEDICHVU.SoLuong *  CHITIETTHUEDICHVU.giaDV) as THANHTIEN from DICHVU, CHITIETTHUEDICHVU, CHITIETTHUE, HOADON\r\n"
            		+ "where DICHVU.maDV = CHITIETTHUEDICHVU.maDV and CHITIETTHUEDICHVU.maCTT = CHITIETTHUE.maCTT and HOADON.maCTT = CHITIETTHUE.maCTT AND chitietthue.maCTT = '"+mactt+"' and chitietthue.tinhTrangXuLy = "+options+"";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	ItemDV hd = new ItemDV();
                hd.setTenDV(rs.getString(1));
                hd.setLoaiDV(rs.getString(2));
                hd.setNgaySD(sdf.format(rs.getDate(3)));
                hd.setSoLuong(rs.getInt(4));
                hd.setDonGia(rs.getInt(5));
                hd.setThanhTien(rs.getInt(6));
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
