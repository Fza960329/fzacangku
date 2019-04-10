package cn.com.taiji.domain;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, String>,JpaSpecificationExecutor<User>,PagingAndSortingRepository<User,String>{
/*	@Query("select d from Dept d where d.flag=1")
	List<User> findAllDepts();*/
	/*List<User> findByFlagAndParentIsNullOrderByDeptIndexAsc(@Param("flag") int i);*/
}
