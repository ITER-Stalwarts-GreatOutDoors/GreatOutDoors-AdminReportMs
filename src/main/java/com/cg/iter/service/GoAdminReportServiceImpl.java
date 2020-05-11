package com.cg.iter.service;

import java.net.ConnectException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.dto.ViewDetailedSalesReportByProductDTO;
import com.cg.iter.dto.ViewSalesReportByUserDTO;

import com.cg.iter.exception.ExceptionConstants;
import com.cg.iter.exception.GoAdminException;

@Service(value = "goAdminReportService")
public class GoAdminReportServiceImpl implements GoAdminReportsService {

	

	public List<ViewSalesReportByUserDTO> viewSalesReportByUserAndCategory(Date entry, Date exit, String TargetuserId,
			int category) throws GoAdminException, ConnectException {
		List<ViewSalesReportByUserDTO> viewSales = new ArrayList<ViewSalesReportByUserDTO>();

		try {
			ViewSalesReportByUserDTO temp;
		

			if (entry == null || exit == null) {
				
				throw new GoAdminException(ExceptionConstants.INVALID_DATE);
			}

			
			List<Object[]> results = session.createQuery(HQLQuerryMapper.SELECT_DATA_FROM_DATABASE).getResultList();
			String userId, date, orderId, productId;
			int productCategory;
			Double productPrice;

			for (Object[] data : results) {
				
				
				userId = data[0].toString();
				date = data[1].toString();
				orderId = data[2].toString();
				productId = data[3].toString();
				productCategory = Integer.parseInt(data[4].toString());
				productPrice = Double.parseDouble(data[5].toString());
				
				
				if (TargetuserId.equalsIgnoreCase(userId) && category == productCategory) {

					temp = new ViewSalesReportByUserDTO();
					temp.setUserId(userId);
					temp.setDate(date);
					temp.setOrderId(orderId);
					temp.setProductId(productId);
					temp.setProductPrice(productPrice);
					temp.setProductCategory(productCategory);
					viewSales.add(temp);
				} 
				
				else if (TargetuserId.equalsIgnoreCase("ALL") && category == productCategory) {
					temp = new ViewSalesReportByUserDTO();
					temp.setUserId(userId);
					temp.setDate(date);
					temp.setOrderId(orderId);
					temp.setProductId(productId);
					temp.setProductPrice(productPrice);
					temp.setProductCategory(productCategory);
					viewSales.add(temp);
				} 
				
				else if (TargetuserId.equalsIgnoreCase("ALL") && category == 6) {
					temp = new ViewSalesReportByUserDTO();
					temp.setUserId(userId);
					temp.setDate(date);
					temp.setOrderId(orderId);
					temp.setProductId(productId);
					temp.setProductPrice(productPrice);
					temp.setProductCategory(productCategory);
					viewSales.add(temp);

				}

			}

		} catch (HibernateException e) {

			System.out.println(e.getMessage());

		} catch (Exception exp) {
			
			throw new GoAdminException(ExceptionConstants.ERROR_IN_VIEWING + exp.getMessage()); 
			

		}
		return viewSales;
	}

