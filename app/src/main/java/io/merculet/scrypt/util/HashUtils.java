package io.merculet.scrypt.util;

import android.util.Base64;

/**
 * Created by tony on 2018/8/1.
 */
public final class HashUtils {

    /**
     * Decodes a Base64 string to a byte array.
     *
     * @param string
     *            (in Base64)
     * @return Base64 decoded byte array
     * @see <a href="https://en.wikipedia.org/wiki/Base64">https://en.wikipedia.org/wiki/Base64</a>
     */
    public static byte[] decodeBase64(String string) {
        return Base64.decode(string.getBytes(), Base64.DEFAULT);
    }

    /**
     * Encodes a byte array into a Base64 string.
     *
     * @param array
     *            (byte array)
     * @return Base64 encoded string
     * @see <a href="https://en.wikipedia.org/wiki/Base64">https://en.wikipedia.org/wiki/Base64</a>
     */
    public static String encodeBase64(byte[] array) {
        return new String(Base64.encode(array, Base64.DEFAULT));
    }
}
