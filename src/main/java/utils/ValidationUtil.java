package utils;

/**
 * Utility class for performing various validation checks on strings.
 */
public class ValidationUtil {

    /**
     * Validates if the provided text contains only letters and whitespace characters.
     * 
     * @param text The text to be validated.
     * @return True if the text contains only letters and whitespace, false otherwise.
     */
    public static boolean isTextOnly(String text) {
        return text.matches("[a-zA-Z\\s]+"); // Match letters and whitespace only
    }

    /**
     * Validates if the provided text contains only digits (0-9).
     * 
     * @param text The text to be validated.
     * @return True if the text contains only digits, false otherwise.
     */
    public static boolean isNumbersOnly(String text) {
        return text.matches("\\d+"); // Match digits only
    }

    /**
     * Validates if the provided text is alphanumeric, containing only letters and digits.
     * 
     * @param text The text to be validated.
     * @return True if the text is alphanumeric, false otherwise.
     */
    public static boolean isAlphanumeric(String text) {
        return text.matches("[a-zA-Z0-9]+"); // Match letters and digits only
    }

    /**
     * Validates if the provided text is a valid email address format.
     * 
     * @param email The email address to be validated.
     * @return True if the email address has a valid format, false otherwise.
     */
    public static boolean isEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$"); // Match standard email pattern
    }

    /**
     * Validates if the provided text contains no special characters other than letters, digits, and whitespace.
     * 
     * @param text The text to be validated.     
     * @return True if the text contains no special characters, false otherwise.
     */
    public static boolean hasNoSpecialCharacters(String text) {
        return text.matches("[a-zA-Z0-9\\s]+"); // Match only letters, digits, and whitespace
    }

    /**
     * Validates if the provided password meets complexity requirements:
     * - Contains at least one uppercase letter (A-Z)
     * - Contains at least one lowercase letter (a-z)
     * - Contains at least one digit (0-9)
     * - Contains at least one symbol (@$!%*?&).
     * 
     * @param password The password to be validated.
     * @return True if the password meets complexity requirements, false otherwise.
     */
    public static boolean isValidPassword(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]*$"); // No length validation
    }

    /**
     * Validates if the provided text has the specified length.
     * 
     * @param text The text to be validated.
     * @param length The expected length of the text.
     * @return True if the text has the specified length, false otherwise.
     */
    public static boolean hasLength(String text, int length) {
        return text.length() == length;
    }
    
    
    /**
     * Checks if the provided gender matches "male" or "female" (ignoring case).
     * 
     * @param gender The gender to be validated.
     * @return True if the gender matches "male" or "female", false otherwise.
     */
    public static boolean isGenderMatches(String gender) {
        // Convert the gender to lowercase and compare with "male" and "female" ignoring case
        return gender != null && (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"));
    }
}