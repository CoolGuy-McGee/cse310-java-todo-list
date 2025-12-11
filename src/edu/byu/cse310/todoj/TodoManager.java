package edu.byu.cse310.todoj;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages a list of Todo items. Demonstrates use of ArrayList and basic file I/O.
 */
public class TodoManager {
    private final List<Todo> todos = new ArrayList<>();

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(String title, int priority) {
        todos.add(new Todo(title, priority, false));
    }

    public boolean removeByTitle(String title) {
        return todos.removeIf(t -> t.getTitle().equals(title));
    }

    public boolean toggleStatus(String title) {
        for (Todo t : todos) {
            if (t.getTitle().equals(title)) {
                t.setDone(!t.isDone());
                return true;
            }
        }
        return false;
    }

    /**
     * Toggle status by zero-based index. Returns true when index valid.
     */
    public boolean toggleStatusByIndex(int index) {
        if (index >= 0 && index < todos.size()) {
            Todo t = todos.get(index);
            t.setDone(!t.isDone());
            return true;
        }
        return false;
    }

    public void listTodos() {
        if (todos.isEmpty()) {
            System.out.println("(no todos)");
            return;
        }
        for (int i = 0; i < todos.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, todos.get(i).toString());
        }
    }

    /**
     * Save todos to a pipe-delimited file. Each line: Title|Priority|done
     */
    public void saveToFile(String filename) throws IOException {
        Path p = Paths.get(filename);
        List<String> lines = new ArrayList<>();
        for (Todo t : todos) {
            lines.add(t.toLine());
        }
        Files.write(p, lines);
    }

    /**
     * Load todos from a pipe-delimited file. Existing list is cleared.
     */
    public void loadFromFile(String filename) throws IOException {
        Path p = Paths.get(filename);
        if (!Files.exists(p)) return;
        List<String> lines = Files.readAllLines(p);
        todos.clear();
        for (String line : lines) {
            Todo t = Todo.fromLine(line);
            if (t != null) todos.add(t);
        }
    }
}
