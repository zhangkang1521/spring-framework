package org.zk.dynamicdatasource.support;

/**
 * 数据源线程绑定
 */
public class DataSourceHolder {

    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();

    public static void setDataSource(String customerType) {
        dataSources.set(customerType);
    }
    public static String getDataSource() {
        return dataSources.get();
    }
    public static void clearDataSource() {
        dataSources.remove();
    }
}