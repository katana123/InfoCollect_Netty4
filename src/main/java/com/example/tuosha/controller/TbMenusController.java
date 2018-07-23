package com.example.tuosha.controller;

import java.util.List;
import java.util.Map;

import com.example.tuosha.Util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import com.example.tuosha.constant.Constants;

import com.example.tuosha.base.controller.BaseController;
import com.example.tuosha.model.TbMenusEntity;
import com.example.tuosha.service.TbMenusService;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
@Controller
@RequestMapping("tbmenus")
public class TbMenusController extends BaseController {
    @Autowired
    private TbMenusService tbMenusServiceImpl;

    /**
     * 页面
     */
    @RequestMapping("/page")
    public String page(@RequestParam Map<String, Object> params) {
        return "tbmenus";
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/list", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<TbMenusEntity> tbMenusList = tbMenusServiceImpl.queryList(query);
        int total = tbMenusServiceImpl.queryTotal(query);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", total, tbMenusList);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{menuId}", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object info(@PathVariable("menuId") Long menuId) {
        TbMenusEntity tbMenus = tbMenusServiceImpl.queryObject(menuId);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, tbMenus);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@ModelAttribute TbMenusEntity tbMenus) {
        tbMenusServiceImpl.save(tbMenus);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, tbMenus);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@ModelAttribute TbMenusEntity tbMenus) {
        int result = tbMenusServiceImpl.update(tbMenus);
        return putMsgToJsonString(result, "", 0, "");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam Long[] menuIds) {
        int result = tbMenusServiceImpl.deleteBatch(menuIds);
        return putMsgToJsonString(result, "", 0, "");
    }

}
