public class Change {
    String arab = "1,2,3,4,5,6,7,8,9,10";
    String rome = "I,II,III,IV,V,VI,VII,VIII,IX,X";
    byte vib;
    String[] line(String in) {
        String[] mas = in.split(" ");
        return mas;
    }

    void ArabOrRim(String []in){

    }

    int arab(String[] val) {
        int a = Integer.parseInt(val[0]);
        int b = Integer.parseInt(val[2]);
        switch (val[1]) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                break;
        }
        return 0;
    }
}