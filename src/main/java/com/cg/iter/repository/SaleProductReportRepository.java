package com.cg.iter.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.iter.dto.ViewDetailedSalesReportByProductDTO;

public interface SaleProductReportRepository extends CrudRepository<ViewDetailedSalesReportByProductDTO, Integer>{

}
