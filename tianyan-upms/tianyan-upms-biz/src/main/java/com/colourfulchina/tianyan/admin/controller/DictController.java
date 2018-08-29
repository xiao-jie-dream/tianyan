

package com.colourfulchina.tianyan.admin.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.colourfulchina.tianyan.admin.api.dto.Query;
import com.colourfulchina.tianyan.admin.api.entity.SysDict;
import com.colourfulchina.tianyan.admin.service.SysDictService;
import com.colourfulchina.tianyan.common.core.constant.CommonConstant;
import com.colourfulchina.tianyan.common.core.util.R;
import com.colourfulchina.tianyan.common.log.annotation.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/dict")
public class DictController {
	@Autowired
	private SysDictService sysDictService;

	/**
	 * 通过ID查询字典信息
	 *
	 * @param id ID
	 * @return 字典信息
	 */
	@GetMapping("/{id}")
	public SysDict dict(@PathVariable Integer id) {
		return sysDictService.selectById(id);
	}

	/**
	 * 分页查询字典信息
	 *
	 * @param params 分页对象
	 * @return 分页对象
	 */
	@RequestMapping("/dictPage")
	public Page dictPage(@RequestParam Map<String, Object> params) {
		params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
		return sysDictService.selectPage(new Query<>(params), new EntityWrapper<>());
	}

	/**
	 * 通过字典类型查找字典
	 *
	 * @param type 类型
	 * @return 同类型字典
	 */
	@GetMapping("/type/{type}")
	@Cacheable(value = "dict_details", key = "#type")
	public List<SysDict> findDictByType(@PathVariable String type) {
		SysDict condition = new SysDict();
		condition.setDelFlag(CommonConstant.STATUS_NORMAL);
		condition.setType(type);
		return sysDictService.selectList(new EntityWrapper<>(condition));
	}

	/**
	 * 添加字典
	 *
	 * @param sysDict 字典信息
	 * @return success、false
	 */
	@SysLog("添加字典")
	@PostMapping
	@CacheEvict(value = "dict_details", key = "#sysDict.type")
	@PreAuthorize("@pms.hasPermission('sys_dict_add')")
	public R<Boolean> dict(@RequestBody SysDict sysDict) {
		return new R<>(sysDictService.insert(sysDict));
	}

	/**
	 * 删除字典，并且清除字典缓存
	 *
	 * @param id   ID
	 * @param type 类型
	 * @return R
	 */
	@SysLog("删除字典")
	@DeleteMapping("/{id}/{type}")
	@CacheEvict(value = "dict_details", key = "#type")
	@PreAuthorize("@pms.hasPermission('sys_dict_del')")
	public R<Boolean> deleteDict(@PathVariable Integer id, @PathVariable String type) {
		return new R<>(sysDictService.deleteById(id));
	}

	/**
	 * 修改字典
	 *
	 * @param sysDict 字典信息
	 * @return success/false
	 */
	@PutMapping
	@SysLog("修改字典")
	@CacheEvict(value = "dict_details", key = "#sysDict.type")
	@PreAuthorize("@pms.hasPermission('sys_dict_edit')")
	public R<Boolean> editDict(@RequestBody SysDict sysDict) {
		return new R<>(sysDictService.updateById(sysDict));
	}
}
