package com.bieganski.ox.checkers;

import com.bieganski.ox.model.Field;

import java.util.TreeSet;

class TreeSetHelper {
  private TreeSet<Field> fields;

  public TreeSetHelper(TreeSet<Field> fields) {
    this.fields = fields;
  }

  Field getHigherField(Field field, int position) {
    Field next = fields.higher(field);

    if (next != null) {
      if (next.hashCode() == position) {
        return next;
      }
      if (next.hashCode() < position) {
        return getHigherField(next, position);
      }
    }
    return null;
  }

  Field getLowerField(Field field, int position) {
    Field next = fields.lower(field);
    if (next != null) {
      if (next.hashCode() == position) {
        return next;
      }
      if (next.hashCode() > position) {
        return getLowerField(next, position);
      }
    }
    return null;
  }
}
