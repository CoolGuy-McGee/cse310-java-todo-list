package edu.byu.cse310.todoj;

/**
 * Simple Todo data class for the cse310-java-todo project.
 */
public class Todo {
    private String title;
    private int priority;
    private boolean done;

    public Todo(String title, int priority, boolean done) {
        this.title = title;
        this.priority = priority;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    /**
     * Serialize to a simple pipe-delimited text line: Title|Priority|done
     */
    public String toLine() {
        return title + "|" + priority + "|" + (done ? "true" : "false");
    }

    /**
     * Parse a line produced by toLine(). Returns null on parse error.
     */
    public static Todo fromLine(String line) {
        if (line == null) return null;
        String[] parts = line.split("\\|", 3);
        if (parts.length != 3) return null;
        String t = parts[0];
        int p;
        try {
            p = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            return null;
        }
        boolean d = "true".equalsIgnoreCase(parts[2]);
        return new Todo(t, p, d);
    }

    @Override
    public String toString() {
        return String.format("%s (priority: %d) - %s", title, priority, done ? "done" : "open");
    }
}
