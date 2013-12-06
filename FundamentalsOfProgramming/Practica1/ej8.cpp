/*
 * ej8.cpp
 *
 *  Created on: 17/11/2010
 *      Author: I. Lasaosa
 *  Ej8. Decodificación de un numero
 */

#include <iostream>

using namespace std;


int main () {

	int codigo,provincia,restocodigo,operacion,control;

	// Pedimos el codigo
	cout << "Dame un codigo de 4 cifras = ";
	cin >>  codigo	;
	// Analizamos si es de 4 cifras
	if ((codigo<1000) && (codigo > 9999)) {
		cout << "Error: Codigo no valido";
	} else {
		// El cociente hace que nos quedemos con la provincia
		provincia=codigo/1000;
		// Con el resto de esta division sacamos operacion y control
		restocodigo=codigo%1000;
		operacion=restocodigo/10;
		control=restocodigo%10;

		// Analizamos si el control es valido
		if (control!=(operacion%provincia)){
			cout << "Error: Codigo no valido";
		} else {
			cout << "provincia =" << provincia << endl;
			cout << "operacion= " << operacion << endl;
			cout <<  "control =" << control << endl;
		}
	}
	return 0;
}