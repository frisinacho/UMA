/*
 * ejer1-12.cpp
 *
 *  Created on: 04/10/2010
 *      Author: I. Lasaosa
 *      12.	Escriba el siguiente c�digo, ejec�telo y descubra qu� hace este
 *      programa y c�mo lo hace. Sustituya las tres asignaciones que hay tras el comentario por estas otras tres:
		  a = a + b;
		  b = a - b;
		  a = a - b;
		Puede comprobarse que el resultado es an�logo al caso anterior: estudie c�mo funciona este nuevo programa.
 *
 *
 */
#include <iostream>
using namespace std;

int main()
{
  int a=6, b=14;

  cout << "a vale " << a << " y b vale " << b << endl;

  // �Qu� hacen estas tres sentencias?
  a = a+b;
  b = a-b;
  a = a-b;

  cout << "a vale " << a << " y b vale " << b << endl;

  return 0;
}