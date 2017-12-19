package at.fh.ima.swengs.recipebox.model;

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
    public List<User> findByFirstnameAndLastname(@Param("firstname") String firstname, @Param("lastname")String lastname);

}
