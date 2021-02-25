package com.example.addressbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "buddyinfo", path = "buddyinfo")
public interface BuddyInfoRepository extends JpaRepository<BuddyInfo, Integer> {
    BuddyInfo findById(@Param("id") int id);
}
