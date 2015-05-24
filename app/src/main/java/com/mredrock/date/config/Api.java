package com.mredrock.date.config;

/**
 * Created by Lecion on 4/3/15.
 */
public class Api {
    public static final String BASE_URL = "http://106.184.7.12:8002/index.php/api";
    public static final String SEPERATOR = "/";



    public class Url {
        public static final String Banner = BASE_URL + "/public/banner";
    }

    public class Key {
        public static final String STATUS = "status";
        public static final String DATA = "data";
        public static final String INFO = "info";
        public static final String TOKEN = "token";
        public static final String UID = "uid";
        public static final String PAGE = "page";
        public static final String SIZE = "size";

        public class Letter {
            public static final String LETTER_ID = "letter_id";
            public static final String USER_ID = "user_id";
            public static final String USER_NAME = "user_name";
            public static final String USER_SIGNATURE = "user_signature";
            public static final String USER_AVATAR = "user_avatar";
            public static final String USER_GENDER = "userGender";
            public static final String CONTENT = "content";
            public static final String DATA_ID = "date_id";
            public static final String LETTER_STATUS = "letter_status";
            public static final String USER_DATE_STATUS = "user_date_status";
            public static final String TO_ID = "to_id";
            public static final String ACTION = "action";
            public static final String USER_SCORE = "user_score";
        }
    }


    public class Module {
        public static final String LETTER = "letter";
    }

    public class Method {
        public static final String GET_LETTER = "getletter";
        public static final String DATE_ACTION = "dateaction";
    }

    public class Code {
        public static final  int OK = 200;
        public static final int PERMISSION_DENIED = 403;
        public static final int SERVER_ERROR = 500;

    }
}
