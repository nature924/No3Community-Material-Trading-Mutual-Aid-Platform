package com.dao;

import com.entity.WuziCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WuziCollectionView;

/**
 * 物资收藏 Dao 接口
 *
 * @author 
 */
public interface WuziCollectionDao extends BaseMapper<WuziCollectionEntity> {

   List<WuziCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
