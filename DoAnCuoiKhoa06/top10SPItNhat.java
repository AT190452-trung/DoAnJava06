/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.actvn.java06.deantotngiep;

import java.util.Comparator;

/**
 *
 * @author HP
 */
public class top10SPItNhat implements Comparator<SanPham>{

    @Override
    public int compare(SanPham o1, SanPham o2) {
          return (o1.getSoLuong() - o2.getSoLuong());
    }

   
    
}
