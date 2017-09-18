package sample;


import java.io.*;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Smirnoff on 02.05.2017.
 */
public class Model {


    static List<String> historyList = new ArrayList<>();
    File history = new File("history.dat");
    FileOutputStream fout;
    BufferedReader br;


    public void addHistory(String string) throws FileNotFoundException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String dateString = dateFormat.format(new Date());
        string = dateString.concat(" : " + string + "\n ");
        historyList.add(string);
        try {
            fout = new FileOutputStream(history, true);
            fout.write(string.getBytes());
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void clearHistory() {

        try{
             if(history.delete()){
                System.out.println(history.getName() + " is deleted!");
            }else{
                System.out.println("Delete operation is failed.");
            }
        }catch(Exception e){

            e.printStackTrace();

        }
    }

    public String showHistory() throws IOException {

        String txt = "";
        try {
            try {
                br = new BufferedReader(new FileReader(history));
            } catch (FileNotFoundException e) {
                txt = "Brak historii";
                return txt;


            }
            String line;
            line = br.readLine();
            while (line != null) {
                txt = txt + line + "\n";
                line = br.readLine();

            }
            br.close();
            return txt;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return txt;

    }
}
