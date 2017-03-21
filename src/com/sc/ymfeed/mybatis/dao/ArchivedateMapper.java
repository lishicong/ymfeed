package com.sc.ymfeed.mybatis.dao;

import com.sc.ymfeed.mybatis.dto.Archivedate;
import com.sc.ymfeed.mybatis.dto.ArchivedateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArchivedateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b3_solo_archiveDate
     *
     * @mbg.generated Mon Mar 20 18:35:37 CST 2017
     */
    long countByExample(ArchivedateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b3_solo_archiveDate
     *
     * @mbg.generated Mon Mar 20 18:35:37 CST 2017
     */
    int deleteByExample(ArchivedateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b3_solo_archiveDate
     *
     * @mbg.generated Mon Mar 20 18:35:37 CST 2017
     */
    int deleteByPrimaryKey(String oid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b3_solo_archiveDate
     *
     * @mbg.generated Mon Mar 20 18:35:37 CST 2017
     */
    int insert(Archivedate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b3_solo_archiveDate
     *
     * @mbg.generated Mon Mar 20 18:35:37 CST 2017
     */
    int insertSelective(Archivedate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b3_solo_archiveDate
     *
     * @mbg.generated Mon Mar 20 18:35:37 CST 2017
     */
    List<Archivedate> selectByExample(ArchivedateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b3_solo_archiveDate
     *
     * @mbg.generated Mon Mar 20 18:35:37 CST 2017
     */
    Archivedate selectByPrimaryKey(String oid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b3_solo_archiveDate
     *
     * @mbg.generated Mon Mar 20 18:35:37 CST 2017
     */
    int updateByExampleSelective(@Param("record") Archivedate record, @Param("example") ArchivedateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b3_solo_archiveDate
     *
     * @mbg.generated Mon Mar 20 18:35:37 CST 2017
     */
    int updateByExample(@Param("record") Archivedate record, @Param("example") ArchivedateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b3_solo_archiveDate
     *
     * @mbg.generated Mon Mar 20 18:35:37 CST 2017
     */
    int updateByPrimaryKeySelective(Archivedate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b3_solo_archiveDate
     *
     * @mbg.generated Mon Mar 20 18:35:37 CST 2017
     */
    int updateByPrimaryKey(Archivedate record);
}