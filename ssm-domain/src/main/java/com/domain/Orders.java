package com.domain;

import com.Utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: wudaren
 * @create: 2020-07-27 15:59
 **/

public class Orders {
    private int id;
    private String orderNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-MM")
    private Date orderTime;
    private int peopleCount;
    private String orderDesc;
    private int payType;
    private int orderStatus;
    private int productId;
    private int memberId;
    private Product product;
    private String payTypeStr;
    private String orderTimeStr;
    private String orderStatusStr;
private List<traveller> travellers;
private Member member;


    public String getPayTypeStr() {
        //支付方式(0 支付宝 1 微信 2其它)
        if(payType==0){
            payTypeStr="支付宝";
        }else if(payType==1){
            payTypeStr="微信";
        }else if(payType==2){
            payTypeStr="其它";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public List<traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getOrderStatusStr() {
        //订单状态(0 未支付 1 已支付)
        if(orderStatus==0){
            orderStatusStr="未支付";
        }else if(orderStatus==1){
            orderStatusStr="已支付";
        }
        return orderStatusStr;
    }
    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }


    public String getOrderTimeStr() {
        if(orderTime!=null){
            orderTimeStr= DateUtils.date2String(orderTime,"yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }


    public void setOrderTimeStr() {
        this.orderTimeStr = orderTime.toString();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "orders{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", peopleCount=" + peopleCount +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType=" + payType +
                ", orderStatus=" + orderStatus +
                ", productId=" + productId +
                ", memberId=" + memberId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
