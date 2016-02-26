package cn.edu.gduf.netserver.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * 操作excel相关的类
 * @author hsg
 * 2015-02-28
 */
public class ExcelUtil {

	/**
	 * 创建单元格
	 * @param sheet 
	 * @param rowIndex 行索引
	 * @param columnIndex 列索引
	 * @param rowHeight 行高
	 * @param value 显示的内容
	 * @param cellStyle 单元格样式
	 * @param beginRow 开始行（单元格合并时用到，以下都是；若不合并这四个值均为0）
	 * @param endRow 结束行
	 * @param beginColumn 开始列
	 * @param endColumn 结束列
	 * @throws Exception
	 */
	public static void newCell(Sheet sheet, int rowIndex, int columnIndex, Short rowHeight, String[] value, CellStyle cellStyle, int beginRow, int endRow, int beginColumn, int endColumn)throws Exception{
		Row row;
		Cell cell; 
		if (sheet.getRow(rowIndex) != null) {  // 如果该已创建过则使用创建过的
			row = sheet.getRow(rowIndex);
		}else {
			row = sheet.createRow(rowIndex);
		}
		row.setHeight(rowHeight);
		if (value.length == 1) {
			cell = row.createCell(columnIndex);
			cell.setCellValue(value[0]);
			cell.setCellStyle(cellStyle);
		}else {
			// 如果value数组长度大于1，则从第rowIndex行第columnIndex列开始遍历，往后写入内容
			for(int i = columnIndex; i < value.length + columnIndex; i++){
				cell = row.createCell(i);
				cell.setCellValue(value[i - columnIndex]);
				cell.setCellStyle(cellStyle);
			}
		}	
		sheet.addMergedRegion(new CellRangeAddress(beginRow, endRow, beginColumn, endColumn));  // 合并
	}
	
	/**
	 * 创建单元格样式
	 * @param wb 工作簿
	 * @param size 字体大小
	 * @param fontType 采用的字体
	 * @param isBold 是否粗体；“1”表示粗体，“0”表示否
	 * @param isAlign 是否居中；“0”表示默认，“1”表示居中，“2”表示居左上
	 * @return
	 */
	public static CellStyle newCellStyle(Workbook wb, Short size, String fontType, int isBold, int isCenter){
		CellStyle cellStyle = wb.createCellStyle();  // 创建单元格样式
		Font font = wb.createFont();
		font.setFontHeightInPoints(size);
		font.setFontName(fontType);
		if (1 == isBold) {  // 粗体
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		}
		if (1 == isCenter) {  // 居中
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  // 设置单元格水平方向居中对齐
			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 设置单元格垂直方向居中对齐
		}else if (2 == isCenter) {  // 左上
			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP); // 设置单元格垂直方向居中对齐
		}
		cellStyle.setFont(font);
		cellStyle.setWrapText(true);  // 设置换行
		return cellStyle;
		
	}
}