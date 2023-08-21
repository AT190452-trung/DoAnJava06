/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.actvn.java06.deantotngiep;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDate;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DocAndGhiFile {
    
    private static final String curentDir = System.getProperty("user.dir");
    private static final String separator = File.separator;
    private static final String PATH_FILE_CSV = curentDir + separator + "data" + separator + "input.csv";
    private static final String PATH_FILE_CSV_1 = curentDir + separator + "data" + separator + "dssp.csv";
   
    
     public static void main(String[] args) throws FileNotFoundException {
        
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
          FileReader fr = null;
         List<SanPham> list = new ArrayList<>();
        BufferedReader bf =  new BufferedReader(new FileReader(PATH_FILE_CSV));
		String line;
		//đọc file
		try {
			while((line = bf.readLine()) != null){
				String[] str = line.split(",");
                 LocalDate NSX = LocalDate.parse(str[5], formatter);
                LocalDate HSD =  LocalDate.parse(str[6], formatter);
                
                SanPham sp = new SanPham(str[0], str[1], str[2], Integer.parseInt(str[3]), Double.parseDouble(str[4]), NSX, HSD);
                list.add(sp);
                        }
           bf.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			                 System.out.println("e.printStackTrace()");
		}
		
		list.stream().forEach(SanPham -> System.out.println(SanPham.toString()));
       BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(PATH_FILE_CSV_1 ));
			for (SanPham sanpham : list) {
				bw.append(sanpham.writeCSV());
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    }
   
    
    
     

