package org.spring.data.jpa.example.domain.base;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Cacheable
public abstract class BaseNamed extends BaseAuditable {

    @Column(name = "name")
    protected String name;

    @Column(name = "description")
    protected String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
