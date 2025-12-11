package com.example.tiktok.utils;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * 资源工具类：文件名转资源ID（带缓存）
 */
public class ResourceUtils {
    private static final Map<String, Integer> DRAWABLE_CACHE = new HashMap<>();

    /**
     * 获取Drawable资源ID
     */
    public static int getDrawableResId(Context context, String resName) {
        if (resName == null || resName.isEmpty()) {
            return 0;
        }
        // 查缓存
        if (DRAWABLE_CACHE.containsKey(resName)) {
            return DRAWABLE_CACHE.get(resName);
        }
        // 获取资源ID
        int resId = context.getResources().getIdentifier(
                resName,
                "drawable",
                context.getPackageName()
        );
        // 缓存结果
        DRAWABLE_CACHE.put(resName, resId);
        return resId;
    }
    @BindingAdapter(value = {"resName", "context"}, requireAll = true)
    public static void loadImage(ImageView imageView, String resName, Context context) {
        // 1. 通过资源名获取资源ID
        int resId = ResourceUtils.getDrawableResId(context, resName);

        // 2. 将资源ID转换为Drawable并设置到ImageView
        if (resId != 0) {
            imageView.setImageResource(resId);
        }
    }
    /**
     * 清空缓存
     */
    public static void clearCache() {
        DRAWABLE_CACHE.clear();
    }
}