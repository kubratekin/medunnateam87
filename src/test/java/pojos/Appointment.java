package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Appointment {
    /* "lastName": "string",
                "phone": "string",
                "ssn": "632-76-7763",
                "user": {
            "activated": true,
                    "createdBy": "string",
                    "createdDate": "2022-07-02T07:36:28.746Z",
                    "email": "string",
                    "firstName": "string",
                    "id": 0,
                    "imageUrl": "string",
                    "langKey": "string",
                    "lastName": "string",
                    "login": "string",
                    "resetDate": "2022-07-02T07:36:28.746Z",
                    "ssn": "528-34-0040"
        }*/

    private String firstName;
    private String lastName;
    private String email;
    private String ssn;
    private String phone;
    private String createdDate;
    private int id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {

        this.ssn = ssn;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreatedDate() {

        return createdDate;
    }

    public void setCreatedDate(String createdDate) {

        this.createdDate = createdDate;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return "U007_Appointment{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", ssn='" + ssn + '\'' +
                ", phone='" + phone + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id=" + id +
                '}';
    }
}

