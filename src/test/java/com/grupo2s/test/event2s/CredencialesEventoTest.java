/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2s.test.event2s;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
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
 * Test para las credenciales de un evento.
 * {@link http://test.event2s.com/}
 *
 * @author Xavier Sumba (xavier.sumba93@ucuenca.ec)
 */
public class CredencialesEventoTest {

    private Selenium selenium;
    private WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://test.event2s.com/";
        wait = new WebDriverWait(driver, 10);
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    @Test
    public void testGenerarCredenciales() throws Exception {
        selenium.open("/login.jsf");
        assertEquals("Login - Event2S", selenium.getTitle());
        selenium.type("id=formContenido:username", "user");
        selenium.type("id=formContenido:password", "pass2");
        selenium.click("id=formContenido:loginButton");
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("//a[contains(text(),'Eventos')]")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        assertEquals("Event2S", selenium.getTitle());
        selenium.click("//a[contains(text(),'Eventos')]");
        selenium.click("link=Gestionar evento");
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("id=dataTableEventos:0:cmb_accion")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        assertEquals("Event2S", selenium.getTitle());
        selenium.click("id=dataTableEventos:0:cmb_accion");
        selenium.click("link=Credenciales");
        Thread.sleep(5000);
        assertEquals("", selenium.getText("id=qr_code"));
        selenium.click("id=j_idt471");
        Thread.sleep(3000);
        selenium.click("//div[@id='dlg_credenciales']/div/a/span");
        Thread.sleep(3000);
        selenium.click("id=btn_mn_perfil");
        selenium.click("css=#btn_logout > span.gray");
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
