import java.util.Scanner;

public class ViewConsole {

    private final NoteController controller;

    public ViewConsole(NoteController controller) {
        this.controller = controller;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        Commands command = Commands.NONE;
        while (true){
            System.out.print("Введите команду: ");
            try {
                command = Commands.valueOf(scanner.nextLine().toUpperCase());
                System.out.print("\033[H\033[J");
            }
            catch (Exception ignored){}
            switch (command) {
                case ADD:
                    addNote(scanner);
                    break;
                case READ:
                    readNote(scanner);
                    break;
                case READALL:
                    readAll();
                    break;
                case EDIT:
                    editNote(scanner);
                    break;
                case DELETE:
                    deleteNote(scanner);
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Введена неверная команда!");
                    break;
            }
        }
    }

    private static void exit() {
        System.exit(0);
    }

    private void deleteNote(Scanner scanner) {
        String delId = prompt(scanner, "Введите id: ");
        controller.delete(delId);
    }

    private void editNote(Scanner scanner) {
        String editId = prompt(scanner, "Введите id: ");
        String editText = prompt(scanner, "Введите текст: ");
        controller.edit(editId, editText);
    }

    private void readAll() {
        controller.readAll().forEach(System.out::println);
    }

    private void readNote(Scanner scanner) {
        try {
            String readId = prompt(scanner, "Введите id: ");
            INote note = controller.read(readId);
            System.out.println(note.toString());
        }
        catch (Exception ex){
            System.out.println("Заметки с таким id не существует!");
        }
    }

    private void addNote(Scanner scanner) {
        String name = prompt(scanner, "Название заметки: ");
        String text = prompt(scanner, "Описание заметки: ");
        controller.add(name, text);
    }

    public String prompt(Scanner scanner, String text){
        System.out.print(text);
        return scanner.nextLine();
    }
}
