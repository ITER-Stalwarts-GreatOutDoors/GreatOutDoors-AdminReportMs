package com.cg.iter.service;

import java.net.ConnectException;
import java.util.Date;
import java.util.List;

import com.cg.iter.dto.ViewSalesReportByUserDTO;
import com.cg.iter.dto.ViewDetailedSalesReportByProductDTO;
import com.cg.iter.exception.GoAdminException;

public interface GoAdminReportsService {

		List<ViewSalesReportByUserDTO> viewSalesReportByUserAndCategory(Date entry, Date exit, String TargetuserId,
				int category) throws GoAdminException,ConnectException;


		List<ViewDetailedSalesReportByProductDTO> viewDetailedSalesReportByProduct(Date entry, Date exit, int cat,int category)
				 throws GoAdminException,ConnectException;

	
	

}
