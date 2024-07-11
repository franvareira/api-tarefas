package Utils;

public class Endpoints {


        protected static final String BASE_URI = FileOperations.getProperties("Environment").getProperty("baseUri");

        protected static final String PATH_USERS = FileOperations.getProperties("Environment").getProperty("users");

        protected static final String PATH_SESSIONS = FileOperations.getProperties("Environment").getProperty("sessions");

        protected static final String PATH_TASKS = FileOperations.getProperties("Environment").getProperty("tasks");

        protected static final String PATH_CONTACTS = FileOperations.getProperties("Environment").getProperty("contacts");



}
