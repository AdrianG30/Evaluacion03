package com.renato.ec03.network;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.renato.ec03.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

public class StoryEntry {
    private static final String TAG= StoryEntry.class.getSimpleName();
    public final String title;
    public final Uri dynamicUrl;
    public final String url;
    public final String description;

    public StoryEntry(String title, Uri dynamicUrl, String url, String description) {
        this.title = title;
        this.dynamicUrl = dynamicUrl;
        this.url = url;
        this.description = description;
    }
    public static List<StoryEntry> initStoryEntryList (Resources resources){
        InputStream inputStream= resources.openRawResource(R.raw.stories);
        Writer writer= new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader= new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            int pointer;
            while((pointer=reader.read(buffer)) != -1){
                writer.write(buffer,0, pointer);
            }
        }catch (IOException exception){
            Log.e(TAG, "Hubo un error al momento de leer y escribir el archivo Json ", exception);
        }finally {
            try {
                inputStream.close();
            }catch (IOException exception){
                Log.e(TAG, "Hubo un error al cerrar el input stream", exception);
            }

        }
        String jsonStoriesString = writer.toString();
        Gson gson=new Gson();
        Type storyListType=new TypeToken<ArrayList<StoryEntry>>(){

        }.getType();
        return gson.fromJson(jsonStoriesString, storyListType);
    }
}
