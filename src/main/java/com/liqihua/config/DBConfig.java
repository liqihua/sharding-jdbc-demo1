package com.liqihua.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.MasterSlaveRuleConfiguration;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import javax.xml.transform.Source;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.*;
/*

@Configuration
public class DBConfig {
    @Value("classpath:database.json")
    private Resource jsonDatabase;


    @Bean
    @Lazy
    public List<Database> databases() throws IOException {
        String databaseStr = IOUtils.toString(jsonDatabase.getInputStream(), Charset.forName("UTF-8"));
        List<Database> databases = new Gson().fromJson(databaseStr, new TypeToken<List<Database>>() {}.getType());
        return databases;
    }

    @Bean
    public HashMap<String, DataSource> dataSourceMap(List<Database> databases) {
        HashMap<String, DataSource> dataSourceMap = new HashMap<String, DataSource>();
        for (Database database : databases) {
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.url(database.getUrl());
            dataSourceBuilder.driverClassName(database.getDriveClassName());
            dataSourceBuilder.username(database.getUsername());
            dataSourceBuilder.password(database.getPassword());
            DataSource dataSource = dataSourceBuilder.build();
            dataSourceMap.put(database.getName(), dataSource);
        }
        return dataSourceMap;
    }

    @Bean
    public HashMap<String, DataSource> dataMasterSourceMap(List<Database> databases) throws SQLException {
        HashMap<String, DataSource> dataSourceMap = new HashMap<String, DataSource>();
        for (Database database : databases) {

            if(database.getSlaves() != null && database.getSlaves().size()>0){
                MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration();
                masterSlaveRuleConfig.setName(database.getName());
                masterSlaveRuleConfig.setMasterDataSourceName(database.getName());

                Map<String, DataSource> map = new HashMap<String, DataSource>();
                map.put(database.getName(), createDataSource(database));
                for(Database slave : database.getSlaves()){
                    map.put(slave.getName(), createDataSource(slave));
                    masterSlaveRuleConfig.getSlaveDataSourceNames().add(slave.getName());
                }
                DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(map, masterSlaveRuleConfig,new HashMap<String, Object>());
                dataSourceMap.put(database.getName(), dataSource);
            }else {
                dataSourceMap.put(database.getName(), createDataSource(database));
            }
        }
        return dataSourceMap;
    }



    */
/*@Bean
    @Primary
    public DataSource shardingDataSource(HashMap<String, DataSource> dataMasterSourceMap) {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("masterDataSource0", masterDataSource0);
        dataSourceMap.put("slaveDataSource00", slaveDataSource00);
        dataSourceMap.put("slaveDataSource01", slaveDataSource01);

        dataSourceMap.put("masterDataSource1", masterDataSource1);
        dataSourceMap.put("slaveDataSource10", slaveDataSource10);
        dataSourceMap.put("slaveDataSource11", slaveDataSource11);

// 构建读写分离配置
        MasterSlaveRuleConfiguration masterSlaveRuleConfig0 = new MasterSlaveRuleConfiguration();
        masterSlaveRuleConfig0.setName("ds_0");
        masterSlaveRuleConfig0.setMasterDataSourceName("masterDataSource0");
        masterSlaveRuleConfig0.getSlaveDataSourceNames().add("slaveDataSource00");
        masterSlaveRuleConfig0.getSlaveDataSourceNames().add("slaveDataSource01");

        MasterSlaveRuleConfiguration masterSlaveRuleConfig1 = new MasterSlaveRuleConfiguration();
        masterSlaveRuleConfig1.setName("ds_1");
        masterSlaveRuleConfig1.setMasterDataSourceName("masterDataSource1");
        masterSlaveRuleConfig1.getSlaveDataSourceNames().add("slaveDataSource10");
        masterSlaveRuleConfig1.getSlaveDataSourceNames().add("slaveDataSource11");

// 通过ShardingSlaveDataSourceFactory继续创建ShardingDataSource
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getMasterSlaveRuleConfigs().add(masterSlaveRuleConfig0);
        shardingRuleConfig.getMasterSlaveRuleConfigs().add(masterSlaveRuleConfig1);

        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig);

        return shardingDataSource;
    }*//*



    private List<DataSource> createDataSourceList(List<Database> databaseList) {
        List<DataSource> dataSourceList = new ArrayList<DataSource>();
        for (Database database : databaseList) {
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setDriverClassName(database.getDriveClassName());
            dataSource.setUrl(database.getUrl());
            dataSource.setUsername(database.getUsername());
            dataSource.setPassword(database.getPassword());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }



    private DataSource createDataSource(Database database) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(database.getDriveClassName());
        dataSource.setUrl(database.getUrl());
        dataSource.setUsername(database.getUsername());
        dataSource.setPassword(database.getPassword());
        return dataSource;
    }






}
*/
