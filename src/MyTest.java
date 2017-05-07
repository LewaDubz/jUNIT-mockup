import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class MyTest {
    @Test
    public void ReadTestFrom1to2 () throws IOException {
        FilePartReader filepartReader = new FilePartReader("/home/byteforce/Asztal/JunitMockup/src/Text.txt",1,2);
        String result = filepartReader.readLinesFromStartToEnd();
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filepartReader);
        System.out.println(result);
        assertEquals("egy,két,",result);
  }
    public void ReadTestFrom0to2 () throws IOException {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();

        try{assertEquals(illegalArgumentException,new FilePartReader("/home/byteforce/Asztal/JunitMockup/src/Text.txt",0, 2));}
        catch (IllegalArgumentException illegalAE){
            System.err.print("\n AssertEquals Exception handling Success Read from line 0 to 2 Exited with illegalArgumentException");
        }
    }
    public void ReadTestFromEndLineIndexSmallerThanStartLineIndex () throws IOException {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();

        try{assertEquals(illegalArgumentException,new FilePartReader("/home/byteforce/Asztal/JunitMockup/src/Text.txt",2, 1));}
        catch (IllegalArgumentException illegalAE){
            System.err.print("\n AssertEquals Exception handling Success Reading Smaller Endline than StartLine Exited with illegalArgumentException");
        }
    }
    public void ReadFromInvalidSourceFile(){
         IOException ioException = new IOException();

        try{assertEquals(ioException,new FilePartReader("/home/byteforce/Asztal/JunitMockup/src/Text2.pdf",2, 1));}
        catch (IllegalArgumentException illegalAE){
            System.err.print("\n AssertEquals Exception handling Success process exited with IOException on abscence of SourceFile");
        }

    }
    public void CheckSorting() throws IOException {
        FilePartReader correctlySorted = new FilePartReader("/home/byteforce/Asztal/JunitMockup/src/SortedText.txt",1,12);
        FileWordAnalyzer corecctlySortedAnalyzer = new FileWordAnalyzer(correctlySorted);
        FilePartReader toSort = new FilePartReader("/home/byteforce/Asztal/JunitMockup/src/Text.txt",1,12);
        FileWordAnalyzer toSortAnalyzer = new FileWordAnalyzer(toSort);
        assertEquals(corecctlySortedAnalyzer.wordsByABC(),toSortAnalyzer.wordsByABC());

    }
    public void CheckSubstring(String subString){
        FilePartReader filePartReader = new FilePartReader("/home/byteforce/Asztal/JunitMockup/src/Text.txt",1,12);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        int i = 0;
        try {
            while(i < fileWordAnalyzer.wordsContainingSubStrings(subString).size()){
                assertEquals(subString,fileWordAnalyzer.wordsContainingSubStrings(subString).get(i));
                i++;
                System.out.println("\n" + subString);
            }

        } catch (IOException e) {
            System.err.print("No file found");
        }

    }
}




