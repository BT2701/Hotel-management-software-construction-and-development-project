package GUI.GUI_DICHVU;

import BUS.ChiTietNhapBUS;
import BUS.DichVuBUS;
import BUS.NhanVienBUS;
import BUS.PhieuNhapBUS;
import DTO.ChiTietNhapDTO;
import DTO.PhieuNhapDTO;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportFileExcelPhieuNhap {

    public void ExportFileExcelPhieuNhap(String path, String maPN) throws FileNotFoundException, IOException {
        PhieuNhapDTO pn = PhieuNhapBUS.searchPN(maPN);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Thông tin phiếu nhập");
        // add row1
        XSSFRow Row1 = sheet.createRow(0);
        // add cell
        Cell Row1Cell1 = Row1.createCell(0);
        Row1Cell1.setCellValue("Mã phiếu nhập");
        Cell Row1Cell2 = Row1.createCell(1);
        Row1Cell2.setCellValue(pn.getMaPN());
        // add row2
        XSSFRow Row2 = sheet.createRow(1);
        // add cell
        Cell Row2Cell1 = Row2.createCell(0);
        Row2Cell1.setCellValue("Tên nhân viên");
        Cell Row2Cell2 = Row2.createCell(1);
        Row2Cell2.setCellValue(NhanVienBUS.getTenNV(pn.getMaNV()));
        // add row3
        XSSFRow Row3 = sheet.createRow(2);
        // add cell
        Cell Row3Cell1 = Row3.createCell(0);
        Row3Cell1.setCellValue("Ngày lập");
        Cell Row3Cell2 = Row3.createCell(1);
        Row3Cell2.setCellValue(pn.getNgayLapPhieu());
        // add row4
        XSSFRow Row4 = sheet.createRow(3);
        // add cell
        Cell Row4Cell1 = Row4.createCell(0);
        Row4Cell1.setCellValue("Tình trạng phiếu");
        Cell Row4Cell2 = Row4.createCell(1);
        if (pn.getTinhTrangXuLy() == 0) {
            Row4Cell2.setCellValue("Chưa xử lý");
        } else {
            Row4Cell2.setCellValue("Đã xử lý");
        }
        
        ArrayList<ChiTietNhapDTO> list = ChiTietNhapBUS.getList(pn.getMaPN());
        // add row5
        XSSFRow Row5 = sheet.createRow(4);
        // add cell
        Cell Row5Cell1 = Row5.createCell(0);
        Row5Cell1.setCellValue("STT");
        Cell Row5Cell2 = Row5.createCell(1);
        Row5Cell2.setCellValue("Mã dịch vụ");
        Cell Row5Cell3 = Row5.createCell(2);
        Row5Cell3.setCellValue("Tên dịch vụ");
        Cell Row5Cell4 = Row5.createCell(3);
        Row5Cell4.setCellValue("Số lượng");
        Cell Row5Cell5 = Row5.createCell(4);
        Row5Cell5.setCellValue("Đơn giá nhập");
        Cell Row5Cell6 = Row5.createCell(5);
        Row5Cell6.setCellValue("Thành tiền");
        int rowNum = 5;
        int no = 1;
        for (ChiTietNhapDTO x : list) {
            XSSFRow row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(no++);
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(x.getMaDV());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(DichVuBUS.getTenDV(x.getMaDV()));
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(x.getSoLuong());
            Cell cell5 = row.createCell(4);
            if(x.getGiaDVNhap() != 0) {
                cell5.setCellValue(x.getGiaDVNhap());
            }
            Cell cell6 = row.createCell(5);
            int col4 = cell4.getColumnIndex();
            int row4 = cell4.getRowIndex();
            int col5 = cell5.getColumnIndex();
            int row5 = cell5.getRowIndex();
            String ref4 = CellReference.convertNumToColString(col4) + (row4 + 1);
            String ref5 = CellReference.convertNumToColString(col5) + (row5 + 1);
            String formula = ref5 + "*" + ref4;
            cell6.setCellFormula(formula);
        }
        for (int i = 0; i < 6; i++) {
            sheet.autoSizeColumn(i);
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
    }
}
