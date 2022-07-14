package utilities;

import pojos.*;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToTxt {



    public static void saveRegistrantData(Registrant registrant){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("api_registrant_data"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);


            writer.append(registrant+"\n");


            writer.close();




        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void saveAppointData(Appointment appointment){

        try{

            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("appointment_records"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(appointment+"\n");


            writer.close();



        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public static <Appointments> void saveAppointData(Appointments appointment){

        try{

            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("appointment_records"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(appointment+"\n");


            writer.close();



        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public static <Appointments> void saveApiAppointmentData(Appointments appointment) {
        try {
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("api_appointment_data"), true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(appointment + "\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static <AppointmentGet> void saveAppointmentCreation(AppointmentGet appointmentGet){
        try{

            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("appointment_creation_records"), true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(appointmentGet+"\n");
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static <TestItem> void saveTestItemData(TestItem testItem) {
        try {
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("api_test_itmes_data"), true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(testItem + "\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveRoomData(String roomNumber, int price, String createdDate){
        try{

            FileWriter fileWriter = new FileWriter("./src/test/resources/testdata/RoomData.txt", false);

            BufferedWriter writer = new BufferedWriter(fileWriter);


            writer.append("Room "+roomNumber+"\n");

            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}