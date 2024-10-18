package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 物资
 *
 * @author 
 * @email
 */
@TableName("wuzi")
public class WuziEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuziEntity() {

	}

	public WuziEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 物资编号
     */
    @ColumnInfo(comment="物资编号",type="varchar(200)")
    @TableField(value = "wuzi_uuid_number")

    private String wuziUuidNumber;


    /**
     * 物资名称
     */
    @ColumnInfo(comment="物资名称",type="varchar(200)")
    @TableField(value = "wuzi_name")

    private String wuziName;


    /**
     * 物资照片
     */
    @ColumnInfo(comment="物资照片",type="varchar(200)")
    @TableField(value = "wuzi_photo")

    private String wuziPhoto;


    /**
     * 物资类型
     */
    @ColumnInfo(comment="物资类型",type="int(11)")
    @TableField(value = "wuzi_types")

    private Integer wuziTypes;


    /**
     * 物资库存
     */
    @ColumnInfo(comment="物资库存",type="int(11)")
    @TableField(value = "wuzi_kucun_number")

    private Integer wuziKucunNumber;


    /**
     * 原价
     */
    @ColumnInfo(comment="原价",type="decimal(10,2)")
    @TableField(value = "wuzi_old_money")

    private Double wuziOldMoney;


    /**
     * 现价
     */
    @ColumnInfo(comment="现价",type="decimal(10,2)")
    @TableField(value = "wuzi_new_money")

    private Double wuziNewMoney;


    /**
     * 物资热度
     */
    @ColumnInfo(comment="物资热度",type="int(11)")
    @TableField(value = "wuzi_clicknum")

    private Integer wuziClicknum;


    /**
     * 物资介绍
     */
    @ColumnInfo(comment="物资介绍",type="longtext")
    @TableField(value = "wuzi_content")

    private String wuziContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "wuzi_delete")

    private Integer wuziDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：物资编号
	 */
    public String getWuziUuidNumber() {
        return wuziUuidNumber;
    }
    /**
	 * 设置：物资编号
	 */

    public void setWuziUuidNumber(String wuziUuidNumber) {
        this.wuziUuidNumber = wuziUuidNumber;
    }
    /**
	 * 获取：物资名称
	 */
    public String getWuziName() {
        return wuziName;
    }
    /**
	 * 设置：物资名称
	 */

    public void setWuziName(String wuziName) {
        this.wuziName = wuziName;
    }
    /**
	 * 获取：物资照片
	 */
    public String getWuziPhoto() {
        return wuziPhoto;
    }
    /**
	 * 设置：物资照片
	 */

    public void setWuziPhoto(String wuziPhoto) {
        this.wuziPhoto = wuziPhoto;
    }
    /**
	 * 获取：物资类型
	 */
    public Integer getWuziTypes() {
        return wuziTypes;
    }
    /**
	 * 设置：物资类型
	 */

    public void setWuziTypes(Integer wuziTypes) {
        this.wuziTypes = wuziTypes;
    }
    /**
	 * 获取：物资库存
	 */
    public Integer getWuziKucunNumber() {
        return wuziKucunNumber;
    }
    /**
	 * 设置：物资库存
	 */

    public void setWuziKucunNumber(Integer wuziKucunNumber) {
        this.wuziKucunNumber = wuziKucunNumber;
    }
    /**
	 * 获取：原价
	 */
    public Double getWuziOldMoney() {
        return wuziOldMoney;
    }
    /**
	 * 设置：原价
	 */

    public void setWuziOldMoney(Double wuziOldMoney) {
        this.wuziOldMoney = wuziOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getWuziNewMoney() {
        return wuziNewMoney;
    }
    /**
	 * 设置：现价
	 */

    public void setWuziNewMoney(Double wuziNewMoney) {
        this.wuziNewMoney = wuziNewMoney;
    }
    /**
	 * 获取：物资热度
	 */
    public Integer getWuziClicknum() {
        return wuziClicknum;
    }
    /**
	 * 设置：物资热度
	 */

    public void setWuziClicknum(Integer wuziClicknum) {
        this.wuziClicknum = wuziClicknum;
    }
    /**
	 * 获取：物资介绍
	 */
    public String getWuziContent() {
        return wuziContent;
    }
    /**
	 * 设置：物资介绍
	 */

    public void setWuziContent(String wuziContent) {
        this.wuziContent = wuziContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getWuziDelete() {
        return wuziDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setWuziDelete(Integer wuziDelete) {
        this.wuziDelete = wuziDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Wuzi{" +
            ", id=" + id +
            ", wuziUuidNumber=" + wuziUuidNumber +
            ", wuziName=" + wuziName +
            ", wuziPhoto=" + wuziPhoto +
            ", wuziTypes=" + wuziTypes +
            ", wuziKucunNumber=" + wuziKucunNumber +
            ", wuziOldMoney=" + wuziOldMoney +
            ", wuziNewMoney=" + wuziNewMoney +
            ", wuziClicknum=" + wuziClicknum +
            ", wuziContent=" + wuziContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", wuziDelete=" + wuziDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
