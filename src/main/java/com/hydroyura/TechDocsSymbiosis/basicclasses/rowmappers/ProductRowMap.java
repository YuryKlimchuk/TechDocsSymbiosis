package com.hydroyura.TechDocsSymbiosis.basicclasses.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.product.ProductEntity;

public class ProductRowMap implements RowMapper<ProductEntity> {

	@Override
	public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductEntity item = new ProductEntity();
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_PRODUCT_ID)) item.setId(rs.getInt(Constants.TABLE_COLOMN_PRODUCT_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_PRODUCT_ASM_ID)) item.setAsmId(rs.getInt(Constants.TABLE_COLOMN_PRODUCT_ASM_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_PRODUCT_NAME)) item.setName(rs.getString(Constants.TABLE_COLOMN_PRODUCT_NAME));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_PRODUCT_NUMBER)) item.setNumber(rs.getString(Constants.TABLE_COLOMN_PRODUCT_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_PRODUCT_DESCRIPTION)) item.setDescription(rs.getString(Constants.TABLE_COLOMN_PRODUCT_DESCRIPTION));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_PRODUCT_DRAW_LINK)) item.setDrawLink(rs.getString(Constants.TABLE_COLOMN_PRODUCT_DRAW_LINK));
		
		return item;
	}
}
