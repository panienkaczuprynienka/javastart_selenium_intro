package configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class PropertiesLoader {
  //będzie odczytywała plik properties

  private Logger logger = LogManager.getLogger(PropertiesLoader.class);

  //W klasie znajduje się tylko jedna metoda. Służy ona do odczytywania właściwości z zadanego pliku properties
  public Properties getPropertiesFromFile(String propertiesFileName) {

    //Tworzymy obiekt InputStream, który posłuży nam  do odczytania pliku properties
    InputStream inputStream = null;

    //Obiekt Properties będzie przechowywał właściwości
    Properties properties = new Properties();
    try {
      logger.info("Trying to load properties with file name: " + propertiesFileName);

      //Odczytujemy plik properties i inicjalizujemy obiekt inputStream
      inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

      //Jeśli plik properties by nie istniał, obiekt inputStream będzie null-em. W związku z czym
      // zostanie rzucony wyjątek FileNotFoundException
      if (inputStream != null) {
        //Ładujemy properties w formie InputStream do właściwego obiektu typu Properties
        properties.load(inputStream);
        logger.info("Successfully loaded properties for file: " + propertiesFileName);
      } else {
        throw new FileNotFoundException("Property file '" + propertiesFileName + "' not found in the classpath");
      }

    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Cannot load properties due to IOException!");
    } finally {
      // Na sam koniec zamykamy InputStream wywołując prywatną metodę closeResource
      closeResource(inputStream);
    }

    //Zwracamy zainicjalizowany obiekt properties
    return properties;
  }

  private void closeResource(InputStream inputStream) {
    try {
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
