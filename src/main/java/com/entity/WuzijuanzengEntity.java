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
 * 物资捐赠
 *
 * @author 
 * @email
 */
@TableName("wuzijuanzeng")
public class WuzijuanzengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuzijuanzengEntity() {

	}

	public WuzijuanzengEntity(T t) {
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
     * 捐赠标题
     */
    @ColumnInfo(comment="捐赠标题",type="varchar(200)")
    @TableField(value = "wuzijuanzeng_name")

    private String wuzijuanzengName;


    /**
     * 捐赠类型
     */
    @ColumnInfo(comment="捐赠类型",type="int(11)")
    @TableField(value = "wuzijuanzeng_types")

    private Integer wuzijuanzengTypes;


    /**
     * 捐赠用户
     */
    @ColumnInfo(comment="捐赠用户",type="int(20)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 捐赠数量
     */
    @ColumnInfo(comment="捐赠数量",type="int(11)")
    @TableField(value = "wuzijuanzeng_numb")

    private Integer wuzijuanzengNumb;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 捐赠详情
     */
    @ColumnInfo(comment="捐赠详情",type="longtext")
    @TableField(value = "wuzijuanzeng_content")

    private String wuzijuanzengContent;


    /**
     * 创建时间  listShow
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
	 * 获取：捐赠标题
	 */
    public String getWuzijuanzengName() {
        return wuzijuanzengName;
    }
    /**
	 * 设置：捐赠标题
	 */

    public void setWuzijuanzengName(String wuzijuanzengName) {
        this.wuzijuanzengName = wuzijuanzengName;
    }
    /**
	 * 获取：捐赠类型
	 */
    public Integer getWuzijuanzengTypes() {
        return wuzijuanzengTypes;
    }
    /**
	 * 设置：捐赠类型
	 */

    public void setWuzijuanzengTypes(Integer wuzijuanzengTypes) {
        this.wuzijuanzengTypes = wuzijuanzengTypes;
    }
    /**
	 * 获取：捐赠用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：捐赠用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：捐赠数量
	 */
    public Integer getWuzijuanzengNumb() {
        return wuzijuanzengNumb;
    }
    /**
	 * 设置：捐赠数量
	 */

    public void setWuzijuanzengNumb(Integer wuzijuanzengNumb) {
        this.wuzijuanzengNumb = wuzijuanzengNumb;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：捐赠详情
	 */
    public String getWuzijuanzengContent() {
        return wuzijuanzengContent;
    }
    /**
	 * 设置：捐赠详情
	 */

    public void setWuzijuanzengContent(String wuzijuanzengContent) {
        this.wuzijuanzengContent = wuzijuanzengContent;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Wuzijuanzeng{" +
            ", id=" + id +
            ", wuzijuanzengName=" + wuzijuanzengName +
            ", wuzijuanzengTypes=" + wuzijuanzengTypes +
            ", yonghuId=" + yonghuId +
            ", wuzijuanzengNumb=" + wuzijuanzengNumb +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", wuzijuanzengContent=" + wuzijuanzengContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
