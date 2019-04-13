package com.phh.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <p> 动态数据源 </p>
 *
 * @author phh
 * @version V1.0
 * @project: spring
 * @package com.phh.config
 * @date 2019/4/5
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHelper.get();
    }
}
