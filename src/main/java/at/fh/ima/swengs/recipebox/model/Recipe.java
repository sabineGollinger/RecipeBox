package at.fh.ima.swengs.recipebox.model;

import at.fh.ima.swengs.recipebox.util.JsonDateDeserializer;
import at.fh.ima.swengs.recipebox.util.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sabine on 18.12.2017.
 */
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String category;

    private String ingredients;

    private String preparation;

    private String hints;

    @ManyToOne
    private String user;

    private String image;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @Temporal(TemporalType.DATE)
    private Date addedDate;

    @JsonIgnore
    //private String password;

    //TODO: OneToMany Recipe
    /*
    @OneToMany(mappedBy = "user",orphanRemoval = true)
    private List<recipe> bookings;
    */

    @Version
    private long version;


    public Recipe() {
    }

    public Recipe(String name, String category, String ingredients, String preparation, String hints) {
        this.name = name;
        this.category = category;
        this.ingredients = ingredients;
        this.preparation = preparation;
        this.hints = hints;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getingredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getHints() {
        return hints;
    }

    public void setHints(String hints) {
        this.hints = hints;
    }

    public String getUser() { return user; }

    public void setUser(String user) { this.user = user; }


}
