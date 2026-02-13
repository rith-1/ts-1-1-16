import java.util.List;

public class ProgramController {

    private final FileHandler fileHandler;

    public ProgramController(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    //displays file list or opens a specific file
    public void run(String[] args) {
        //gets the available files from handler
        List<String> availableFiles = fileHandler.getFiles();
        if(args.length == 0) {
            displayFileList(availableFiles);
            return;
        }
        int index;

        //tries to covert to integer if fails then error is produced
        try{
            index = Integer.parseInt(args[0]) -1;
        } catch (NumberFormatException e) {
            System.out.println("Error: file needs to be an integer");
            return;
        }

        //checks for range of file
        if(index < 0 || index >= availableFiles.size()) {
            System.out.println("Error: out of range");
            return;
        }

        //reads and displays the command line
        String selectedFile = availableFiles.get(index);
        String contents = fileHandler.readFile(selectedFile);
        System.out.println(contents);

    }

    //displays the files starting at number 1
    private void displayFileList(List<String> files) {
        for (int i = 0; i < files.size(); i++) {
            System.out.println((i + 1) + ". " + files.get(i));
        }
    }

}
