package app.project.sinsin.project.model;

/**
 * Created by SINSIN on 4/18/2017.
 */

public class BacSy {
    private int maBacSy;
    private String chuyenMon;
    private String diaChi;
    private String ten;
    private String soDienThoai, email;
    private byte[] hinhAnh;

    public int getMaBacSy() {
        return maBacSy;
    }

    public void setMaBacSy(int maBacSy) {
        this.maBacSy = maBacSy;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
//    public BacSy(String ten, String soDienThoai, String email, byte[] hinhAnh) {
//        this.ten = ten;
//        this.soDienThoai = soDienThoai;
//        this.email = email;
//        this.hinhAnh = hinhAnh;
//    }

    public BacSy() {
    }

    public String getTen() {
        return ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public String getEmail() {
        return email;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
