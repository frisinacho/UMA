/*
 * ej5.cpp
 *
 *  Created on: 17/11/2010
 *      Author: I. Lasaosa
 *      Calculamos la factura de una compra
 */

#include <iostream>

using namespace std;


// constante para el IVA
const float IVA= 12.0;
const float DESCUENTO=5.0;

int main () {
	unsigned numart;
	float precio,bruto,factura,valordesc;

	//Entrada datos
	cout << "Introduce el precio";
	cin >> precio;

	cout << "Introduce el numero de articulos";
	cin >> numart;

	// calculamos el precio total;

	bruto=precio*numart;

	// Aplicamos el IVA
	factura=bruto + bruto*IVA/100;

	// Analizamos si supera un valor
	if (factura> 300) {
		valordesc=factura*DESCUENTO/100;
		factura=factura - valordesc;
		cout<< "El articulo tiene un descuento de " << valordesc << endl;
	}

	// Salida datos
	cout << "El precio final es = " << factura;
