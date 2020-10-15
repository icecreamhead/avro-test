package avro.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ByteUtil {

    public static String xxd(byte[] bytes) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (PrintStream stream = new PrintStream(baos)) {
            for (int idx = 0; idx < bytes.length; idx += 16) {
                printLineNumber(stream, idx);
                printHexBytes(stream, bytes, idx);
                stream.print("  ");
                printPrintableChars(stream, bytes, idx);
                stream.print("\n");
            }
        }
        return baos.toString();
    }

    private static void printLineNumber(PrintStream stream, int line) {
        stream.printf("%08x:", line);
    }

    private static void printHexCharOrSpace(PrintStream stream, byte[] bytes, int offset) {
        if (offset < bytes.length) {
            stream.printf("%02x", bytes[offset]);
        } else {
            stream.print("  ");
        }
    }

    private static void printHexBytes(PrintStream stream, byte[] bytes, int offset) {
        for (int j = 0; j < 8; ++j) {
            stream.print(" ");
            printHexCharOrSpace(stream, bytes, offset + 2 * j);
            printHexCharOrSpace(stream, bytes, offset + 2 * j + 1);
        }
    }

    private static void printPrintableChars(PrintStream stream, byte[] bytes, int offset) {
        for (int j = 0; j < 16; ++j) {
            if (offset + j < bytes.length) {
                byte b = bytes[offset + j];
                if (Character.isISOControl((char) b)) {
                    stream.print(".");
                } else {
                    stream.append((char) b);
                }
            } else {
                stream.append(' ');
            }
        }
    }
}