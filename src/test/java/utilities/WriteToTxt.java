package utilities;

import pojos.Appointment;
import pojos.AppointmentOut;
import pojos.Registrant;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToTxt {


    public static void savePatientAppointmentData (AppointmentOut appointment[]) {

        try{
            FileWriter fw = new FileWriter(ConfigReader.getProperty("users_api_url"), true);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int i =0 ; i < appointment.length ; i++){

                bw.append(appointment[i].toString()+ "\n");
            }

            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void saveAppointmentData( Appointment[] appointments ) {

        try {
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("appointment_records"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (int i =0 ; i < appointments.length ; i++){

                writer.append(appointments[i].getPatient().getFirstName()+ "," + appointments[i].getPatient().getLastName()+ ",");

                if (appointments[i].getPatient().getUser()!=null){

                writer.append(appointments[i].getPatient().getUser().getSsn()+"\n");
            }else
            {
            writer.append("\n");
            }
            }
            writer.close();

           // ???Registrant registrant1 = new Registrant();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }



}

