/*
 * decbin.cpp
 *
 *  Created on: 28/11/2011
 *      Author: I. Lasaosa
 */

#include <iostream>

//Prototipos de los subprogramas
unsigned BuscarExp(unsigned, unsigned);
void Conversion(unsigned,unsigned,unsigned);
unsigned Elevar(unsigned , unsigned );


using namespace std;


// Definimos la constante base. Es la base a la que convertimos
const unsigned base=2;

// Función que busca el exponente mas cercano al numero y que sea menor o igual
unsigned BuscarExp(unsigned num, unsigned base) {
	unsigned exp=0, valor=1;


	if (num>0) {
		while (valor<num) {
			exp++;
			valor=valor*base;
		}

		// Si la potencia a calcular coincide con el numero NO hay que quitar nada.
		if (valor>num) {
			exp--;
		}
	}
	return exp;
}


//Procedimiento que muestra por pantalla la conversion siguendo el alg.
// del ejercicio
void Conversion(unsigned num,unsigned base,unsigned exp) {

	int divs,divd,nexp;


	divd=num;
	divs=Elevar(base, exp);
	nexp=exp;

	while (nexp>=0) {

		cout << divd/divs;
		//cogemos el resto y quitamos una potencia para seguir dividiendo
		divd=divd%divs;
		divs=divs/2;
		//divido hasta que el exponente sea cero.
		nexp--;
	}
}


// Función que devuelve la potencia de un numero
unsigned Elevar(unsigned base, unsigned exp) {

	unsigned pot=1;

	for (unsigned i=1;i<=exp;i++) {
		pot=pot*base;
	}
	return pot;
}


// Programa principal
int main() {

	unsigned num, exp;

	cout << "Dame un numero en base decimal: ";
	cin >> num;


	exp=BuscarExp(num, base);
	Conversion(num,base,exp);



	return 0;
}