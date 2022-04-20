package pl.edu.pw.elka.prm2t.cw5;

import java.io.*;

/**
 * Napisz program typu copy służący do kopiowania plików, których nazwy przekazano jako argumenty wywołania.
 * Program ma być wydajny (użyj buforowanych operacji wejścia-wyjścia). Program musi być odporny na błędy.
 * Przetestuj różne sposoby zapewniania wydajności. Zastosuj testy jednostkowe.
 *
 * Termin: do końca 21 kwietnia 2022 r.
 * Wartość: 2 punkty
 *
 * Wpisz nazwiska autorów:
 * @author Adam Staciwa
 * @author Radosław Szawłowski
 */
public class Zadanie102_CopyFile {

    private static void copyFileUsingStream(String source, String dest) throws IOException {
        try (InputStream is = new FileInputStream(source)){
            try (OutputStream os = new FileOutputStream(dest);) {
                byte[] buffer = new byte[4096];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            }
        } finally {
            System.out.println("Koniec pracy programu");
        }
    }

    private static void bufferedCopy(String source, String dest, int bufferSize) throws IOException {
        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(source), bufferSize)) {
            try (BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(dest))) {
                byte[] buffer = new byte[bufferSize];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer);
                }
            }
        }
        finally {
            System.out.println("Koniec pracy programu");
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[] {"C:\\Users\\astac\\Desktop\\a.txt",
                    "C:\\Users\\astac\\Desktop\\b.txt" };
        }

        try {
            //copyFileUsingStream(args[0], args[1]);
            bufferedCopy(args[0], args[1], 4096);
        } catch (IOException e) {
            System.out.println("Błąd - " + e);
        }


        }

    }
