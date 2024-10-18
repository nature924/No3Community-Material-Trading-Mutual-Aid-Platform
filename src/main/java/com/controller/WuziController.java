
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 物资
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wuzi")
public class WuziController {
    private static final Logger logger = LoggerFactory.getLogger(WuziController.class);

    private static final String TABLE_NAME = "wuzi";

    @Autowired
    private WuziService wuziService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private LiuyanService liuyanService;//求助留言板
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private WuziCollectionService wuziCollectionService;//物资收藏
    @Autowired
    private WuziOrderService wuziOrderService;//物资订单
    @Autowired
    private WuzijuanzengService wuzijuanzengService;//物资捐赠
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("wuziDeleteStart",1);params.put("wuziDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = wuziService.queryPage(params);

        //字典表数据转换
        List<WuziView> list =(List<WuziView>)page.getList();
        for(WuziView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WuziEntity wuzi = wuziService.selectById(id);
        if(wuzi !=null){
            //entity转view
            WuziView view = new WuziView();
            BeanUtils.copyProperties( wuzi , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WuziEntity wuzi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wuzi:{}",this.getClass().getName(),wuzi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<WuziEntity> queryWrapper = new EntityWrapper<WuziEntity>()
            .eq("wuzi_name", wuzi.getWuziName())
            .eq("wuzi_types", wuzi.getWuziTypes())
            .eq("wuzi_kucun_number", wuzi.getWuziKucunNumber())
            .eq("shangxia_types", wuzi.getShangxiaTypes())
            .eq("wuzi_delete", wuzi.getWuziDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuziEntity wuziEntity = wuziService.selectOne(queryWrapper);
        if(wuziEntity==null){
            wuzi.setWuziClicknum(1);
            wuzi.setShangxiaTypes(1);
            wuzi.setWuziDelete(1);
            wuzi.setInsertTime(new Date());
            wuzi.setCreateTime(new Date());
            wuziService.insert(wuzi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WuziEntity wuzi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wuzi:{}",this.getClass().getName(),wuzi.toString());
        WuziEntity oldWuziEntity = wuziService.selectById(wuzi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(wuzi.getWuziPhoto()) || "null".equals(wuzi.getWuziPhoto())){
                wuzi.setWuziPhoto(null);
        }

            wuziService.updateById(wuzi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WuziEntity> oldWuziList =wuziService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<WuziEntity> list = new ArrayList<>();
        for(Integer id:ids){
            WuziEntity wuziEntity = new WuziEntity();
            wuziEntity.setId(id);
            wuziEntity.setWuziDelete(2);
            list.add(wuziEntity);
        }
        if(list != null && list.size() >0){
            wuziService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<WuziEntity> wuziList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            WuziEntity wuziEntity = new WuziEntity();
//                            wuziEntity.setWuziUuidNumber(data.get(0));                    //物资编号 要改的
//                            wuziEntity.setWuziName(data.get(0));                    //物资名称 要改的
//                            wuziEntity.setWuziPhoto("");//详情和图片
//                            wuziEntity.setWuziTypes(Integer.valueOf(data.get(0)));   //物资类型 要改的
//                            wuziEntity.setWuziKucunNumber(Integer.valueOf(data.get(0)));   //物资库存 要改的
//                            wuziEntity.setWuziOldMoney(data.get(0));                    //原价 要改的
//                            wuziEntity.setWuziNewMoney(data.get(0));                    //现价 要改的
//                            wuziEntity.setWuziClicknum(Integer.valueOf(data.get(0)));   //物资热度 要改的
//                            wuziEntity.setWuziContent("");//详情和图片
//                            wuziEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            wuziEntity.setWuziDelete(1);//逻辑删除字段
//                            wuziEntity.setInsertTime(date);//时间
//                            wuziEntity.setCreateTime(date);//时间
                            wuziList.add(wuziEntity);


                            //把要查询是否重复的字段放入map中
                                //物资编号
                                if(seachFields.containsKey("wuziUuidNumber")){
                                    List<String> wuziUuidNumber = seachFields.get("wuziUuidNumber");
                                    wuziUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wuziUuidNumber = new ArrayList<>();
                                    wuziUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wuziUuidNumber",wuziUuidNumber);
                                }
                        }

                        //查询是否重复
                         //物资编号
                        List<WuziEntity> wuziEntities_wuziUuidNumber = wuziService.selectList(new EntityWrapper<WuziEntity>().in("wuzi_uuid_number", seachFields.get("wuziUuidNumber")).eq("wuzi_delete", 1));
                        if(wuziEntities_wuziUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WuziEntity s:wuziEntities_wuziUuidNumber){
                                repeatFields.add(s.getWuziUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [物资编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wuziService.insertBatch(wuziList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<WuziView> returnWuziViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = wuziOrderService.queryPage(params1);
        List<WuziOrderView> orderViewsList =(List<WuziOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(WuziOrderView orderView:orderViewsList){
            Integer wuziTypes = orderView.getWuziTypes();
            if(typeMap.containsKey(wuziTypes)){
                typeMap.put(wuziTypes,typeMap.get(wuziTypes)+1);
            }else{
                typeMap.put(wuziTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("wuziTypes",type);
            PageUtils pageUtils1 = wuziService.queryPage(params2);
            List<WuziView> wuziViewList =(List<WuziView>)pageUtils1.getList();
            returnWuziViewList.addAll(wuziViewList);
            if(returnWuziViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = wuziService.queryPage(params);
        if(returnWuziViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnWuziViewList.size();//要添加的数量
            List<WuziView> wuziViewList =(List<WuziView>)page.getList();
            for(WuziView wuziView:wuziViewList){
                Boolean addFlag = true;
                for(WuziView returnWuziView:returnWuziViewList){
                    if(returnWuziView.getId().intValue() ==wuziView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnWuziViewList.add(wuziView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnWuziViewList = returnWuziViewList.subList(0, limit);
        }

        for(WuziView c:returnWuziViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnWuziViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = wuziService.queryPage(params);

        //字典表数据转换
        List<WuziView> list =(List<WuziView>)page.getList();
        for(WuziView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WuziEntity wuzi = wuziService.selectById(id);
            if(wuzi !=null){

                //点击数量加1
                wuzi.setWuziClicknum(wuzi.getWuziClicknum()+1);
                wuziService.updateById(wuzi);

                //entity转view
                WuziView view = new WuziView();
                BeanUtils.copyProperties( wuzi , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody WuziEntity wuzi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wuzi:{}",this.getClass().getName(),wuzi.toString());
        Wrapper<WuziEntity> queryWrapper = new EntityWrapper<WuziEntity>()
            .eq("wuzi_uuid_number", wuzi.getWuziUuidNumber())
            .eq("wuzi_name", wuzi.getWuziName())
            .eq("wuzi_types", wuzi.getWuziTypes())
            .eq("wuzi_kucun_number", wuzi.getWuziKucunNumber())
            .eq("wuzi_clicknum", wuzi.getWuziClicknum())
            .eq("shangxia_types", wuzi.getShangxiaTypes())
            .eq("wuzi_delete", wuzi.getWuziDelete())
//            .notIn("wuzi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuziEntity wuziEntity = wuziService.selectOne(queryWrapper);
        if(wuziEntity==null){
            wuzi.setWuziClicknum(1);
            wuzi.setWuziDelete(1);
            wuzi.setInsertTime(new Date());
            wuzi.setCreateTime(new Date());
        wuziService.insert(wuzi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

