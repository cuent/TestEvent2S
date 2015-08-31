package com.grupo2s.demo.event2s;

import com.grupo2s.test.event2s.*;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.apache.commons.lang3.StringUtils.join;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Test para la creación de un evendo en la pagina
 * {@link http://demo.event2s.com/}
 *
 * @author Xavier Sumba (xavier.sumba93@ucuenca.ec)
 */
public class CrearEventoTest {

    private Selenium selenium;
    private WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://demo.event2s.com/";
        wait = new WebDriverWait(driver, 10);
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    @Test
    public void testCrearEvento() throws Exception {
        selenium.open("/login.jsf");
        assertEquals("Login - Event2S", selenium.getTitle());
        selenium.type("id=formContenido:username", "user");
        selenium.type("id=formContenido:password", "pass2");
        selenium.click("id=formContenido:loginButton");
        selenium.waitForPageToLoad("3000");
        assertTrue(
                "The page title should start with the search string after the search.",
                wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return d.getTitle().toLowerCase().startsWith("event2s");
                    }
                }));
//assertEquals("Event2S", selenium.getTitle());
        selenium.click("//a[@id='cml_nuevo']/i");
        selenium.click("css=#item_evento > span.gray");
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("//div[@id='tabAcordion']/h3")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        selenium.click("//div[@id='tabAcordion']/h3");
        selenium.click("//div[@id='tabAcordion:cboCategoriaTB']/div[3]");
        selenium.click("//div[@id='tabAcordion:cboCategoriaTB_panel']/div/ul/li[3]");
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("id=tabAcordion:cboTemaTB_label")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        Thread.sleep(2000);

        selenium.click("id=tabAcordion:cboTemaTB_label");
        Thread.sleep(3000);
        selenium.click("//div[@id='tabAcordion:cboTemaTB_panel']/div/ul/li[6]");
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("id=tabAcordion:j_idt291")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        selenium.click("id=tabAcordion:j_idt291");

        assertEquals("Event2S", selenium.getTitle());

        selenium.waitForPageToLoad("3000");
        assertEquals("Event2S", selenium.getTitle());
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("id=j_idt548")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        selenium.click("id=j_idt548");
        selenium.type("id=txtNombreEvento", "Evento Prueba Selenium");

        selenium.click("id=j_idt464");
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("id=nombreLugar")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("//div[@id='j_idt472']/div[2]/div/div[2]/iframe")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        selenium.click("//div[@id='j_idt472']/div[2]/div/div[2]/iframe");
        selenium.click("css=div.gmnoprint");
        selenium.type("id=nombreLugar", "Hotel Oro Verde");
        selenium.click("id=j_idt484_input");
        selenium.type("id=j_idt484_input", "06/08/2030");
        Thread.sleep(3000);
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isElementPresent("css=#calendarioInicio > tbody > tr > td")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        selenium.click("css=#calendarioInicio > tbody > tr > td");
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if ("".equals(join(selenium.getAllButtons(), ','))) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        selenium.click("id=cmdAceptarSede");
        selenium.click("id=j_idt469");
        selenium.waitForPageToLoad("3000");
        assertEquals("Event2S", selenium.getTitle());
        selenium.click("id=j_idt438");
        selenium.waitForPageToLoad("3000");
        assertEquals("Event2S", selenium.getTitle());
        selenium.type("id=nombreBol", "VIP");
        selenium.click("id=cmdAgregaBoleto");
        Thread.sleep(3000);
        selenium.click("//div[@id='tableBoletos:0:j_idt443']/div/div");
        selenium.type("id=tableBoletos:0:j_idt446", "500");
        selenium.click("id=tableBoletos:0:preciosParaBoleto");
        selenium.type("id=tableBoletos:0:j_idt441", "60");
        selenium.click("//div[@id='j_idt403_content']/table/tbody/tr[4]/td");
        selenium.click("id=j_idt599");
        selenium.waitForPageToLoad("3000");
        Thread.sleep(3000);
        assertTrue(
                "The page title should start with the search string after the search.",
                wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return d.getTitle().toLowerCase().startsWith("event2s");
                    }
                }));
        selenium.click("id=j_idt565");
        selenium.waitForPageToLoad("3000");
        assertTrue(
                "The page title should start with the search string after the search.",
                wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return d.getTitle().toLowerCase().startsWith("event2s");
                    }
                }));
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isElementPresent("id=j_idt682")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        selenium.click("id=j_idt682");

        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isElementPresent("id=j_idt689")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        selenium.click("id=j_idt689");
//        for (int second = 0;; second++) {
//            if (second >= 60) {
//                fail("timeout");
//            }
//            try {
//                if (selenium.isElementPresent("id=j_idt650")) {
//                    break;
//                }
//            } catch (Exception e) {
//            }
//            Thread.sleep(1000);
//        }
//
//        selenium.click("id=j_idt650");
        selenium.waitForPageToLoad("3000");
        assertEquals("Event2S", selenium.getTitle());
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isElementPresent("id=btn_mn_perfil")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        Thread.sleep(2000);
        selenium.click("id=btn_mn_perfil");

        Thread.sleep(3000);
        selenium.click("id=btn_logout");
        selenium.waitForPageToLoad("3000");
        assertTrue(
                "The page title should start with the search string after the search.",
                wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return d.getTitle().toLowerCase().startsWith("login");
                    }
                }));
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}
