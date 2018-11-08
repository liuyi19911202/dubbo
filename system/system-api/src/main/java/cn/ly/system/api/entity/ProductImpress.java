package cn.ly.system.api.entity;

import cn.ly.common.api.DataEntity;

/**
 * 商品详情
 *
 * @author liuyi
 */
public class ProductImpress extends DataEntity {

	private String productId; // 商品外键
	private String title; // 印象内容
	private Integer count; // 点赞数

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
