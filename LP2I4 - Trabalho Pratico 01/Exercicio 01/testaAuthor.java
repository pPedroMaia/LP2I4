/*
* Pedro Henrique de Oliveira Maia dos Santos CB3013197    
*/

import java.util.Scanner;

public class testaAuthor {
	public static void main(String[] args) {
		String name;
		char gender;
		String email;

		Scanner scan = new Scanner(System.in);

		System.out.print("digite o seu nome :  ");
		name = scan.next();

		System.out.print("digite seu sexo com os caracter M = masculino F = feminino M/F  : ");
		gender = scan.next().charAt(0);

		System.out.print(" Digite seu email :  ");
		email = scan.next();

		Author classeAuthor = new Author(name, email, gender);

		System.out.println(classeAuthor.toString());
		System.out.println("Digite um novo email :   ");
		email = scan.next();
		classeAuthor.setEmail(email);
		System.out.println(classeAuthor.getEmail());

	}

}