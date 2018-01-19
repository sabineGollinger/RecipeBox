package at.fh.ima.swengs.recipebox.model;

import at.fh.ima.swengs.recipebox.util.JsonDateDeserializer;
import at.fh.ima.swengs.recipebox.util.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Michaela
 */

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String category;
    private String ingredient;
    private String preparation;
    private String hint;

    @ManyToOne
    private User user;

    //private String image;

    /*
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @Temporal(TemporalType.DATE)
    private Date addedDate;
    */

    @Version
    private long version;

    public Recipe() {
    }

    public Recipe(String name, String category, String ingredient, String preparation, String hint, User user) {
        this.name = name;
        this.category = category;
        this.ingredient = ingredient;
        this.preparation = preparation;
        this.hint = hint;
        this.user = user;
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

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getHint() { return hint; }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public User getUsername() { return user; }

    public void setUsername(User user) { this.user = user; }

    // public Date getAddedDate() { return addedDate; }

    // public void setAddedDate(String user) { this.addedDate = addedDate; }

}
