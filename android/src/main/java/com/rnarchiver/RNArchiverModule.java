package com.rnarchiver;

import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import java.io.File;
import java.io.FileNotFoundException;
import org.rauschig.jarchivelib.Archiver;
import org.rauschig.jarchivelib.ArchiveFormat;
import org.rauschig.jarchivelib.ArchiverFactory;
import org.rauschig.jarchivelib.CompressionType;

public class RNArchiverModule extends ReactContextBaseJavaModule {
  
  private static final String TAG = RNArchiverModule.class.getSimpleName();
  private final ReactApplicationContext reactContext;

  public RNArchiverModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNArchiver";
  }

  @ReactMethod
  public void untar(final String tarPath, final String destDirectory, final Promise promise) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try{
          try { 
            File archive = new File(tarPath); 
            if (!archive.exists()){
              promise.reject(null, tarPath + " does not exist"); 
              return;
            }
            File destination = new File(destDirectory); 
            if (!destination.exists()){
              destination.mkdirs();
            }
            Archiver archiver = ArchiverFactory.createArchiver(ArchiveFormat.TAR, CompressionType.GZIP);
            try {
              archiver.extract(archive, destination);
            } catch (Exception ex) {
              promise.reject(null, ex.getMessage());
              return;
            }
            promise.resolve(destDirectory);
          } catch (Exception ex) {
            ex.printStackTrace(); 
            throw new Exception(String.format("Couldn't untar %s", tarPath));
          }
        } catch (Exception ex) {
          promise.reject(null, ex.getMessage());
          return;
        }
      }
    }).start();
  }
}