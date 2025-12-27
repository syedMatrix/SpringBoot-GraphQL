package ReactiveProgram.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoServices {

    public Flux<String> fruitsFlux(){
        return Flux.fromIterable(List.of("Rice","Wheat","Grains")).log();
    }
    public Mono<String> fruitMono(){
        return Mono.just("Peach").log();
    }
    public Flux<String> fruitsFluxMap(){
       return Flux.fromIterable(List.of("Rice","Wheat","Grains")).map(String::toUpperCase).log();
    }
    public Flux<String> fruitsFluxFilter(){
        return Flux.fromIterable(List.of("Rice","Wheat","Grains")).filter(i->i.length()>4).log();
    }
    public Flux<String> fruitsFluxFilterMap(){
        return Flux.fromIterable(List.of("Rice","Wheat","Grains")).filter(i->i.length()>4).map(String::toUpperCase).log();
    }
    public Flux<String> fruitsFluxFlatMap(){
        return Flux.fromIterable(List.of("Rice","Wheat","Grains")).flatMap(s->Flux.just(s.split(""))).log();
    }
    public Mono<List<String>> fruitsMonoFlatMap(){
        return Mono.just("Peach").flatMap(s->Mono.just(List.of(s.split("")))).log();
    }

    public static void main(String[] args) {
        FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();
/*
        fluxAndMonoServices.fruitsFlux().subscribe(System.out::println);
        fluxAndMonoServices.fruitMono().subscribe(System.out::println);
*/
//        fluxAndMonoServices.fruitsFluxFlatMap().subscribe(System.out::println);
        fluxAndMonoServices.fruitsMonoFlatMap().subscribe(System.out::println);
    }
}
