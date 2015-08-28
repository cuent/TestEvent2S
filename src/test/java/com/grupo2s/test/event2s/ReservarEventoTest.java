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
 * Test para la reserva de eventos en la página {@link http://test.event2s.com/}
 *
 * @author Xavier Sumba (xavier.sumba93@ucuenca.ec)
 */
public class ReservarEventoTest {

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
    public void testReservarEvento() throws Exception {
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
        selenium.click("//div[@id='dataTableEventos:0:j_idt474']/ul/li[2]/a/span");
        selenium.waitForPageToLoad("3000");
        Thread.sleep(3000);
        assertTrue(
                "The page title should start with the search string after the search.",
                wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return d.getTitle().toLowerCase().startsWith("event2s");
                    }
                }));
//      selenium.click("id=dataTableEventos:0:cmb_accion");
//selenium.click("link=Reservar");
        assertEquals("Event2S", selenium.getTitle());
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
        selenium.click("id=j_idt590");
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("//div[@id='txt_titulo']/div[3]/span")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        assertEquals("Event2S", selenium.getTitle());
        selenium.click("//div[@id='txt_titulo']/div[3]/span");
        selenium.click("//div[@id='txt_titulo_panel']/div/ul/li[2]");
        selenium.type("id=txt_apellido", "Perez");
        selenium.type("id=txt_nombre", "Juan");
        selenium.click("//div[@id='txt_tipo_ident']/div[3]");
        selenium.click("//div[@id='txt_tipo_ident_panel']/div/ul/li[2]");
        selenium.type("id=txt_identificacion", "0105593693");
        selenium.type("id=txt_email", "jperez@domain.com");
        selenium.type("id=txt_reEmail", "jperez@domain.com");
        selenium.type("id=txt_telefono1", "+593 983473827");
        selenium.type("id=txt_direccion", "Av. Prueba 1 y La intersección");
        selenium.type("id=txt_ciudad", "Cuenca");
        selenium.type("id=txt_provincia", "Azuay");
        selenium.type("id=txt_cod_postal", "10101");
        selenium.type("id=txt_pais", "Ecuador");
        selenium.click("id=j_idt591");
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("css=td.columnCenter")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        Thread.sleep(3000);

        selenium.click("css=td.columnCenter");
        Thread.sleep(3000);
        assertEquals("Event2S", selenium.getTitle());
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("//div[@id='dtg_forma_pago:0:j_idt440']/div[2]/span")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        selenium.click("//div[@id='dtg_forma_pago:0:j_idt440']/div[2]/span");
        Thread.sleep(3000);

        selenium.type("id=txt_referencia_reg", "ABCD12");
        selenium.type("id=txt_valor_reg", "60");
        selenium.type("id=txt_descripcion_reg", "Pago por el evento");
        selenium.click("id=cmd_confirmar");
        assertEquals("Event2S", selenium.getTitle());
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("id=j_idt466")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        selenium.click("id=j_idt466");
        assertTrue(
                "The page title should start with the search string after the search.",
                wait.until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return d.getTitle().toLowerCase().startsWith("event2s");
                    }
                }));
        selenium.waitForPageToLoad("3000");
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (selenium.isVisible("id=btn_mn_perfil")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
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
