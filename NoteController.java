import java.util.List;

public class NoteController {

    private Repository repository;

    public NoteController(Repository repository){

        this.repository = repository;
    }
    public void add(String name, String text){
        List<INote> notes = repository.getAllNotes();
        notes.add(new Note(name, text));
        repository.CreateNote(notes);
    }

    public INote read(String id){
        List<INote> notes = repository.getAllNotes();
        return notes.stream().filter(n -> n.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<INote> readAll(){
        return repository.getAllNotes();
    }

    public void delete(String id){
        List<INote> notes = repository.getAllNotes();
        INote delNote = read(id);;
        notes = notes.stream().filter(n -> !n.getId().equals(delNote.getId())).toList();
        repository.DeleteNote(notes);
    }

    public void edit(String id, String text){
        INote note = read(id);
        note.setText(text);
    }
}
