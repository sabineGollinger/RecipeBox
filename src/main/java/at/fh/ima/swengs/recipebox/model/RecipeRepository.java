package at.fh.ima.swengs.recipebox.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Sabine on 18.12.2017.
 */
public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long> {

    public List<Recipe> findByName(@Param("name") String name);
    public List<Recipe> findByCategory(@Param("category") String category);
    public List<Recipe> findByIngredients(@Param("ingredients") String ingredients);
    public List<Recipe> findByNameAndIngredients(@Param("name") String name, @Param("ingredients") String ingredients);


}
