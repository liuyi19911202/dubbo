package cn.ly.test.caotuan.dbdata.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
	private Long id;
	private Long userid;
	private Long goodsid;
	private Long goodsmodelid;
	private Long addressid;
	private Long couponid;
	private Long shopid;
	private Long drawingid;
	private Integer amount;
	private Integer state;
	private Date createdate;
	private Integer type;
	private BigDecimal finalprice;
	private Integer couponnumber;
	private String response;
	private String good_model;
	private String sku_number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public Long getGoodsmodelid() {
		return goodsmodelid;
	}

	public void setGoodsmodelid(Long goodsmodelid) {
		this.goodsmodelid = goodsmodelid;
	}

	public Long getAddressid() {
		return addressid;
	}

	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}

	public Long getCouponid() {
		return couponid;
	}

	public void setCouponid(Long couponid) {
		this.couponid = couponid;
	}

	public Long getShopid() {
		return shopid;
	}

	public void setShopid(Long shopid) {
		this.shopid = shopid;
	}

	public Long getDrawingid() {
		return drawingid;
	}

	public void setDrawingid(Long drawingid) {
		this.drawingid = drawingid;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getFinalprice() {
		return finalprice;
	}

	public void setFinalprice(BigDecimal finalprice) {
		this.finalprice = finalprice;
	}

	public Integer getCouponnumber() {
		return couponnumber;
	}

	public void setCouponnumber(Integer couponnumber) {
		this.couponnumber = couponnumber;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getGood_model() {
		return good_model;
	}

	public void setGood_model(String good_model) {
		this.good_model = good_model;
	}

	public String getSku_number() {
		return sku_number;
	}

	public void setSku_number(String sku_number) {
		this.sku_number = sku_number;
	}

}
