package com.solutions.mbangi.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Helper {

   // private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

   // public static boolean matchPassword(String rawPassword, String hashedPassword) {
    //    return passwordEncoder.matches(rawPassword, hashedPassword);
    //}
    //public static boolean isValidRole(Logins role) {
    //    return role != null; // simple check, all enum values are valid
    //}

    //public static String encodePassword(String rawPassword) {
    //    return passwordEncoder.encode(rawPassword);//this is added by kelly
   // }


    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValidEmail(String email) {
        if (isNullOrEmpty(email)) {
            return false;
        }
        return email.contains("@") && email.contains(".") && email.indexOf("@") < email.lastIndexOf(".");
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (isNullOrEmpty(phoneNumber)) {
            return false;
        }
        if (phoneNumber.length() < 10 || phoneNumber.length() > 13) {
            return false;
        }
        for (char c : phoneNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidPassword(String password) {
        if (isNullOrEmpty(password)) {
            return false;
        }
        return password.length() >= 6;
    }

    public static boolean isValidName(String name) {
        if (isNullOrEmpty(name)) {
            return false;
        }
        return name.length() >= 2 && name.length() <= 50;
    }

    public static boolean isStrongPassword(String password) {
        if (isNullOrEmpty(password)) return false;
        return password.matches("^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{6,}$");
    }


    public static boolean isValidPostalCode(short postalCode) {
        return postalCode >= 1000 && postalCode <= 9999;
    }

    public static boolean isValidStreetNumber(short streetNumber) {
        return streetNumber >= 1 && streetNumber <= 99999;
    }

    public static boolean isValidErfNumber(Long erfNumber) {
        return erfNumber != null && erfNumber >= 1 && erfNumber <= 99999;
    }

    public static boolean isValidProvince(String province) {
        if (isNullOrEmpty(province)) return false;

        String[] validProvinces = {
                "Eastern Cape", "Free State", "Gauteng", "KwaZulu-Natal",
                "Limpopo", "Mpumalanga", "Northern Cape", "North West", "Western Cape"
        };

        for (String p : validProvinces) {
            if (p.equalsIgnoreCase(province.trim())) {
                return true;
            }
        }
        return false;
    }

   // public static boolean isValidUser(Users user) {
     //   return user != null && isValidId(user.getUserId());
    //}

    public static boolean isValidId(Long id) {
        return id != null && id > 0;
    }

    public static boolean isValidIntId(int id) {
        return id > 0;
    }

    public static boolean isValidLongId(long id) {
        return id > 0;
    }

    public static boolean isValidDouble(Double d) {
        return d != null && d > 0;
    }

    public static boolean isValidQuantity(int quantity) {
        return quantity >= 0;
    }

    public static boolean isValidDate(Date date) {
        return date != null;
    }

    public static boolean isValidLocalDateTime(LocalDateTime dateTime) {
        return dateTime != null;
    }

    public static boolean isValidBoolean(Boolean b) {
        return b != null;
    }

    public static boolean isValidStatus(String status) {
        if (!isNullOrEmpty(status)) {
            return status.equalsIgnoreCase("Pending") ||
                    status.equalsIgnoreCase("In Transit") ||
                    status.equalsIgnoreCase("Delivered") ||
                    status.equalsIgnoreCase("Cancelled");
        }
        return false;
    }

    public static boolean isValidNotificationType(String type) {
        if (isNullOrEmpty(type)) {
            return false;
        }
        return type.equalsIgnoreCase("INFO") ||
                type.equalsIgnoreCase("ALERT") ||
                type.equalsIgnoreCase("WARNING");
    }


    public static boolean isValidStock(String stock) {
        return !isNullOrEmpty(stock);
    }

    // Valid quantity: range 1 to 99999
    public static boolean isValidQuantityRange(int s) {
        return s >= 1 && s <= 99999;
    }

    // Valid price: range 1 to 99999
    public static boolean isValidPrice(double price) {
        return price >= 1 && price <= 99999;
    }

    // Total price must equal price * quantity
    public static boolean isValidTotalPrice(double totalPrice, int quantity, double price) {
        return totalPrice == price * quantity;
    }

    public static boolean isValidDateCreated(LocalDate date) {
        return date != null && !date.isAfter(LocalDate.now());
    }

    //Valid uodated dated
    public static boolean isValidDateUpdate(LocalDate createdAt, LocalDate updateDate) {
        return updateDate != null && !updateDate.isBefore(createdAt);
    }

    // Validation for Availability enum
    //public static boolean isValidAvailability(Availability availability) {
     //   return availability != null;
   // }

    // Validation for image (byte array)
    public static boolean isValidImage(byte[] image) {
        return image != null && image.length > 0;
    }

    // Validation for image with size limit (recommended)
    public static boolean isValidImageWithSizeLimit(byte[] image) {
        if (image == null || image.length == 0) {
            return false;
        }

        // Maximum size: 5MB
        long maxSize = 5 * 1024 * 1024; // 5MB in bytes
        return image.length<=maxSize;
    }
}

