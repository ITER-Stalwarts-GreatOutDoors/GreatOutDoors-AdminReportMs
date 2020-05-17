package com.cg.iter.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "View_SaleReport")
public class ViewSalesReportByUserDTO {
	@Id
	private String userId;
	private String date;
	private String orderId;
	private String productId;
	private int productCategory;
	private Double productPrice;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public ViewSalesReportByUserDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	public ViewSalesReportByUserDTO(String userId, String date, String orderId, String productId, int productCategory,
			Double productPrice) {
		super();
		this.userId = userId;
		this.date = date;
		this.orderId = orderId;
		this.productId = productId;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
	}

	public void printData() {
		System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s %n", userId, date, orderId, productId, productCategory,
				productPrice);
	}

}

