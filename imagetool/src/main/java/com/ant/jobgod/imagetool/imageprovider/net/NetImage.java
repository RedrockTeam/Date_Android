package com.ant.jobgod.imagetool.imageprovider.net;

import java.io.Serializable;

/**
 * Created by Mr.Jude on 2015/2/23.
 */
public abstract class NetImage implements Serializable{

    public abstract String getThumbImg();

    public abstract String getLargeImg();

    public abstract int getWidth();

    public abstract int getHeight();
}
