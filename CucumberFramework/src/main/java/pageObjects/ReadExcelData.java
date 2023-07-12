package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws IOException {

		ReadExcelData objReadExcelData = new ReadExcelData();
		objReadExcelData.getData("Email");

		Random random = new Random();

//		System.out.println(random.nextInt(500));

		objReadExcelData.randomNumberGenerator();

	}

	public String getData(String fieldNametoGetValue) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\resources\\UserRegistrationData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		Sheet sheet = wb.getSheetAt(0);

		Iterator<Row> it = sheet.iterator();
		Row row;
		Cell fieldName = null;
		Cell fieldValue = null;
		String str = "";
		while (it.hasNext()) {
			row = it.next();

			fieldName = row.getCell(0);
			fieldValue = row.getCell(1);

			if (fieldNametoGetValue.equals(fieldName.getStringCellValue())) {
				str = fieldValue.getStringCellValue();

			}

		}
		return str;

	}

	public int randomNumberGenerator() {
		Random random = new Random();
		int num = random.nextInt(9990);
		String str = "Akshay";
//		System.out.println(num + str);
		return num;

	}
}
