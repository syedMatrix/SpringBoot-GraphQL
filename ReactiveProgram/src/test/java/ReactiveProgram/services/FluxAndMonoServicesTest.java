package ReactiveProgram.services;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
class FluxAndMonoServicesTest {

    FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();
    @Test
    void fruitsFlux() {
        var fluxFruits= fluxAndMonoServices.fruitsFlux();
        StepVerifier.create(fluxFruits).expectNext("Rice","Wheat","Grains").verifyComplete();
    }

    @Test
    void fruitMono() {
        var monoFruits= fluxAndMonoServices.fruitMono();
        StepVerifier.create(monoFruits).expectNext("Peachs").verifyComplete();
    }

    @Test
    void fruitsFluxMap() {
        var fluxFruits= fluxAndMonoServices.fruitsFluxMap();
        StepVerifier.create(fluxFruits).expectNext("RICE","WHEAT","GRAINS").verifyComplete();
    }

    @Test
    void fruitsFluxFilter() {
        var fruitsFlux= fluxAndMonoServices.fruitsFluxFilter();
        StepVerifier.create(fruitsFlux).expectNext("Wheat","Grains").verifyComplete();
    }

    @Test
    void fruitsFluxFilterMap() {
        var fruitsFlux= fluxAndMonoServices.fruitsFluxFilterMap();
        StepVerifier.create(fruitsFlux).expectNext("WHEAT","GRAINS").verifyComplete();
    }

    @Test
    void fruitsFluxFlatMap() {
        var fruitsFlux= fluxAndMonoServices.fruitsFluxFlatMap();
        StepVerifier.create(fruitsFlux).expectNextCount(15).verifyComplete();
    }

    @Test
    void fruitsMonoFlatMap() {
        var fruitsFlux=fluxAndMonoServices.fruitsMonoFlatMap();
        StepVerifier.create(fruitsFlux).expectNextCount(1).verifyComplete();
    }
}