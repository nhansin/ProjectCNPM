package app.project.sinsin.project.model;

import java.util.HashMap;

/**
 * Created by SINSIN on 5/13/2017.
 */

public class BaiViet {
    private int maBaiViet;
    private String hinhAnh;
    private byte[] anhDaiDien;
    private String tieuDe;
    private HashMap<String, String> listNoiDung;
    private String noiDung;

    public BaiViet() {
    }

    public BaiViet(int maBaiViet,String hinhAnh, byte[] anhDaiDien,String tieuDe, HashMap<String, String> listNoiDung) {
        this.maBaiViet=maBaiViet;
        this.hinhAnh = hinhAnh;
        this.tieuDe = tieuDe;
        this.anhDaiDien=anhDaiDien;
        this.listNoiDung = listNoiDung;
    }
public BaiViet(int maBaiViet,String hinhAnh, String noiDung){
this.maBaiViet=maBaiViet;
    this.hinhAnh=hinhAnh;
    this.noiDung=noiDung;
}
    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public HashMap<String, String> getListNoiDung() {
        return listNoiDung;
    }

    public void setListNoiDung(HashMap<String, String> listNoiDung) {
        this.listNoiDung = listNoiDung;
    }

    public int getMaBaiViet() {
        return maBaiViet;
    }

    public void setMaBaiViet(int maBaiViet) {
        this.maBaiViet = maBaiViet;
    }

    public byte[] getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(byte[] anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    @Override
    public String toString() {
        return "BaiViet_{" +
                "hinhAnh='" + hinhAnh + '\'' +
                ", tieuDe='" + tieuDe + '\'' +
                ", listNoiDung=" + listNoiDung +
                '}';
    }
}
