
package com.actvn.java06.deantotngiep;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
class BanHang {

    private ArrayList<SanPham> danhSachSanPhamDaBan;

    public BanHang() {
        danhSachSanPhamDaBan = new ArrayList<>();
    }

    public void banSanPham(DanhSachSanPham danhSachSanPham) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma san pham can ban: ");
        String maSanpham = sc.nextLine();

        SanPham spCanBan = danhSachSanPham.timSanPhamTheoMa(maSanpham);

        if (spCanBan != null) {
            System.out.println("Nhap so luong san pham ban muon ban: ");
            int soLuongBan = sc.nextInt();

            if (soLuongBan <= spCanBan.getSoLuong()) {
                spCanBan.setSoLuong(spCanBan.getSoLuong() - soLuongBan);

                SanPham spDaBan = new SanPham(spCanBan.getMaSP(),
                        spCanBan.getTen(),
                        spCanBan.getNhaSX(),
                        soLuongBan,
                        spCanBan.getGia(),
                        spCanBan.getNSX(),
                        spCanBan.getHSD());

                danhSachSanPhamDaBan.add(spDaBan);

                System.out.println("Ban hang thanh cong!");
            } else {
                System.out.println("Khong du hang de ban!");
            }
        } else {
            System.out.println("Khong tim thay san pham trong kho!");
        }
    }

    public void inSanPhamDaBan() {
        System.out.println("Danh sach san pham da ban:");
        for (SanPham sp : danhSachSanPhamDaBan) {
            System.out.println(sp);
        }
    }

    public boolean kiemTraHanSuDung(SanPham sp) {
        LocalDate ngayHienTai = LocalDate.now();
        return ngayHienTai.isBefore(sp.getHSD());
    }
}

