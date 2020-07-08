package com.sec.aidog.util;

import java.io.*;

public class FileSysUtil {
    public static String getFileExt(String filename) {
        int index = filename.lastIndexOf(".");

        if (index == -1) {
            return null;
        }
        String result = filename.substring(index + 1);
        return result;
    }

    public synchronized static boolean SaveResourceFile(String sFilePath, byte[] content) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(sFilePath);
            fos.write(content);
            fos.flush();
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if(fos != null) {
                try {
                    fos.close();

                    File file = new File(sFilePath);
                    file.setReadable(true, false);
                    file.setExecutable(true, false);
                    file.setWritable(true, false);
                } catch (Exception e) {
                    System.out.println("error  " + e.getMessage());
                }
            }
        }
    }

    public synchronized static void Copy(File srcfile, String dstFile) {
        try {
            int bytesum = 0;
            int byteread = 0;
            if (srcfile.exists()) {
                InputStream inStream = new FileInputStream(srcfile);
                FileOutputStream fs = new FileOutputStream(dstFile);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread;
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
                fs.close();
            }
        } catch (Exception e) {
            System.out.println("error  ");
            e.printStackTrace();
        }
    }

    public synchronized static void Copy(String srcfile, String dstFile) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(srcfile);
            if (oldfile.exists()) {
                InputStream inStream = new FileInputStream(srcfile);
                FileOutputStream fs = new FileOutputStream(dstFile);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread;
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
                fs.close();
            }
        } catch (Exception e) {
            System.out.println("error  ");
            e.printStackTrace();
        }
    }

    public synchronized static boolean Move(File srcFile, String dstFile) {
        // Destination directory
        File dir = new File(dstFile);

        // Move file to new directory
        boolean success = srcFile.renameTo(new File(dir, srcFile.getName()));

        return success;
    }

    public synchronized static boolean Move(String srcFile, String dstFile) {
        // File (or directory) to be moved
        File file = new File(srcFile);

        // Destination directory
        File dir = new File(dstFile);

        // Move file to new directory
        boolean success = file.renameTo(new File(dir, file.getName()));

        return success;
    }

    public synchronized static boolean CreateFolder(String filePath) {
        boolean rtn = false;
        try {
            File baseDir = new File(filePath);
            if(!baseDir.exists())
                baseDir.mkdirs();

            rtn = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }

    public synchronized static boolean deleteFolder(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //锟捷癸拷删锟斤拷目录锟叫碉拷锟斤拷目录锟斤拷
            for (int i=0; i<children.length; i++) {
                boolean success = deleteFolder(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录锟斤拷时为锟秸ｏ拷锟斤拷锟斤拷删锟斤拷
        return dir.delete();
    }
}
