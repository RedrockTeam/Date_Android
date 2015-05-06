package com.mredrock.date.config;

/**
 * Created by Lecion on 4/3/15.
 */
public class Api {
    public static final String BASE_URL = "http://106.184.7.12:8002/index.php/api";
    public static final String SEPERATOR = "/";

    public class Key {
        public static final String STATUS = "status";
        public static final String DATA = "data";
        public static final String TOKEN = "token";
        public static final String UID = "uid";
        public static final String PAGE = "page";
        public static final String SIZE = "size";
    }


    public class Module {
        public static final String LETTER = "letter";
    }

    public class Method {
        public static final String GET_LETTER = "getletter";
    }

    public class Code {
        public static final  int OK = 200;
        public static final int PERMISSION_DENIED = 403;
        public static final int SERVER_ERROR = 500;

    }
}
