# Compiler

A C-subset compiler project built with ANTLR4 and C++. It defines a lexer and parser, builds a syntax tree, maintains compiler data structures, and generates assembly output.

## Requirements

- C++17 compiler
- ANTLR 4.13.2
- ANTLR4 C++ runtime

## Run

Make the script executable and pass a source file to it:

```bash
chmod +x run-script.sh
./run-script.sh input.txt
```

The compiler writes generated assembly and diagnostic output to files in the project directory.