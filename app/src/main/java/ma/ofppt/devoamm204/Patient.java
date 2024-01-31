package ma.ofppt.devoamm204;

import android.annotation.SuppressLint;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Patient implements Serializable {
    static List<Patient> list = new ArrayList<>();
    String cin;
    String nom;
    int age;
static List<Patient> getLstPatients(){
    return list;
}
static void addPatient(Patient patient){
    list.add(patient);
}

void getDate(){
    @SuppressLint({"NewApi", "LocalSuppress"})
    LocalDate today = LocalDate.now();
    @SuppressLint({"NewApi", "LocalSuppress"}) LocalTime now = LocalTime.now();

}
}
