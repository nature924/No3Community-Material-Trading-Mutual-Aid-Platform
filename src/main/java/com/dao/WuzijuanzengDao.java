package com.dao;

import com.entity.WuzijuanzengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WuzijuanzengView;

/**
 * 物资捐赠 Dao 接口
 *
 * @author 
 */
public interface WuzijuanzengDao extends BaseMapper<WuzijuanzengEntity> {

   List<WuzijuanzengView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
