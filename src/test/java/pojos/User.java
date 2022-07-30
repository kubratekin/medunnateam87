package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty("activated")
    private boolean activated;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("email")
    private String email;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("id")
    private long id;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("langKey")
    private String langKey;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("login")
    private String login;
    /*
minLength: 1
maxLength: 50
pattern: ^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$
    * */
    @JsonProperty("resetDate")
    private String resetDate;
    @JsonProperty("ssn")
    private String ssn;
    /*
    * minLength: 0
    maxLength: 50
    pattern: ^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$
    * */
    public User() {
    }
    @JsonProperty("activated")
    public boolean getActivated() {
        return activated;
    }

    @JsonProperty("activated")
    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @JsonProperty("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("createdBy")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("createdDate")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("langKey")
    public String getLangKey() {
        return langKey;
    }

    @JsonProperty("langKey")
    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("login")
    public String getLogin() {
        return login;
    }

    @JsonProperty("login")
    public void setLogin(String login) {
        this.login = login;
    }

    @JsonProperty("resetDate")
    public String getResetDate() {
        return resetDate;
    }

    @JsonProperty("resetDate")
    public void setResetDate(String resetDate) {
        this.resetDate = resetDate;
    }

    @JsonProperty("ssn")
    public String getSsn() {
        return ssn;
    }

    @JsonProperty("ssn")
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "User{" +
                "activated=" + activated +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", langKey='" + langKey + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", resetDate='" + resetDate + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(activated, user.activated) && Objects.equals(createdBy, user.createdBy) && Objects.equals(createdDate, user.createdDate) && Objects.equals(email, user.email) && Objects.equals(firstName, user.firstName) && Objects.equals(id, user.id) && Objects.equals(imageUrl, user.imageUrl) && Objects.equals(langKey, user.langKey) && Objects.equals(lastName, user.lastName) && Objects.equals(login, user.login) && Objects.equals(resetDate, user.resetDate) && Objects.equals(ssn, user.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activated, createdBy, createdDate, email, firstName, id, imageUrl, langKey, lastName, login, resetDate, ssn);
    }
}
