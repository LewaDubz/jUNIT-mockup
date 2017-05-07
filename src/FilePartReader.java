import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by byteforce on 2017.05.03..
 */
public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader(String filePath, Integer fromLine, Integer toLine)throws IllegalArgumentException {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
        if(toLine<fromLine || fromLine<1) {
            throw new IllegalArgumentException();
        }

    }
    public String readFile() throws IOException {
        String content;
        content = new String(Files.readAllBytes(Paths.get(this.filePath)));
        return content;
    }
    public String readLinesFromStartToEnd() throws IOException,IllegalArgumentException{
        String fullText= this.readFile();
        int startLine = this.fromLine;
        int endLine = this.toLine;
        String strippedText = "";
        int i;
        for(i = startLine-1; i<endLine;i++){
                strippedText += fullText.split("\n")[i].toLowerCase() +",";
            }
        return strippedText;
        }
    public int getToLine(){
        return this.toLine;
    }
    }

