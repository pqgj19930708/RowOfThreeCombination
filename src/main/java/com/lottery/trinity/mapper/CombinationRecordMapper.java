package com.lottery.trinity.mapper;

import java.util.List;
import java.util.Map;

import com.lottery.trinity.model.entity.CombinationRecord;

public interface CombinationRecordMapper {
	int deleteByPrimaryKey(Long id);

	int insert(CombinationRecord record);

	int insertSelective(CombinationRecord record);

	CombinationRecord selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(CombinationRecord record);

	int updateByPrimaryKey(CombinationRecord record);

	Long selectByCid(Long cId);

	List<Map<String, Object>> selectRankingList(Map<String, Object> map);
}