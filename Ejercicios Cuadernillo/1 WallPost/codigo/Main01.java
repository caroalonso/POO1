package ejercicio1;

import javax.swing.SwingUtilities;

import ejercicio1.ui.WallPostUI;

public class Main01 {

  public static void main(String[] args) {
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/package-summary.html
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new WallPostUI();
      }
    });
  }
}

