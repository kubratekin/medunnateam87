package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class US17_Pojo {

    private String name;
    private String description;
    private int price;
    private int defaultValMax;
    private int defaultValMin;

    public US17_Pojo(String name, String description, int price, int defaultValMax, int defaultValMin) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.defaultValMax = defaultValMax;
        this.defaultValMin = defaultValMin;
    }

    public US17_Pojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDefaultValMax() {
        return defaultValMax;
    }

    public void setDefaultValMax(int defaultValMax) {
        this.defaultValMax = defaultValMax;
    }

    public int getDefaultValMin() {
        return defaultValMin;
    }

    public void setDefaultValMin(int defaultValMin) {
        this.defaultValMin = defaultValMin;
    }

    @Override
    public String toString() {
        return "US17_Pojo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", defaultValMax=" + defaultValMax +
                ", defaultValMin=" + defaultValMin +
                '}';
    }


}
