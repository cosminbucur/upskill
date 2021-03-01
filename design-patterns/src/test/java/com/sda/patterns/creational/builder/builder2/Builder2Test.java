package com.sda.patterns.creational.builder.builder2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Builder2Test {

    @Test
    void givenClassicBuilder_whenBuild_thenReturnOk() {
        Person person = new PersonBuilder()
                .withSalutation("Mr")
                .withLastName("smith")
                .createPerson();

        assertThat(person).isNotNull();
    }

    @Test
    void givenLambdaBuilder_whenBuild_thenReturnOk() {
        Person actual = new PersonLambdaBuilder()
                .with(personLambdaBuilder -> {
                    personLambdaBuilder.firstName = "Andrew";
                    personLambdaBuilder.lastName = "Smith";
                    personLambdaBuilder.address = new AddressLambdaBuilder()
                            .with(addressLambdaBuilder -> {
                                addressLambdaBuilder.city = "Bucharest";
                                addressLambdaBuilder.street = "Unirii";
                            })
                            .createAddress();
                })
                .createPerson();
    }
}