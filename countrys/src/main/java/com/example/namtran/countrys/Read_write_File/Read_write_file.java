package com.example.namtran.countrys.Read_write_File;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Nam Tran on 8/5/2015.
 */
public class Read_write_file {
    Context mContext;

    public Read_write_file(Context mContext) {
        this.mContext = mContext;
    }

    public boolean internalFileExistance(String filename)
    {
        File file = mContext.getFileStreamPath(filename);
        return file.exists();
    }
    public void copyFiletoInternal(InputStream inputStream,String name)
    {
        try {
            FileOutputStream fileOutputStream = mContext.openFileOutput(name, Context.MODE_PRIVATE);
            byte[] buffer = new byte[512];
            int i = 0;
            while ((i = inputStream.read(buffer)) != -1)
            {
                fileOutputStream.write(buffer, 0, i);
            }
            fileOutputStream.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
