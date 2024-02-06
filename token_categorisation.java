import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
public class token_categorisation {
    private static final Set<String> javaKeywords = new HashSet<>();
    private static final Set<String> builtInFunction=new HashSet<>();
    static{
        javaKeywords.add("if");
        javaKeywords.add("else");
        javaKeywords.add("import");
        javaKeywords.add("break");
        javaKeywords.add("continue");

        builtInFunction.add("length");
        builtInFunction.add("println");
        builtInFunction.add("replace");
        builtInFunction.add("charAt");
        builtInFunction.add("endswith");
}


    private static void processToken(String token, FileWriter w) throws IOException{
        String cleanedToken=token.replaceAll("//.*", "").replaceAll("/t","").replaceAll("\n", "").trim();
        if (cleanedToken.length()!=0){
            
            if (isJavaKeyword(cleanedToken)){
                w.write("Keyword:"+ cleanedToken+"\n");
            }else if (isBuiltInFunction(cleanedToken)){
                w.write("Built-In Function: "+cleanedToken+"\n");
            }else{
                w.write("Identifier: "+cleanedToken+"\n");
            }
        }
    }
    private static boolean isJavaKeyword(String token){
        return javaKeywords.contains(token);
    }
    private static boolean isBuiltInFunction(String token){
        return builtInFunction.contains(token);
    }
    public static void main(String[] args){
        try{
            FileReader r=new FileReader("File1.txt");
            
            FileWriter w=new FileWriter("Output.txt");   
            int ch;
            
            StringBuilder current= new StringBuilder();
            while ((ch=r.read())!=-1){      
                char currentChar=(char)ch;
                
                if (currentChar=='/' && current.length() >0 && current.charAt(current.length()-1)=='/'){
                    while ((ch=r.read())!=-1 && ch!='\n'){
                        continue;
                    }
                }
                if (currentChar == ' ' || currentChar == '\n') {
                    processToken(current.toString(), w);
                    current.setLength(0);
                    
                } else {
                    current.append(currentChar);
                }
              }
                if (current.length()>0){
                processToken(current.toString(),w);
                
            }
            System.out.println("Dhruv Varshney\nA2305221157\n");
            System.out.println("Token Categorised Successfully");
            
            r.close();
            w.close();

            FileReader outputReader = new FileReader("Output.txt");
            int outputTokenCount = 0;
            while ((ch = outputReader.read()) != -1) {
                char outputChar = (char) ch;
                if (outputChar == '\n') {
                    outputTokenCount++;
                }
            }
            outputReader.close();

            System.out.println("Token Count: " + outputTokenCount);
        }catch(IOException e){
            System.err.println("Error Copying FIle"+ e.getMessage());
        }
      }
  }
