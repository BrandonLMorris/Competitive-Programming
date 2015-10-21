import java.util.*;
import java.io.*;

public class Schedule {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (int t = 0;;t++) {
      int numAppointments = Integer.parseInt(in.readLine());
      if (numAppointments == 0) break;
      if (t != 0) System.out.println();
      ArrayList<Appointment> appointments =
          new ArrayList<Appointment>(numAppointments);
      for (int i = 0; i < numAppointments; i++) {
        appointments.add(new Appointment(in.readLine()));
      }
      Collections.sort(appointments);
      for (Appointment a : appointments) {
        System.out.println(a);
      }
    }

  }

  private static class Appointment implements Comparable<Appointment>{
    int hour;
    int minute;
    boolean isAm;
    public Appointment(String str) {

      StringBuilder hr = new StringBuilder();
      for (int i = 0; i < str.indexOf(':'); i++) {
        hr.append(str.charAt(i));
      }
      hour = Integer.parseInt(hr.toString());

      StringBuilder min = new StringBuilder();
      int pos = str.indexOf(':')+1;
      for (int i = pos; i < pos+2; i++) {
        min.append(str.charAt(i));
      }
      minute = Integer.parseInt(min.toString());

      isAm = str.charAt(str.length()-4) == 'a';
    }

    public int compareTo(Appointment that) {
      if (this.isAm != that.isAm) {
        return this.isAm ? -1 : 1;
      }
      if (this.hour != that.hour) {
        if (this.hour == 12) return -1;
        if (that.hour == 12) return 1;
        return this.hour - that.hour;
      }
      if (this.minute != that.minute) {
        return this.minute - that.minute;
      }
      return 0;
    }

    public String toString() {
      String minuteStr = Integer.toString(minute);
      if (minuteStr.length() == 1) minuteStr = "0" + minuteStr;
      return hour + ":" + minuteStr + " " + (isAm ? "a.m." : "p.m.");
    }
  }
}