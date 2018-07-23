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
import com.example.tuosha.model.TbRolesEntity;
import com.example.tuosha.service.TbRolesService;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
@Controller
@RequestMapping("tbroles")
public class TbRolesController extends BaseController {
    @Autowired
    private TbRolesService tbRolesServiceImpl;

    /**
     * 页面
     */
    @RequestMapping("/page")
    public String page(@RequestParam Map<String, Object> params) {
        return "tbroles";
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/list", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<TbRolesEntity> tbRolesList = tbRolesServiceImpl.queryList(query);
        int total = tbRolesServiceImpl.queryTotal(query);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", total, tbRolesList);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{roleId}", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object info(@PathVariable("roleId") Long roleId) {
        TbRolesEntity tbRoles = tbRolesServiceImpl.queryObject(roleId);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, tbRoles);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@ModelAttribute TbRolesEntity tbRoles) {
        tbRolesServiceImpl.save(tbRoles);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, tbRoles);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@ModelAttribute TbRolesEntity tbRoles) {
        int result = tbRolesServiceImpl.update(tbRoles);
        return putMsgToJsonString(result, "", 0, "");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam Long[] roleIds) {
        int result = tbRolesServiceImpl.deleteBatch(roleIds);
        return putMsgToJsonString(result, "", 0, "");
    }

}
