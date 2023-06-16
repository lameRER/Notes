import java.util.List;

public interface Repository {
    List<INote> getAllNotes();
    void CreateNote(List<INote> notes);
    void DeleteNote(List<INote> notes);
    void SaveNotes(List<INote> notes);
}