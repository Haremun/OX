package com.bieganski.ox.ui;

import com.bieganski.ox.model.Field;

import java.util.TreeSet;

class ConsoleBoardPainter implements BoardPainter {

  private int boardSide;

  public ConsoleBoardPainter(int boardSide) {
    this.boardSide = boardSide;
  }

  //TODO: Too long function
  @Override
  public String paintBoard(TreeSet<Field> fieldsWithValues) {
    StringBuilder stringBuilder = new StringBuilder();
    IndexCreator indexCreator = new IndexCreator(boardSide);

    Field fieldWithValue = null;
    if (!fieldsWithValues.isEmpty()) {
      fieldWithValue = fieldsWithValues.first();
    }
    indexCreator.indexColumns(stringBuilder);

    int counter = 0;
    indexCreator.nextIndex(stringBuilder, counter);

    for (int position = 0; position < boardSide * boardSide; position++) {

      if (fieldWithValue != null && fieldWithValue.isOnPosition(position)) {
        stringBuilder.append(String.format("[%s]", fieldWithValue));
        fieldWithValue = fieldsWithValues.higher(fieldWithValue);
      } else {
        stringBuilder.append("[ ]");
      }

      if ((position + 1) % boardSide == 0 && position + 1 != boardSide * boardSide) {
        stringBuilder.append("\n");
        counter++;
        indexCreator.nextIndex(stringBuilder, counter);
      }
    }

    return stringBuilder.toString();
  }
}
