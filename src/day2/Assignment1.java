package day2;

public class Assignment1 {
    public static void main(String[] args) throws Exception {
        //variable to hold the sum of arguments
        float sum = 0;

        //ehanced for loop to iterate over args, parsing each arg and outputting an error message when unsuccessful 
        for (String arg : args) {
            try {
                float parsedArg = Float.parseFloat(arg);
                sum += parsedArg;
            } catch (Exception e) {
                String customErrorMessage = String.format("Coudln't parse argument: %s", arg);
                System.out.println(customErrorMessage);
            }
        }
        //show user the sum, exit
        System.out.println(String.format(("Sum of parsed arguments: %f"), sum));
    }
}
