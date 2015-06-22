package com.mredrock.date.config;

/**
 * Created by Lecion on 4/3/15.
 */
public class Api {
    public static final String BASE_URL = "http://106.184.7.12:8002/index.php/api";
    public static final String SEPERATOR = "/";



    public class Url {
        public static final String PublicDate = BASE_URL + "/date/createdate";
        public static final String Login = BASE_URL + "/public/login";
        public static final String Banner = BASE_URL + "/public/banner";
        public static final String DateList = BASE_URL + "/date/datelist";
        public static final String CollectionList = BASE_URL + "/person/collection";
        public static final String JoinList = BASE_URL + "/person/join";
        public static final String Detail = BASE_URL + "/date/detaildate";
        public static final String CollectionDetail = BASE_URL + "/person/collect";
        public static final String CancleCollection = BASE_URL + "/person/rmcollection";
        public static final String Report = BASE_URL + "/date/report";
        public static final String EditInformation = BASE_URL + "/person/editdata";
        public static final String UploadFace = BASE_URL+"/person/uploadimg";
        public static final String Information = BASE_URL + "/person/userinfo";
        public static final String CreateList = BASE_URL + "/person/create";
        public static final String Advice = BASE_URL + "/advice/advice";
        public static final String DateType = BASE_URL + "/date/datetype";
    }

    public class Key {
        public static final String STATUS = "status";
        public static final String DATA = "data";
        public static final String INFO = "info";
        public static final String TOKEN = "token";
        public static final String UID = "uid";
        public static final String PAGE = "page";
        public static final String SIZE = "size";
        public static final String ORDER = "order";
        public static final String LETTER = "letter";
        public static final String DATE_TYPE = "date_type";

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

        public class Detail {
            public static final String DATE_ID = "date_id";
            public static final String TOKEN = "token";
            public static final String UID = "uid";
        }


    }


    public class Module {
        public static final String LETTER = "letter";
    }

    public class Method {
        public static final String GET_LETTER = "getletter";
        public static final String DATE_ACTION = "dateaction";
        public static final String LATTER_STATUS = "letterstatus";
    }

    public class Code {
        public static final  int OK = 200;
        public static final int PERMISSION_DENIED = 401;
        public static final int SERVER_ERROR = 500;

    }
}
