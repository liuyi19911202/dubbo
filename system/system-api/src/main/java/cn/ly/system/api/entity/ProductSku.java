package cn.ly.system.api.entity;

import java.math.BigDecimal;

import cn.ly.common.api.DataEntity;

/**
 * 商品详情
 *
 * @author liuyi
 */
public class ProductSku extends DataEntity {

	private String productId; // 商品外键
	private String name; // 属性
	private String value; // 值

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
