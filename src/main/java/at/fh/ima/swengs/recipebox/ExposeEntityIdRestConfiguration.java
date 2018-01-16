package at.fh.ima.swengs.recipebox;

import at.fh.ima.swengs.recipebox.model.Recipe;
import at.fh.ima.swengs.recipebox.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class ExposeEntityIdRestConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Recipe.class);
        config.exposeIdsFor(User.class);
    }
}