package app.project.sinsin.project.dao;

import java.util.ArrayList;

import app.project.sinsin.project.model.BaiViet;

/**
 * Created by nhan-dev on 6/4/2017.
 */

public class BaiVietDAO {
    public ArrayList<BaiViet> listBaiViet;

    public BaiVietDAO() {
        listBaiViet = new ArrayList<>();
        createDatabase();
    }

    public void createDatabase() {
        listBaiViet.add(new BaiViet(1, "Bai Viet 01", "<!doctype html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<title>CKEditor - Classic Version</title>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t<h3 style=\"color:red;\">\n" +
                "\t\t\t<img alt=\"mang-thai-tuan-thu-8\" class=\"aligncenter size-full wp-image-3658\" height=\"348\" src=\"file:///android_res/drawable/tuan20.jpg\" style=\"box-sizing: border-box; border: 0px; max-width: 100%; height: auto; text-align: center; clear: both; display: block; margin: 6px auto 21px; color: rgb(34, 34, 34); font-family: Verdana, Geneva, sans-serif; font-size: 15px; background-color: rgb(255, 255, 255);\" width=\"374\" /></h3>\n" +
                "\t\t<h3 style=\"color:red;\">\n" +
                "\t\t\t<span style=\"font-size:12px;\"><span style=\"font-family:arial,helvetica,sans-serif;\">Title 1</span></span></h3>\n" +
                "\t\t<p>\n" +
                "\t\t\t<span style=\"font-size:12px;\"><span style=\"font-family:arial,helvetica,sans-serif;\">Bước sang tuần mang thứ 8 n&agrave;y, em b&eacute; c&oacute; những ph&aacute;t triển mạnh mẽ. Những ng&oacute;n tay, ng&oacute;n ch&acirc;n nhỏ x&iacute;u của b&eacute; bắt đầu ph&acirc;n h&oacute;a r&otilde; r&agrave;ng. Thật l&agrave; một điều hạnh ph&uacute;c phải kh&ocirc;ng n&agrave;o! Những ng&oacute;n tay v&agrave; ng&oacute;n ch&acirc;n bắt đầu h&igrave;nh th&agrave;nh trong tuần n&agrave;y. C&aacute;nh tay c&oacute; những khoảng cong ở khuỷu tay v&agrave; cổ tay. Bắt của b&eacute; ng&agrave;y c&agrave;ng r&otilde; r&agrave;ng hơn, những sắc tố trong mắt bắt đầu h&igrave;nh th&agrave;nh trong v&otilde;ng mạc.</span></span></p>\n" +
                "\t\t<h3 style=\"color:red;\">\n" +
                "\t\t\t<span style=\"font-size:12px;\"><span style=\"font-family:arial,helvetica,sans-serif;\">Title 2</span></span></h3>\n" +
                "\t\t<p>\n" +
                "\t\t\t<span style=\"font-size: 12px;\"><span style=\"font-family: arial, helvetica, sans-serif;\">Bước sang tuần mang thứ 8 n&agrave;y, em b&eacute; c&oacute; những ph&aacute;t triển mạnh mẽ. Những ng&oacute;n tay, ng&oacute;n ch&acirc;n nhỏ x&iacute;u của b&eacute; bắt đầu ph&acirc;n h&oacute;a r&otilde; r&agrave;ng. Thật l&agrave; một điều hạnh ph&uacute;c phải kh&ocirc;ng n&agrave;o! Những ng&oacute;n tay v&agrave; ng&oacute;n ch&acirc;n bắt đầu h&igrave;nh th&agrave;nh trong tuần n&agrave;y. C&aacute;nh tay c&oacute; những khoảng cong ở khuỷu tay v&agrave; cổ tay. Bắt của b&eacute; ng&agrave;y c&agrave;ng r&otilde; r&agrave;ng hơn, những sắc tố trong mắt bắt đầu h&igrave;nh th&agrave;nh trong v&otilde;ng mạc.</span></span></p>\n" +
                "\t\t<p>\n" +
                "\t\t\t&nbsp;</p></body>\n" +
                "</html>\n"));


    }
}
