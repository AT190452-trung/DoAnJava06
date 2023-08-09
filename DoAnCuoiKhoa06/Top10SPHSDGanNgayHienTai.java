/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.actvn.java06.deantotngiep;

import java.util.Comparator;
import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class Top10SPHSDGanNgayHienTai implements Comparator<SanPham>{
    
     public int compare(SanPham o1, SanPham o2) {
          return o1.getNSX().compareTo(o2.getNSX());
    }
    
}

    