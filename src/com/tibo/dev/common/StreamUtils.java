package com.tibo.dev.common;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: tibo
 * Date: 20/09/11
 * Time: 16:18
 * To change this template use File | Settings | File Templates.
 */
public class StreamUtils {

             private static final int BUFFER_SIZE = 128;

    /**
     * Write a stream into another stream
     * @param in read stream
     * @param out write stream
     * @throws IOException
     */
    public static void input2Ouput(InputStream in, OutputStream out) throws IOException{
        byte[] buffer = new byte[BUFFER_SIZE];
        int count = 0;
        while((count = in.read(buffer)) != -1){
            out.write(buffer, 0, count);
        }
    }

    /**
     * Write the stream into the file
     * @param in inputStream
     * @param file
     * @throws IOException
     */
    public static void input2File(InputStream in, File file) throws IOException{
        FileOutputStream write = new FileOutputStream(file);
        input2Ouput(in, write);
        write.close();
    }

}