	public List<ViewDetailedSalesReportByProductDTO> viewDetailedSalesReportByProduct(Date entry, Date exit, int cat,int category)
			throws GoAdminException, ConnectException {

		List<ViewDetailedSalesReportByProductDTO> viewDetailedSalesReportByProduct = new ArrayList<ViewDetailedSalesReportByProductDTO>();
		List<ViewDetailedSalesReportByProductDTO> growthListfinal = new ArrayList<ViewDetailedSalesReportByProductDTO>();

		ViewDetailedSalesReportByProductDTO temp;

		Statement stmt = null;
		
		int j = 0;
		double prevM = 0.0, prevQ = 0.0, prevY = 0.0;

		double[] amtM = new double[12];
		double[] perChngM = new double[12];
		String[] codeM = new String[12];

		double[] amtQ = new double[4];
		double[] perChngQ = new double[4];
		String[] codeQ = new String[4];

		double amtY = 0.0, perChngY = 0.0;
		String codeY;

		double[] arrRevM = new double[12];
		double[] arrRevQ = new double[4];
		double arrRevY = 0.0;

		Session session = null;

		try {
			
			if (entry == null || exit == null) {
				
				throw new GoAdminException(ExceptionConstants.INVALID_DATE);

			}
			int startYear = entry.getYear();
			int endYear = exit.getYear();


			List<Object[]> results = session.createQuery(HQLQuerryMapper.SELECT_REVENUE_DATA).getResultList();

			Double price;

			if (results.size() == 0) {
			
				throw new GoAdminException(ExceptionConstants.EMPTY_DATABASE);

			}

			for (int index = startYear; index <= endYear; index++) {
				for (Object[] rs : results) {

					int month = Integer.parseInt((rs[0].toString().substring(5, 7)));
					int year = Integer.parseInt((rs[0].toString().substring(0, 4))) - 1900;

					for (j = 0; j <= 11; j++) {

						if (month == j && year == index) {

							price = Double.parseDouble(rs[1].toString());
							arrRevM[j] += price;

						}

					}
					
				}
				
				for (j = 0; j <= 11; j++) {

					temp = new ViewDetailedSalesReportByProductDTO();

					if (j == 0) {

						amtM[j] = arrRevM[j] - prevM;
						perChngM[j] = Math.round((100 * (amtM[j]) / prevM) * 100) / 100D;

					} else {
						amtM[j] = arrRevM[j] - arrRevM[j - 1];
						perChngM[j] = Math.round((100 * (amtM[j]) / arrRevM[j - 1]) * 100) / 100D;

					}

					if (perChngM[j] >= 10.0)
						codeM[j] = "GREEN";
					else if (perChngM[j] >= 2.0 && perChngM[j] <= 10)
						codeM[j] = "AMBER";
					else
						codeM[j] = "RED";

					temp.setPeriod(j);
					temp.setRevenue(arrRevM[j]);
					temp.setAmountChange(amtM[j]);
					temp.setPercentageGrowth(perChngM[j]);
					temp.setCode(codeM[j]);
					temp.setType("MONTH");

					viewDetailedSalesReportByProduct.add(temp);

				}

				prevM = arrRevM[11];

				int k = 0;
				for (j = 0; j <= 3; j++) {
					arrRevQ[j] = arrRevM[k] + arrRevM[k + 1] + arrRevM[k + 2];
					k += 3;

				}

				for (j = 0; j <= 3; j++) {

					temp = new ViewDetailedSalesReportByProductDTO();

					if (j == 0) {

						amtQ[j] = arrRevQ[j] - prevQ;
						perChngM[j] = Math.round((100 * (amtQ[j]) / prevQ) * 100) / 100D;

					} else {

						amtQ[j] = arrRevQ[j] - arrRevQ[j - 1];
						perChngQ[j] = Math.round((100 * (amtQ[j]) / arrRevQ[j - 1]) * 100) / 100D;

					}

					if (perChngQ[j] >= 10.0)
						codeQ[j] = "GREEN";
					else if (perChngQ[j] >= 2.0 && perChngQ[j] <= 10)
						codeQ[j] = "AMBER";
					else
						codeQ[j] = "RED";

					temp.setPeriod(j);
					temp.setRevenue(arrRevQ[j]);
					temp.setAmountChange(amtQ[j]);
					temp.setPercentageGrowth(perChngQ[j]);
					temp.setCode(codeQ[j]);
					temp.setType("QUARTER");

					viewDetailedSalesReportByProduct.add(temp);

				}
				prevQ = arrRevQ[3];

				
				arrRevY = arrRevQ[0] + arrRevQ[1] + arrRevQ[2] + arrRevQ[3];
				amtY = arrRevY - prevY;
				perChngY = Math.round((100 * (amtY / prevY)));
				if (perChngY >= 10.0)
					codeY = "GREEN";
				else if (perChngY >= 2.0 && perChngY <= 10)
					codeY = "AMBER";
				else
					codeY = "RED";

				temp = new ViewDetailedSalesReportByProductDTO();
				temp.setPeriod((index + 1900));
				temp.setRevenue(arrRevY);
				temp.setAmountChange(amtY);
				temp.setPercentageGrowth(perChngY);
				temp.setCode(codeY);
				temp.setType("YEAR");
				viewDetailedSalesReportByProduct.add(temp);
				prevY = arrRevY;
				for (j = 0; j <= 11; j++) {

					amtM[j] = 0.0;
					perChngM[j] = 0.0;
					codeM[j] = "NA";
					arrRevM[j] = 0.0;

				}
				for (j = 0; j <= 3; j++) {
					amtQ[j] = 0.0;
					perChngQ[j] = 0.0;
					codeQ[j] = "NA";
					arrRevQ[j] = 0.0;

				}
				amtY = 0.0;
				perChngY = 0.0;
				codeY = "NA";
				arrRevY = 0.0;

			}

			int n = viewDetailedSalesReportByProduct.size(), index;
			if (category == 1) {
				for (index = 0; index < n; index++) {

					if (viewDetailedSalesReportByProduct.get(index).getType().equalsIgnoreCase("MONTH"))
						growthListfinal.add(viewDetailedSalesReportByProduct.get(index));
				}

			} 
			else if (category == 2) {
				for (index = 0; index < n; index++) {
					if (viewDetailedSalesReportByProduct.get(index).getType().equalsIgnoreCase("QUARTER"))
						growthListfinal.add(viewDetailedSalesReportByProduct.get(index));
				}

			}
			else if (category == 3) {
				for (index = 0; index < n; index++) {
					if (viewDetailedSalesReportByProduct.get(index).getType().equalsIgnoreCase("YEAR"))
						growthListfinal.add(viewDetailedSalesReportByProduct.get(index));
				}
			}
		} catch (HibernateException e) {

			session.getTransaction().rollback();

		} catch (Exception exp) {
			throw new GoAdminException(ExceptionConstants.ERROR_IN_VIEWING + exp.getMessage()); 
			

		}

		return growthListfinal;


	}


}
