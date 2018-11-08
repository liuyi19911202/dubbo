package cn.ly.system.api.entity;

import java.math.BigDecimal;

import cn.ly.common.api.DataEntity;

/**
 * 商品
 *
 * @author liuyi
 */
public class ProductPicture extends DataEntity {

	private String productId;
	private String url;// 图片url


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
