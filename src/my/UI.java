package my;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

/**
 * Klasse um das Fenster zu definieren und die Inhalte der Log-Datei in eine scrollbare TextArea zu setzen
 *
 */
public class UI {


    /**
     * Methode zum Erstellen der Fenster und der scrollbaren Textbox.
     */
    public static void init(){
        JTextArea jTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(jTextArea);
        JFrame f = new JFrame("Heimspiel Log-Datei");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(400,400,500,500);
        f.add(scrollPane);
        jTextArea.setText(getContentFile());
        f.setVisible(true);
    }

    /**
     * Methode um den Inhalt der Textdatei "log.txt" einzulesen und in einem String abzulegen
     *
     * @return String - Inhalt der Txt-Datei: "log.txt"
     */
    private static String getContentFile(){
        FileReader fr;
        String contentString = " ";
        try{
            fr = new FileReader("log.txt");
            int i;
            while((i=fr.read()) != -1){
               contentString += String.valueOf((char) i);
            }
            contentString = contentString.strip();
            fr.close();
        }catch (IOException e){
            System.out.println("Leider ist ein Fehler beim Lesen der Datei aufgetreten !");
        }
        return contentString;
    }
}
