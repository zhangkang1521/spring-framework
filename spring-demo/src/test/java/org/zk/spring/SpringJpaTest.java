package org.zk.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zk.config.JpaConfig;
import org.zk.entity.UserEntity;
import org.zk.repo.UserRepo;
import org.zk.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class SpringJpaTest {

	@Test
	public void test1() {
		// PersistenceAnnotationBeanPostProcessor 支持@PersistenceContext @PersistenceUnit
		// SharedEntityManagerCreator$SharedEntityManagerInvocationHandler 对@PersistenceContext注入的EntityManager进行代理
		// spring-boot能使用@Autowired注入
		// 是因为EntityManagerBeanDefinitionRegistrarPostProcessor注入了SharedEntityManagerCreator factory-method:createSharedEntityManager
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		UserEntity user = userService.find(1);
		System.out.println(user);
	}

	@Test
	public void testRepo() {
		// org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
		UserRepo userRepo = ctx.getBean(UserRepo.class);
		List<UserEntity> userList = userRepo.findByUsername("11");
		System.out.println(userList);
	}

	@Test
	public void testCriteria() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
		EntityManagerFactory entityManagerFactory = ctx.getBean(EntityManagerFactory.class);
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserEntity> query = cb.createQuery(UserEntity.class);
		Root<UserEntity> root = query.from(UserEntity.class);
		query.select(root);

		Predicate predicate1 = cb.and(cb.equal(root.get("username"), "11"));
		query.where(predicate1);

		TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);
		List<UserEntity> userList = typedQuery.getResultList();

	}
}
