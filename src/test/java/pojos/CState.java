package pojos;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import java.util.Objects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CState {
    @JsonProperty("country")
    private Country country;
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    public CState() {
    }
    @JsonProperty("country")
    public Country getCountry() {
        return country;
    }
    @JsonProperty("country")
    public void setCountry(Country country) {
        this.country = country;
    }
    @JsonProperty("id")
    public long getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "CState{" +
                "country=" + country +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CState cState = (CState) o;
        return Objects.equals(country, cState.country) && Objects.equals(id, cState.id) && Objects.equals(name, cState.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(country, id, name);
    }
}