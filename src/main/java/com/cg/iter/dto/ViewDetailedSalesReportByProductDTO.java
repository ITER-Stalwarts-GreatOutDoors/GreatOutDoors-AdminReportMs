package com.cg.iter.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "View_SaleProductReport")
public class ViewDetailedSalesReportByProductDTO {
	@Id
	private int period;
	private Double revenue;
	private Double amountChange;
	private Double percentageGrowth;
	private String code;
	private String type;

	public ViewDetailedSalesReportByProductDTO(int period, Double revenue, Double amountChange, Double percentageGrowth,
			String code, String type) {
		super();
		this.period = period;
		this.revenue = revenue;
		this.amountChange = amountChange;
		this.percentageGrowth = percentageGrowth;
		this.code = code;
		this.type = type;
	}

	public ViewDetailedSalesReportByProductDTO() {

	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public Double getRevenue() {
		return revenue;
	}

	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}

	public Double getAmountChange() {
		return amountChange;
	}

	public void setAmountChange(Double amountChange) {
		this.amountChange = amountChange;
	}

	public Double getPercentageGrowth() {
		return percentageGrowth;
	}

	public void setPercentageGrowth(Double percentageGrowth) {
		this.percentageGrowth = percentageGrowth;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void printData() {

		System.out.printf("%-25s %-25.2f %-25.2f %-25.2f %-25s %-25s %n", period, revenue, amountChange,
				percentageGrowth, code, type);

	}
}
