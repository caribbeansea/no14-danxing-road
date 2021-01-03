package com.caribbeansea.engine.utils;

/*
 * Creates on 2020/5/14.
 */

import com.caribbeansea.engine.Log;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author kevin
 */
public class AutoClose
{

  public static void close(Closeable... closeables) {
    try {
      if (closeables == null) return;
      for (Closeable closeable : closeables) {
        if (closeable == null) continue;
        closeable.close();
      }
    }catch (IOException e){
      Log.error("close failure.", e);
    }
  }

}