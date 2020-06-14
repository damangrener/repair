package com.wtf.service.mapper;

import com.wtf.service.entity.po.StatusLog;
import com.wtf.service.entity.po.StatusLogExample;
import java.util.List;

import com.wtf.service.entity.vo.LogVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface StatusLogMapper {
    int countByExample(StatusLogExample example);

    int deleteByExample(StatusLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StatusLog record);

    int insertSelective(StatusLog record);

    List<StatusLog> selectByExample(StatusLogExample example);

    StatusLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StatusLog record, @Param("example") StatusLogExample example);

    int updateByExample(@Param("record") StatusLog record, @Param("example") StatusLogExample example);

    int updateByPrimaryKeySelective(StatusLog record);

    int updateByPrimaryKey(StatusLog record);

    List<Integer> getLog(String order);

    LogVO getNewestLog(@Param("order") String order,@Param("status")Integer status);

}