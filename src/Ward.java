import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Ward {
    private  int size;
    private int[] beds;

    public Ward(){
        size = 10;
        beds = new int[size];
        for(int bed : beds){
            bed = 0;
        }
    }

    public int setBed(int patientId){
        for(int i=0; i<beds.length;i++){
            if(beds[i] == 0){
                beds[i] = patientId;
                return i+1;
            }
        }
        return -1;
    }
    public void updateBeds(ArrayList<Patient> patients){
        for(int i=0; i< patients.size();i++){
            Patient patient = patients.get(i);
            if(patient.getPatientStatus().equals("Discharged")){
                for(int bed : beds){
                    if(bed == patient.getPatientId())
                        bed = 0;
                }
            }
        }
    }
}
