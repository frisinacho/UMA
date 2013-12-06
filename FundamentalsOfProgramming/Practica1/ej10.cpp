/*
 * ej10.cpp
 *
 *  Created on: 03/11/2010
 *      Author: I. Lasaosa
 *      Conversion de segundos a semanas,dias,horas
 *      minutos y segundos
 */

#include <iostream>

using namespace std;

// Constantes de conversion de segundos a semanas,dias,...
const unsigned SEGSEM=604800;
const unsigned SEGDIA=86400;
const unsigned SEGHORA=3600;
const unsigned SEGMIN=60;

int main () {

	unsigned segundos,semanas,dias,horas,minutos;
	cout<<"Dime el numero de segundos";

// leo segundos
	cin >> segundos;
// Semanas
	semanas=segundos/SEGSEM;
// calculo los segundos que me quedan despues de calcular las semanas
	segundos=segundos % SEGSEM;
// dias
	dias=segundos/SEGDIA;
// segundos que me quedan
	segundos=segundos%SEGDIA;
//horas
	horas=segundos/SEGHORA;
	// segundos que me quedan
	segundos=segundos%SEGHORA;
//minutos
	minutos=segundos/SEGMIN;
// segundos que me quedan
	segundos=segundos%SEGMIN;

//salida
	cout << "Son "<< semanas << "semanas, " << dias << "dias, " <<
			horas << "horas, " << minutos << "minutos, " << segundos << "segundos";

	return 0;
}