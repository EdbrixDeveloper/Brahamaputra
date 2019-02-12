package com.brahamaputra.mahindra.brahamaputra.commons;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.brahamaputra.mahindra.brahamaputra.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OfflineStorageWrapper {

    private File yourAppStorageDir;


    public OfflineStorageWrapper(Context context, String userId, String ticketNo) {
        yourAppStorageDir = new File(Environment.getExternalStorageDirectory(), "/" + context.getString(R.string.app_name) + "/offlinedata/" + userId + "/" + ticketNo + "/");
        if (!yourAppStorageDir.exists()) {
            boolean isDirCreated = yourAppStorageDir.mkdirs();
            Log.d("Brahmputra App", "App mediaStorageDirectory created :" + isDirCreated);
        }
    }

    public static OfflineStorageWrapper getInstance(Context appContext, String userId, String ticketNo) {
        return new OfflineStorageWrapper(appContext, userId, ticketNo);
    }

    public boolean checkOfflineFileIsAvailable(String filename) {
        File fname = new File(yourAppStorageDir.toString(), filename);
        if (fname.exists() && fname.isFile()) {
            return true;
        }
        return false;
    }

    public boolean removedOffLineFile(String filename) {
        File fObj = new File(yourAppStorageDir.toString(), filename);
        if (fObj.exists() && fObj.isFile()) {
            return fObj.delete();
        }
        return false;
    }

    public File getFileObjectByName(String filename) {
        return new File(yourAppStorageDir.toString(), filename);
    }

    public String getOfflineStorageFolderPath(String folderName) {
        File folderDir = new File(yourAppStorageDir.toString(), folderName + "/");
        boolean isDirCreated = false;
        if (!folderDir.exists()) {
            isDirCreated = folderDir.mkdirs();
        }

        return isDirCreated ? folderDir.toString() : folderDir.getPath();
    }

    /**
     * @param filename file name with extension without full path
     * @return object content of file i.e. String, JsonObject etc.
     * @throws IOException,ClassNotFoundException
     */
    public Object getObjectFromFile(String filename) throws IOException, ClassNotFoundException {
        Object object = null;
        File fileObj = getFileObjectByName(filename);
        if (fileObj.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileObj));
            object = objectInputStream.readObject();
            objectInputStream.close();
        }
        return object;
    }

    /**
     * @param filename   file name with extension without full path
     * @param fileObject content of file i.e. String, JsonObject etc.
     * @return filePath full path of created file.
     * @throws IOException
     */
    public String saveObjectToFile(String filename, Object fileObject) throws IOException {
        File fileObj = getFileObjectByName(filename);

        if (fileObj.exists() && fileObj.isFile()) {
            fileObj.delete();
        }

        if (fileObj.createNewFile()) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileObj));
            objectOutputStream.writeObject(fileObject);
            objectOutputStream.close();
        }

        return fileObj.getPath();
    }
}
