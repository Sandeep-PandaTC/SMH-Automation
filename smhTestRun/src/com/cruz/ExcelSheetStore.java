package com.cruz;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class ExcelSheetStore {
	
	static String pathTillProject;
	static String FilePAth;
	static HSSFWorkbook workbook;
	static HSSFSheet sheet;
	static HSSFRow row;
	static HSSFRow rowHead;
	static int rowCount=1;
	static LocalTime start;
	static LocalTime end;
	static long starttime;
	static long endtime;
	static SimpleDateFormat StartTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SS");
	static String startTime;
	static String Date;
	static String appName;
	static String platformOS;
	static final String fileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	
	@SuppressWarnings("deprecation")
	ExcelSheetStore(String AppName){
		appName = AppName;
		
		
		pathTillProject = "/Users/sandeep/Desktop/SMHAutomationReporting"+AppName+"\\Completed\\Export"+AppName+ fileName+".xls";
		FilePAth = pathTillProject;
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet("new sheet");
		rowHead = sheet.createRow((short) 0);
		rowHead.createCell((short) 0).setCellValue("AppName"); // Header Name
		rowHead.createCell((short) 1).setCellValue("TestCase"); // Header Name	
		rowHead.createCell((short) 2).setCellValue("Date"); // Header Name		
		rowHead.createCell((short) 3).setCellValue("StartTime"); // Header Name
		rowHead.createCell((short) 4).setCellValue("EndTime"); // Header Name
		rowHead.createCell((short) 5).setCellValue("Execution Time(sec)"); // Header Name
		rowHead.createCell((short) 6).setCellValue("Execution Result"); // Header Name
		rowHead.createCell((short) 7).setCellValue("ErrorMessage"); // Header Name
		rowHead.createCell((short) 8).setCellValue("Error Code"); // Header Name
		rowHead.createCell((short) 9).setCellValue("Info"); // Header Name
		//rowHead.createCell((short) 10).setCellValue("Test Time"); // Header Name
	}

	public static HSSFWorkbook getWorkbook() {
		return workbook;
	}
	public static void setWorkbook(HSSFWorkbook workbook) {
		ExcelSheetStore.workbook = workbook;
	}
	public static HSSFSheet getSheet() {
		return sheet;
	}
	public static void setSheet(HSSFSheet sheet) {
		ExcelSheetStore.sheet = sheet;
	}
	public static HSSFRow getRow() {
		return row;
	}
	public static void setRow(HSSFRow row) {
		ExcelSheetStore.row = row;
	}
	public static HSSFRow getRowHead() {
		return rowHead;
	}
	public static void setRowHead(HSSFRow rowHead) {
		ExcelSheetStore.rowHead = rowHead;
	}
	public static int getRowCount() {
		return rowCount;
	}
	public static void setRowCount(int rowCount) {
		ExcelSheetStore.rowCount = rowCount;
	}
	public static LocalTime getStart() {
		return start;
	}
	public static void setStart(LocalTime start) {
		ExcelSheetStore.start = start;
		
	}
	public static LocalTime getEnd() {
		return end;
	}
	public static void setEnd(LocalTime end) {
		ExcelSheetStore.end = end;
	}
	public static void startTimer() {
		setStart(LocalTime.now());
		Date= StartTime.format(Calendar.getInstance().getTime());
		ExcelSheetStore.starttime = System.currentTimeMillis(); 
	}
	public static void stopTimer() {
		setEnd(LocalTime.now());
		ExcelSheetStore.endtime = System.currentTimeMillis();
	}
	
	
	
	@SuppressWarnings("deprecation")
	public static void enterFailureData(String testCase) {
		row = sheet.createRow((short) getRowCount());
		row.createCell((short) 0).setCellValue(appName); // writing the data to excel sheet
		row.createCell((short) 1).setCellValue(testCase);
		row.createCell((short) 2).setCellValue(Date);
		row.createCell((short) 3).setCellValue(getStart().toString());
		row.createCell((short) 4).setCellValue(getEnd().toString());
		row.createCell((short) 5).setCellValue(ExecutionTimeNew());
		row.createCell((short) 6).setCellValue("Failed");
		row.createCell((short) 7).setCellValue("");
		row.createCell((short) 8).setCellValue("");
		row.createCell((short) 9).setCellValue("");
		//row.createCell((short) 10).setCellValue(ExecutionTimeNew());
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(pathTillProject);
			workbook.write(fileOut);
			fileOut.close();
			setRowCount(getRowCount()+1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("deprecation")
	public static void enterSuccessData(String testCase) {
		row = sheet.createRow((short) getRowCount());
		row.createCell((short) 0).setCellValue(appName); // writing the data to excel sheet
		row.createCell((short) 1).setCellValue(testCase);
		row.createCell((short) 2).setCellValue(Date);
		row.createCell((short) 3).setCellValue(getStart().toString());
		row.createCell((short) 4).setCellValue(getEnd().toString());
		row.createCell((short) 5).setCellValue(ExecutionTimeNew());
		row.createCell((short) 6).setCellValue("Passed");
		row.createCell((short) 7).setCellValue("");
		row.createCell((short) 8).setCellValue("");
		row.createCell((short) 9).setCellValue("");
		//row.createCell((short) 10).setCellValue(ExecutionTimeNew());
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(pathTillProject);
			workbook.write(fileOut);
			fileOut.close();
			setRowCount(getRowCount()+1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public  static int ExecutionTimeNew()
	{
		try
		{
		
		float difference = endtime - starttime;
		System.out.println(difference/1000);
		return (int)difference/1000;
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return 0;
	

}
}
