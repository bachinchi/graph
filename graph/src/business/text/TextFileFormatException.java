package business.text;

public class TextFileFormatException extends Exception {

        /**
         * 
         */
        private static final long serialVersionUID = 3537912818064691050L;

        /**
         * Parameterless Constructor
         */
        public TextFileFormatException() {
        }

        /**
         * Accepts a message
         * 
         * @param message
         */
        public TextFileFormatException(final String message) {
                super(message);
        }

        public TextFileFormatException(final String arg0, final Throwable arg1) {
                super(arg0, arg1);
                // TODO Auto-generated constructor stub
        }

        public TextFileFormatException(final String arg0, final Throwable arg1,
                        final boolean arg2, final boolean arg3) {
                super(arg0, arg1, arg2, arg3);
                // TODO Auto-generated constructor stub
        }

        public TextFileFormatException(final Throwable arg0) {
                super(arg0);
                // TODO Auto-generated constructor stub
        }

}
