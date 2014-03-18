package uma.seguridad;

/*************************************************************************
 *  Compilation:  javac RSA.java
 *  Execution:    java RSA N
 *  
 *  Generate an N-bit public and private RSA key and use to encrypt
 *  and decrypt a random message.
 * 
 *  % java RSA 50
 *  public  = 65537
 *  private = 553699199426609
 *  modulus = 825641896390631
 *  message   = 48194775244950
 *  encrpyted = 321340212160104
 *  decrypted = 48194775244950
 *
 *  Known bugs (not addressed for simplicity)
 *  -----------------------------------------
 *  - It could be the case that the message >= modulus. To avoid, use
 *    a do-while loop to generate key until modulus happen to be exactly N bits.
 *
 *  - It's possible that gcd(phi, publicKey) != 1 in which case
 *    the key generation fails. This will only happen if phi is a
 *    multiple of 65537. To avoid, use a do-while loop to generate
 *    keys until the gcd is 1.
 *
 *************************************************************************/

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
	private final static BigInteger one = new BigInteger("1");
	private final static SecureRandom random = new SecureRandom();

	private BigInteger p;
	private BigInteger q;
	private BigInteger n;

	RSA(int N) {
		// Crear Modulo
		do {
			p = BigInteger.probablePrime(N / 2, random);
			q = BigInteger.probablePrime(N / 2, random);
		} while (p == q); // Comprueba que no sean iguales.

		n = p.multiply(q);

		System.out.println("p= " + p + "\nq= " + q + "\nn= " + n + "\n");
	}

	public void crearClave(int N) {
		BigInteger phi = (p.subtract(one).multiply(q.subtract(one)));
		
		BigInteger publicKey = BigInteger.probablePrime(N, random); // Clave Publica (e)
		BigInteger privateKey = publicKey.modInverse(phi); // Clave Privada (d)

		System.out.println("Clave Publica: " + publicKey + "\nClave Privada: "+ privateKey + "\n");
	}

	public static BigInteger cifrar(BigInteger m, BigInteger e, BigInteger n) {
		BigInteger cifrado = m.modPow(e, n);
		System.out.println("Mensaje cifrado: " + cifrado + "\n");
		return cifrado;
	}

	public static BigInteger descifrar(BigInteger c, BigInteger d, BigInteger n) {
		BigInteger descifrado = c.modPow(d, n);
		System.out.println("Mensaje descifrado: " + descifrado + "\n");
		return descifrado;
	}

	public static void main(String[] args) {
		RSA rsa = new RSA(50);
		rsa.crearClave(50);
		
		BigInteger m = new BigInteger("14091990");
		
		// Ejecutar Foro
		
		/* Crear
		BigInteger mensaje = new BigInteger("-");
		BigInteger clavePublica = new BigInteger("-");
		BigInteger modulo = new BigInteger("-");
		
		BigInteger mensajeCifrado = rsa.cifrar(mensaje, clavePublica, modulo);
		System.out.println("Mensaje Cifrado: "+ mensajeCifrado +"\n");
		*/
		
		// Prueba Cifrar: Juan Antonio Reyes
		BigInteger pruebaM = m;
		BigInteger pruebaE = new BigInteger("896538328575859");
		BigInteger pruebaN = new BigInteger("468923008163681");
		
		cifrar(pruebaM, pruebaE, pruebaN);
		
		/* Descifrar:
		 * 				Datos Foro:
		 * 				Modulo (n): 492783521272631
		 *				Clave Publica: 578360836703581
		 *				Clave Privada: 178194759786373
		 *				Mensaje foro: 311441762046542
		 */
		BigInteger mensaje = new BigInteger("311441762046542");
		BigInteger clavePrivada = new BigInteger("178194759786373");
		BigInteger modulo = new BigInteger("492783521272631");
		
		descifrar(mensaje, clavePrivada, modulo);
		//*/
	}
}
