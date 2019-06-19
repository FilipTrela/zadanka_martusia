package com.model.day1.game;

import lombok.Data;

@Data
public class Plansza {
    private Gracz gracz;
    private int rozmiar;
    private char[][] tablica;
    private boolean zamalowywać=false;

    public void wypelnijTablice() {
        tablica = new char[rozmiar][rozmiar * 2];
        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar * 2; j++) {
                if (i == 0 || i == rozmiar - 1) {
                    tablica[i][j] = '#';
                } else {
                    tablica[i][j] = ' ';
                    tablica[i][0] = '#';
                    tablica[i][tablica[i].length - 1] = '#';
                }
            }
        }

    }

    void wypiszTablice() {
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                if (i == gracz.getPoprzedniaWysokosc() && j == gracz.getPoprzedniaSzerokosc()&&!zamalowywać)
                    tablica[i][j] = ' ';
                if (i == gracz.getWysokoscGracza() && j == gracz.getSzerokoscGracza())
                    tablica[i][j] = gracz.getZnakGracza();
                System.out.print(tablica[i][j]);
            }
            System.out.println();

        }
    }

    public Plansza(Gracz gracz, int rozmiar) {
        this.gracz = gracz;
        this.rozmiar = rozmiar;
    }
}
