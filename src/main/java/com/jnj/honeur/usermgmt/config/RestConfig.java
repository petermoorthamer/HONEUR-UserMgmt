package com.jnj.honeur.usermgmt.config;

import com.jnj.honeur.usermgmt.model.Permission;
import com.jnj.honeur.usermgmt.model.Role;
import com.jnj.honeur.usermgmt.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Role.class);
        config.exposeIdsFor(Permission.class);
    }

}
