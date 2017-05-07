import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by byteforce on 2017.05.03..
 */
public class FileWordAnalyzer {
    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    private FilePartReader filePartReader;

    public ArrayList<String> wordsByABC() throws IOException {
        ArrayList<String> wordsByABC ;
        String content =this.filePartReader.readLinesFromStartToEnd();
            wordsByABC = new ArrayList<> (Arrays.asList(content.split(",")));
        for(String words : wordsByABC){
            System.out.println(words);}
        Collections.sort(wordsByABC);
       return wordsByABC;


    }

    public ArrayList wordsContainingSubStrings(String subString) throws IOException {
        ArrayList<String> wordsWithSub = new ArrayList<>();
        for (Object words:wordsByABC()) {
            if(words.toString().contains(subString)){
                wordsWithSub.add(words.toString());
            }

        }
        return wordsWithSub;
    }

}
