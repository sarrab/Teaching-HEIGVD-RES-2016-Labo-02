package ch.heigvd.res.lab01.impl.explorers;

import ch.heigvd.res.lab01.interfaces.IFileExplorer;
import ch.heigvd.res.lab01.interfaces.IFileVisitor;
import java.io.File;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered
 * node (file and directory). When the explorer reaches a directory, it visits all
 * files in the directory and then moves into the subdirectories.
 * 
 * @author Olivier Liechti
 */
public class DFSFileExplorer implements IFileExplorer {

  @Override
  public void explore(File rootDirectory, IFileVisitor vistor) {
      if (rootDirectory == null) {
          return;
      }
      //on visite le noeud
      vistor.visit(rootDirectory);
      //si le neoud est un dossier on explore son contenu
      if (rootDirectory.isDirectory()) {
          File[] files = rootDirectory.listFiles();
          if (files == null) {
              return;
          }
          for (File file : files) {
              //si il est un fichier, avec explore on le visite seulement
              if (file.isFile()) {
                  explore(file, vistor);
              }
          }
          for (File file : files) {
              // si il est un dossier on visite d'abord son contenu avec l'appel récursif
              if (file.isDirectory()) {
                  explore(file, vistor);
              }
          }
      } else {
          return;
      }
  }

}
