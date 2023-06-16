import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileLogger implements Loggable {
    private String filename;

    public FileLogger(String filename){
        this.filename = filename;
    }

    @Override
    public void saveToJournal(String event) {
        try(FileWriter fileWriter = new FileWriter(filename, true)){
            LocalDateTime localDateTime = LocalDateTime.now();
            fileWriter.write(String.format("%s, %s\n", localDateTime, event));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
