package org.spring.data.jpa.example.service;

import org.spring.data.jpa.example.domain.security.AuthorityGroup;

public interface AuthorityGroupService {

    AuthorityGroup findOne(final Long id) throws Exception;

    void insert(final AuthorityGroup authorityGroup) throws Exception;

    void update(final AuthorityGroup authorityGroup) throws Exception;

    void delete(final AuthorityGroup authorityGroup) throws Exception;

}
