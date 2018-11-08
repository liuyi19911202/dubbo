package cn.ly.system.api.vo;

import java.util.List;

import cn.ly.common.api.DataEntity;

public class ReptileProductVo extends DataEntity {
	private Integer result; // 0 成功,-1 失败
	private List<String> imgs; // 图片
	private String name; // 商品名称
	private String price; // 商品价格
	private List<String> attributes; // 详情
	private List<String> impress; // 印象
	private List<String> sku; // 库存

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public List<String> getImgs() {
		return imgs;
	}

	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}

	public List<String> getImpress() {
		return impress;
	}

	public void setImpress(List<String> impress) {
		this.impress = impress;
	}

	public List<String> getSku() {
		return sku;
	}

	public void setSku(List<String> sku) {
		this.sku = sku;
	}
}
