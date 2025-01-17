package lib;

import java.util.Scanner;

public class LibIO {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Request the user an String with a personalized request message
     * and loops input request in case length of the String given is not between {@code [minLon-maxLon]}
     * <p>
     * Examples:
     * <blockquote><pre>
     * 
     * String string = leerString("Enter an String: ", 0, 20);
     * 
     * </pre></blockquote>
     * <p>
     * 
     * @param mensaje String with the personalized message
     * @param minLon Integer with the minimum length
     * @param maxLon Integer with the maximum length
     * @return String with the validated input
     */
    public static String leerString(String mensaje, int minLon, int maxLon) {
        String resultado = "";
        boolean valido;
        do {
            System.out.println(mensaje);
            resultado = scanner.nextLine();
            valido = resultado.length() >= minLon && resultado.length() <= maxLon;
            if (!valido) {
                System.out.printf("El string debe tener entre %d y %d letras\n", minLon, maxLon);
            }
        } while (!valido);
        return resultado;
    }

    /**
     * Requests the user an integer with personalized message and
     * loops input request in case number it's not in range {@code [min-max]}
     * <p>
     * Examples:
     * 
     * <blockquote><pre>
     * 
     * int validNumber = leerInt("Enter integer between 0 and 10: ", 0, 10);
     * 
     * </pre></blockquote>
     * 
     * <p>
     * @param mensaje String with personalized input
     * @param min Integer with min value to accept
     * @param max Integer with max value to accept
     * @return an integer with the validated input 
     */
    public static int leerInt(String mensaje, int min, int max){
        boolean valido;
        do{
            System.out.print(mensaje);
            int num = scanner.nextInt();
            if (inRange(num, min, max)){
                valido = true;
                return num;
            }

            else{
                System.out.println("Entrada no valida");
                valido = false;
            }
        } while (!valido);

        return 0;
    }

    /**
     * Prints a menu with personalized title, footer and initial sequence per element given.
     * <p>
     * If the initial sequence includes a {@code "."}, an autoincremental index will be added before the {@code "."}.
     * <p>
     * Footer lenght equals the title columns. If footer ==  {@code " "}, footer won't be printed. 
     * <p>
     * Examples:
     *  <blockquote><pre>
     *deployMenu("Example menu", " ", "--> ", "Opt1", "Opt2");
     *  //******************
     *  //** Example menu **
     *  //******************
     *  // --> Opt1
     *  // --> Opt2
     * 
     *deployMenu("Example menu with id", "Footer!", "--> . ", "Opt1", "Opt2");
     *  //**************************
     *  //** Example menu with id **
     *  //**************************
     *  // --> 1. Opt1
     *  // --> 2. Opt2
     *  //--------------------------
     *  // Footer!
     *  </pre></blockquote>
     *
     * @param title String with the title
     * @param footer String with the footer
     * @param init String with the starting sequence.
     * @param args Receives an undefinied number of Strings or a String array ({@code String[]})
     */
    public static void deployMenu(String title, String footer, String init, String... args){
        int idx = 1;
        String titleMod = "*".repeat(title.length() + 6) 
                + "\n** " + title + " **\n"
                + "*".repeat(title.length() + 6);
        
        System.out.println(titleMod);

        if (init.contains(".")){

            for (String arg : args){
                String initMod = init.replace(".", idx + ".");
                System.out.println(initMod + arg);
                idx++;
            }
        }

        else{
            for (String arg : args){
                System.out.println(init + arg);
            }
        }

        if(footer.equals(" "));
        else{
            System.out.println("-".repeat(title.length() + 6));
            System.out.println(footer);
        }
    }
    
        /**
     * Returns wether the number is between a range of numbers or not
     * <p>
     * Examples:
     * <blockquote><pre>
     * 
     * boolean b = inRange(3, 2.5, 4)
     *      //b = true
     * 
     * </pre></blockquote>
     * @param x Number to be checked
     * @param lowerBound Min range border
     * @param upperBound Max range border
     * @return a boolean with the result
     */
    public static boolean inRange(double x, double lowerBound, double upperBound){
        if (x >= lowerBound && x <=upperBound) return true;
        else return false;
    }

}