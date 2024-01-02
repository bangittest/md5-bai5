package com.ra.model.dto.orders;
import java.util.Date;

public class OrderDTO {
    private Long id;
    private Float totalPrice;
    private String address;
    private String phone;
    private String note;
    private Date createdDate;
    private Long userId;
    private Integer status;

    public OrderDTO() {
    }

    public OrderDTO(Long id, Float totalPrice, String address, String phone, String note, Date createdDate, Long userId, Integer status) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.createdDate = createdDate;
        this.userId = userId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
