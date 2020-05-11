package com.cg.iter.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "SalesRepDTO")
@Table(name = "SALES_REP", uniqueConstraints = { @UniqueConstraint(columnNames = "USER_ID") })
public class SalesRepDTO implements Serializable {

	private static final long serialVersionUID = 2356552048985844788L;
	// attributes
	@Id
	@Column(name = "USER_ID", unique = false, nullable = true)
	private String userId;
	@Column(name = "BONUS", unique = false, nullable = false)
	private Double bonus;
	@Column(name = "TARGET_SALES", unique = false, nullable = false)
	private Double target;
	@Column(name = "TARGET_STATUS", unique = false, nullable = false)
	private int targetStatus;
	@Column(name = "CART_ID", unique = false, nullable = false)
	private String cartId;
	@Column(name = "CURRENT_SALES", unique = false, nullable = false)
	private Double currentSales;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public Double getTarget() {
		return target;
	}

	public void setTarget(Double target) {
		this.target = target;
	}

	public int getTargetStatus() {
		return targetStatus;
	}

	public void setTargetStatus(int targetStatus) {
		this.targetStatus = targetStatus;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Double getCurrentSales() {
		return currentSales;
	}

	public void setCurrentSales(Double currentSales) {
		this.currentSales = currentSales;
	}

	public SalesRepDTO() {
		super();
	}

	public SalesRepDTO(String userId, Double bonus, Double target, int targetStatus, String cartId,
			Double currentSales) {
		super();
		this.userId = userId;
		this.bonus = bonus;
		this.target = target;
		this.targetStatus = targetStatus;
		this.cartId = cartId;
		this.currentSales = currentSales;
	}

	@Override
	public String toString() {
		return "SalesRepEntity [userId=" + userId + ", bonus=" + bonus + ", target=" + target + ", targetStatus="
				+ targetStatus + ", cartId=" + cartId + ", currentSales=" + currentSales + "]";
	}

}
