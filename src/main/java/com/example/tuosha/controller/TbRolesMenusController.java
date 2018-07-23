package com.example.tuosha.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import com.example.tuosha.constant.Constants;
import com.example.tuosha.Util.Query;
import com.example.tuosha.base.controller.BaseController;
import com.example.tuosha.model.TbRolesMenusEntity;
import com.example.tuosha.service.TbRolesMenusService;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
@Controller
@RequestMapping("tbrolesmenus")
public class TbRolesMenusController extends BaseController {
    @Autowired
    private TbRolesMenusService tbRolesMenusServiceImpl;

    /**
     * 页面
     */
    @RequestMapping("/page")
    public String page(@RequestParam Map<String, Object> params) {
        return "tbrolesmenus";
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/list", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<TbRolesMenusEntity> tbRolesMenusList = tbRolesMenusServiceImpl.queryList(query);
        int total = tbRolesMenusServiceImpl.queryTotal(query);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", total, tbRolesMenusList);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{menuId}", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object info(@PathVariable("menuId") Long menuId) {
        TbRolesMenusEntity tbRolesMenus = tbRolesMenusServiceImpl.queryObject(menuId);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, tbRolesMenus);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@ModelAttribute TbRolesMenusEntity tbRolesMenus) {
        tbRolesMenusServiceImpl.save(tbRolesMenus);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, tbRolesMenus);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@ModelAttribute TbRolesMenusEntity tbRolesMenus) {
        int result = tbRolesMenusServiceImpl.update(tbRolesMenus);
        return putMsgToJsonString(result, "", 0, "");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam Long[] menuIds) {
        int result = tbRolesMenusServiceImpl.deleteBatch(menuIds);
        return putMsgToJsonString(result, "", 0, "");
    }

}
