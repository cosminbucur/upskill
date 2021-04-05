package com.sda.json;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

class JsonSchemaTest {

    @Test
    void givenInvalidInput_whenValidating_thenInvalid() {
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(getClass().getResourceAsStream("/schema/ComplexSchema.json")));
        JSONObject jsonObject = new JSONObject(
                new JSONTokener(getClass().getResourceAsStream("/json/valid.json")));

        // load schema
        Schema schema = SchemaLoader.load(jsonSchema);

        // validate
        schema.validate(jsonObject);
    }
}
