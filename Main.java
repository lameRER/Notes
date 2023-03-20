public class Main {
    public static void main(String[] args) {
        FileOperationImp fileOperationlmp = new FileOperationImp("notes");
        RepositoryFile repositoryFile = new RepositoryFile(fileOperationlmp, new Mapper());
        NoteController controller = new NoteController(repositoryFile);
        ViewConsole view = new ViewConsole(controller);
        view.run();
    }
}
