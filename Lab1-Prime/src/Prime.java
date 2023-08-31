import java.util.Calendar;
import java.util.GregorianCalendar;

public class Prime {
    public static void main(String[] args) {
        System.out.println(currentTime() + "------------------------------------------------------------------------------");
        System.out.println(primeList(300000));
        System.out.println(currentTime() + "------------------------------------------------------------------------------");
        System.out.println(seiveOfEratoshenes(300000));
        System.out.println(currentTime() + "------------------------------------------------------------------------------");

    }

    public static String currentTime() {
        Calendar now = new GregorianCalendar();
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        int millisecond = now.get(Calendar.MILLISECOND);
        int ampm = now.get(Calendar.AM_PM);
        return (hour + (ampm > 0 ? "PM" : "AM") + ":" + minute + ":" + second + ":" + millisecond);
    }

    public static String seiveOfEratoshenes(int n){
        String result = "";
        int[] a = new int[n + 1];
        for (int i = 0; i < n + 1; i++){
            a[i] = i;
        }
        for (int p = 2; p <= Math.floor(Math.sqrt(n)); p++){
            if (a[p] != 0){
                int j = p * p;
                while (j <= n){
                    a[j] = 0;
                    j += p;
                }
            }
        }
        for (int i = 2; i < n + 1; i++){
            if (a[i] != 0){
                result += a[i] + ", ";
            }
        }
        return  result.substring(0, result.length() - 2);
    }

    public static String primeList(int n) {
        String result = "";
        for (int i = 2; i <= n; i++) {
            int j;
            for (j = 2; j < i; j++) if (i % j == 0) break;
            if (j == i) result += j + ", ";
        }
        return result.substring(0, result.length() - 2);
    }
}