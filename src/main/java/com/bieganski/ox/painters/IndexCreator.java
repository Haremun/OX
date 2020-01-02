package com.bieganski.ox.painters;

class IndexCreator {
    private int boardSide;

    IndexCreator(int boardSide) {
        this.boardSide = boardSide;
    }

    void indexColumns(StringBuilder stringBuilder) {
        stringBuilder.append(createSpaces());
        for (int i = 0; i < boardSide; i++) {
            nextIndex(stringBuilder, i);
        }
        stringBuilder.append("\n");
    }
  
    void nextIndex(StringBuilder stringBuilder, int index) {

        if (index < 10)
            stringBuilder.append(String.format(" %s ", index));
        else if (index < 100)
            stringBuilder.append(String.format("%s ", index));
        else
            stringBuilder.append(String.format("%s", index));
    }
  
    private String createSpaces() {
        return " ".repeat(3);
    }
}
