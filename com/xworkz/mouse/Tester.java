package com.xworkz.mouse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xworkz.mouse.dao.MouseDAO;
import com.xworkz.mouse.dao.MouseDAOImpl;
import com.xworkz.mouse.dto.MouseDTO;

public class Tester {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=null;
		XSSFWorkbook workbook=null;
		
		try{
		file= new FileInputStream(new File("E:\\Excel sheets for db\\mouse_excel.xlsx"));
		workbook = new XSSFWorkbook(file);
			
        XSSFSheet sheet =workbook.getSheetAt(0);
        Row row;
        for(int i=1;i<=sheet.getLastRowNum();i++) {
        	row = (Row) sheet.getRow(i);
        	
        	String MOUSE_ID;
			if(row.getCell(0)==null) { MOUSE_ID = "null"; }
			else  MOUSE_ID=row.getCell(0).toString();
        	
        	String BRAND;
        	if(row.getCell(1)==null) {BRAND ="null";}
        	else BRAND=row.getCell(1).toString();
        	
        	String WIRELESS;
        	if(row.getCell(2)==null) { WIRELESS="false";}
        	else WIRELESS=row.getCell(2).toString();
        	
        	String PRICE;
        	if(row.getCell(3)==null) { PRICE="0.00";}
        	else PRICE=row.getCell(3).toString();
        		
        	MouseDTO mouseDTO = new MouseDTO();
        	mouseDTO.setMouseID(Double.parseDouble(MOUSE_ID));
        	mouseDTO.setBrand(BRAND);
        	mouseDTO.setWireless(Boolean.parseBoolean(WIRELESS));
        	mouseDTO.setPrice(Double.parseDouble(PRICE));
        	
		    MouseDAO mouseDAOImpl = new MouseDAOImpl();
		    mouseDAOImpl.saveMouse(mouseDTO);
        }

        }catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        finally {
			
        	if((file!=null)&&(workbook!=null)) {
				try {
					file.close();
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("file and workbook is closed");
			}else {
				System.out.println("file and workbook not closed");
			}
		}
	}
	
}

//invoked saveMouse
//Hibernate: 
//    insert 
//    into
//        mouse_dto
//        (BRAND, PRICE, WIRELESS, MOUSE_ID) 
//    values
//        (?, ?, ?, ?)
//saved mouseDTO
//session is closed
//invoked saveMouse
//Hibernate: 
//    insert 
//    into
//        mouse_dto
//        (BRAND, PRICE, WIRELESS, MOUSE_ID) 
//    values
//        (?, ?, ?, ?)
//saved mouseDTO
//session is closed
//file and workbook is closed