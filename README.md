# CSE310-java-todo-list

A simple to-do list written in Java. Operated via a CLI menu, this project demonstrates basic Java concepts (conditionals, loops, methods, classes) and uses the Java Collections Framework (`ArrayList`) as well as simple file I/O for persistence.


## Instructions for Build and Use

Steps to build and/or run the software (Windows / PowerShell):

1. Open PowerShell and change to the project root (where `src` is located):

```powershell
cd "C:\Users\dalton\Documents\BYU-I\Coursework\Fall 2025\CSE 310 (Applied Programming)\Individual Sprints\Sprint 3\cse310-java-todo-list"
```

2. Compile the Java sources (target JDK 21):

```powershell
javac -d out src\edu\byu\cse310\todoj\*.java
```

3. Run the program:

```powershell
java -cp out edu.byu.cse310.todoj.Main
```

Instructions for using the software (menu):

1. `1) Add todo` — enter a title and a numeric priority (1-5).
2. `2) List todos` — shows numbered tasks, priority, and status.
3. `3) Toggle status (by number)` — enter the task number shown by the list to flip its done/open state.
4. `4) Save and quit` — saves current tasks to `todos.txt` and exits.

Notes:

- The program persists tasks to a file named `todos.txt` in the project root. Each line is pipe-delimited: `Title|Priority|done` (example: `Buy milk|2|false`).
- If `todos.txt` does not exist it is created when you choose `Save and quit`.


## Development Environment 

To recreate the development environment you need:

* Java Development Kit (JDK) 21
* Any OS that supports JDK 21 (development done on Windows in these instructions)
* A terminal (PowerShell, cmd, or a Unix shell) and a text editor or IDE (e.g., VS Code, IntelliJ IDEA, or Eclipse)


## Useful Websites to Learn More

I found these websites useful in developing this software:

* [W3 Schools](https://www.w3schools.com/java/default.asp)
* [Oracle Docs (Java SE)](https://docs.oracle.com/en/java/javase/21/)
* [Beginners Book (Java Collections)](https://beginnersbook.com/java-collections-tutorials/)
* [Baeldung (file I/O in Java)](https://www.baeldung.com/java-io)


## Future Work

The following items I plan to fix, improve, and/or add to this project in the future (pick items to implement):

* [ ] Replace plain `done`/`open` text with a visual checkbox or emoji in the list output.
* [ ] Add ability to remove tasks by number.
* [ ] Add an "edit" option to change a task's title or priority.
