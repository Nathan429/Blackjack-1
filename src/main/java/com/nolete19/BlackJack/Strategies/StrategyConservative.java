package com.nolete19.BlackJack.Strategies;

import com.nolete19.BlackJack.Jugadores.Opciones;
import com.nolete19.BlackJack.Jugadores.Mano;

import java.util.Random;

public class StrategyConservative implements Strategy {
    @Override
    public Opciones opcion(Mano player, Mano house) {

        if (opcionPlayer(player) == Opciones.PLANTARSE && opcionHouse(house) == Opciones.PLANTARSE) {
            return Opciones.PLANTARSE;
        } else if (opcionPlayer(player) == Opciones.PEDIR_CARTA && opcionHouse(house) == Opciones.PLANTARSE) {
            return Opciones.PLANTARSE;
        } else if (opcionPlayer(player) == Opciones.PLANTARSE && opcionHouse(house) == Opciones.PEDIR_CARTA) {
            return Opciones.PLANTARSE;
        } else if (opcionPlayer(player) == Opciones.PEDIR_CARTA && opcionHouse(house) == Opciones.PEDIR_CARTA) {
            return Opciones.PEDIR_CARTA;
        }

        return null;
    }


    @Override
    public Opciones opcionPlayer(Mano player) {

        if (!player.isBlackJack()) {
            if (player.getPuntuacion() < 15) {
                return Opciones.PEDIR_CARTA;
            } else {
                return Opciones.PLANTARSE;
            }
        } else {
            return Opciones.PLANTARSE;
        }
    }


    @Override
    public Opciones opcionHouse(Mano house) {

        if (!house.isBlackJack()) {
            if (house.getPuntuacion() < 15) {
                return Opciones.PEDIR_CARTA;
            }
        } else {
            return Opciones.PLANTARSE;
        }
        return Opciones.PLANTARSE;
    }

    @Override
    public int apuesta(int saldo) {
        int apuestaGrande = (int) (saldo * 0.20);
        int apuestaMedio = (int) (saldo * 0.15);
        int apuestaPequeno = (int) (saldo * 0.10);
        int[] apuestaArr = {apuestaGrande, apuestaMedio, apuestaPequeno};
        int pos;
        final int MAX = apuestaArr.length - 1;
        final int MIN = 0;
        Random rand = new Random();
        pos = rand.nextInt((MAX - MIN) + 1) - MIN;

        return apuestaArr[pos];
    }
}
