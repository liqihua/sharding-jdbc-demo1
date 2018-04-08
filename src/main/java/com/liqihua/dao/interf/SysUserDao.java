package com.liqihua.dao.interf;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysUserDao {

    public List<Map<String,Object>> findListSQL(@Param("sql") String sql);


}
