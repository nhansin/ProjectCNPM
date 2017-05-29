package app.project.sinsin.project.model;

        import java.util.Date;

/**
 * Created by SINSIN on 5/15/2017.
 */

public class NhatKy {
    private int maNhatKy;
    private String tieuDe;
    private String noiDung;
    private Date ngay;
    private String hinhAnh;

    public NhatKy(int maNhatKy, String tieuDe, String noiDung, Date ngay, String hinhAnh) {
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

    public Date getNgay() {
        return ngay;
    }

    public String getHinhAnh() {
        return hinhAnh;
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

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
