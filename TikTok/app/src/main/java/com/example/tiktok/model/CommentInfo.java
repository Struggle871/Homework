package com.example.tiktok.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.tiktok.BR;

import java.util.Objects;

/**
 * 评论实体类
 */
public class CommentInfo extends BaseObservable {
    // 评论ID
    private int id;
    // 评论内容
    private String content;
    // 评论者昵称
    private String commenterName;
    // 评论者头像
    private String commenterAvatarResName;

    public CommentInfo() {}
    public CommentInfo(int id, String content, String commenterName, String commenterAvatarResName) {
        this.id = id;
        this.content = content;
        this.commenterName = commenterName;
        this.commenterAvatarResName = commenterAvatarResName;
    }

    @Bindable
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }

    @Bindable
    public String getCommenterName() {
        return commenterName;
    }
    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
        notifyPropertyChanged(BR.commenterName);
    }

    @Bindable
    public String getCommenterAvatarResName() {
        return commenterAvatarResName;
    }
    public void setCommenterAvatarResName(String commenterAvatarResName) {
        this.commenterAvatarResName = commenterAvatarResName;
        notifyPropertyChanged(BR.commenterAvatarResName);
    }
    public boolean equals(Object o) {
        if (this == o) return true; // 地址相同直接返回true
        if (o == null || getClass() != o.getClass()) return false; // 类型不同返回false
        CommentInfo commentInfo = (CommentInfo) o;
        // 比较所有需要判断“内容是否相同”的字段
        return id == commentInfo.id &&
                Objects.equals(content, commentInfo.content) &&
                Objects.equals(commenterName, commentInfo.commenterName) &&
                Objects.equals(commenterAvatarResName,commentInfo.commenterAvatarResName);
    }

    // 重写hashCode()：与equals()保持一致（规范要求）
    @Override
    public int hashCode() {
        return Objects.hash(id, content, commenterName, commenterAvatarResName);
    }
}