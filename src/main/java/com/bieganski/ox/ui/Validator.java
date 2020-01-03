package com.bieganski.ox.ui;

/**
 * Validator checks if given argument is correct.
 */
interface Validator {
  /**
   * Checks if given String is in proper pattern.
   *
   * @param textToValidate - String to validate
   * @return true if String matches pattern
   */
  boolean checkString(String textToValidate);
}
