package Parsing;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Read input file and return a list of lines
public class FileParser {
    File file;
    List lines;
    BufferedReader reader;

    public FileParser(String path){
        file = new File(path);
        lines = new ArrayList();
        parse();
    }

    void parse(){
        try {
            String line;
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                lines.add(line);
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e);
            return;
        }
        catch(IOException e){
            System.out.println(e);
            return;
        }
    }

    public List getLines(){
        return lines;
    }

    protected void finalize(){
        try{
            reader.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
