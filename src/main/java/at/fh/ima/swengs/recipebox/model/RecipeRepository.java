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
    public List<Recipe> findByIngredient(@Param("ingredient") String ingredient);
    public Recipe findById(@Param("id") int id);
    //public List<Recipe> findByNameAndIngredient(@Param("name") String name, @Param("ingredient") String ingredient);


}
