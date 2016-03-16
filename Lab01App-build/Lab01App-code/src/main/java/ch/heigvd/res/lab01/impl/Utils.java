package ch.heigvd.res.lab01.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {
      

      String[] toReturn = new String[2];
      //chercher le retour à la ligne
      int separatorIndex = lines.indexOf("\n");
      //s'il ny pas on cherche des tabulations
      if (separatorIndex == -1) {
          separatorIndex = lines.indexOf("\r"); // for \r
      }
      //s'il n' y pas de séparateurs..
      if (-1 == separatorIndex) {
          toReturn[0] = "";
          toReturn[1] = lines;
          return toReturn;
      } else {
          toReturn[0] = lines.substring(0, separatorIndex + 1);
          if (lines.length() < separatorIndex + 1) {
              toReturn[1] = "";
          } else {
              toReturn[1] = lines.substring(separatorIndex+1);
          }
      }
      return toReturn;
 }

}
