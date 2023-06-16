import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperationImp implements FileOperation{

    private String filename;

    public FileOperationImp(String filename){
        this.filename = filename;
        try (FileWriter fileWriter = new FileWriter(filename, true)){
            fileWriter.flush();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<String> readAllLines() {
        List<String> lines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();;
            if (line != null) {
                do {
                    lines.add(line);
                    line = bufferedReader.readLine();
                } while (line != null);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    @Override
    public void saveAllLines(List<String> lines) {
        try(FileWriter fileWriter = new FileWriter(filename, false)){
            for (String line : lines){
                fileWriter.write(line);
                fileWriter.write('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
