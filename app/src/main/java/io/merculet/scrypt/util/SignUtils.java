package io.merculet.scrypt.util;

/**
 * @version V1.0 <描述当前版本功能>
 * @FileName: io.merculet.io.merculet.scrypt.util.SignUtils.java
 * @author: Tony Shen
 * @date: 2018-05-07 21:11
 */
public class SignUtils {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("scrypt");
    }

    public static native byte[] scryptN(byte[] password, byte[] salt, int cost, int blocksize, int parallel, int length);
}
