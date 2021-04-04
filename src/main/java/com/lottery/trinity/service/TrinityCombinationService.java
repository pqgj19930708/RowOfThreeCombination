package com.lottery.trinity.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lottery.trinity.common.util.TrinityCombinationUtils;
import com.lottery.trinity.mapper.CombinationMapper;
import com.lottery.trinity.mapper.CombinationRecordMapper;
import com.lottery.trinity.model.entity.Combination;
import com.lottery.trinity.model.entity.CombinationRecord;

@Service
public class TrinityCombinationService {

	@Autowired
	private CombinationMapper combinationMapper;

	@Autowired
	private CombinationRecordMapper combinationRecordMapper;

	public Combination selectByPrimaryKey(Long id) {
		return combinationMapper.selectByPrimaryKey(id);
	}

	public List<Long> generate(Long[] arr, int fetchCount) {
		List<Long> generateList = TrinityCombinationUtils.generate(arr, fetchCount);
		for (int i = 0; i < generateList.size(); i++) {
			Combination combination = combinationMapper.selectByCombination(generateList.get(i));
			if (null != combination) {
				CombinationRecord record = new CombinationRecord();
				record.setcId(combination.getId());
				Long sequence = combinationRecordMapper.selectByCid(combination.getId());
				record.setSequence(null == sequence ? 0 : sequence);
				record.setCreateTime(new Date());
				record.setType(combination.getType());
				combinationRecordMapper.insert(record);
			}
		}
		return generateList;
	}

	public List<Map<String, Object>> selectRankingList(int offsetStart, int offsetend, String orderType) {
		Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("offsetStart", offsetStart);
		map.put("offsetend", offsetend);
		map.put("orderType", orderType);
		return combinationRecordMapper.selectRankingList(map);
	}

}
