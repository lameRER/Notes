import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository{

    private FileOperation fileOperation;
    private Mapper mapper;

    public RepositoryFile(FileOperation fileOperation, Mapper mapper){
        this.fileOperation = fileOperation;
        this.mapper = mapper;
    }
    @Override
    public List<INote> getAllNotes() {
        List<String> lines = fileOperation.readAllLines();
        List<INote> nodes = new ArrayList<>();
        for (String line : lines){
            nodes.add(mapper.map(line));
        }
        return nodes;
    }

    @Override
    public void CreateNote(List<INote> notes) {
        SaveNotes(notes);
    }

    @Override
    public void DeleteNote(List<INote> notes) {
        SaveNotes(notes);
    }

    @Override
    public void SaveNotes(List<INote> notes) {
        List<String> strings = new ArrayList<>();
        notes.forEach(n -> { strings.add(mapper.map((Note) n)); });
        fileOperation.saveAllLines(strings);
    }
}
