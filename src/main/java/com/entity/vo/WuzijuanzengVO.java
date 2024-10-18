package com.entity.vo;

import com.entity.WuzijuanzengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资捐赠
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuzijuanzeng")
public class WuzijuanzengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 捐赠标题
     */

    @TableField(value = "wuzijuanzeng_name")
    private String wuzijuanzengName;


    /**
     * 捐赠类型
     */

    @TableField(value = "wuzijuanzeng_types")
    private Integer wuzijuanzengTypes;


    /**
     * 捐赠用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 捐赠数量
     */

    @TableField(value = "wuzijuanzeng_numb")
    private Integer wuzijuanzengNumb;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 捐赠详情
     */

    @TableField(value = "wuzijuanzeng_content")
    private String wuzijuanzengContent;


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
	 * 设置：捐赠标题
	 */
    public String getWuzijuanzengName() {
        return wuzijuanzengName;
    }


    /**
	 * 获取：捐赠标题
	 */

    public void setWuzijuanzengName(String wuzijuanzengName) {
        this.wuzijuanzengName = wuzijuanzengName;
    }
    /**
	 * 设置：捐赠类型
	 */
    public Integer getWuzijuanzengTypes() {
        return wuzijuanzengTypes;
    }


    /**
	 * 获取：捐赠类型
	 */

    public void setWuzijuanzengTypes(Integer wuzijuanzengTypes) {
        this.wuzijuanzengTypes = wuzijuanzengTypes;
    }
    /**
	 * 设置：捐赠用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：捐赠用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：捐赠数量
	 */
    public Integer getWuzijuanzengNumb() {
        return wuzijuanzengNumb;
    }


    /**
	 * 获取：捐赠数量
	 */

    public void setWuzijuanzengNumb(Integer wuzijuanzengNumb) {
        this.wuzijuanzengNumb = wuzijuanzengNumb;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：捐赠详情
	 */
    public String getWuzijuanzengContent() {
        return wuzijuanzengContent;
    }


    /**
	 * 获取：捐赠详情
	 */

    public void setWuzijuanzengContent(String wuzijuanzengContent) {
        this.wuzijuanzengContent = wuzijuanzengContent;
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
