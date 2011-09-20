package com.tibo.dev.common;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: tibo
 * Date: 20/09/11
 * Time: 16:38
 * To change this template use File | Settings | File Templates.
 */
public class ZipTools {


    /**
     * @param files
     * @param destination
     * @throws Exception
     */
    public static void createZip(Map<String, InputStream> files, OutputStream destination) throws Exception {
        ZipOutputStream out = new ZipOutputStream(destination);
        Set<String> set = files.keySet();
        for (String key : set) {
            ZipEntry entry = new ZipEntry(key);
            out.putNextEntry(entry);
            InputStream in = files.get(key);
            byte data[] = new byte[2048];
            int count;
            while ((count = in.read(data)) != -1) {
                out.write(data, 0, count);
            }
            out.closeEntry();
            in.close();
        }
        out.close();
    }

    /**
     * @param file
     * @param destination
     * @throws Exception
     */
    public static void createZip(File file, OutputStream destination) throws Exception {
        ZipOutputStream out = new ZipOutputStream(destination);
        ZipEntry entry = new ZipEntry(file.getName());
        out.putNextEntry(entry);
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        byte data[] = new byte[2048];
        int count;
        while ((count = in.read(data)) != -1) {
            out.write(data, 0, count);
        }
        out.closeEntry();
        in.close();
        out.close();
    }

    /**
     * @param base
     * @param path
     * @param out
     * @throws Exception
     */
    public static void zipDir(File base, String path, ZipOutputStream out) throws Exception {

        if (path != null && path.length() > 0){
            path += "/";
        }

        byte[] readBuffer = new byte[2048];
        int bytesIn = 0;

        for (File f : base.listFiles()) {

            if (f.isDirectory()) {
                ZipEntry entry = new ZipEntry(path + f.getName() + "/");
                out.putNextEntry(entry);
                zipDir(f, path + f.getName(), out);
                continue;
            }

            FileInputStream fis = new FileInputStream(f);
            ZipEntry entry = new ZipEntry(path + f.getName());
            out.putNextEntry(entry);
            while ((bytesIn = fis.read(readBuffer)) != -1) {
                out.write(readBuffer, 0, bytesIn);
            }
            fis.close();
            out.closeEntry();
        }
    }

}
