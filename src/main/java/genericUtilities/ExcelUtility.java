package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to file operations
 * @author kavya
 *
 */

public class ExcelUtility {
	
	/**
	 * This method will read data from excel file
	 * @param sheetname
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String readDataFromExcel(String sheetname, int rowNo, int celNo) throws EncryptedDocumentException, IOException  {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row rw = sh.getRow(rowNo);
		Cell cl = rw.getCell(celNo);
		String value = cl.getStringCellValue();
		return value;
		
	}
}

