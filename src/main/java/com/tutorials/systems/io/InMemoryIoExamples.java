package com.tutorials.systems.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.UncheckedIOException;
import java.util.List;

/**
 * java.io streams are a DECORATOR chain: a DataOutputStream wraps a
 * ByteArrayOutputStream, adding typed-write methods (writeInt, writeUTF...)
 * on top of the raw byte sink underneath — same pattern as
 * BufferedReader wrapping an InputStreamReader wrapping a raw InputStream.
 * In-memory streams (the ByteArray and String stream families) let this run
 * with no filesystem dependency, which is exactly why they are used here
 * instead of real files (see the nio package for real file I/O).
 */
public class InMemoryIoExamples {
    public static List<String> readLines(String content) {
        // BufferedReader.lines() returns a Stream backed by the reader — it must be
        // closed to release the reader, which try-with-resources guarantees here.
        try (BufferedReader reader = new BufferedReader(new StringReader(content))) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static byte[] serializeInts(int[] numbers) {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        try (DataOutputStream dataOut = new DataOutputStream(byteOut)) {
            dataOut.writeInt(numbers.length);
            for (int n : numbers) {
                dataOut.writeInt(n);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return byteOut.toByteArray();
    }

    public static int[] deserializeInts(byte[] bytes) {
        try (DataInputStream dataIn = new DataInputStream(new ByteArrayInputStream(bytes))) {
            int length = dataIn.readInt();
            int[] result = new int[length];
            for (int i = 0; i < length; i++) {
                result[i] = dataIn.readInt();
            }
            return result;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
