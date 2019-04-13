package com.phh.aop;

import com.phh.annotation.DS;
import com.phh.config.DataSourceContextHelper;
import com.phh.config.DataSourceKey;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * <p> TODO
 *
 * @author phh
 * @version V1.0
 * @project: spring
 * @package com.phh.aop
 * @date 2019/4/5
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Before("execution(public * com.phh.service..*.*(..))&&@annotation(ds)")
    public void beforeSwitchDataSource(JoinPoint point, DS ds) {
        DataSourceKey dataSource = ds.value();
        // 切换数据源
        DataSourceContextHelper.set(dataSource);
    }

    @After("execution(public * com.phh.service..*.*(..))&&@annotation(ds)")
    public void afterSwitchDataSource(JoinPoint point, DS ds) {
        DataSourceContextHelper.clear();
    }

}
