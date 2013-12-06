/*
 * ejer1-12.cpp
 *
 *  Created on: 04/10/2010
 *      Author: I. Lasaosa
 *      12.	Escriba el siguiente código, ejecútelo y descubra qué hace este
 *      programa y cómo lo hace. Sustituya las tres asignaciones que hay tras el comentario por estas otras tres:
		  a = a + b;
		  b = a - b;
		  a = a - b;
		Puede comprobarse que el resultado es análogo al caso anterior: estudie cómo funciona este nuevo programa.
 *
 *
 */
#include <iostream>
using namespace std;

int main()
{
  int a=6, b=14;

  cout << "a vale " << a << " y b vale " << b << endl;

  // ¿Qué hacen estas tres sentencias?
  a = a+b;
  b = a-b;
  a = a-b;

  cout << "a vale " << a << " y b vale " << b << endl;

  return 0;
}