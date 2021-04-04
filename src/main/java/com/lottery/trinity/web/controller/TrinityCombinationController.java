package com.lottery.trinity.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lottery.trinity.model.entity.Combination;
import com.lottery.trinity.service.TrinityCombinationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description = "10（0~9）选三排列")
@RestController
@RequestMapping("/trinity")
public class TrinityCombinationController {

	@Autowired
	private TrinityCombinationService trinityCombinationService;

	@ApiOperation("根据主键ID查询排列")
	@GetMapping("/selectByPrimaryKey")
	public Combination testname(@ApiParam("组合ID") Long id) throws Exception {
		return trinityCombinationService.selectByPrimaryKey(id);
	}

	@ApiOperation("根据数组生成不重复三位排列，入库")
	@PostMapping("/generate")
	public List<Long> generate(@ApiParam("源数据") Long[] arr,
			@ApiParam("生成几位排列组合") @RequestParam(defaultValue = "3") int fetchCount) throws Exception {
		return trinityCombinationService.generate(arr, fetchCount);
	}

	@ApiOperation("排行榜")
	@GetMapping("/selectRankingList")
	public List<Map<String, Object>> selectRankingList(
			@ApiParam("源数据") @RequestParam(required = false, defaultValue = "3") int offsetStart,
			@ApiParam("前几位或后几位") @RequestParam(required = false, defaultValue = "10") int offsetend,
			@ApiParam("排序类型：0：升序；1：降序； 默认升序") @RequestParam(required = false, defaultValue = "0") String orderType)
			throws Exception {
		return trinityCombinationService.selectRankingList(offsetStart, offsetend, orderType);
	}
}
