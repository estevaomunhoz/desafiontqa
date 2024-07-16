package br.com.desafioqa;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExecucaoTestes {

    @Test
    public void addCustumer() throws InterruptedException {
        System.setProperty("ChromeDriver", "br/com/desafioqa/utils/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.grocerycrud.com/v1.x/demo/bootstrap_theme");

        Thread.sleep(5000);

        Select selectVersion = new Select(driver.findElement(By.id("switch-version-select")));
        selectVersion.selectByVisibleText("Bootstrap V4 Theme");

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a")).click();

        Thread.sleep(5000);

        driver.findElement(By.id("field-customerName")).sendKeys("Estevão");
        driver.findElement(By.id("field-contactLastName")).sendKeys("Munhoz");
        driver.findElement(By.id("field-contactFirstName")).sendKeys("Luana");
        driver.findElement(By.id("field-phone")).sendKeys("51992432342");
        driver.findElement(By.id("field-addressLine1")).sendKeys("Rua Teste, 123");
        driver.findElement(By.id("field-addressLine2")).sendKeys("Bairro Centro");
        driver.findElement(By.id("field-city")).sendKeys("POA");
        driver.findElement(By.id("field-state")).sendKeys("RS");
        driver.findElement(By.id("field-postalCode")).sendKeys("9100000");
        driver.findElement(By.id("field-country")).sendKeys("Brasil");
        driver.findElement(By.id("field-creditLimit")).sendKeys("10000");

        Thread.sleep(2000);

        driver.findElement(By.id("form-button-save")).click();

        Thread.sleep(10000);

        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"report-success\"]/p")).getText().contains("Your data has been successfully stored into the database."));

        Thread.sleep(5000);

        driver.close();
    }
}
