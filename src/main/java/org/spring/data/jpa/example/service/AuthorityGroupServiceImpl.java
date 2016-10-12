package org.spring.data.jpa.example.service;

import org.spring.data.jpa.example.domain.security.AuthorityGroup;
import org.spring.data.jpa.example.repository.AuthorityGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class AuthorityGroupServiceImpl implements AuthorityGroupService {

    private final AuthorityGroupRepository authorityGroupRepository;

    @Autowired
    public AuthorityGroupServiceImpl(final AuthorityGroupRepository authorityGroupRepository) {
        this.authorityGroupRepository = authorityGroupRepository;
    }

    @Override
    public AuthorityGroup findOne(final Long id) throws Exception {
        return authorityGroupRepository.findOne(id);
    }

    @Override
    public void insert(final AuthorityGroup authorityGroup) throws Exception {
        authorityGroupRepository.save(authorityGroup);
    }

    @Override
    public void update(final AuthorityGroup authorityGroup) throws Exception {
        authorityGroupRepository.save(authorityGroup);
    }

    @Override
    public void delete(final AuthorityGroup authorityGroup) throws Exception {
        authorityGroupRepository.delete(authorityGroup);
    }

}
