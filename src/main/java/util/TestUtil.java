package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseTest;

public class TestUtil extends BaseTest{
	public static String TESTDATA_SHEET_PATH = "E://DEMO_WORKSPACE//com.freecrm//src//main//java//testdata//freeCRMTestData.xlsx";
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT=60;
	static Workbook book ;
	static Sheet sheet;

	WebDriverWait wait =null;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	//Method to call data from excel file
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
				book = WorkbookFactory.create(file);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		System.out.println(data);
		return data;
		
	}
	
	public static void takeScreenShotAtEndOfTest() throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	//	Files.copyFile(srcFile, new File(currentDir +"/freeCRM_Screenshot"+System.currentTimeMillis()+".png"));
	}
	
}
