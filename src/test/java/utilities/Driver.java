package utilities;

import org.openqa.selenium.WebDriver;

/*
 * Driver class uses Singleton design pattern
 * This will allow us to reuse a single instance across the framework
 * ThreadLocal is used to enable parallel execution for the Driver class becomes thread safe
 * ThreadLocal will enable each thread to have its own instance of Driver class
 * */

public class Driver {

    private static Driver instance = new Driver();
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private Driver(){}

    public static Driver getInstance(){
        return instance;
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    public void setDriver(WebDriver driverParameter) {
       driver.set(driverParameter);
    }

    public void removeDriver(){
        driver.get().quit();
        driver.remove();
    }

}
