package generic_Lib;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import propertyfiles.Messages;

public class Excel_Lib {

	DataFormatter d = new DataFormatter();
	String FilePath = Messages.getString("ExcelSheet");
	String SheetName = Messages.getString("SheetName");

	public String ExcelRead(int row, int Column) throws Exception{
		FileInputStream fi = new FileInputStream(FilePath);  //Path
		XSSFWorkbook wb = new XSSFWorkbook(fi);  //xlsx format
		XSSFSheet sh = wb.getSheet(SheetName); // sheet name
		XSSFRow r = sh.getRow(row);  //row
		String cellvalue = d.formatCellValue(r.getCell(Column));  // column
		System.out.println("cellvalue  "+cellvalue);
		wb.close();
		fi.close();
		return cellvalue;
	}

}
		//DB   framewrok   reportsExtent   Lingked/HapsMaps  github/bitbuket/jekins-10mins
