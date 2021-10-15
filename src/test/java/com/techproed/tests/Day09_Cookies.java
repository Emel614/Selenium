package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day09_Cookies extends TestBase {
    @Test
    public void HandleCookies(){
        driver.get("https://www.amazon.com");
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numberOfCookies = allCookies.size();
        System.out.println(numberOfCookies);
        for(Cookie each : allCookies) {
            System.out.println(each.getName());
            System.out.println(each.getValue());
        }
            System.out.println("Cookie named sp-cdn==>" + driver.manage().getCookieNamed("sp-cdn"));
            Cookie myCookie = new Cookie("My Fav Cookie","Cookie Monster 1");
            driver.manage().addCookie(myCookie);
            allCookies = driver.manage().getCookies();
            System.out.println("Number of cookies -->"+ allCookies.size());
            driver.manage().deleteCookieNamed("i18n-prefs");
            allCookies = driver.manage().getCookies();
            System.out.println("Number of cookies -->"+ allCookies.size());
            driver.manage().deleteAllCookies();
        allCookies = driver.manage().getCookies();
        System.out.println("Number of cookies -->"+ allCookies.size());

    }
    /*
    //-Go to amazon  and automate the tasks:
        driver.get("https://www.amazon.com");
//            1. Find the total number of cookies
//        getCookies() returns all of the cookies in the browser
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies = allCookies.size();
        System.out.println("Number of Cookies => "+numOfCookies); //8
//2. Print all the cookies: cookie names and cookie values
        for (Cookie eachCookie : allCookies){
            System.out.println("Cookie Names => "+eachCookie.getName());
            System.out.println("Cookie Values => "+eachCookie.getValue());
        }
//3. Get the cookies by their name
        System.out.println("Cookie named i18n-prefs => "+driver.manage().getCookieNamed("i18n-prefs"));
//4. Add new cookie
        //creating a new cookie
       Cookie myCookie = new Cookie("My Fav Cookie","Cookie Monster 1");//name: My Fav Cookie, value : Cookie Monster 1
       //adding the cookie
       driver.manage().addCookie(myCookie);
       //getting all cookies
       allCookies = driver.manage().getCookies();
       //printing the total number of cookies
        System.out.println("Number Of Cookie => "+allCookies.size()); //9
//5. Delete cookie by name
        driver.manage().deleteCookieNamed("session-token");//deleting cookie whose name is session-token
        allCookies = driver.manage().getCookies();
        System.out.println("Number Of Cookie => "+allCookies.size()); //8
//6. Delete all of the cookies
        driver.manage().deleteAllCookies();//deleting all cookies
        allCookies = driver.manage().getCookies();
        System.out.println("Number Of Cookie => "+allCookies.size()); //0

     */
}
