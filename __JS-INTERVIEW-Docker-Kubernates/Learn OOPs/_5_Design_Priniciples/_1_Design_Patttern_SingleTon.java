package oops._5_Design_Priniciples;

public class _1_Design_Patttern_SingleTon {
    /*
        Singleton Pattern - It ensures that only 1 instance of object is created
            and tha instance is globally accessible.

        - Logger - Logging is one meaningful example for the Singleton as the information flow happens
            only in one direction and therefore global state is not a big issue.
                - private constructor in the example below ensures that the
                  object creation only happens through getInstance() which
                  at the same time serves as the global accessor.
     */
}
    class Logger {

        private static Logger instance;
        private Logger() {}

        public static Logger getInstance() {
            if(instance == null) {
                instance = new Logger();
            }
            return instance;
        }
    }
