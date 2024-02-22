package GUI.GUI_DICHVU;

import BUS.ChiTietNhapBUS;
import BUS.DichVuBUS;
import BUS.PhieuNhapBUS;
import DTO.ChiTietNhapDTO;
import GUI.ThongBaoDialog;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportFileExcelPhieuNhap {

    public void ImportFile(String path, String maPN, FormDetailImportService formDetailImportService) throws IOException {
        String[] expectedHeaders = {"STT", "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Đơn giá nhập", "Thành tiền"};
        try {
            FileInputStream file = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            if (hasNullValue(sheet) == false) {
                if (checkHeader(sheet, expectedHeaders)) {
                    ArrayList<ChiTietNhapDTO> list = new ArrayList<>();
                    for (Row row : sheet) {
                        // Bỏ qua hàng đầu tiên vì nó chứa tiêu đề của bảng Excel
                        if (row.getRowNum() == 0 || row.getRowNum() == 1 || row.getRowNum() == 2 || row.getRowNum() == 3 || row.getRowNum() == 4) {
                            continue;
                        }

                        ChiTietNhapDTO x = new ChiTietNhapDTO();
                        x.setMaPN(maPN.trim());
                        x.setMaDV(row.getCell(1).getStringCellValue());
                        x.setSoLuong((int) row.getCell(3).getNumericCellValue());
                        Cell cell = row.getCell(4);
                        if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                            int ans = JOptionPane.showConfirmDialog(null, "File này chưa nhập đơn giá dịch vụ\nBạn có muốn nhập giá dịch vụ không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                            if (ans == JOptionPane.YES_OPTION) {
                                Desktop.getDesktop().open(new File(path));
                                return;
                            } else {
                                return;
                            }
                        }
                        x.setGiaDVNhap((int) row.getCell(4).getNumericCellValue());
                        list.add(x);
                    }
                    String check = PhieuNhapBUS.updateXuLy(maPN.trim());
                    if (check.equals("Phiếu nhập đã xử lý thành công")) {
                        int count = 0;
                        for (ChiTietNhapDTO x : list) {
                            if (ChiTietNhapBUS.updateCTN(x).equals("Sửa dịch vụ thành công")) {
                                count++;
                            }
                        }
                        if(count == list.size()) {
                            count = 0;
                            for(ChiTietNhapDTO x : list) {
                                count += DichVuBUS.updateSL(x.getMaDV(), x.getSoLuong());
                            }
                            if(count == list.size()) {
                                ThongBaoDialog tb = new ThongBaoDialog("Hoàn tất xử lý phiếu thuê", 2);
                                formDetailImportService.displayContentListService.Reset();
                                formDetailImportService.dispose();
                            } else {
                                ThongBaoDialog tb = new ThongBaoDialog("Xử lý phiếu thuê không thành công", 1);
                            }
                        }
                    } else {
                        ThongBaoDialog tb = new ThongBaoDialog(check, 1);
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Hãy Kiểm Tra Tiêu Đề Cột Hoặc Thứ Tự Cột Dữ Liệu ");
                }

            } else {
                JOptionPane.showConfirmDialog(null, "Hãy Kiểm Tra Lại, Có Giá Trị Là NULL");
            }

            workbook.close();
            file.close();
        } catch (Exception e) {
            ThongBaoDialog tbd = new ThongBaoDialog("Không tìm thấy file đã tự động tạo file mới\nHãy thực hiện lại xác nhận", 3);
            ExportFileExcelPhieuNhap export = new ExportFileExcelPhieuNhap();
            export.ExportFileExcelPhieuNhap(path, maPN);
        }
    }

    public boolean checkHeader(Sheet sheet, String[] expectedHeaders) {
        Row headerRow = sheet.getRow(4);
        int numColumns = headerRow.getLastCellNum();
        if (numColumns != expectedHeaders.length) {
            return false;
        }
        for (int i = 0; i < numColumns; i++) {
            Cell cell = headerRow.getCell(i);
            String actualHeader = cell.getStringCellValue().trim();
            String expectedHeader = expectedHeaders[i];
            if (!actualHeader.equals(expectedHeader)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasNullValue(Sheet sheet) {
        int lastRowNum = sheet.getLastRowNum();
        Row firstRow = sheet.getRow(0);
        int lastCellNum = firstRow.getLastCellNum();
        for (int i = 0; i <= lastRowNum; i++) { // duyệt hết các hàng trong bảng
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            for (int j = 0; j < lastCellNum; j++) { // duyệt hết các ô trong hàng
                Cell cell = row.getCell(j);
                if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                    return true; // nếu có bất kỳ ô nào null hoặc rỗng thì trả về true và dừng hàm
                }
                if (cell.getCellType() == Cell.CELL_TYPE_STRING && cell.getStringCellValue().isEmpty()) {
                    return true; // nếu có ô chứa chuỗi rỗng thì trả về true và dừng hàm
                }
            }
        }
        return false; // nếu không có ô nào null hoặc rỗng thì trả về false
    }
}
