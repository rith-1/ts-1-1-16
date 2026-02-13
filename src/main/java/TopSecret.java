/**
 * Commmand Line Utility
 * part a --> command line interface
 * checking the number of arguments the user uses
 */
import java.util.regex.Pattern;

public class TopSecret {
    //defines a constant Pattern in Java that matches exactly two digits (like "01", "12", "99").
    private static final Pattern FILE_NUMBER = Pattern.compile("\\d{2}");

    //Testing variable
    //0 = list files
    //1 = display file with default key
    //2 = display file with provided key
    //3 = invalid arguments
    private static int testing = -1; //defailt value before it runs

    //getter method to return the testing variable
    public int getTesting(){
        return testing;
    }

    //setter method to set the testing variable
    public void setTesting(int testing){
        TopSecret.testing = testing;
    }

    //main method -> entry point of the program
    public static void main(String[] args) {
        //create a ProgramController object to handle program actions
        ProgramController user = new ProgramController();

        try{
            //validate command line arguments before running program logic
            validateArgs(args);

            //if there are no arguments, list the numbered files available
            if (args.length == 0){
                //calls method to display the available files
                System.out.println(user.listFiles());

                //update testing variable
                testing = 0;
            }
            //if there is one argument, open the file at that index (use the default key)
            else if (args.length == 1){
                //calls method to display the files
                System.out.println(user.displayFile(args[0],null)); //pass the file number and no key
                //update testing variable
                testing = 1;
            }
            //if two args, display the file at the index of the first argument and the key provided by the second argument
            else{ //after validating, the else would just be when args.length == 2
                // random
                System.out.println(user.displayFile(args[0],args[1])); //pass file number and key
                testing = 2; //set testing flag
            }

        }
        //catch invalid argument errors
        catch (IllegalArgumentException e){
            //print specific error message
            System.out.println(e.getMessage());
            //print a correct usage format
            System.out.println("Correct Format: java topsecret [fileNumber] [optionalKey]");
            //update testing variable
            testing = 3;
        }
    }

    //VALIDATING ARGUMENTS
    static void validateArgs(String[] args){
        //only 0,1,2 arguments allowed
        if (args.length > 2){
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        //validate file number if at least one argument is provided
        if (args.length >= 1){
            //store first argument
            String fileNumber = args[0];
            //check if null or does not match the two-digit pattern
            if (fileNumber == null || !FILE_NUMBER.matcher(fileNumber).matches()){
                throw new IllegalArgumentException("Invalid file number. Use two digits like 01.");
            }
        }

        //validate cipherkey if two arguments are provided
        if (args.length == 2){
            //store second argument
            String optionalKey = args[1];
            //check if null or blank
            if (optionalKey == null || optionalKey.isBlank()){
                throw new IllegalArgumentException("Invalid optional key. Optional Cipher key can't be blank.");
            }
        }
    }
}


