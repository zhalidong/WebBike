package cn.edu360.web.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bikes")
public class Bike {


    private String id;

    private int status;

    //纬度
    private Double latitude;

    //经度
    private Double  longitude;

    //二维码
    private String qrCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
