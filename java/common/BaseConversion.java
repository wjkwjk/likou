package common;

public class BaseConversion {

    public static void main(String[] args) {
        System.out.println(baseConversion(128,16));
    }

    static String baseConversion(int num, int base){
        StringBuilder s = new StringBuilder();
        while (num > 0){
            if (num % base < 10){
                s.insert(0,num % base);
            }else {
                s.insert(0, (char) (num % base + 31));
            }
            num /= base;
        }
        return s.toString();
    }

}
