package com.cg.iter.dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RETAILER_INVENTORY")
public class RetailerInventoryDTO {
	// attributes
	@Column(name = "RETAILER_ID", unique = false, nullable = false)
	private String retailerId;

	@Column(name = "PRODUCT_CATEGORY", unique = false, nullable = false)
	private byte productCategory;

	@Column(name = "PRODUCT_ID", unique = false, nullable = false)
	private String productId;
	
	@Id
	@Column(name = "PRODUCT_UIN", unique = true, nullable = false)
	private String productUniqueId;

	@Column(name = "PRODUCT_DISPATCH_TIMESTAMP", unique = false, nullable = false)
	private Calendar productDispatchTimestamp;

	@Column(name = "PRODUCT_RECEIVE_TIMESTAMP", unique = false, nullable = true)
	private Calendar productReceiveTimestamp;

	@Column(name = "PRODUCT_SALE_TIMESTAMP", unique = false, nullable = true)
	private Calendar productSaleTimestamp;

	// getters
	public String getRetailerId() {
		return this.retailerId;
	}

	public byte getProductCategory() {
		return this.productCategory;
	}

	public String getProductId() {
		return this.productId;
	}
	
	public String getProductUniqueId() {
		return this.productUniqueId;
	}

	public Calendar getProductDispatchTimestamp() {
		return this.productDispatchTimestamp;
	}

	public Calendar getProductReceiveTimestamp() {
		return this.productReceiveTimestamp;
	}

	public Calendar getProductSaleTimestamp() {
		return this.productSaleTimestamp;
	}

	// setters
	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}

	public void setProductCategory(byte productCategory) {
		this.productCategory = productCategory;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public void setProductUniqueId(String productUniqueId) {
		this.productUniqueId = productUniqueId;
	}

	public void setProductDispatchTimestamp(Calendar productOrderTimestamp) {
		this.productDispatchTimestamp = productOrderTimestamp;
	}

	public void setProductReceiveTimestamp(Calendar productDeliveryTimestamp) {
		this.productReceiveTimestamp = productDeliveryTimestamp;
	}

	public void setProductSaleTimestamp(Calendar productSaleTimestamp) {
		this.productSaleTimestamp = productSaleTimestamp;
	}

	// constructors
	public RetailerInventoryDTO() {

	}

	public RetailerInventoryDTO(String retailerId, byte productCategory, String productId, String productUniqueId,
			Calendar productOrderTimestamp, Calendar productDeliveryTimestamp, Calendar productSaleTimestamp) {
		this.retailerId = retailerId;
		this.productCategory = productCategory;
		this.productId = productId;
		this.productUniqueId = productUniqueId;
		this.productDispatchTimestamp = productOrderTimestamp;
		this.productReceiveTimestamp = productDeliveryTimestamp;
		this.productSaleTimestamp = productSaleTimestamp;
	}

	// other helper methods
	public static String calendarToString(Calendar instance) {
		int year = instance.get(Calendar.YEAR);
		int month = instance.get(Calendar.MONTH);
		int day = instance.get(Calendar.DAY_OF_MONTH);

		int hour = instance.get(Calendar.HOUR);
		int minute = instance.get(Calendar.MINUTE);
		int second = instance.get(Calendar.SECOND);

		// String result = "{" + day + "/" + month + "/" + year + "}";
		// String result = "{" + day + "/" + month + "/" + year + "::" + hour + ":" +
		// minute + ":" + second + ":" + milliSecond + "}";
		String result = "{Date: " + day + "/" + month + "/" + year + ", Time:" + hour + ":" + minute + ":" + second
				+ "}";
		return result;
	}

	@Override
	public String toString() {
		String temp = "";
		if (this.productReceiveTimestamp != null) {
			temp += ", productDeliveryTimestamp: " + calendarToString(this.productReceiveTimestamp);
		}
		if (this.productSaleTimestamp != null) {
			temp += ", productSaleTimestamp: " + calendarToString(this.productSaleTimestamp);
		}
		String result = "[retailerId: " + this.retailerId + ", productCategory: " + this.productCategory + ", productId: " + this.productId
				+ ", productUniqueId: " + this.productUniqueId + ", productOrderTimestamp: "
				+ calendarToString(this.productDispatchTimestamp) + temp + "]";
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productCategory;
		result = prime * result + ((productDispatchTimestamp == null) ? 0 : productDispatchTimestamp.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productReceiveTimestamp == null) ? 0 : productReceiveTimestamp.hashCode());
		result = prime * result + ((productSaleTimestamp == null) ? 0 : productSaleTimestamp.hashCode());
		result = prime * result + ((productUniqueId == null) ? 0 : productUniqueId.hashCode());
		result = prime * result + ((retailerId == null) ? 0 : retailerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RetailerInventoryDTO other = (RetailerInventoryDTO) obj;
		if (productCategory != other.productCategory)
			return false;
		if (productDispatchTimestamp == null) {
			if (other.productDispatchTimestamp != null)
				return false;
		} else if (!productDispatchTimestamp.equals(other.productDispatchTimestamp))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productReceiveTimestamp == null) {
			if (other.productReceiveTimestamp != null)
				return false;
		} else if (!productReceiveTimestamp.equals(other.productReceiveTimestamp))
			return false;
		if (productSaleTimestamp == null) {
			if (other.productSaleTimestamp != null)
				return false;
		} else if (!productSaleTimestamp.equals(other.productSaleTimestamp))
			return false;
		if (productUniqueId == null) {
			if (other.productUniqueId != null)
				return false;
		} else if (!productUniqueId.equals(other.productUniqueId))
			return false;
		if (retailerId == null) {
			if (other.retailerId != null)
				return false;
		} else if (!retailerId.equals(other.retailerId))
			return false;
		return true;
	}
}
