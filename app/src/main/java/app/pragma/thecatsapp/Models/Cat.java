package app.pragma.thecatsapp.Models;

import com.google.gson.annotations.SerializedName;

public class Cat {
    @SerializedName("name")
    private String breedName;

    @SerializedName("origin")
    private String origin;

    @SerializedName("affection_level")
    private int affectionLevel;

    @SerializedName("intelligence")
    private int intelligence;

    @SerializedName("reference_image_id")
    private String imageUrl;

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getAffectionLevel() {
        return affectionLevel;
    }

    public void setAffectionLevel(int affectionLevel) {
        this.affectionLevel = affectionLevel;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}