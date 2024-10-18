package com.entity.model;

import com.entity.WuzijuanzengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资捐赠
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuzijuanzengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 捐赠标题
     */
    private String wuzijuanzengName;


    /**
     * 捐赠类型
     */
    private Integer wuzijuanzengTypes;


    /**
     * 捐赠用户
     */
    private Integer yonghuId;


    /**
     * 捐赠数量
     */
    private Integer wuzijuanzengNumb;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 捐赠详情
     */
    private String wuzijuanzengContent;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
