package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.client;




public interface clientRepository extends JpaRepository <client, Long> {
	
@Query(value="select * from TBLCLIENT where IS_ACTIVE='Y'", nativeQuery=true)
public List<client> findActive();

@Query(value="select * from TBLCLIENT" +
                 "where CLIENT_ID like '%'+ ?1 + '%'" +
                 "or CLIENT_NAME like '%'+ ?1 + '%'" + 
		              " ) and IS_ACTIVE='Y'", nativeQuery=true)
public List<client> findBySearch(String search);

@Query(value="select * from TBLCLIENT " +
	     "where CLIENT_ID like '%'+ ?1 + '%'" +
         "or CLIENT_NAME like '%'+ ?1 + '%'" , nativeQuery=true)

public List<client> findAllBySearch(String search);

@Query(value="select * from TBLCLIENT" +
          "where CLIENT_ID like CASE.WHEN ?1=0 THEN CLIENT_ID ELSE ?1 END" +
		  "and CLIENT_NAME  like CASE.WHEN ?2=0 THEN CLIENT_NAME ELSE ?2 END " +
		  "and CLIENT_ADDRESS  like CASE.WHEN ?3=0 THEN CLIENT_ADDRESS ELSE ?3 END " +
               "and IS_ACTIVE='Y'", nativeQuery=true)
public List<client> findByAdvancedSearh(int CLIENT_ID , String CLIENT_NAME , String CLIENT_ADDRESS);

@Query(value="select * from TBLCLIENT" +
		 "where CLIENT_ID like CASE.WHEN ?1=0 THEN CLIENT_ID ELSE ?1 END" +
		  "and CLIENT_NAME  like CASE.WHEN ?2=0 THEN CLIENT_NAME ELSE ?2 END " +
		  "and CLIENT_ADDRESS  like CASE.WHEN ?3=0 THEN CLIENT_ADDRESS ELSE ?3 END ", nativeQuery=true)
public List<client> findAllByAdvancedSearch(int CLIENT_ID , String CLIENT_NAME , String CLIENT_ADDRESS);

}
