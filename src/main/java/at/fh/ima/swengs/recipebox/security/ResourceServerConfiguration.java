package at.fh.ima.swengs.recipebox.security;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
 
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
 
    private static final String RESOURCE_ID = "my_rest_api";
     
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }
 
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .anonymous().and().authorizeRequests()
        .antMatchers(HttpMethod.POST,"/customers").authenticated()

        .and().anonymous().disable().requestMatchers()
        .antMatchers(HttpMethod.GET,"/users/**","/recipes/**")
        .antMatchers(HttpMethod.DELETE,"/users/*","/recipes/*")
        .antMatchers(HttpMethod.PUT,"/users/*","/recipes/*")
        .antMatchers(HttpMethod.PATCH, "/users/*")
        .antMatchers(HttpMethod.POST,"/users","/recipes")
        .and().authorizeRequests()
        .antMatchers("/cars/**","/recipes/**").access("hasRole('ADMIN') or hasRole('USER')")
        //.antMatchers("/profile/**").access("hasRole('ADMIN')")
        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }


}