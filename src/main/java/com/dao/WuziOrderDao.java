package com.dao;

import com.entity.WuziOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WuziOrderView;

/**
 * 物资订单 Dao 接口
 *
 * @author 
 */
public interface WuziOrderDao extends BaseMapper<WuziOrderEntity> {

   List<WuziOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
