public class Constants {
    //constant variables of page: "RegiScreen"
    public static final String PATH_TO_ENTER_BUTTON = "//span[text()='כניסה']";
    public static final String PATH_TO_REG_BUTTON = "//span[text()='להרשמה']";
    public static final String PATH_TO_NAME = "//input[@placeholder='שם פרטי']";
    public static final String PATH_TO_MAIL = "//input[@placeholder='מייל']";
    public static final String PATH_TO_PASSWORD = "//input[@placeholder='סיסמה']";
    public static final String PATH_TO_RE_PASSWORD = "//input[@placeholder='אימות סיסמה']";
    public static final String PATH_TO_SUBMIT_BUTTON = "//button[@type='submit']";


    //constant variables of page: "HomeScreen"
    public static final String PATH_TO_SELECT_PRICE = "//span[text()='סכום']";
    public static final String PATH_TO_SELECT_AREA = "//span[text()='אזור']";
    public static final String PATH_TO_SELECT_CATEGORY = "//span[text()='קטגוריה']";
    public static final String PATH_TO_SEARCH_BUTTON = "//a[text()='תמצאו לי מתנה']";
    public static final String PATH_TO_SELECTION = "active-result";

    //constant variables of page: "GiftScreen"
    public static final String PATH_TO_GIFT = "thumbnail";



    //constant variables of page: "SendRecScreen"
    public static final String PATH_TO_RECEIVER = "//input[@data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']";
    public static final String PATH_TO_SENDER = "//input[@data-parsley-required-message='למי יגידו תודה? שכחת למלא את השם שלך']";
    public static final String PATH_TO_EVENT = "//span[text()='לאיזה אירוע?']";
    public static final String PATH_TO_EVENT_SELECTION = "active-result";
    public static final String PATH_TO_TEXTAREA = "//textarea[@rows='4']";
    public static final String PATH_TO_UPLOAD_PHOTO = "//input[@type='file']";
    public static final String PATH_TO_BY_MAIL = "//span[text()='במייל']";
    public static final String PATH_TO_EMAIL = "//input[@placeholder='כתובת המייל של מקבל/ת המתנה']";
    public static final String PATH_TO_SAVE_BUTTON = "//button[@type='submit']";
    public static final String PATH_TO_PAY_BUTTON = "//button[@type='submit']";

    //file destinations
    public static final String SETTINGS_XML = "\\C:\\Users\\Ofer\\IdeaProjects\\BuyMe\\src\\settings.xml";
    public static final String LOG_HTML = "C:\\Users\\Ofer\\Desktop\\buyme_test_log.html";

    //drivers
    public static final String CHROMEDRIVER = "\\C:\\Users\\Ofer\\Documents\\QA AUTOMATION\\chromedriver.exe";
    public static final String FIREFOXDRIVER = "\\C:\\Users\\Ofer\\Documents\\QA AUTOMATION\\firefoxdriver.exe";
    public static final String IEDRIVER = "\\C:\\Users\\Ofer\\Documents\\QA AUTOMATION\\IEDriverServer.exe";
}
