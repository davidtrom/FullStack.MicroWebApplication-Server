package com.theocho.youflix.services;


import org.junit.Assert;
import org.junit.Test;

public class InfoValidationTest {

    private String goodUsername = "IAmGoodBoy13";
    private String goodPassword = "LetMeIn13";
    private String goodEmail = "goodboy@email.com";

    private String badUsername = "(i am bad boy because nobody wants me so sad)";
    private String badPassword = "123123123123123123123123123123123123123";
    private String badEmail = "whatisemail?";

    @Test
    public void testBetween6And20Chars() {
        Assert.assertTrue(
                InfoValidation.between6And20Chars(goodUsername));
        Assert.assertFalse(
                InfoValidation.between6And20Chars(badUsername));
    }

    @Test
    public void testUpperAndLowercaseChars() {
        Assert.assertTrue(
                InfoValidation.upperAndLowercaseChars(goodPassword));
        Assert.assertFalse(
                InfoValidation.upperAndLowercaseChars(badPassword));
    }

    @Test
    public void testContainsNumber() {
        Assert.assertTrue(
                InfoValidation.containsNumber(goodUsername));
        Assert.assertFalse(
                InfoValidation.containsNumber(badUsername));
    }

    @Test
    public void testDoesNotContainSpace() {
        Assert.assertTrue(
                InfoValidation.doesNotContainSpace(goodUsername));
        Assert.assertFalse(
                InfoValidation.doesNotContainSpace(badUsername));
    }

    @Test
    public void testValidEmail() {
        Assert.assertTrue(
                InfoValidation.validEmail(goodEmail));
        Assert.assertFalse(
                InfoValidation.validEmail(badEmail));
    }

    @Test
    public void testValidUsername() {
        Assert.assertTrue(
                InfoValidation.validUsername(goodUsername));
        Assert.assertFalse(
                InfoValidation.validUsername(badUsername));
    }

    @Test
    public void testValidPassword() {
        Assert.assertTrue(
                InfoValidation.validPassword(goodPassword));
        Assert.assertFalse(
                InfoValidation.validPassword(badPassword));
    }

}
