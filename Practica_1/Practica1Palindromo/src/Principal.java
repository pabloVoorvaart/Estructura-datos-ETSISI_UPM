public class Principal {
    public static void main(String[] args){
        Comprobador1 cp1 = new Comprobador1("aroma a mora");
        Comprobador1 cp2 = new Comprobador1("camino a casa");//11 camin acasa
        Comprobador1 cp3 = new Comprobador1("dabale arroz a la zorra el abad");
        Comprobador1 cp4 = new Comprobador1();

        cp1.esPalindromo(); cp2.esPalindromo(); cp3.esPalindromo();

        cp4.leerFrase(); cp4.esPalindromo();


        Comprobador2 cp21 = new Comprobador2("aroma a mora");
        Comprobador2 cp22 = new Comprobador2("camino a casa");
        Comprobador2 cp23 = new Comprobador2("dabale arroz a la zorra el abad");
        Comprobador2 cp24 = new Comprobador2();

        cp21.esPalindromo(); cp22.esPalindromo(); cp23.esPalindromo();

        cp24.leerFrase(); cp24.esPalindromo();

        Comprobador3 cp31 = new Comprobador3("aroma a mora");
        Comprobador3 cp32 = new Comprobador3("camino a casa");
        Comprobador3 cp33 = new Comprobador3("dabale arroz a la zorra el abad");
        Comprobador3 cp34 = new Comprobador3();

        cp31.esPalindromo(); cp32.esPalindromo(); cp33.esPalindromo();

        cp34.leerFrase(); cp34.esPalindromo();

    }

}
