package com.solvd.qa.carina.demo;

import com.jayway.jsonpath.JsonPath;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.qa.carina.demo.api.GetAlbumMethod;
import com.solvd.qa.carina.demo.api.PatchAlbumMethod;
import com.solvd.qa.carina.demo.api.PostAlbumMethod;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class APIAlbumTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(APIAlbumTest.class);

    @Test(enabled = true)
    public void createAlbum() {
        LOGGER.info("test post Album");
        PostAlbumMethod api = new PostAlbumMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test(enabled = true)
    public void createAlbumMissingField() {
        LOGGER.info("test create Album with missing field");
        PostAlbumMethod api = new PostAlbumMethod();
        api.getProperties().remove("userId");
        api.getProperties().remove("title");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test(enabled = false)
    public void getAlbum() {
        LOGGER.info("test get Album");
        GetAlbumMethod getAlbumMethod = new GetAlbumMethod();
        getAlbumMethod.callAPIExpectSuccess();
        getAlbumMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAlbumMethod.validateResponseAgainstSchema("api/albums/_get/rs.schema");
    }

    @Test(enabled = false)
    public void patchAlbum() {
        PostAlbumMethod postAlbumMethod = new PostAlbumMethod();
        Response postResponse = postAlbumMethod.callAPIExpectSuccess();
        postAlbumMethod.validateResponse();

        Integer id = JsonPath.read(postResponse.asString(), "$.id");
        LOGGER.info("id:" + id);

        PatchAlbumMethod patchAlbumMethod = new PatchAlbumMethod(1);
        Response response = patchAlbumMethod.callAPIExpectSuccess();
        patchAlbumMethod.addProperty("id", id);
        patchAlbumMethod.callAPIExpectSuccess();
        patchAlbumMethod.validateResponse();
    }
}
