package com.lottery.trinity.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lottery.trinity.model.entity.Combination;

@Mapper
public interface CombinationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Combination record);

    int insertSelective(Combination record);

    Combination selectByPrimaryKey(Long id);

    Combination selectByCombination(Long combination);

    int updateByPrimaryKeySelective(Combination record);

    int updateByPrimaryKey(Combination record);
}