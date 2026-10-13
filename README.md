# RNG Chess

RNG Chess is a desktop chess project (with a fun twist) built with Java Swing.

## Requirements

- Java 25 or a compatible recent JDK
- Eclipse IDE is optional; the repository includes Eclipse project files

## Running the project

### Eclipse

1. Select **File → Import → Existing Projects into Workspace**.
2. Choose this repository.
3. Run `rngchess.mainWindow` as a Java application.

## Project structure

```text
src/rngchess/   Application, board, and chess-piece classes
assets/         Chess-piece images and other visual assets
icon.png        Application icon
```

## Git workflow

Before starting work, download the latest changes:

```powershell
git fetch origin
git pull --ff-only origin main
```

After making a change, review and publish it:

```powershell
git status
git add .
git commit -m "Describe the change"
git push
```

## Asset credit

Chess-piece images were downloaded from the [Wikimedia Commons PNG chess pieces collection](https://commons.wikimedia.org/wiki/Category:PNG_chess_pieces/Standard_transparent).
