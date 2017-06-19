package app.project.sinsin.project.model;

        /**
 * Created by SINSIN on 5/15/2017.
 */

public class NhatKy {
    private int maNhatKy;
    private String tieuDe;
    private String noiDung;
    private String ngay;
    private byte[] hinhAnh;

    public NhatKy(int maNhatKy, String tieuDe, String noiDung, String ngay, byte[] hinhAnh) {
        this.maNhatKy = maNhatKy;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngay = ngay;
        this.hinhAnh = hinhAnh;
    }

    public int getMaNhatKy() {
        return maNhatKy;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public String getNgay() {
        return ngay;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public void setMaNhatKy(int maNhatKy) {
        this.maNhatKy = maNhatKy;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

}
