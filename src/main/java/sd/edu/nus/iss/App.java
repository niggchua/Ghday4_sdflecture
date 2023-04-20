package sd.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );

        String dirPath = args[0]; //array always start from index zero
        String fileName = args[1];
        String dirPathFileName = dirPath + File.separator + fileName;
        


       File newDir = new File(dirPath); //create directory and creating new file
       if (newDir.exists()){            //check if new directory exists using file path, if don't exist then create it
            System.out.println(dirPath + "directory already exsits");
       } else {
        newDir.mkdir();

       }
       
       File newFile = new File(dirPathFileName);
       if (!newFile.exists()){
        System.out.println(dirPathFileName + " file does not exists");
        System.exit(0);
       }

        //1. use FileReader and BufferedReader to read file

        FileReader fr = new FileReader(new File(dirPathFileName));
        BufferedReader br = new BufferedReader(fr);
        String lineInput = "";

        // variables here one detects the whole file content, the other detects line by line
       // String fileContent = ""; //These two lines and next two lines serve same purpose
       // String lineInput = ""; 


        StringBuilder sbFileContent = new StringBuilder(); //Stringbuilder can juse use append, whereas the above one have to keep using +
      

        //2. while loop to readfile into a string variable
       while ((lineInput = br.readLine()) != null) {
        sbFileContent.append(lineInput);
       }


        //3. close the readers
       br.close();
       fr.close();


       //print out the StringBuilder object sbFileContent 
       //Purpose is just to make sure we read all the content from the file
       System.out.println(sbFileContent);


       //convert the stringin sbFileContent to all upper case
       //print to screen
       System.out.println(sbFileContent.toString().toUpperCase());

       //converst Stringbuilder to String
       //so that i can use String fucntions to perform other tasks
       String fileContent = sbFileContent.toString();
       fileContent = fileContent.replace(',', ' ');
       fileContent = fileContent.replace('.', ' ');
       fileContent = fileContent.replace('(', ' ');
       fileContent = fileContent.replace(')', ' ');
       fileContent = fileContent.replace('[', ' ');
       fileContent = fileContent.replace(']', ' ');
       fileContent = fileContent.replace('"', ' ');
       fileContent = fileContent.replace('?', ' ');
       fileContent = fileContent.replace('!', ' ');

       String [] fileContentArray = fileContent.split(" "); //creating a filecontent array filled with strings
                                                            //fileContent.split - things separated by space (" "), treated as individual strings


       //Lists out all all the unique words read without the occurences
       List<String> words = new ArrayList<>(); //create a new list of type String, with the label words

       for (String word: fileContentArray) {  //for(String words: fileContentArray)  -> looks through the filecontent array, 
        //first index, second index etc, and because of the previous step, it loops through and lists each String found under 
        //the new varaiable "word". intialised here.

            // initialise variable wordExists as an int
            int wordExists = words.indexOf(word);

            if (wordExists >= 0) {
                // means the word exists in the list collection
            } else {
                //new word found
                words.add(word);
                //add new word into list
            }
            System.out.println(words);

            

       }
            //Store all the unique words read with occurences
            Map<String, Integer> wordss = new HashMap<>(); //string is the key(the word), integer is the value (number of times the word appear)

         for (String word: fileContentArray) {

              Integer wordExists = wordss.get(word);
                if (wordExists == null) {
                    wordss.put(word, 1);
                        //new word found
                } else {
                    //the word exists in the Map/HashMap collection
                    wordss.put(word, wordExists + 1);
                }

                System.out.println(wordss);
            }


       }

    }

