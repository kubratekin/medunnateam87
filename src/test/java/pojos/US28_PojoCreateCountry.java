package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class US28_PojoCreateCountry {

    private String name;
    private int id;

    public US28_PojoCreateCountry(String name) {
        this.name = name;
    }
    public US28_PojoCreateCountry(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public US28_PojoCreateCountry() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "US28_Pojo{" +
                "name='" + name + '\'' +
                '}';
    }
}



