package app.project.sinsin.project.model;

/**
 * Created by SINSIN on 5/13/2017.
 */

public class BaiViet {
    private int maBaiViet;
    private String tieuDe;
    private String noiDung;

    public BaiViet(int maBaiViet, String tieuDe, String noiDung) {
        this.maBaiViet = maBaiViet;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
    }

    public int getMaBaiViet() {
        return maBaiViet;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setMaBaiViet(int maBaiViet) {
        this.maBaiViet = maBaiViet;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
