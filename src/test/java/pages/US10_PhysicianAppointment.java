package pages;

public class US10_PhysicianAppointment {

    public String patient;
    private String id;
    private String startDate;
    private String endDate;
    private String status;
    public String ssn;
    public String user;

    @Override
    public String toString() {
        return "DoctorAppointment{" +
                "id='" + id + '\'' +
                ", start_date='" + startDate + '\'' +
                ", end_date='" + endDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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

    public US10_PhysicianAppointment() {
    }

    public US10_PhysicianAppointment(String  id, String startDate, String endDate, String status) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }


}
