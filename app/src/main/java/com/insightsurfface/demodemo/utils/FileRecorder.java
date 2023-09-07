package com.insightsurfface.demodemo.utils;

import android.media.AudioFormat;
import android.media.AudioRecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by chengyijun on 2018/12/10.
 */
public class FileRecorder {
    private static final String TAG = "FileRecorder";
    private static final int SAMPLE_RATE_INHZ = 16000;
    private static final int CHANNEL_CONFIG = AudioFormat.CHANNEL_IN_MONO;
    private static final int AUDIO_FORMAT = AudioFormat.ENCODING_PCM_16BIT;

    // return size of inFilename
    public static long savePcmToWav(File pcmFile, File wavFile) {
        FileInputStream in = null;
        FileOutputStream out = null;
        long totalPcmLen = 0;
        long totalWavLen;
        long longSampleRate = SAMPLE_RATE_INHZ;
        int channels = 1;
        long byteRate = 16 * SAMPLE_RATE_INHZ * channels / 8;
        byte[] data = new byte[AudioRecord.getMinBufferSize(SAMPLE_RATE_INHZ, CHANNEL_CONFIG, AUDIO_FORMAT)];
        try {
            in = new FileInputStream(pcmFile);
            totalPcmLen = in.getChannel().size();
            if (totalPcmLen == 0) {
                // inFilename is empty
                return 0;
            }
            out = new FileOutputStream(wavFile, true);
            totalWavLen = totalPcmLen + 36;
            writeWaveFileHeader(out, totalPcmLen, totalWavLen, longSampleRate, channels, byteRate);
            while (in.read(data) != -1) {
                out.write(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return totalPcmLen;
    }

    /**
     * 加入wav文件头
     */
    private static void writeWaveFileHeader(FileOutputStream out, long totalAudioLen,
                                            long totalDataLen, long longSampleRate, int channels, long byteRate)
            throws IOException {
        byte[] header = new byte[44];
        // RIFF/WAVE header
        header[0] = 'R';
        header[1] = 'I';
        header[2] = 'F';
        header[3] = 'F';
        header[4] = (byte) (totalDataLen & 0xff);
        header[5] = (byte) ((totalDataLen >> 8) & 0xff);
        header[6] = (byte) ((totalDataLen >> 16) & 0xff);
        header[7] = (byte) ((totalDataLen >> 24) & 0xff);
        //WAVE
        header[8] = 'W';
        header[9] = 'A';
        header[10] = 'V';
        header[11] = 'E';
        // 'fmt ' chunk
        header[12] = 'f';
        header[13] = 'm';
        header[14] = 't';
        header[15] = ' ';
        // 4 bytes: size of 'fmt ' chunk
        header[16] = 16;
        header[17] = 0;
        header[18] = 0;
        header[19] = 0;
        // format = 1
        header[20] = 1;
        header[21] = 0;
        header[22] = (byte) channels;
        header[23] = 0;
        header[24] = (byte) (longSampleRate & 0xff);
        header[25] = (byte) ((longSampleRate >> 8) & 0xff);
        header[26] = (byte) ((longSampleRate >> 16) & 0xff);
        header[27] = (byte) ((longSampleRate >> 24) & 0xff);
        header[28] = (byte) (byteRate & 0xff);
        header[29] = (byte) ((byteRate >> 8) & 0xff);
        header[30] = (byte) ((byteRate >> 16) & 0xff);
        header[31] = (byte) ((byteRate >> 24) & 0xff);
        // block align
        header[32] = (byte) (2 * 16 / 8);
        header[33] = 0;
        // bits per sample
        header[34] = 16;
        header[35] = 0;
        //data
        header[36] = 'd';
        header[37] = 'a';
        header[38] = 't';
        header[39] = 'a';
        header[40] = (byte) (totalAudioLen & 0xff);
        header[41] = (byte) ((totalAudioLen >> 8) & 0xff);
        header[42] = (byte) ((totalAudioLen >> 16) & 0xff);
        header[43] = (byte) ((totalAudioLen >> 24) & 0xff);
        out.write(header, 0, 44);
    }

    public static void deleteFile(File file) {
        if (file.isFile() && file.exists()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] childFile = file.listFiles();
            if (childFile == null || childFile.length == 0) {
                file.delete();
                return;
            }
            for (File f : childFile) {
                deleteFile(f);
            }
            file.delete();
        }
    }

    public static void clearDirectory(File dir) {
        if (dir.isFile()) {
            dir.delete();
            return;
        }
        File[] files = dir.listFiles();
        if (null == files || files.length == 0) {
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            } else {
                clearDirectory(file);
            }
        }
    }

    /**
     * 获取文件夹大小
     *
     * @param file File实例
     * @return long
     */
    public static long getFolderSize(File file) {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                if (fileList[i].isDirectory()) size = size + getFolderSize(fileList[i]);
                else size = size + fileList[i].length();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }
}
