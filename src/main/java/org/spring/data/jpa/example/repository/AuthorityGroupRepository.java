package org.spring.data.jpa.example.repository;

import org.spring.data.jpa.example.domain.security.AuthorityGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityGroupRepository extends CrudRepository<AuthorityGroup, Long> {

}


