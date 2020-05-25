package com.cg.iter.controller;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
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

	

	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping(value = "/RevenueReports", method = RequestMethod.POST)
	public List<ViewSalesReportByUserDTO> getRevenueReports(@RequestParam String userId,@RequestParam int categoryType,
			@RequestParam String date1,@RequestParam String date2) {
		List<ViewSalesReportByUserDTO> list = new ArrayList<ViewSalesReportByUserDTO>();
		
		try {
			
			Date dentry = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
			Date dexit = new SimpleDateFormat("yyyy-MM-dd").parse(date2);

			goAdminReportsService.viewSalesReportByUserAndCategory(dentry, dexit,
				userId, categoryType);
//			list = new ArrayList<ViewSalesReportByUserDTO>();
			
			  for (ViewSalesReportByUserDTO bean : list) { 
//				  list = new ArrayList<ViewSalesReportByUserDTO>();
			
			   bean.getUserId(); 
			   bean.getDate().toString(); 
			   bean.getOrderId(); 
			   bean.getProductId();
			   Integer.toString(bean.getProductCategory());
			   Double.toString(bean.getProductPrice());
			   list.add(bean);
			   } 
			 
		} catch (Exception e) {
		
		}

		return list;
	}
	@ResponseBody

	@RequestMapping(value = "/GrowthReports", method = RequestMethod.POST)

	public List<ViewDetailedSalesReportByProductDTO> getGrowthReports(@RequestParam int categoryType, @RequestParam String date1, @RequestParam String date2) throws GoAdminException {

	
		List<ViewDetailedSalesReportByProductDTO> list =  new ArrayList<ViewDetailedSalesReportByProductDTO>();
		try {

			Date dentry = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
			Date dexit = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
           
//			list = new ArrayList<ViewDetailedSalesReportByProductDTO>();
			goAdminReportsService.viewDetailedSalesReportByProduct(dentry, dexit, categoryType, categoryType);
			for (ViewDetailedSalesReportByProductDTO bean : list) {
//        		list = new ArrayList<ViewDetailedSalesReportByProductDTO>();
				if (categoryType == 1) {
					 Month.of(bean.getPeriod() + 1).name();
				} else if (categoryType == 2) {
					 Integer.toString((bean.getPeriod()) + 1);
				} else {
					 Integer.toString(bean.getPeriod());
				}
				 Double.toString(bean.getRevenue());
				 Double.toString(bean.getAmountChange());
				 Double.toString(bean.getPercentageGrowth());
				 bean.getCode();
				list.add(bean);
			}
		} catch (Exception e) {
			
		}

		return list;
	}
}


