package com.cg.iter.controller;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.dto.ViewDetailedSalesReportByProductDTO;
import com.cg.iter.dto.ViewSalesReportByUserDTO;
import com.cg.iter.exception.GoAdminException;
import com.cg.iter.service.GoAdminReportsService;


@RestController
@RequestMapping("/Reports")
public class GoAdminReportsController {

	@Autowired
	private GoAdminReportsService goAdminReportsService;

	public GoAdminReportsService getGoAdminReportsService() {
		return goAdminReportsService;
	}

	public void setGoAdminReportsService(GoAdminReportsService goAdminReportsService) {
		this.goAdminReportsService = goAdminReportsService;
	}

	@ResponseBody
	@RequestMapping(value = "/RevenueReports", method = RequestMethod.POST)
	public List<ViewSalesReportByUserDTO> getRevenueReports(@RequestParam String userId,@RequestParam int categoryType,
			@RequestParam String date1,@RequestParam String date2) {
		List<ViewSalesReportByUserDTO> list = null;
		
		try {
			
			Date dentry = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
			Date dexit = new SimpleDateFormat("yyyy-MM-dd").parse(date2);

			list = goAdminReportsService.viewSalesReportByUserAndCategory(dentry, dexit,
					userId, categoryType);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@ResponseBody

	@RequestMapping(value = "/GrowthReports", method = RequestMethod.POST)

	public List<ViewDetailedSalesReportByProductDTO> getGrowthReports(@RequestParam int categoryType, @RequestParam String date1, @RequestParam String date2) throws GoAdminException {

		

		
		List<ViewDetailedSalesReportByProductDTO> list = null;
		try {

			Date dentry = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
			Date dexit = new SimpleDateFormat("yyyy-MM-dd").parse(date2);

			//list = goAdminReportsService.viewDetailedSalesReportByProduct(dentry, dexit, categoryType);
			for (ViewDetailedSalesReportByProductDTO bean : list) {
				if (categoryType == 1) {
					//dataObj.addProperty("period", Month.of(bean.getPeriod() + 1).name());
				} else if (categoryType == 2) {
					//dataObj.addProperty("period", "Q" + Integer.toString((bean.getPeriod()) + 1));
				} else {
					//dataObj.addProperty("period", "YEAR:" + Integer.toString(bean.getPeriod()));
				}
//				dataObj.addProperty("revenue", Double.toString(bean.getRevenue()));
//				dataObj.addProperty("amountChange", Double.toString(bean.getAmountChange()));
//				dataObj.addProperty("percentageGrowth", Double.toString(bean.getPercentageGrowth()));
//				dataObj.addProperty("colorCode", bean.getCode());
//				dataList.add(dataObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
