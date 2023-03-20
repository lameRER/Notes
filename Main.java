public class Main {
    public static void main(String[] args) {
        FileOperation fileOperationlmp = new FileOperationImp("notes");
//        RepositoryFile repositoryFile = new RepositoryFile(fileOperationlmp, new Mapper());
        Repository repositoryFile = new RepositoryLogger(new RepositoryFile(fileOperationlmp, new Mapper()), new FileLogger("log"));
        NoteController controller = new NoteController(repositoryFile);
        ViewConsole view = new ViewConsole(controller);
        view.run();
    }
}
