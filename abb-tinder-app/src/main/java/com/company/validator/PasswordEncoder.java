package com.company.validator;

public class PasswordEncoder {

    public static String passwordEncoder(String password) {
        String salt = "4f34fv934f934vn3c23024v2";
        int number = 343223;
        return String.valueOf((password.hashCode() ^ salt.hashCode()) % number);
    }
//
//    public static String passwordEncoder(String password) throws Exception {
//        byte[] salt = new String("12345678").getBytes();
//        int iterationCount = 40000;
//        int keyLength = 128;
//        SecretKeySpec key = createSecretKey(password.toCharArray(), salt, iterationCount, keyLength);
//        return encrypt(password, key);
//    }
//
//    private static SecretKeySpec createSecretKey(char[] password, byte[] salt, int iterationCount, int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
//        PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, keyLength);
//        SecretKey keyTmp = keyFactory.generateSecret(keySpec);
//        return new SecretKeySpec(keyTmp.getEncoded(), "AES");
//    }
//
//    private static String encrypt(String property, SecretKeySpec key) throws GeneralSecurityException {
//        Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//        pbeCipher.init(Cipher.ENCRYPT_MODE, key);
//        AlgorithmParameters parameters = pbeCipher.getParameters();
//        IvParameterSpec ivParameterSpec = parameters.getParameterSpec(IvParameterSpec.class);
//        byte[] cryptoText = pbeCipher.doFinal(property.getBytes(StandardCharsets.UTF_8));
//        byte[] iv = ivParameterSpec.getIV();
//        return base64Encode(iv) + ":" + base64Encode(cryptoText);
//    }
//
//    private static String base64Encode(byte[] bytes) {
//        return Base64.getEncoder().encodeToString(bytes);
//    }

}
