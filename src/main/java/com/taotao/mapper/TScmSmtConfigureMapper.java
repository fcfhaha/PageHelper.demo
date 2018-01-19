package com.taotao.mapper;

import com.taotao.pojo.TScmSmtConfigure;
import com.taotao.pojo.TScmSmtConfigureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TScmSmtConfigureMapper {
    int countByExample(TScmSmtConfigureExample example);

    int deleteByExample(TScmSmtConfigureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TScmSmtConfigure record);

    int insertSelective(TScmSmtConfigure record);

    List<TScmSmtConfigure> selectByExample(TScmSmtConfigureExample example);

    TScmSmtConfigure selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TScmSmtConfigure record, @Param("example") TScmSmtConfigureExample example);

    int updateByExample(@Param("record") TScmSmtConfigure record, @Param("example") TScmSmtConfigureExample example);

    int updateByPrimaryKeySelective(TScmSmtConfigure record);

    int updateByPrimaryKey(TScmSmtConfigure record);
}