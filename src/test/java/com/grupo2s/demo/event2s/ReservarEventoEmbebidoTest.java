/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2s.demo.event2s;

import com.grupo2s.test.event2s.*;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import java.util.Iterator;
import java.util.Set;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Test para las reservas de eventos mediante código embebido en la pagina
 * {@link http://demo.event2s.com/}
 *
 * @author Xavier Sumba (xavier.sumba93@ucuenca.ec)
 */
public class ReservarEventoEmbebidoTest {

    private Selenium selenium;
    private WebDriverWait wait;
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        String baseUrl = "http://demo.event2s.com/";
        wait = new WebDriverWait(driver, 10);
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    @Test
    public void testReservarEventoEmbebido() throws Exception {
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
        selenium.click("//a[contains(text(),'Eventos')]");
        selenium.click("link=Gestionar evento");
        selenium.waitForPageToLoad("30000");
        assertEquals("Event2S", selenium.getTitle());
        selenium.click("id=dataTableEventos:0:cmb_accion");
        selenium.click("//div[@id='dataTableEventos:0:j_idt474']/ul/li[4]/a/span");
        selenium.waitForPageToLoad("3000");
        assertEquals("Event2S", selenium.getTitle());
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("css=#j_idt378_content > a > span.gray.Fs14")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        String mwh = driver.getWindowHandle();

        selenium.click("css=#j_idt378_content > a > span.gray.Fs14");
        selenium.waitForPageToLoad("5000");
        assertEquals("Event2S", selenium.getTitle());

        Set s = driver.getWindowHandles();

        Iterator iterator = s.iterator();

        while (iterator.hasNext()) {
            String actualWindowHandle = iterator.next().toString();
            if (!actualWindowHandle.contains(mwh)) {
                driver.switchTo().window(actualWindowHandle);
            }
        }

        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("//span[@id='dt_detalle_Boleto:0:txt_cantidad']/a/span/span")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        selenium.click("//span[@id='dt_detalle_Boleto:0:txt_cantidad']/a/span/span");
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("id=dt_detalle_Boleto:0:txt_cantidad_input")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        selenium.click("//span[@id='dt_detalle_Boleto:0:txt_cantidad']/a/span/span");
        

        //For terms and conditions
        //selenium.click("//div[@id='sbc_condicion']/div[2]/span");
//        selenium.type("id=dt_detalle_Boleto:0:txt_cantidad_input", "1");
        selenium.click("id=j_idt317");
        Thread.sleep(3000);
        selenium.waitForPageToLoad("30000");
        assertTrue(
                "The page title should start with the search string after the search.",
                wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return d.getTitle().toLowerCase().startsWith("event2s");
                    }
                }));
        selenium.click("//div[@id='txt_titulo']/div[3]");
        selenium.click("//div[@id='txt_titulo_panel']/div/ul/li[2]");
        selenium.type("id=txt_nombre", "Juan"); 
        selenium.type("id=txt_apellido", "Perez");
        selenium.click("//div[@id='txt_tipo_ident']/div[3]");
        selenium.click("//div[@id='txt_tipo_ident_panel']/div/ul/li[2]");
        selenium.type("id=txt_identificacion", "0914010459");
        selenium.type("id=txt_email", "jperez@domain.com");
        selenium.type("id=txt_reEmail", "jperez@domain.com");
        selenium.type("id=txt_telefono1", "+593 982348273");
        selenium.type("id=txt_direccion", "Av. Las palomas y Gaviotas");
        selenium.type("id=txt_ciudad", "Cuenca");
        selenium.type("id=txt_provincia", "Azuay");
        selenium.type("id=txt_cod_postal", "10101");
        selenium.type("id=txt_pais", "Ecuador");
        selenium.click("id=j_idt317");
        assertTrue(
                "The page title should start with the search string after the search.",
                wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return d.getTitle().toLowerCase().startsWith("event2s");
                    }
                }));
        selenium.waitForPageToLoad("3000");
        Thread.sleep(3000);
        selenium.click("//div[@id='dtg_forma_pago:0:j_idt171']/div[2]/span");
        Thread.sleep(3000);
        selenium.click("id=cmd_confirmar");
        assertTrue(
                "The page title should start with the search string after the search.",
                wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return d.getTitle().toLowerCase().startsWith("event2s");
                    }
                }));
        selenium.waitForPageToLoad("3000");
        Thread.sleep(3000);
        selenium.click("id=j_idt185");
        selenium.waitForPageToLoad("30000");
        selenium.waitForPageToLoad("3000");
        assertEquals("Event2S", selenium.getTitle());
        assertTrue(selenium.getText("css=span.Fs16.FontRalewayBold").contains("En hora buena!!! Tus espacios están bloqueados."));
        selenium.open("/login.jsf");
        selenium.click("id=opt_nombre");
        selenium.click("css=#btn_logout > span.gray");
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
