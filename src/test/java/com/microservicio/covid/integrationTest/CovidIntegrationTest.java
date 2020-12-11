package com.microservicio.covid.integrationTest;


public class CovidIntegrationTest {

/*
    @Test
    public void getNewsWithValidEndpointTest(){
        String responseString = RestAssured.given().spec()
                .when().get().andReturn()
                .then().log().all().statusCode(HttpStatus.SC_OK)
                .and().extract().body().asString();

}

    @Test
    public void getNews(){
        URI newsUri = URI.create("localhost:8080/news");

        ValidatableResponse responseString = RestAssured.given()
                .param("published", "2020-10-23T03:00:00.000+03:00")
                .when().post(newsUri)
                .then().assertThat().body("thread.published", equalTo("2020-10-23T03:00:00.000+03:00"));
    }

 */
}
