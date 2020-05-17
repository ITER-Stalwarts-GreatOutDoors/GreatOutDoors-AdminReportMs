package com.cg.iter.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.iter.dto.ViewSalesReportByUserDTO;

public interface SaleReportRepository extends CrudRepository<ViewSalesReportByUserDTO, String>{

}
