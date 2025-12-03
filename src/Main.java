//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Podaj pierwszą liczbę całkowitą: ");
    int firstNumber = scanner.nextInt();
    System.out.println("Podaj drugą liczbę całkowitą: ");
    int secondNumber = scanner.nextInt();

    TypeOFMathOperator operator = new TypeOFMathOperator();

    System.out.println("Wynik dodawania: " + operator.add(firstNumber, secondNumber));
    System.out.println("Wynik odejmowania: " + operator.subtract(firstNumber, secondNumber));
    System.out.println("Wynik mnożenia: " + operator.multiply(firstNumber, secondNumber));
    System.out.println("Wynik dzielenia: " + operator.divide(firstNumber, secondNumber));

}
