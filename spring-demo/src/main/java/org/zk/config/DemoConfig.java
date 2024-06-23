package org.zk.config;

import org.springframework.context.annotation.*;
import org.zk.domain.User;
import org.zk.service.MyLifeCycleDemo;

// 引入properties配置文件，放入environment中
//@PropertySource("classpath:jdbc.properties")

// 引入xml配置
// @ImportResource("classpath:applicationContext.xml")

// 直接引入配置类，配置类也会成为一个bean
//@Import(FooConfig.class)
// 实现ImportSelector接口，返回配置类名的字符串
//@Import(MyImportSelector.class)
// 实现容器注册接口
//@Import(MyImportBeanDefinitionRegistrar.class)

// Enable类注解是对@Import进行包装，封装底层细节
//@EnableUser("test")

// 包扫描
@ComponentScan("org.zk.service")
@Configuration
public class DemoConfig {

    // 指定name+type，则按name+type去查找唯一匹配的bean，找不到，找到多个都报错
    // @Resource(type = User.class, name = "user22")

    // 按type去查找，找不到或找到多个，会报错
    // @Resource(type = User.class)

    // 按name去查询
    // @Resource(name = "user1")

    // 都不指定，按默认属性名查找，如果找不到，就按类型找（与Autowired区别）
//    @Resource
//    private User user3;

//    @Bean
//	public User user() throws Exception {
//		User user = new User();
//		user.setId(1);
//		return user;
//	}




//	@Bean
//	public FactoryBean<User> user2() {
//    	return new FactoryBean<User>() {
//
//			@Override
//			public User getObject() throws Exception {
//				return new User();
//			}
//
//			@Override
//			public Class<?> getObjectType() {
//				return User.class;
//			}
//
//			@Override
//			public boolean isSingleton() {
//				return true;
//			}
//		};
//	}

//    @Bean
//    public User user2() throws Exception {
//        User user = new User();
//        user.setId(2);
//        return user;
//    }


	// 命令参数(getProperties) > 环境变量(getEnv) > properties 文件
//	private String test;
//	private Map<String, String> map;

//	@Value("${jdbc.username}")
//	@Value("#{user.username}")
//	public void setTest(String test) {
//		this.test = test;
//	}

//	public void setMap(Map<String, String> map) {
//		this.map = map;
//	}

	// 容器后处理器，处理占位符，PropertyPlaceholderConfigurer不行，这个类不会从environment中读取配置
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}




//
//
//	@Bean(name = "order2")
//	public Order order2(User user) {
//		Order order1 = new Order();
//		order1.setId(2);
//		return order1;
//	}

//	@Bean
//	public User user0() {
//		return new User();
//	}





}
