/*
 * ejer1-11.cpp
 *
 *  Created on: 04/10/2010
 *      Author: I. Lasaosa
 *      11.	Escriba un programa que calcule la nota final de una asignatura.
 *       Éste habrá de leer por teclado la nota  de la parte de teoría y
 *       la nota de la parte de problemas, y habrá de calcular la nota final
 *       considerando que la parte de teoría vale un 70% de la nota final
 *       y la de práctica un 30%.
 */
// Incluir E/S y Librerías Standard
#include <iostream>
using namespace std;

// Zona de Declaración de Constantes
const float VALOR_TEORIA = 0.7;
const float VALOR_PROBLEMAS = 0.3;

// Zona de Declaración de Tipos

// Zona de Cabeceras de Procedimientos y Funciones

// Programa Principal
int main()
{
    // Zona de Declaración de Variables del Programa principal
    float nota_teoria, nota_problemas, nota_final;

    cout << "Introduzca la nota de teoria: ";
    cin >> nota_teoria;
    cout << "Introduzca la nota de problemas: ";
    cin >> nota_problemas;

    nota_final = (nota_teoria*VALOR_TEORIA) + (nota_problemas*VALOR_PROBLEMAS);

    cout << "La nota final es: " << nota_final << endl;

    return 0;           // Valor de retorno al S.O.
}