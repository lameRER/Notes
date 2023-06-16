import java.util.ArrayList;
import java.util.List;

public class Note implements INote {

    public static int count = 0;
    private String id;
    private String name;
    private String text;

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.text = text;
    }

    public List<Note> notes = new ArrayList<>();

    public Note(String name, String text){
        this.id = String.valueOf(Note.count += 1);
        this.name = name;
        this.text = text;
    }

    public Note(String id, String name, String text){
        this(name, text);
        if (Note.count < Integer.parseInt(id))
            Note.count = Integer.parseInt(id);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Note № " + id + " name: " + name + " text: " + text;
    }
}
