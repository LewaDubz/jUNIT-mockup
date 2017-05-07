import java.io.IOException;

public class Main {

    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        FilePartReader filepartReader = new FilePartReader("/home/byteforce/Asztal/JunitMockup/src/Text.txt", 1, 2);
        String result = filepartReader.readFile();
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filepartReader);
        System.out.println(result);
        MyTest myTest = new MyTest();
        myTest.ReadTestFrom1to2();
        myTest.ReadTestFrom0to2();
        myTest.ReadTestFromEndLineIndexSmallerThanStartLineIndex();
        myTest.ReadFromInvalidSourceFile();
        System.out.println("\n");
        myTest.CheckSubstring("magad");
        myTest.CheckSorting();

    }
}


