package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class US09_PatientsPojo {

//    private String createdBy;
//    private String createdDate;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    //private String ssn;
    private US09_UserPojo user ;

    public US09_PatientsPojo() {
    }

    public US09_PatientsPojo(String firstName, String lastName, String phone, String email) {
//        this.createdBy = createdBy;
//        this.createdDate = createdDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        //this.ssn = ssn;
    }
    public US09_PatientsPojo(String firstName, String lastName, String phone, String email, US09_UserPojo user) {
//        this.createdBy = createdBy;
//        this.createdDate = createdDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        //this.ssn = ssn;
        this.user = user;
    }

//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public String getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(String createdDate) {
//        this.createdDate = createdDate;
//    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getSsn() {
//        return ssn;
//    }
//
//    public void setSsn(String ssn) {
//        this.ssn = ssn;
//    }

    public US09_UserPojo getUser() {
        return user;
    }

    public void setUser(US09_UserPojo user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "US09_PatientsPojo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                //", ssn='" + ssn + '\'' +
                ", user=" + user +
                '}';
    }
}
