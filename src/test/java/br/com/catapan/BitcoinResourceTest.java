package br.com.catapan;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

@QuarkusTest
public class BitcoinResourceTest {

    @Test
    public void testarSeStatusCodeDaRequisicaoEh200() {
        RestAssured
                .given()
                    .get("bitcoins")
                .then()
                    .statusCode(Response.Status.OK.getStatusCode());
    }
}
