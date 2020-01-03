package com.bieganski.ox.model;

/**
 * Field represents symbol O or X on given by user position.
 */
public class Field implements Comparable<Field> {

  private int position;
  private Symbol symbol;

  public Field(int position, Symbol symbol) {
    this.position = position;
    this.symbol = symbol;
  }

  /**
   * Check if field is on given position.
   * @param position - position to compare
   * @return true if field is on given position
   */
  public boolean isOnPosition(int position) {
    return this.position == position;
  }

  /**
   * Check if field is in given bounds.
   * @param bounds - bounds of board
   * @return true if field position is in given bounds
   */
  public boolean isInBounds(int bounds) {
    return 0 <= position && position < bounds;
  }

  /**
   * Check if symbols of two fields are equal.
   * @param field - field to compare
   * @return true if symbols are equal
   */
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
