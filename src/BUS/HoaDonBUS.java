package BUS;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;

public class HoaDonBUS implements BusInterface<HoaDonDTO> {

    private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static HoaDonBUS getIntance() {
        return new HoaDonBUS();
    }
    private ArrayList<HoaDonDTO> listHD = HoaDonDAO.getIntance().selectAll();

    @Override
    public ArrayList<HoaDonDTO> getList() {
        return HoaDonDAO.getIntance().selectAll();
    }

    public ArrayList<HoaDonDTO> getlistdata() {
        return listHD;
    }

//    public ArrayList<HoaDonDTO> getListByDate(Date date) {
//        HoaDonDTO hd = new HoaDonDTO();
//        hd.setDate(date);
//        String txtDate = sdf1.format(hd.getDate());
//        ArrayList<HoaDonDTO> listHD = new ArrayList<>();
//        for (int i = 0; i < getList().size(); i++) {
//            if ((sdf1.format(getList().get(i).getDate())).equalsIgnoreCase(txtDate)) {
//                listHD.add(getList().get(i));
//            }
//        }
//        return listHD;
//    }
    @Override
    public void saveData(HoaDonDTO t) {
        // TODO Auto-generated method stub
        HoaDonDAO.getIntance().them(t);

    }

    @Override
    public HoaDonDTO getByID(HoaDonDTO t) {
        // TODO Auto-generated method stub
        return HoaDonDAO.getIntance().selectById(t);
    }

    @Override
    public void inSert(HoaDonDTO t) {
        HoaDonDAO.getIntance().them(t);

    }

    @Override
    public void upDate(HoaDonDTO t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(HoaDonDTO t) {
        // TODO Auto-generated method stub

    }

    public int getMaHDmoiNhat() {
        int maHDmoiNhat = 0;
        for (HoaDonDTO hoaDon : getList()) {
            String txtmaHD = hoaDon.getMaHD();
            int maHD = 0;
            if (txtmaHD.length() >= 4) {
                txtmaHD = txtmaHD.substring(txtmaHD.length() - 4);
                maHD = Integer.parseInt(txtmaHD);
            }
            if (maHD > maHDmoiNhat) {
                maHDmoiNhat = maHD;
            }
        }
        return maHDmoiNhat;
    }

    public double getTongDoanhThu() {
        double tongDoanhThu = 0;
        for (HoaDonDTO hoaDon : getList()) {
            tongDoanhThu += hoaDon.getTongTien();
        }
        return tongDoanhThu;
    }

//    public double getTongDoanhThuTheoNgay(Date date) {
//        double tongDoanhThuTheoNgay = 0;
//        for (HoaDonDTO hoaDon : getList()) {
//            if (sdf.format(hoaDon.getDate()).equalsIgnoreCase(sdf.format(date))) {
//                tongDoanhThuTheoNgay += hoaDon.getTongTien();
//            }
//        }
//        return tongDoanhThuTheoNgay;
//    }
    public double getTongDoanhThuTheoMaCTT(String maCTT) {
        double tongDoanhThuTheoNV = 0;
        for (HoaDonDTO hoaDon : getList()) {
            if (hoaDon.getMaCTT().equalsIgnoreCase(maCTT)) {
                tongDoanhThuTheoNV += hoaDon.getTongTien();
            }
        }
        return tongDoanhThuTheoNV;
    }

    public ArrayList<String> getDsMaHoaDonTheoCTT(String maCTT) {
        ArrayList<String> listMahd = new ArrayList<>();
        for (HoaDonDTO hoaDon : getList()) {
            if (hoaDon.getMaCTT().equalsIgnoreCase(maCTT)) {
                String maHD = hoaDon.getMaHD();
                listMahd.add(maHD);
            }
        }
        return listMahd;
    }

    public ArrayList<String> layMaHoaDonTheoKhoangThoiGian(Date tuNgay, Date denNgay) {

        return HoaDonDAO.getIntance().layMaHoaDonTheoKhoangThoiGian(tuNgay, denNgay);
    }

    public double layDoanhThuTheoNgayChart(int year, int month, int day) {
        double doanhThu = 0;
        String ngay = day + "";
        String thang = month + "";
        if (day < 10) {
            ngay = "0" + day;
        } else {
            ngay = day + "";
        }
        if (month < 10) {
            thang = "0" + month;
        } else {
            thang = month + "";
        }
        String ngayThangNam = ngay + "/" + thang + "/" + year;
        try {
            for (HoaDonDTO hoaDon : getList()) {
                Date date = sdf.parse(hoaDon.getNgayThanhToan());
                if (sdf1.format(date).equalsIgnoreCase(ngayThangNam)) {
                    doanhThu += hoaDon.getTongTien();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return doanhThu;
    }

    public double thongKeTheoKhoangThoiGian(Date tuNgay, Date denNgay) {
        return HoaDonDAO.getIntance().thongKeTheoKhoangThoiGian(tuNgay, denNgay);
    }

    public ArrayList<HoaDonDTO> layDsHoaDonTheoKhoangThoiGian(Date tuNgay, Date denNgay) {
        ArrayList<HoaDonDTO> listhd = new ArrayList<>();
        for (String maHD : HoaDonDAO.getIntance().layMaHoaDonTheoKhoangThoiGian(tuNgay, denNgay)) {
            for (HoaDonDTO hoaDon : getList()) {
                if (hoaDon.getMaHD().equalsIgnoreCase(maHD)) {
                    listhd.add(hoaDon);
                }
            }
        }
        return listhd;
    }

    public ArrayList<HoaDonDTO> layDsHoaDonTheoGia(double giaTu, double denGia) {
        return HoaDonDAO.getIntance().layDanhSachHoaDonTheoGia(giaTu, denGia);
    }

    public void thayDoiTrangThai(String maHD, int trangThai) {
        HoaDonDAO.getIntance().thayDoiTrangThai(maHD, trangThai);
    }

    public ArrayList<HoaDonDTO> layDsHoaDonTheoKhoangGia(ArrayList<HoaDonDTO> list, double giaTu, double denGia) {
        ArrayList<HoaDonDTO> newList = new ArrayList<>();
        for (HoaDonDTO hoaDonDTO : list) {
            if ((double) hoaDonDTO.getTongTien() >= giaTu && (double) hoaDonDTO.getTongTien() <= denGia) {
                newList.add(hoaDonDTO);
            }
        }
        return newList;
    }
    //hàm thêm mới ngày 6/11/2023

    public double layDuLieuTongThuTheoThang(int nam, int thang) {
        return HoaDonDAO.getIntance().layDuLieuTongThuTheoThang(nam, thang);
    }

    public double layDuLieuTongChiTheoThang(int nam, int thang) {
        return HoaDonDAO.getIntance().layDuLieuTongChiTheoThang(nam, thang);
    }
}
