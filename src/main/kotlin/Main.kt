package br.vehicle_registration

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["br.vehicle_registration.*"])
@EntityScan(basePackages = ["br.vehicle_registration.*"])
@EnableJpaRepositories(basePackages = ["br.vehicle_registration.*"])
@ComponentScan(basePackages = ["br.vehicle_registration.*"])
class VehicleRegistrationApplication

fun main(args: Array<String>) {
    runApplication<VehicleRegistrationApplication>(*args)
}