import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) throws Throwable {


         Album album = new Album("Open Letter", "Talhah Anjum");
            String userHome = System.getProperty("user.home");
            JFileChooser chooser = new JFileChooser(userHome+"\\Music");
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Mp3 Files", "mp3");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            //try {
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " +
                            chooser.getSelectedFile().getName());
                }



        try
        {
          File file = new File(chooser.getSelectedFile().toURI());
            if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if(file.exists())         //checks file exists or not
                desktop.open(file);              //opens the specified file
            album.addSong(chooser.getSelectedFile().getName());
           // System.out.println(chooser.getSelectedFile().length());
        }
        catch(NullPointerException e){
            System.out.println("Error: No File Chosen");
        }

        


    }
}