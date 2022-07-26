package utilities;

import pojos.Appointment;
import pojos.Registrant;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TXTWriter {

    public  static void saveUIRegistrantData(Registrant registrant){

        try {
            //file creation
            FileWriter fw =new FileWriter(ConfigReader.getProperty("applicant_data"),true);

            //records creation
            BufferedWriter bw =new BufferedWriter(fw);
            bw.append(registrant.toString()+"\n");
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public  static void saveUIAppointmentData(Appointment appointment){

        try {
            //file creation
            FileWriter fw =new FileWriter(ConfigReader.getProperty("appointment_data"),true);

            //records creation
            BufferedWriter bw =new BufferedWriter(fw);
            bw.append(appointment.toString()+"\n");
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
