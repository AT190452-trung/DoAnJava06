package com.actvn.java06.deantotngiep;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

//kho
public class DanhSachSanPham {

    private ArrayList<SanPham> danhSach;

    public DanhSachSanPham() {
        this.danhSach = new ArrayList<SanPham>();
    }

    public DanhSachSanPham(ArrayList<SanPham> danhSach) {
        this.danhSach = danhSach;
    }

    //nhập vào kho
    public void themSP(SanPham sp) {
        this.danhSach.add(sp);
    }

    //Thông tin sản phầm từ khoa
    public void inSP() {
        for (SanPham sanPham : danhSach) {
            System.out.println(sanPham);
        }
    }

    public int soluong() {
        return this.danhSach.size();
    }

    public boolean ktTonTai(SanPham sp) {
        return this.danhSach.contains(sp);
    }

    public boolean XoaSPcu(SanPham sp) {
        return this.danhSach.remove(sp);
    }

    public int kiemTraNSX(LocalDate d1) {
        LocalDate d2 = LocalDate.of(2023, 1, 1);
        if (d1.isAfter(d2)) {
            return 1;
        }
        return 0;
    }

    public SanPham timSanPhamTheoMa(String maSP) {
        for (SanPham sp : danhSach) {
            if (sp.getMaSP().equals(maSP)) {
                return sp;
            }
        }
        return null;
    }

    public void locSPCoCungNSX(String NSX) {
        for (SanPham sanPham : danhSach) {
            if (sanPham.getNhaSX().equals(NSX)) {
                System.out.println(sanPham.getTen());
            }
        }
    }

    public void locNhungSPHetHan(LocalDate d1) {
        for (SanPham sanPham : danhSach) {
            if (sanPham.getHSD().isAfter(d1)) {
                System.out.println(sanPham.getTen());
            }

        }
    }

    public void SapXeptop10SPNhieuNhat() {
        Collections.sort(danhSach, new top10SpNhieuNhat());
    }

    public void SapXeptop10SPItNhat() {
        Collections.sort(danhSach, new top10SPItNhat());
    }

    public void SapXepTenSP() {
        Collections.sort(danhSach);
    }
    public void SapXep10SPcoHSD()
    {
      Collections.sort(danhSach, new Top10SPHSDGanNgayHienTai());
    }
   
    public void intTop10()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println(danhSach.get(i));
        }
    }

}
