package cn.kgc.tangcco.appinfosys.controller.developer;

import cn.kgc.tangcco.appinfosys.pojo.AppCategory;
import cn.kgc.tangcco.appinfosys.pojo.AppDictionary;
import cn.kgc.tangcco.appinfosys.pojo.AppInfo;
import cn.kgc.tangcco.appinfosys.pojo.AppVersion;
import cn.kgc.tangcco.appinfosys.service.appcategory.AppCategoryService;
import cn.kgc.tangcco.appinfosys.service.appdictionary.AppDictionayService;
import cn.kgc.tangcco.appinfosys.service.appinfo.AppInfoService;
import cn.kgc.tangcco.appinfosys.service.appversion.AppVersionService;
import cn.kgc.tangcco.appinfosys.tools.Constants;
import cn.kgc.tangcco.appinfosys.tools.PageSupport;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/appinfo")
public class AppInfoController {
private Logger logger = Logger.getLogger(AppInfoController.class);
    /*app信息*/
    @Resource
    private AppInfoService appInfoService;


    /*app版本*/
    @Resource
    private AppVersionService appVersionService;


    /*数据字典*/
    @Resource
    private AppDictionayService appDictionayService;

/*app类别*/
    @Resource
    private AppCategoryService appCategoryService;




    @RequestMapping(value = "/toAppInfoList")
    public String appInfoList(Model model
            , @RequestParam(value = "querySoftwareName",required = false)String querySoftwareName
            ,@RequestParam(value = "queryStatus",required = false)Integer queryStatus
            ,@RequestParam(value = "queryFlatformId",required = false)Integer queryFlatformId
            ,@RequestParam(value = "queryCategoryLevel1",required = false)Integer queryCategoryLevel1
            ,@RequestParam(value = "queryCategoryLevel2",required = false)Integer queryCategoryLevel2
            ,@RequestParam(value = "queryCategoryLevel3",required = false)Integer queryCategoryLevel3
            ,@RequestParam(value = "pageIndex",required = false)String pageIndex){
        List<AppDictionary> statusList;
        List<AppDictionary> flatFormList;
      statusList = appDictionayService.getValueNameByValueId("APP状态");
        flatFormList =  appDictionayService.getValueNameByValueId("所属平台");

        List<AppInfo> appInfoLis = appInfoService.getAppInfo();

/*List<AppCategory> categoryList = appCategoryService.findCategoryNameById();*/
        List<AppCategory> categoryLevel1List = appCategoryService.findCategoryNameByparentId(0);
       /* List<AppCategory> categoryLevel2List = null;
        List<AppCategory> categoryLevel3List = null;*/

        model.addAttribute("categoryLevel1List",categoryLevel1List);
      /*  model.addAttribute("categoryLevel2List",categoryLevel2List);
        model.addAttribute("categoryLevel3List",categoryLevel3List);*/



/*
        for (AppInfo appinfo:appInfoLis) {



            categoryLevel1List = appCategoryService.findCategoryNameById();



            logger.info(categoryLevel1List.size()+"长");


                    categoryLevel2List = appCategoryService.findCategoryNameById();




                    categoryLevel3List = appCategoryService.findCategoryNameById();



        }*/

              /*      logger.info(appinfo.getCategoryLevel1()+"q");
            logger.info(appCategoryList.size()+"q");*/
                    /*categoryLevel1List.add(appCategory);*/
           /* logger.info(appCategoryList.get(1).getCategoryName()+"r");*/




                /*    categoryLevel2List = appCategoryService.findCategoryNameById(appinfo.getCategoryLevel2());
                    logger.info(appinfo.getCategoryLevel2()+"q");
                    model.addAttribute("categoryLevel2List",categoryLevel2List);



                    categoryLevel3List = appCategoryService.findCategoryNameById(appinfo.getCategoryLevel3());
                    logger.info(appinfo.getCategoryLevel3()+"q");
                    model.addAttribute("categoryLevel3List",categoryLevel3List);
*/




/*
if (categoryLevel2List != null && categoryLevel2List.equals("")){
            categoryLevel2List = appCategoryService.getCategoryNameById(appinfo.getCategoryLevel2());
            logger.info(appinfo.getCategoryLevel2()+"w");
    model.addAttribute("categoryLevel2List",categoryLevel2List);
}
if (categoryLevel3List != null && categoryLevel3List.equals("")){

            categoryLevel3List = appCategoryService.getCategoryNameById(appinfo.getCategoryLevel3());
    logger.info(appinfo.getCategoryLevel3()+"e");

    model.addAttribute("categoryLevel3List",categoryLevel3List);
}
*/


        //设置页面容量
        Integer pageSize = Constants.pageSize;
        //当前页码

        Integer currentPageNo = 1;
        System.out.println("pageIndex"+pageIndex);
        System.out.println("owefnk");
        if (pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch (NumberFormatException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }


        //总页数
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        System.out.println(querySoftwareName+"querSoftwarenaem");
        if (querySoftwareName == null){
            querySoftwareName = "";
        }



        Integer totalCount = appInfoService.AppInfoCount(querySoftwareName,queryStatus,queryFlatformId,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3);
        pages.setTotalCount(totalCount);

        /*控制总页数*/
        Integer totalPageCount = pages.getTotalPageCount();
        if (currentPageNo < 1){
            currentPageNo = 1;
        }else if (currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;

        }

        pages.setTotalPageCount(totalPageCount);

        Integer uu = (currentPageNo - 1) * pageSize;

        System.out.println("uu"+uu);


        System.out.println("pageSize"+pageSize);


        List<AppInfo> appInfoList = appInfoService.findSizAppAttr(querySoftwareName,queryStatus,queryFlatformId,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3,uu,pageSize);
        System.out.println(currentPageNo+"1osjlkdvfsnfhgfjshv");
        model.addAttribute("appInfoList",appInfoList);
      /*  model.addAttribute("currentPageNo",currentPageNo);*/
        model.addAttribute("pages",pages);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("statusList",statusList);
        model.addAttribute("totalPageCount",totalPageCount);
model.addAttribute("flatFormList",flatFormList);


        return "/developer/appinfolist";


    }



    /*处理一二三级分类*/
    @RequestMapping(value = "/oneinfo")
    public JSON OneInfo(@RequestParam("parentId") Integer id){
        List<AppCategory> appCategoryList = appCategoryService.findCategoryNameByparentId(id);
       /* Map<String,String> map = new HashMap<>();
        if (){

        }*/
        return (JSON) JSON.toJSON(appCategoryList);
    }



//    去新增基础信息页面
    @RequestMapping(value = "/appinfoadd",method = RequestMethod.GET)
    public String appInfoAdd(){
        return "/developer/appinfoadd";
    }


}
