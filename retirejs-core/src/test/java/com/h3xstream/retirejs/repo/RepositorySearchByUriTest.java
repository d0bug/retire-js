package com.h3xstream.retirejs.repo;

import com.esotericsoftware.minlog.Log;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.h3xstream.retirejs.repo.PrettyDisplay.displayResults;
import static org.testng.Assert.assertEquals;

/**
 * Test the class Repository
 */
public class RepositorySearchByUriTest {

    @BeforeClass
    public void setUp() {
        Log.DEBUG();
    }

    @Test
    public void findJqueryByUri() throws IOException {
        RepositoryLoader.syncWithOnlineRepository = false;

        Repository repo = new RepositoryLoader().load();

        List<JsLibraryResult> res = repo.findByUri("/1.6.2/jquery.js");
        displayResults(res);
        assertEquals(res.size(), 2, "Jquery not found");

        res = repo.findByUri("/1.6.3/jquery.js");
        displayResults(res);
        assertEquals(res.size(), 1, "Jquery not found");

        res = repo.findByUri("/1.8.9/jquery.min.js");
        displayResults(res);
        assertEquals(res.size(), 1, "Jquery not found");
    }

    @Test
    public void findEmberByUri() throws IOException {
        RepositoryLoader.syncWithOnlineRepository = false;

        Repository repo = new RepositoryLoader().load();

        List<JsLibraryResult> res = repo.findByUri("/v1.3.0-1/ember.js");
        displayResults(res);
        assertEquals(res.size(), 2, "Ember not found");

        res = repo.findByUri("/1.2.1-1/ember.min.js");
        displayResults(res);
        assertEquals(res.size(), 2, "Ember not found");
    }
}
