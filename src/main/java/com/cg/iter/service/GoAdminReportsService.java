package com.cg.iter.service;

import java.net.ConnectException;
import java.util.Date;
import java.util.List;

import com.cg.iter.dto.ViewSalesReportByUserDTO;
import com.cg.iter.dto.ViewDetailedSalesReportByProductDTO;
import com.cg.iter.exception.GoAdminException;

public interface GoAdminReportsService {

		List<ViewDetailedSalesReportByProductDTO> viewDetailedSalesReportByProduct(Date dentry, Date dexit,int cat,
				int categoryType) throws GoAdminException, ConnectException;

		List<ViewSalesReportByUserDTO> viewSalesReportByUserAndCategory(Date dentry, Date dexit, String userId,
				int categoryType) throws GoAdminException, ConnectException;

	
	

}
