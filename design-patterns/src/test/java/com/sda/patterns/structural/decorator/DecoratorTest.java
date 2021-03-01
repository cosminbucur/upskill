package com.sda.patterns.structural.decorator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DecoratorTest {

    /*
        repair bot = 100
        fighting bot = 300
        scanner = 10
        laser = 50
        thrusters = 20

        fighting bot / repair bot
     */
    @Test
    void givenRepairBotWithScanner_shouldComputeCorrectCost() {
        Robot decoratedRobot = new RepairBot();

        decoratedRobot = new Scanner(decoratedRobot);

        assertThat(decoratedRobot.cost()).isEqualTo(110);
    }

    @Test
    void givenRepairBotWithScanner_shouldGetCorrectInfo() {
        Robot decoratedRobot = new RepairBot();

        decoratedRobot = new Scanner(decoratedRobot);

        assertThat(decoratedRobot.getInfo()).isEqualTo("repair bot, scanner");
    }

    @Test
    void givenFighterBotFullOption_shouldGetCorrectCost() {
        Robot decoratedRobot = new FightingBot();

        decoratedRobot = new Scanner(decoratedRobot);
        decoratedRobot = new Thrusters(decoratedRobot);
        decoratedRobot = new Laser(decoratedRobot);

        assertThat(decoratedRobot.cost()).isEqualTo(380);
    }

}
