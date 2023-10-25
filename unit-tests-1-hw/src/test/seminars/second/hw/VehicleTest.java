package test.seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.second.hw.Car;
import seminars.second.hw.Motorcycle;
import seminars.second.hw.Vehicle;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
/*
 Домашнее задание к семинару №2 JUnit:
         1. Настроить новый проект:
         a). Нужно создать новый проект, со следующей структурой классов (3 отдельных класса):
         b). Настроить тестовую среду
         (создать тестовый класс VehicleTest, пометить папку как Test sources (зеленая папка),
         импортировать необходимые для тестов библиотеки (JUnit, assertJ - все что было на семинаре))
         c). Написать следующие тесты:
         - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
         - проверка того, объект Car создается с 4-мя колесами
         - проверка того, объект Motorcycle создается с 2-мя колесами
         - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
         - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
         - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
         - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
         */
class VehicleTest {
    /* Домашнее задание №2 */
    /* Хотел использовать @BeforeEach. Но по какой-то причине тесны не срабатывали. */

//    Car car;
//    Motorcycle moto;

//    @BeforeEach
//    void setUp () {
//        Car car = new Car("Toyota", "Camry", 2023);
//        Motorcycle moto = new Motorcycle("Yamaha", "Sport", 2021);
//    }


    @Test
    void checkCarIsInstanceOfVehicle() {
        Car car = new Car("Toyota", "Camry", 2023);
        assertTrue(car instanceof Vehicle);
    }
    @Test
    void checkCarHasFourWheels() {
        Car car = new Car("Toyota", "Camry", 2023);
        assertThat(car.getNumWheels()).isEqualTo(4);
    }
    @Test
    void checkMotorcycleHasTwoWheels() {
        Motorcycle moto = new Motorcycle("Yamaha", "Sport", 2021);
        assertThat(moto.getNumWheels()).isEqualTo(2);
    }
    @Test
    void checkSpeedOfCarInTestDrive() {
        Car car = new Car("Toyota", "Camry", 2023);
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }
    @Test
    void checkSpeedOfMotorcycleInTestDrive() {
        Motorcycle moto = new Motorcycle("Yamaha", "Sport", 2021);
        moto.testDrive();
        assertThat(moto.getSpeed()).isEqualTo(75);
    }
    @Test
    void checkSpeedOfCarInPark() {
        Car car = new Car("Toyota", "Camry", 2023);
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }
    @Test
    void checkSpeedOfMotorcycleInPark() {
        Motorcycle moto = new Motorcycle("Yamaha", "Sport", 2021);
        moto.testDrive();
        moto.park();
        assertThat(moto.getSpeed()).isEqualTo(0);
    }
}
