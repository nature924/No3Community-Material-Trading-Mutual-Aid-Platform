package com.entity.vo;

import com.entity.WuziOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuzi_order")
public class WuziOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "wuzi_order_uuid_number")
    private String wuziOrderUuidNumber;


    /**
     * 收货地址
     */

    @TableField(value = "address_id")
    private Integer addressId;


    /**
     * 物资
     */

    @TableField(value = "wuzi_id")
    private Integer wuziId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 购买数量
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 实付价格
     */

    @TableField(value = "wuzi_order_true_price")
    private Double wuziOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "wuzi_order_types")
    private Integer wuziOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "wuzi_order_payment_types")
    private Integer wuziOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getWuziOrderUuidNumber() {
        return wuziOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setWuziOrderUuidNumber(String wuziOrderUuidNumber) {
        this.wuziOrderUuidNumber = wuziOrderUuidNumber;
    }
    /**
	 * 设置：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：物资
	 */
    public Integer getWuziId() {
        return wuziId;
    }


    /**
	 * 获取：物资
	 */

    public void setWuziId(Integer wuziId) {
        this.wuziId = wuziId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getWuziOrderTruePrice() {
        return wuziOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setWuziOrderTruePrice(Double wuziOrderTruePrice) {
        this.wuziOrderTruePrice = wuziOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getWuziOrderTypes() {
        return wuziOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setWuziOrderTypes(Integer wuziOrderTypes) {
        this.wuziOrderTypes = wuziOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getWuziOrderPaymentTypes() {
        return wuziOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setWuziOrderPaymentTypes(Integer wuziOrderPaymentTypes) {
        this.wuziOrderPaymentTypes = wuziOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
