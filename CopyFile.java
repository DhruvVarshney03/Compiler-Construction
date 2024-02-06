import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class CopyFile {
    public static void main(String[] args){
        /*String inputFile = "File1.txt";
        String outputFile = "File2.txt";
*/
        try{
            FileReader r=new FileReader("File1.txt");
            FileWriter w=new FileWriter("File2.txt");   

            int ch;
            int token_count=0;
            while ((ch=r.read())!=-1){
                if (ch==' '){
                    token_count++;
                }
                w.write(ch);
            }
            
            System.out.println("Dhruv Varshney\nA2305221157\n");
            System.out.println("File Copied Successfully");
            System.out.println("Token Count:"+(token_count+1));
            r.close();
            w.close();
        }catch(IOException e){
            System.err.println("Error Copying FIle"+ e.getMessage());
        }
        
        }
    }
    

