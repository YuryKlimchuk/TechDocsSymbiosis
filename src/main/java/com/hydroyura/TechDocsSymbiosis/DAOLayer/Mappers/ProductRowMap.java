package com.hydroyura.TechDocsSymbiosis.DAOLayer.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Product;


public class ProductRowMap implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product entity = new Product();
			if(Constants.isThere(rs, Constants.TABLE_COLOMN_PRODUCT_ID)) entity.setId(rs.getLong(Constants.TABLE_COLOMN_PRODUCT_ID));
			if(Constants.isThere(rs, Constants.TABLE_COLOMN_PRODUCT_ASM_ID)) entity.setAsmId(rs.getLong(Constants.TABLE_COLOMN_PRODUCT_ASM_ID));
			if(Constants.isThere(rs, Constants.TABLE_COLOMN_PRODUCT_NAME)) entity.setName(rs.getString(Constants.TABLE_COLOMN_PRODUCT_NAME));
			if(Constants.isThere(rs, Constants.TABLE_COLOMN_PRODUCT_NUMBER)) entity.setNumber(rs.getString(Constants.TABLE_COLOMN_PRODUCT_NUMBER));
			if(Constants.isThere(rs, Constants.TABLE_COLOMN_PRODUCT_DESCRIPTION)) entity.setDescription(rs.getString(Constants.TABLE_COLOMN_PRODUCT_DESCRIPTION));
			if(Constants.isThere(rs, Constants.TABLE_COLOMN_PRODUCT_STATUS)) entity.setStatus(rs.getString(Constants.TABLE_COLOMN_PRODUCT_STATUS));
			if(Constants.isThere(rs, Constants.TABLE_COLOMN_PRODUCT_VERSION)) entity.setVersion(rs.getString(Constants.TABLE_COLOMN_PRODUCT_VERSION));
			if(Constants.isThere(rs, Constants.TABLE_COLOMN_PRODUCT_UPDATE)) entity.setUpdate(rs.getString(Constants.TABLE_COLOMN_PRODUCT_UPDATE));
		return entity;
	}

}
