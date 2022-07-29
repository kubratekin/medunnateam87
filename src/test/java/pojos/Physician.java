package pojos;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import java.util.List;
import java.util.Objects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Physician {
    @JsonProperty("adress")
    private String adress;
    @JsonProperty("appointments")
    private List<Appointment> appointments;
    @JsonProperty("birthDate")
    private String birthDate;
    //Apositive, Anegative, Bpositive, Bnegative, Opositive, Onegative, ABpositive, ABnegative
    @JsonProperty("bloodGroup")
    private String bloodGroup;
    @JsonProperty("country")
    private Country country;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("cstate")
    private CState cstate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("examFee")
    private double examFee;
    @JsonProperty("firstName")
    private String firstName;
    //MALE, FEMALE, OTHER
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("id")
    private long id;
    @JsonProperty("image")
    private String image;
    @JsonProperty("imageContentType")
    private String imageContentType;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("phone")
    private String phone;
    //ALLERGY_IMMUNOLOGY, ANESTHESIOLOGY, DERMATOLOGY,
    // DIAGNOSTIC_RADIOLOGY, EMERGENCY_MEDICINE, FAMILY_MEDICINE,
    // INTERNAL_MEDICINE, MEDICAL_GENETICS, NEUROLOGY,
    // NUCLEAR_MEDICINE, OBSTETRICS_GYNECOLOGY, OPHTHALMOLOGY,
    // PATHOLOGY, PEDIATRICS, PHYSICALMEDICINE_REHABILITATION,
    // PREVENTIVE_MEDICINE, PSYCHIATRY, RADIATION_ONCOLOGY, SURGERY, UROLOGY
    @JsonProperty("speciality")
    private String speciality;
    @JsonProperty("ssn")
    private String ssn;//pattern: ^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$
    @JsonProperty("user")
    private User user;
    public Physician() {
    }
    @JsonProperty("adress")
    public String getAdress() {
        return adress;
    }
    @JsonProperty("adress")
    public void setAdress(String adress) {
        this.adress = adress;
    }
    @JsonProperty("appointments")
    public List<Appointment> getAppointments() {
        return appointments;
    }
    @JsonProperty("appointments")
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    @JsonProperty("birthDate")
    public String getBirthDate() {
        return birthDate;
    }
    @JsonProperty("birthDate")
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    @JsonProperty("bloodGroup")
    public String getBloodGroup() {
        return bloodGroup;
    }
    @JsonProperty("bloodGroup")
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    @JsonProperty("country")
    public Country getCountry() {
        return country;
    }
    @JsonProperty("country")
    public void setCountry(Country country) {
        this.country = country;
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
    @JsonProperty("cstate")
    public CState getCstate() {
        return cstate;
    }
    @JsonProperty("cstate")
    public void setCstate(CState cstate) {
        this.cstate = cstate;
    }
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }
    @JsonProperty("examFee")
    public double getExamFee() {
        return examFee;
    }
    @JsonProperty("examFee")
    public void setExamFee(double examFee) {
        this.examFee = examFee;
    }
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }
    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }
    @JsonProperty("id")
    public long getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }
    @JsonProperty("image")
    public String getImage() {
        return image;
    }
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }
    @JsonProperty("imageContentType")
    public String getImageContentType() {
        return imageContentType;
    }
    @JsonProperty("imageContentType")
    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }
    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @JsonProperty("speciality")
    public String getSpeciality() {
        return speciality;
    }
    @JsonProperty("speciality")
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    @JsonProperty("ssn")
    public String getSsn() {
        return ssn;
    }
    @JsonProperty("ssn")
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    @JsonProperty("user")
    public User getUser() {
        return user;
    }
    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Physician{" +
                "adress='" + adress + '\'' +
                ", appointments=" + appointments +
                ", birthDate='" + birthDate + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", country=" + country +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", cstate=" + cstate +
                ", description='" + description + '\'' +
                ", examFee=" + examFee +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", image='" + image + '\'' +
                ", imageContentType='" + imageContentType + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", speciality='" + speciality + '\'' +
                ", ssn='" + ssn + '\'' +
                ", user=" + user +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Physician physician = (Physician) o;
        return Objects.equals(adress, physician.adress) && Objects.equals(appointments, physician.appointments) && Objects.equals(birthDate, physician.birthDate) && Objects.equals(bloodGroup, physician.bloodGroup) && Objects.equals(country, physician.country) && Objects.equals(createdBy, physician.createdBy) && Objects.equals(createdDate, physician.createdDate) && Objects.equals(cstate, physician.cstate) && Objects.equals(description, physician.description) && Objects.equals(examFee, physician.examFee) && Objects.equals(firstName, physician.firstName) && Objects.equals(gender, physician.gender) && Objects.equals(id, physician.id) && Objects.equals(image, physician.image) && Objects.equals(imageContentType, physician.imageContentType) && Objects.equals(lastName, physician.lastName) && Objects.equals(phone, physician.phone) && Objects.equals(speciality, physician.speciality) && Objects.equals(ssn, physician.ssn) && Objects.equals(user, physician.user);
    }
    @Override
    public int hashCode() {
        return Objects.hash(adress, appointments, birthDate, bloodGroup, country, createdBy, createdDate, cstate, description, examFee, firstName, gender, id, image, imageContentType, lastName, phone, speciality, ssn, user);
    }
}

