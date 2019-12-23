package com.bieganski.ox;

class IndexCreator {
    private int boardSide;

    public IndexCreator(int boardSide) {
        this.boardSide = boardSide;
    }

    void indexColumns(StringBuilder stringBuilder) {
        stringBuilder.append(createSpaces(boardSide));
        for (int i = 0; i < boardSide; i++) {
            nextIndex(stringBuilder, i);
        }
        stringBuilder.append("\n");
    }
    void nextIndex(StringBuilder stringBuilder, int index){
        if (index < 10)
            stringBuilder.append(String.format(" %s ", index));
        else if (index < 100)
            stringBuilder.append(String.format("%s ", index));
        else
            stringBuilder.append(String.format("%s", index));
    }
    private String createSpaces(int size){
        int maxIndexLength = String.valueOf(size - 1).length();
        return " ".repeat(maxIndexLength);
    }
}
