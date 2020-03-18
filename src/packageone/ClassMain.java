package packageone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;

public class ClassMain extends Course_Schedule{
	
	@BeforeTest
	public void MethodMain() throws IOException, InterruptedException {
		
		int Coulmn_Count=0;
		LinkedList<String> Key = new LinkedList<String>();
		LinkedList<String> Value = new LinkedList<String>();
		
		
		File Excel = new  File("C:\\Users\\Satish\\eclipse-workspace\\Sample_Project\\DataFolder\\TestData.xlsx");
		FileInputStream Read_Write = new FileInputStream(Excel);
		
		XSSFWorkbook wb = new XSSFWorkbook(Read_Write);
		XSSFSheet DataSheet = wb.getSheet("TestDataSheet");
		
		DataFormatter formatter = new DataFormatter();
		
		int Row_Count = DataSheet.getLastRowNum()-DataSheet.getFirstRowNum();
		System.out.println(Row_Count);
		for(int i=0;i<Row_Count;i++) {
			Coulmn_Count = DataSheet.getRow(i).getLastCellNum();
			for(int j=0;j<Coulmn_Count;j++) {
				String Value1 = formatter.formatCellValue(DataSheet.getRow(i).getCell(j));
				Key.add(Value1);
			}
		}
		System.out.println(Key);
		
		for(int i=1;i<=Row_Count;i++) {
			for(int j=0;j<Coulmn_Count;j++) {
				String Value1 = formatter.formatCellValue(DataSheet.getRow(i).getCell(j));
				Value.add(Value1);
			}
		}
		System.out.println(Value);
		
		for(int i=0;i<Key.size();i++) {
			MapData.put(Key.get(i), Value.get(i));
		}
		System.out.println(MapData);
		
	}
}
