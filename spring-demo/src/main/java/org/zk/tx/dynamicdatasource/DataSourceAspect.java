package org.zk.tx.dynamicdatasource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 此切面应优先于事务管理切面执行，否则事务管理器获取到的是默认的
 */
@Aspect
@Order(Integer.MAX_VALUE - 1) // 事务管理器默认优先级为Integer.MAX_VALUE
public class DataSourceAspect {

	private Log log = LogFactory.getLog(DataSourceAspect.class);

    @Pointcut("@annotation(ReadOnlyDataSource)")
    private void readOnly(){}


    @Before("readOnly()")
    public void before() {
	    log.info("切换数据源到slave");
	    DataSourceHolder.setDataSource("slave");
    }

	@After("readOnly()")
	public void after() {
		log.info("清除线程中的DataSource");
		DataSourceHolder.clearDataSource();
	}


}