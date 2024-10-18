package com.entity.vo;

import com.entity.WuziEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuzi")
public class WuziVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 物资编号
     */

    @TableField(value = "wuzi_uuid_number")
    private String wuziUuidNumber;


    /**
     * 物资名称
     */

    @TableField(value = "wuzi_name")
    private String wuziName;


    /**
     * 物资照片
     */

    @TableField(value = "wuzi_photo")
    private String wuziPhoto;


    /**
     * 物资类型
     */

    @TableField(value = "wuzi_types")
    private Integer wuziTypes;


    /**
     * 物资库存
     */

    @TableField(value = "wuzi_kucun_number")
    private Integer wuziKucunNumber;


    /**
     * 原价
     */

    @TableField(value = "wuzi_old_money")
    private Double wuziOldMoney;


    /**
     * 现价
     */

    @TableField(value = "wuzi_new_money")
    private Double wuziNewMoney;


    /**
     * 物资热度
     */

    @TableField(value = "wuzi_clicknum")
    private Integer wuziClicknum;


    /**
     * 物资介绍
     */

    @TableField(value = "wuzi_content")
    private String wuziContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "wuzi_delete")
    private Integer wuziDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：物资编号
	 */
    public String getWuziUuidNumber() {
        return wuziUuidNumber;
    }


    /**
	 * 获取：物资编号
	 */

    public void setWuziUuidNumber(String wuziUuidNumber) {
        this.wuziUuidNumber = wuziUuidNumber;
    }
    /**
	 * 设置：物资名称
	 */
    public String getWuziName() {
        return wuziName;
    }


    /**
	 * 获取：物资名称
	 */

    public void setWuziName(String wuziName) {
        this.wuziName = wuziName;
    }
    /**
	 * 设置：物资照片
	 */
    public String getWuziPhoto() {
        return wuziPhoto;
    }


    /**
	 * 获取：物资照片
	 */

    public void setWuziPhoto(String wuziPhoto) {
        this.wuziPhoto = wuziPhoto;
    }
    /**
	 * 设置：物资类型
	 */
    public Integer getWuziTypes() {
        return wuziTypes;
    }


    /**
	 * 获取：物资类型
	 */

    public void setWuziTypes(Integer wuziTypes) {
        this.wuziTypes = wuziTypes;
    }
    /**
	 * 设置：物资库存
	 */
    public Integer getWuziKucunNumber() {
        return wuziKucunNumber;
    }


    /**
	 * 获取：物资库存
	 */

    public void setWuziKucunNumber(Integer wuziKucunNumber) {
        this.wuziKucunNumber = wuziKucunNumber;
    }
    /**
	 * 设置：原价
	 */
    public Double getWuziOldMoney() {
        return wuziOldMoney;
    }


    /**
	 * 获取：原价
	 */

    public void setWuziOldMoney(Double wuziOldMoney) {
        this.wuziOldMoney = wuziOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getWuziNewMoney() {
        return wuziNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setWuziNewMoney(Double wuziNewMoney) {
        this.wuziNewMoney = wuziNewMoney;
    }
    /**
	 * 设置：物资热度
	 */
    public Integer getWuziClicknum() {
        return wuziClicknum;
    }


    /**
	 * 获取：物资热度
	 */

    public void setWuziClicknum(Integer wuziClicknum) {
        this.wuziClicknum = wuziClicknum;
    }
    /**
	 * 设置：物资介绍
	 */
    public String getWuziContent() {
        return wuziContent;
    }


    /**
	 * 获取：物资介绍
	 */

    public void setWuziContent(String wuziContent) {
        this.wuziContent = wuziContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getWuziDelete() {
        return wuziDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setWuziDelete(Integer wuziDelete) {
        this.wuziDelete = wuziDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
