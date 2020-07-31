package com.domain;

import com.Utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: SSM
 * @description: product实体类
 * @author: wudaren
 * @create: 2020-07-25 18:30
 **/

public class Product {
    private String id;//主键
    private String productNum;//唯一编号
    private String productName;//名称
    private String cityName;//出发城市
    @DateTimeFormat(pattern = "yy-MM-dd HH:mm")
    private Date departureTime;//出发时间
    private double productPrice;//价格
    private String productDesc;//描述
    private Integer productStatus;//状态 0开启 1关闭
    private String departureTimeStr;
    private String productStatusStr;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }
    public String getDepartureTimeStr() {
        if(departureTime!=null){
            departureTimeStr= DateUtils.date2String(departureTime,"yyyy-MM-dd HH:mm:ss");
        }
        return departureTimeStr;
    }
    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }


    public String getProductStatusStr() {
        if (productStatus != null) {
            // 状态 0 关闭 1 开启
            if(productStatus==0)
                productStatusStr="关闭";
            if(productStatus==1)
                productStatusStr="开启";
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
