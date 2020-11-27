package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.GokUser;
import com.ruoyi.system.service.IGokUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * GOK_用户相关操作Controller
 * 
 * @author ruoyi
 * @date 2020-11-27
 */
@Controller
@RequestMapping("/gok/user")
public class GokUserController extends BaseController
{
    private String prefix = "gok/user";

    @Autowired
    private IGokUserService gokUserService;

    @RequiresPermissions("gok:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询GOK_用户相关操作列表
     */
    @RequiresPermissions("gok:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GokUser gokUser)
    {
        startPage();
        List<GokUser> list = gokUserService.selectGokUserList(gokUser);
        return getDataTable(list);
    }

    /**
     * 导出GOK_用户相关操作列表
     */
    @RequiresPermissions("gok:user:export")
    @Log(title = "GOK_用户相关操作", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GokUser gokUser)
    {
        List<GokUser> list = gokUserService.selectGokUserList(gokUser);
        ExcelUtil<GokUser> util = new ExcelUtil<GokUser>(GokUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增GOK_用户相关操作
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存GOK_用户相关操作
     */
    @RequiresPermissions("gok:user:add")
    @Log(title = "GOK_用户相关操作", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GokUser gokUser)
    {
        return toAjax(gokUserService.insertGokUser(gokUser));
    }

    /**
     * 修改GOK_用户相关操作
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GokUser gokUser = gokUserService.selectGokUserById(id);
        mmap.put("gokUser", gokUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存GOK_用户相关操作
     */
    @RequiresPermissions("gok:user:edit")
    @Log(title = "GOK_用户相关操作", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GokUser gokUser)
    {
        return toAjax(gokUserService.updateGokUser(gokUser));
    }

    /**
     * 删除GOK_用户相关操作
     */
    @RequiresPermissions("gok:user:remove")
    @Log(title = "GOK_用户相关操作", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gokUserService.deleteGokUserByIds(ids));
    }
}
