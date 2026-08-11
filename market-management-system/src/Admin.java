public class Admin {

        private static String name;
        private static String password;

        private Admin(String name, String password) {
            this.name = name.toLowerCase();
            this.password = password.toLowerCase();
        }

        public static Admin addAdimin(String name, String password) {
                
            return new Admin(name, password);
        }
        public static boolean authenticateAdmin(String n, String p) {
            
            return (name == null ? n == null : name.equals(n)) && (password == null ? p == null : password.equals(p));

        }
    }

