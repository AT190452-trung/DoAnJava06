package com.actvn.java06.deantotngiep;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSanPham dssp = new DanhSachSanPham();
        BanHang banHang = new BanHang();
        int luachon = 0;
        do {
            System.out.println("1 . them");
            System.out.println("2 . in thong tin");
            System.out.println("3. in ra so luong");
            System.out.println("4. kiem tra ton tai SP");
            System.out.println("5. sua thong tin SP");
            System.out.println("6. in cac san pham cung nha san xuat");
            System.out.println("7. in 10 sp co so luong it nhat");
            System.out.println("8.in 10 sp co so luong nhieu nhat");
            System.out.println("9.  ban hang");
            System.out.println("10. in sp da ban");
            System.out.println("11. vut sp da het han");
            System.out.println("12 . in nhung san pham da het han");
            System.out.println("13. in nhung san pham co gan NSX");
            luachon = sc.nextInt();
            sc.nextLine();
            if (luachon == 1) {
                System.out.println("Nhap ma san pham: ");
                String maSP = sc.nextLine();
                System.out.println("Nhap ten san pham: ");
                String ten = sc.nextLine();
                System.out.println("Nhap nha san xuat: ");
                String nhaSX = sc.nextLine();
                System.out.println("Nhap ngay san xuat (yyyy-MM-dd): ");
                String NSX = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
                LocalDate NSX1 = LocalDate.parse(NSX, formatter);
                System.out.println("Nhap ngay het han (yyyy-MM-dd): ");
                String HSD = sc.nextLine();
                LocalDate HSD1 = LocalDate.parse(HSD, formatter);
                System.out.println("Nhap so luong: ");
                int soLuong = sc.nextInt();
                System.out.println("Nhap gia: ");
                double gia = sc.nextDouble();
                SanPham sp = new SanPham(maSP, ten, nhaSX, soLuong, gia, NSX1, HSD1);
                if (dssp.kiemTraNSX(NSX1) == 1) {
                    System.out.println("nhap hang thanh cong");
                    dssp.themSP(sp);
                } else {
                    System.out.println("ko the nhap hang");
                }
            } else if (luachon == 2) {

                dssp.inSP();
            } else if (luachon == 3) {
                System.out.println("so luong sp : " + dssp.soluong());
            } else if (luachon == 4) {
                String maSP = sc.nextLine();
                SanPham sp = new SanPham(maSP);
                System.out.println("kiem tra : " + dssp.ktTonTai(sp));
            } else if (luachon == 5) {
                System.out.println("Nhap ma san pham can sua thong tin: ");
                String maSP = sc.nextLine();
                SanPham sp = dssp.timSanPhamTheoMa(maSP);
                if (sp != null) {
                    dssp.XoaSPcu(sp);
                    System.out.println("Nhap ten san phm moi: ");
                    String ten = sc.nextLine();
                    System.out.println("Nhap nha san xuat moi: ");
                    String nhaSX = sc.nextLine();
                    System.out.println("Nhap ngay san xuat moi: ");
                    String NSX2 = sc.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
                    LocalDate NSX = LocalDate.parse(NSX2, formatter);
                    System.out.println("Nhap ngay het han moi: ");
                    String HSD2 = sc.nextLine();
                    LocalDate HSD = LocalDate.parse(HSD2, formatter);
                    System.out.println("Nhap so luong moi: ");
                    int soLuong = sc.nextInt();
                    System.out.println("Nhap gia moi: ");
                    double gia = sc.nextDouble();
                    SanPham spMoi = new SanPham(maSP, ten, nhaSX, soLuong, gia, NSX, HSD);
                    dssp.themSP(spMoi);
                } else {
                    System.out.println("ko tim thay san pham");
                }
            } else if (luachon == 6) {
                System.out.println("nhap ten nha san xuat ");
                String nhaSX = sc.nextLine();
                dssp.locSPCoCungNSX(nhaSX);
            } else if (luachon == 7) {
                dssp.SapXeptop10SPItNhat();
                dssp.inSP();
                dssp.SapXepTenSP();
                dssp.inSP();
                dssp.intTop10();
            } else if(luachon==8)
            {
                dssp.SapXeptop10SPNhieuNhat();
                dssp.inSP();
                System.out.println(" ");
                dssp.SapXepTenSP();
                dssp.inSP();
                dssp.intTop10();
            }
            else if (luachon == 9) {
                banHang.banSanPham(dssp);
            } else if (luachon == 10) {
                banHang.inSanPhamDaBan();
            } else if (luachon == 11) {
                System.out.println("Nhap ma san pham can kiem tra ");
                String maSP = sc.nextLine();
                SanPham sp = dssp.timSanPhamTheoMa(maSP);
                if (sp != null) {
                    if(banHang.kiemTraHanSuDung(sp)==true)
                    {
                        dssp.XoaSPcu(sp);
                        System.out.println("xoa san pham thanh cong");
                    }else
                    {
                        System.out.println("san pham chua het han");
                    }
                }
            }else if(luachon==12)
            {
                LocalDate d3 = LocalDate.of(2024, 10, 10);
                dssp.locNhungSPHetHan(d3);    
            }else if(luachon==13)
            {
                dssp.SapXep10SPcoHSD();
                dssp.inSP();
                dssp.intTop10();
            }

        } while (luachon != 0);
    }

}
