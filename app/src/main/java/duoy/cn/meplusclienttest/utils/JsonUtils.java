package duoy.cn.meplusclienttest.utils;

import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Dream on 2016/3/3.
 */
public class JsonUtils {
    private static final String TAG = JsonUtils.class.getSimpleName();
    static ObjectMapper mapper= new ObjectMapper();//// can reuse, share globally,ObjectMapper是jackson中的主要类

    public static <T> T readValue(String content, Class<T> valueType) {//把json转成对象
        try {
            return mapper.readValue(content, valueType);
        } catch (IOException e) {
            Log.e(TAG, "readValue", e);
        }
        return null;
    }

    public static String writeValueAsString(Object obj) {//把对象转成json
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            Log.e(TAG, "writeValueAsString", e);
        }
        return null;
    }

}
