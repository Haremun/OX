package com.bieganski.ox.model;

/**
 * Field represents symbol O or X on a given by user position.
 */
public class Field implements Comparable<Field> {

  private int position;
  private Symbol symbol;

  public Field(int position, Symbol symbol) {
    this.position = position;
    this.symbol = symbol;
  }

  public boolean isOnPosition(int position) {
    return this.position == position;
  }

  /**
   * Check if field is on position between 0 and upper bound.
   * @param upperBound - bound of board
   * @return true if field position is between 0 and upper bound
   */
  public boolean isInBounds(int upperBound) {
    return 0 <= position && position < upperBound;
  }

  public boolean areSymbolsEqual(Field field) {
    return this.symbol.equals(field.symbol);
  }

  //TODO shouldn't calculate distance here
  public int distanceTo(Field field) {
    return Math.abs(this.position - field.position);
  }

  @Override
  public int compareTo(Field field) {
    return Integer.compare(position, field.position);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return position == ((Field) o).position;
  }

  @Override
  public int hashCode() {
    return position;
  }

  @Override
  public String toString() {
    return String.valueOf(symbol);
  }
}
