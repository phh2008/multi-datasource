package com.phh.config;

/**
 * <p> 数据源上下文 </p>
 *
 * @author phh
 * @version V1.0
 * @project: spring
 * @package com.phh.config
 * @date 2019/4/5
 */
public class DataSourceContextHelper {

    private static final ThreadLocal<DataSourceKey> contextHolder = ThreadLocal.withInitial(() -> DataSourceKey.MASTER);

    public static DataSourceKey get() {
        return contextHolder.get();
    }

    public static void set(DataSourceKey key) {
        contextHolder.set(key);
    }

    public static void clear() {
        contextHolder.remove();
    }

}
