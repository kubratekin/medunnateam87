package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class US28_PojoCreateStateCity {

    private String name;
    private US28_PojoCreateCountry country;

    public US28_PojoCreateCountry getCountry() {
        return country;
    }

    public void setCountry(US28_PojoCreateCountry country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "US28_PojoCreateStateCity{" +
                "name='" + name + '\'' +
                ", country=" + country +
                '}';
    }

    public US28_PojoCreateStateCity(String name,US28_PojoCreateCountry country) {
        this.name = name;
        this.country = country;
    }

    public US28_PojoCreateStateCity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    }

