package pl.edu.pw.elka.prm2t;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Some common utilities for PRM2T lectures.
 * @author kmi
 * @version 1.1
 */
public class PRM2TUtil {

	/**
	 * No instances for this class!
	 */
	private PRM2TUtil() {
	}

	public static final int BACKSPACE = 0x8;
	public static final int LINE_FEED = 0xA;
	public static final int CARRIAGE_RETURN = 0xD;

	/**
	 * Prints one character to {@code System.out}.
	 * @param c character to be written.
	 */
	public static void prc(int c) {
		System.out.format("%c", c);
	}

	/**
	 * Prints backspace character, i.e. deletes the last character written to {@code System.out} if it was not a
	 * newLine nor lineFeed nor carriageReturn.
	 */
	public static void BS() {
		System.out.format("%c", BACKSPACE);
	}

	/**
	 * Prints line feed character, i.e. it prints {@code \n}.
	 */
	public static void LF() {
		System.out.format("%c", LINE_FEED);
	}

	/**
	 * Prints carriage return character, i.e. it deletes all the characters already printed in the current line.
	 */
	public static void CR() {
		System.out.format("%c", CARRIAGE_RETURN);
	}
	
	/**
	 * Writes a formatted string to {@code System.out} stream using the specified format string and arguments.
     *  
	 * @param format <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Formatter.html#syntax">
	 * Format string syntax</a>
	 * @param args argument to be written.
	 */
	public static void pr(String format, Object... args) {
    	System.out.format(format, args);
    }
    
    /**
     * Writes a formatted string to {@code System.out} stream using the specified format string and arguments with
	 * the following new line character.
     * 
	 * @param format <a href="https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Formatter.html#syntax">
	 * Format string syntax</a>
	 * @param args argument to be written.
     */
    public static void prn(String format, Object... args) {
		System.out.format(format + "%n", args);
    }

	/**
	 * Writes the string representation of the given object to {@code System.out} stream with the following new line character.
	 * @param arg the object whose string representation is to be written.
	 */
	public static void prn(Object arg) {
		System.out.format("%s%n", arg);
	}

	/**
	 * Writes the new line character to {@code System.out}.
	 */
	public static void prn() {
		System.out.format("%n");
	}

	/**
	 * Makes current thread sleeping for timeToSleep milliseconds. No exceptions thrown.
	 */
	public static void sleep(long timeToSleep) {
    	try {
    		Thread.sleep(timeToSleep);
		} catch (InterruptedException ignore) {
		}
	}

	/**
	 * Simple class to measure running time of some tasks. Usage: create the object just before
	 * the task starts, then call its get() method here after the task completes to get the running
	 * time in milliseconds.
	 */
	public final static class RunningTime {
		private final long startTime;

		public RunningTime() {
			startTime = System.currentTimeMillis(); 
		}

		public long get() { 
			return Math.abs(System.currentTimeMillis() - startTime); 
		}
	}

	/**
	 * Reads the image from a file.
	 * @param pathName the path to the image file.
	 * @return two-dimensional array of pixels stored as {@code int}s.
	 * @throws IOException if occurred during reading.
	 */
	public static int[][] readImage(String pathName) throws IOException {
		BufferedImage img = ImageIO.read(new File(pathName));
		int width = img.getWidth();
		int height = img.getHeight();
		int[] pixels1d = img.getRaster().getPixels(0, 0, width, height, (int[]) null);

		// zamiana z tablicy 1d na 2d
		int[][] pixels = new int[height][width];
		for (int i = 0; i < height; i++) {
			System.arraycopy(pixels1d, i * width, pixels[i], 0, width);
		}
		return pixels;
	}

	/**
	 * Short class' test.
	 * @param args not used.
	 */
	public static void main(String[] args) {
		RunningTime rt = new RunningTime();
		pr("");
		pr("1 ");
		pr("test format ");
		pr("%d ", 33);
		prn("%d", 12);
		prn("%d", 21);
		sleep(750);
		prn("running time: %d ms", rt.get());
		pr("two k than CARRIAGE_RETURN: kk");
		prc(CARRIAGE_RETURN);
		pr("three k: kkk");
		prc(LINE_FEED);
		pr("five k than BACKSPACE: kkkkk");
		prc(BACKSPACE);
	}
}