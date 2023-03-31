import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            System.out.println(calc(Input.scan()));
        }


        public static String calc(String input) {
            Input in= new Input();
            return in.sravn(input);
        }
    }

//###############################################################
    class Input {
        public static String str;//введённая строка
        String[] mas; //разделённый массив строк
        String a1, a2; //строки переменных
        String zn;//строка знака
        int num1, num2; //полученные значения после проверки

        public static String scan() { //метод обработки введённой строки
            System.out.println("Введите пример с римскими или арабскими числами от 1 до 10  : ");
            Scanner sc = new Scanner(System.in);
            str = sc.nextLine();
            return str;
        }

        String sravn(String i) {//метод проверки введённых данных на соответствие формата задания
        try {
            mas = i.split(" ");
            a1 = mas[0];
            a2 = mas[2];
            zn = mas[1];
        }
        catch (ArrayIndexOutOfBoundsException e ) {
            System.out.println("неправильный формат ввода данных");
        }
            int a = 0;
            int r = 0;

            String[] ar = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};


            for (String string : ar) {//проверка того, что цифра арабская и меньше 11
                if (a1.equals(string) == true) {
                    a = 1;
                    break;
                }
            }

            if (a == 1) {
                for (String str : ar) {
                    if (a2.equals(str) == true) {
                        a = 2;
                        break;
                    }
                }
            }
            if (a == 2) {
                num1 = Integer.parseInt(a1);
                num2 = Integer.parseInt(a2);
                return "результат : " + result(zn);
            }

            else {
                for (String string : rim) {
                    if (a1.equals(string) == true) {
                        r = 1;
                        break;
                    }
                }

                if (r == 1) {
                    for (String str : rim) {
                        if (a2.equals(str) == true) {
                            r = 2;
                            break;
                        }
                    }
                }
                if (r == 2) {
                    num1= converter(a1);
                    num2= converter(a2);
                    return "результат : " +  reconverter(result(zn));
                }
            }
           return "неправильный формат ввода данных,попробуйте ещё раз";
        }


        int converter(String c) {
            if (c.equals("I")) return 1;
            if (c.equals("II")) return 2;
            if (c.equals("III")) return 3;
            if (c.equals("IV")) return 4;
            if (c.equals("V")) return 5;
            if (c.equals("VI")) return 6;
            if (c.equals("VII")) return 7;
            if (c.equals("VIII")) return 8;
            if (c.equals("IX")) return 9;
            if (c.equals("X")) return 10;
            return 0;
        }

        String reconverter(int x){
         int des= x/10;
         int ed= x % 10;
         String rimd []  ={"X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C",};
         String rimed [] = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
         String res="";

         if (des>0 && ed>0){res=rimd[des-1] + rimed[ed-1];}
         if (des>0 && ed==0){res= rimd[des-1];}
         if (des<1 && ed>0){res= rimed[ed-1];}
         if (des<1 && ed<0) res="в римских цифрах не существует нуля и отрицательных значений";
         return res;
        }

        int result(String d){
            if (d.equals("+")) return num1+num2;
            if (d.equals("-")) return num1-num2;
            if (d.equals("/")) return num1/num2;
            if (d.equals("*")) return num1*num2;
            return 0;
        }
    }