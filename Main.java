public class Main {
    public static void main(String[] args) {
        // Примеры вызовов метода с различными данными
        System.out.println(validate("valid_login", "valid_password", "valid_password")); // true
        System.out.println(validate("invalid-login-with-long-name", "password", "password")); // false
        System.out.println(validate("validLogin", "password1", "password2")); // false
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            // Проверка логина: только латинские буквы, цифры и знак подчеркивания, длина < 20
            if (!login.matches("[A-Za-z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Login должен содержать только латинские буквы, цифры и знак подчеркивания и быть короче 20 символов.");
            }

            // Проверка пароля: только латинские буквы, цифры и знак подчеркивания, длина < 20
            if (!password.matches("[A-Za-z0-9_]+") || password.length() >= 20) {
                throw new WrongPasswordException("Password должен содержать только латинские буквы, цифры и знак подчеркивания и быть короче 20 символов.");
            }

            // Проверка совпадения password и confirmPassword
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password и confirmPassword должны совпадать.");
            }

            return true; // Если все проверки пройдены
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return false;
        }
    }
}

// Кастомное исключение для ошибок логина
class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Некорректный логин.");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

// Кастомное исключение для ошибок пароля
class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Некорректный пароль.");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
