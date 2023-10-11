public class LargeIntegerMultiplication {
    public static void main(String[] args) {
        String number1 = "123456789";
        String number2 = "0";

//        System.out.println(number1.substring(0, number1.length() / 2) + " " + number1.substring(number1.length() / 2));
        System.out.println(multiplyLarge(number1, number2));
    }

    public static String multiplyLarge(String num1, String num2) {
        if (num1.length() == 1 && num2.length() == 1) {
            return Long.parseLong(num1) * Long.parseLong(num2) + "";
        } else if (num1.length() == 1){
            num1 = "0" + num1;
        } else if (num2.length() == 1){
            num2 = "0" + num2;
        }
        int maxLength = Math.max(num1.length(), num2.length());
        int totalLength = 2;
        for (; totalLength < maxLength; totalLength *= 2);
        for (int i = num1.length(); i < totalLength; i++){
            num1 = "0" + num1;
        }
        for (int i = num2.length(); i < totalLength; i++){
            num2 = "0" + num2;
        }

        String a1, a0, b1, b0, c2, c1, c0;
        a1 = num1.substring(0, num1.length() / 2);
        a0 = num1.substring(num1.length() / 2);
        b1 = num2.substring(0, num2.length() / 2);
        b0 = num2.substring(num2.length() / 2);

        c2 = multiplyLarge(a1, b1);
        c0 = multiplyLarge(a0, b0);

        c1 = Long.parseLong(multiplyLarge(Long.parseLong(a1) + Long.parseLong(a0) + "",
                Long.parseLong(b1) + Long.parseLong(b0) + "")) - Long.parseLong(c0) - Long.parseLong(c2) + "";
        return Long.parseLong(concat0AtBack(c2, num1.length())) + Long.parseLong( concat0AtBack(c1, num1.length() / 2)) + Long.parseLong(c0) + "";
    }

    public static String concat0AtBack(String num, int num_zero){
        for (int i = 0; i < num_zero; i++){
            num += "0";
        }
        return num;
    }
}
