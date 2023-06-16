import java.util.List;

public class RepositoryLogger implements Repository{

    private Repository repository;
    private Loggable loggable;

    public RepositoryLogger(Repository repository, Loggable loggable){
        this.repository = repository;
        this.loggable = loggable;
    }
    @Override
    public List<INote> getAllNotes() {
        loggable.saveToJournal("Считываем список заметок");
        return repository.getAllNotes();
    }

    @Override
    public void CreateNote(List<INote> notes) {
        loggable.saveToJournal("Создаем заментку");
        repository.CreateNote(notes);
    }

    @Override
    public void DeleteNote(List<INote> notes) {
        loggable.saveToJournal("Удалиляем заметку");
        repository.DeleteNote(notes);
    }

    @Override
    public void SaveNotes(List<INote> notes) {
        loggable.saveToJournal("Сохраняем заметку");
        repository.SaveNotes(notes);
    }
}
