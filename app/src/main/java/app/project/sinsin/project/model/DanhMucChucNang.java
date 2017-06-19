package app.project.sinsin.project.model;

/**
 * Created by thuthuy on 6/17/2017.
 */

public class DanhMucChucNang {

    private int maDanhMuc;
    private String tenDanhMuc;
    private byte[] hinhAnh;

    public DanhMucChucNang(){

    }


    public DanhMucChucNang(int maDanhMuc, String tenDanhMuc, byte[] hinhAnh) {
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.hinhAnh = hinhAnh;
    }

    public int getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
