package com.example.fitTrace.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fitTrace.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	   @Query("select e.balance from Account e where e.balance<(Select Max(e1.balance) from Account e1) order by  e.balance desc")
       public List<Double> get();
       
		/* Advantages of jpa query
		 * Database-side Processing:
		 * 
		 * The query executes directly in the database, leveraging its computational
		 * power. Ideal for large datasets, as databases are optimized for sorting,
		 * filtering, and aggregation. Better Performance for Large Datasets:
		 * 
		 * With JPA, the filtering, sorting, and MAX logic are handled in the database,
		 * and only the required results (e.g., second-highest balance) are fetched.
		 * This reduces the memory and CPU usage on the application side since only the
		 * result is transferred. Cleaner and More Maintainable Code:
		 * 
		 * Using JPA, the logic is abstracted into a query, making the code easier to
		 * read and maintain. Scalability:
		 * 
		 * Databases are highly optimized for handling large datasets, so JPA queries
		 * can handle larger accounts tab
		 */
	     //les without significant performance issues.//
	   
	  public Page<Account> findAllBy(Pageable p);
	   
}
