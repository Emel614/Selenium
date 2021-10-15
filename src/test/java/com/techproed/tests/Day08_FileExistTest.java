package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileExistTest {
    @Test
    public void isExist(){
        /*
        Selenium has limitation with desktop application
        * With Java we can check if a file exist in our local computer
        * */

        //Getting the PATH of the HOME directory with JAVA
        String homePath = System.getProperty("user.home");
        System.out.println(homePath);

        String pathOfFlower = homePath+"\\OneDrive\\Masaüstü\\flower.jpeg";
        System.out.println(pathOfFlower);

        boolean isExist = Files.exists(Paths.get(pathOfFlower));

        Assert.assertTrue(isExist);



    }
}
