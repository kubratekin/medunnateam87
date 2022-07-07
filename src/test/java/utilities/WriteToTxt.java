package utilities;

import pojos.Appointment;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToTxt {


    public static void saveUIAppointmentData(Appointment[] appointment) {

        try{
            FileWriter fw = new FileWriter(ConfigReader.getProperty("users_api_url"), true);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int i =0 ; i < appointment.length ; i++){

                bw.append(appointment[i].toString()+ "\n");
            }

            //  bw.append(us007_appointment.toString()+"\n");

            bw.close();

        }catch(Exception e){

            e.printStackTrace();


        }


    }


}

