# Sliding Puzzle (Taquin) – Java (Swing, MVC)

![Java](https://img.shields.io/badge/Java-21+-red?style=flat&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/UI-Swing-0f9d58?style=flat)
![Architecture](https://img.shields.io/badge/Architecture-MVC-blue?style=flat)

A software engineering coursework project: a **Sliding Puzzle (Taquin)** built in **Java (Swing)** with a **clean MVC** architecture.  
Choose the grid size, play with **mouse or keyboard**, and switch between a **numeric tiles grid** and a **random image** puzzle.

---

## Preview

Add a screenshot or animated GIF of the game:

![Sliding Puzzle Preview](demo.gif)

---

## Project Structure

```text
src
├── Demo.java
├── model
│   ├── Piece.java
│   └── PuzzleModel.java
├── Test.java
├── util
│   ├── AbstractModel.java
│   ├── Listener.java
│   ├── Matrix.java
│   └── Model.java
└── view
    ├── GameOverWindow.java
    ├── PuzzleButton.java
    ├── PuzzleGui.java
    ├── PuzzleView.java
    └── SelectionWindow.java
```

- **model/**: game state, tile representation, rules.
- **view/**: Swing GUI (main view, selection dialog, game over window, buttons).
- **util/**: observable model abstraction, listeners, matrix helpers.
- **Demo.java**: application entry point.

---

## Features

- **Grid size selection** (e.g., 3×3, 4×4, 5×5, …).
- **Two content modes**:
  - **Numeric tiles**.
  - **Random image** sliced into tiles (with one blank).
- **Controls**:
  - **Mouse**: click a tile adjacent to the blank to slide.
  - **Keyboard**: arrow keys to move the blank (or the tile direction, depending on your convention).
- **Move counter** displayed in real time.
- **Win detection** with **Game Over** dialog.
- **MVC separation** for maintainability and testing.

> [!IMPORTANT]
> Some shuffled states in sliding puzzles can be **unsolvable**. Ensure the shuffle routine preserves solvability (parity of inversions and blank row).

---

## Build & Run (no Maven/Gradle)

From the project root:

```bash
javac -d bin $(find src -name "*.java") && java -cp bin Demo
```

- Compiles sources into `bin/` then runs the main class `Demo`.
- On Windows without `find`, use Git Bash or adapt the command via PowerShell.

---

## How to Play

1. Launch the application.
2. In **SelectionWindow**, choose:
   - **Grid size**.
   - **Mode**: numeric or random image.
3. Start the game:
   - **Mouse**: click tiles adjacent to the blank to slide.
   - **Keyboard**: use arrow keys.
4. Reconstruct the ordered grid (or the full image) to win.  
5. Track your **move counter** to measure efficiency.

---

## Configuration Notes

- Random image selection can be adapted to load from:
  - A bundled images folder.
  - A user-chosen file (file chooser).
- Numeric mode renders numbers directly (no assets required).

---

## Limitations & Future Work

- Ensure **solvable shuffles** for all grid sizes.
- Optional: add **timer** and **best scores**.
- Optional: support **custom images** via file chooser.
- Optional: add **undo/redo** and **hint** system.

---

## License

MIT
