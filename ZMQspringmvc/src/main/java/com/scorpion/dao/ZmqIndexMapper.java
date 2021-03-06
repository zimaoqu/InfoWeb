package com.scorpion.dao;

import com.scorpion.pojo.ZmqIndex;
import com.scorpion.pojo.ZmqIndexExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZmqIndexMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zmq_index
     *
     * @mbggenerated
     */
    int countByExample(ZmqIndexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zmq_index
     *
     * @mbggenerated
     */
    int deleteByExample(ZmqIndexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zmq_index
     *
     * @mbggenerated
     */
    int insert(ZmqIndex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zmq_index
     *
     * @mbggenerated
     */
    int insertSelective(ZmqIndex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zmq_index
     *
     * @mbggenerated
     */
    List<ZmqIndex> selectByExample(ZmqIndexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zmq_index
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ZmqIndex record, @Param("example") ZmqIndexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zmq_index
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ZmqIndex record, @Param("example") ZmqIndexExample example);
    List<String> getNameList();

    List<Integer> getIndexList(Map map);

    List<String> getDateList(Map map);

    List<Integer> getIndexListByDate(Map map);
}