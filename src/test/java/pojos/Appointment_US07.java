package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Appointment_US07 {

    private String createdBy;
    private String createdDate;
    private int id;
    private String endDate;
    private String status;
    private String anamnesis;
    private String treatment;
    private String diagonosis;
    private String prescription;

    private Patient_US07 patient;

    public Appointment_US07(String createdBy, String createdDate, int id, String endDate, String status, String anamnesis, String treatment, String diagonosis, String prescription, Patient_US07 patient) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.id = id;
        this.endDate = endDate;
        this.status = status;
        this.anamnesis = anamnesis;
        this.treatment = treatment;
        this.diagonosis = diagonosis;
        this.prescription = prescription;
        this.patient = patient;
    }

    public Appointment_US07() {
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDiagonosis() {
        return diagonosis;
    }

    public void setDiagonosis(String diagonosis) {
        this.diagonosis = diagonosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Patient_US07 getPatient() {
        return patient;
    }

    public void setPatient(Patient_US07 patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id=" + id +
                ", endDate='" + endDate + '\'' +
                ", status='" + status + '\'' +
                ", anamnesis='" + anamnesis + '\'' +
                ", treatment='" + treatment + '\'' +
                ", diagonosis='" + diagonosis + '\'' +
                ", prescription='" + prescription + '\'' +
                ", patient=" + patient +
                '}';
    }
}
