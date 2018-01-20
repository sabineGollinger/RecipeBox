package at.fh.ima.swengs.recipebox.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

/**
 * http://docs.spring.io/spring-data/rest/docs/current/reference/html/
 */
@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    //This would be exposed under the URL: http://localhost:8080/user/search/findByFirstNameAndLastName

    //http://localhost:8080/users/search/findByFirstnameAndLastname?firstname=sabine&lastname=gollinger
    public List<User> findByFirstnameAndLastname(@Param("firstname") String firstname, @Param("lastname")String lastname);

    //http://localhost:8080/users/search/findByEmail?email=sabine.gollinger@edu.fh-joanneum.at
    public User findByEmail(@Param("email") String email);

    //http://localhost:8080/users/search/findById?id=1
    public User findById(@Param("id") long id);

    //http://localhost:8080/users/search/findByUsernameAndPassword
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
