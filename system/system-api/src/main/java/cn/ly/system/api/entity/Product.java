package cn.ly.system.api.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import cn.ly.common.api.DataEntity;

/**
 * 商品
 *
 * @author liuyi
 */
public class Product extends DataEntity {

	private String name; // 商品名称
	private String number; // 商品编号
	private BigDecimal price;// 商品价格
	private Integer stock;// 库存量
	private BigDecimal freight;// 运费
	private String webUrl; // 商品地址
	private String url;// 商品图片地址
	private String thumbnail;// 商品列表缩略图

	// 图片
	private List<ProductPicture> listProductPicture = new ArrayList<>();
	// sku
	private List<ProductSku> listProductSku = new ArrayList<>();
	// attributes
	private List<ProductAttribute> listProductAttribute = new ArrayList<>();
	// 大家印象
	private List<ProductImpress> listProductImpress = new ArrayList<>();

	// 非数据库属性,python传过来的vo对象
	// 图片
	private List<String> imgs = new ArrayList<>();
	// sku
	private List<String> sku = new ArrayList<>();
	// attributes
	private List<String> attributes = new ArrayList<>();
	// 大家印象
	private List<String> impress = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public List<ProductPicture> getListProductPicture() {
		return listProductPicture;
	}

	public void setListProductPicture(List<ProductPicture> listProductPicture) {
		this.listProductPicture = listProductPicture;
	}

	public List<ProductSku> getListProductSku() {
		return listProductSku;
	}

	public void setListProductSku(List<ProductSku> listProductSku) {
		this.listProductSku = listProductSku;
	}

	public List<ProductAttribute> getListProductAttribute() {
		return listProductAttribute;
	}

	public void setListProductAttribute(List<ProductAttribute> listProductAttribute) {
		this.listProductAttribute = listProductAttribute;
	}

	public List<ProductImpress> getListProductImpress() {
		return listProductImpress;
	}

	public void setListProductImpress(List<ProductImpress> listProductImpress) {
		this.listProductImpress = listProductImpress;
	}

	public List<String> getImgs() {
		return imgs;
	}

	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}

	public List<String> getSku() {
		return sku;
	}

	public void setSku(List<String> sku) {
		this.sku = sku;
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

}
