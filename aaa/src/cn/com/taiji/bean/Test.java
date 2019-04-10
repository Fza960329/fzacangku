package cn.com.taiji.bean;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class Test {
	
	
	@PersistenceContext
	EntityManager em;

	public static void main(String[] args) {
		// 1. 创建EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-demo");

		// 2. 创建EntityManager
		EntityManager entityManager = factory.createEntityManager();

		add(entityManager);
//		search(entityManager, "tom");

		// 6. 关闭EntityManager
		entityManager.close();

		// 7. 关闭EntityManagerFactory
		factory.close();
	}

	public static void add(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// 4. 持久化操作
		User user = new User();
		user.setUsername("tom");
		user.setPassword("123456");
		

		// 添加user到数据库，相当于hibernate的save();
		entityManager.persist(user);

		// 5. 提交事务
		transaction.commit();

	}

	public static void search(EntityManager entityManager, String name) {

		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		List<User> list = entityManager.createQuery("SELECT u FROM User u WHERE u.name LIKE ?1")
				.setParameter(1, name).getResultList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
			}
		}
		//修改
		public static void alter(EntityManager entityManager){
			
			//3.开启事务
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			//List<User> list = entityManager.createQuery(" UPDATE User SET username= ?1,PASSWORD= ?2  WHERE id= ?3 ").setParameter(1, "WGC")
			User list =  entityManager.createQuery(" UPDATE User SET username= ?1,PASSWORD= ?2  WHERE id= ?3 ",User.class).setParameter(1, "WGC").setParameter(2, "66666").setParameter(3, 1).getSingleResult();
			
			transaction.commit();
		}
		
		//删除
		public static void delete(EntityManager entityManager) {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			User list =  entityManager.createQuery(" DELETE FROM user WHERE id= ?1 ",User.class).setParameter(1, 5).getSingleResult();
			
			transaction.commit();
		}
	
	}


