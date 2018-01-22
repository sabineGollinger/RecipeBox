package at.fh.ima.swengs.recipebox.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Michaela
 */

public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long> {

    public List<Recipe> findByName(@Param("name") String name);
    public List<Recipe> findByCategory(@Param("category") String category);
    public Recipe findById(@Param("id") long id);
    public List<Recipe> findByNameOrCategory(@Param("name") String name, @Param("category") String category);
    // public List<Recipe> findByUser(@Param("user") User user);

}
